/*
 * IndexXML.java
 *
 * Created on 02/10/2007, 11:34:41
 */

package htmlhelpeditor.xml;

import htmlhelpeditor.od.IndexOD;
import htmlhelpeditor.xml.resolver.HelpsetResolver;
import java.io.InputStream;
import java.util.ArrayList;
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
public class IndexXML {

    private DocumentBuilder builder;

    public IndexXML() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        builder.setEntityResolver(new HelpsetResolver());
    }

    public ArrayList<IndexOD> parse(InputStream stream) throws Exception {
        Document document = builder.parse(stream);
        return visit_index(document);
    }

    private ArrayList<IndexOD> visit_index(Document document) throws Exception {
        ArrayList<IndexOD> ret = new ArrayList<IndexOD>();

        Element element = document.getDocumentElement();
        NodeList list = element.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node node = list.item(loop);
            switch (node.getNodeType()) {
                case Node.ELEMENT_NODE:
                    if (node.getNodeName().equals("indexitem")) {
                        ret.add(visit_indexitem(node));
                    }
                    break;
            }
        }

        return ret;
    }

    private IndexOD visit_indexitem(Node node) throws Exception {
        IndexOD od = new IndexOD();

        NamedNodeMap map = node.getAttributes();
        for (int loop = 0; loop < map.getLength(); loop++) {
            Node attr = map.item(loop);
            switch (attr.getNodeType()) {
                case Node.ATTRIBUTE_NODE:
                    String name = attr.getNodeName();
                    if (name.equals("target")) {
                        od.setTarget(attr.getNodeValue());
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
                    if (filho.getNodeName().equals("indexitem")) {
                        od.addFilhos(visit_indexitem(filho));
                    }
                    break;
            }
        }
        return od;
    }
}