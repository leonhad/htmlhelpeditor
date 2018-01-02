/*
 * MapXML.java
 *
 * Created on 02/10/2007, 15:51:47
 */

package htmlhelpeditor.xml;

import htmlhelpeditor.od.MapOD;
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
public class MapXML {

    private DocumentBuilder builder;

    public MapXML() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        builder.setEntityResolver(new HelpsetResolver());
    }

    public ArrayList<MapOD> parse(InputStream stream) throws Exception {
        Document document = builder.parse(stream);
        return visit_map(document);
    }

    private ArrayList<MapOD> visit_map(Document document) throws Exception {
        ArrayList<MapOD> ret = new ArrayList<MapOD>();

        Element element = document.getDocumentElement();
        NodeList list = element.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node node = list.item(loop);
            switch (node.getNodeType()) {
                case Node.ELEMENT_NODE:
                    if (node.getNodeName().equals("mapID")) {
                        ret.add(visit_mapID(node));
                    }
                    break;
            }
        }

        return ret;
    }

    private MapOD visit_mapID(Node node) throws Exception {
        MapOD od = new MapOD();

        NamedNodeMap map = node.getAttributes();
        for (int loop = 0; loop < map.getLength(); loop++) {
            Node attr = map.item(loop);
            switch (attr.getNodeType()) {
                case Node.ATTRIBUTE_NODE:
                    String name = attr.getNodeName();
                    if (name.equals("target")) {
                        od.setTarget(attr.getNodeValue());
                    } else if (name.equals("url")) {
                        od.setUrl(attr.getNodeValue());
                    }
            }
        }
        return od;
    }
}