/*
 * TocXML.java
 * 
 * Created on 02/10/2007, 16:51:16
 */

package htmlhelpeditor.xml;

import htmlhelpeditor.od.TocOD;
import htmlhelpeditor.od.TocitemOD;
import htmlhelpeditor.xml.resolver.HelpsetResolver;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author leonardo.costa
 */
public class TocXML {
    private DocumentBuilder builder;

    public TocXML() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        builder.setEntityResolver(new HelpsetResolver());
    }

    public TocOD parse(InputStream stream) throws Exception {
        Document document = builder.parse(stream);
        return visit_toc(document);
    }

    private TocOD visit_toc(Document document) throws Exception {
        TocOD od = new TocOD();

        Element element = document.getDocumentElement();
        NamedNodeMap map = element.getAttributes();
        for (int loop = 0; loop < map.getLength(); loop++) {
            Node attr = map.item(loop);
            switch (attr.getNodeType()) {
                case Node.ATTRIBUTE_NODE:
                    String name = attr.getNodeName();
                    if (name.equals("categoryopenimage")) {
                        od.setCategoryopenimage(attr.getNodeValue());
                    } else if (name.equals("categoryclosedimage")) {
                        od.setCategoryclosedimage(attr.getNodeValue());
                    } else if (name.equals("topicimage")) {
                        od.setTopicimage(attr.getNodeValue());
                    }
            }
        }
        
        NodeList list = element.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node node = list.item(loop);
            switch (node.getNodeType()) {
                case Node.ELEMENT_NODE:
                    if (node.getNodeName().equals("tocitem")) {
                        od.addFilho(visit_tocitem(node));
                    }
                    break;
            }
        }

        return od;
    }

    private TocitemOD visit_tocitem(Node node) throws Exception {
        TocitemOD od = new TocitemOD();

        NamedNodeMap map = node.getAttributes();
        for (int loop = 0; loop < map.getLength(); loop++) {
            Node attr = map.item(loop);
            switch (attr.getNodeType()) {
                case Node.ATTRIBUTE_NODE:
                    String name = attr.getNodeName();
                    if (name.equals("target")) {
                        od.setTarget(attr.getNodeValue());
                    } else if (name.equals("image")) {
                        od.setImage(attr.getNodeValue());
                    } else if (name.equals("text")) {
                        od.setText(attr.getNodeValue());
                    } else if (name.equals("mergetype")) {
                        od.setMergetype(attr.getNodeValue());
                    } else if (name.equals("expand") && attr.getNodeValue().equals("true")) {
                        od.setExpand(true);
                    } else if (name.equals("presentationtype")) {
                        od.setPresentationtype(attr.getNodeValue());
                    } else if (name.equals("presentationname")) {
                        od.setPresentationname(attr.getNodeValue());
                    }
            }
        }
        NodeList list = node.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node filho = list.item(loop);
            switch (filho.getNodeType()) {
                case Node.ELEMENT_NODE:
                    if (filho.getNodeName().equals("tocitem")) {
                        od.addFilho(visit_tocitem(filho));
                    }
                    break;
            }
        }
        return od;
    }
}
