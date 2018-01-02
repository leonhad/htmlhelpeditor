/*
 * HelpsetXML.java
 *
 * Created on 03/10/2007, 09:14:52
 */

package htmlhelpeditor.xml;

import htmlhelpeditor.od.DataOD;
import htmlhelpeditor.od.HelpActionOD;
import htmlhelpeditor.od.HelpMapsOD;
import htmlhelpeditor.od.HelpsetOD;
import htmlhelpeditor.od.LocationOD;
import htmlhelpeditor.od.PresentationOD;
import htmlhelpeditor.od.SizeOD;
import htmlhelpeditor.od.ViewOD;
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
public class HelpsetXML {

    private DocumentBuilder builder;

    public HelpsetXML() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        builder.setEntityResolver(new HelpsetResolver());
    }

    public HelpsetOD parse(InputStream stream) throws Exception {
        Document document = builder.parse(stream);
        return visit_helpset(document);
    }

    private HelpsetOD visit_helpset(Document document) throws Exception {
        HelpsetOD od = new HelpsetOD();

        Element element = document.getDocumentElement();
        NamedNodeMap map = element.getAttributes();
        for (int loop = 0; loop < map.getLength(); loop++) {
            Node attr = map.item(loop);
            switch (attr.getNodeType()) {
                case Node.ATTRIBUTE_NODE:
                    String name = attr.getNodeName();
                    if (name.equals("xml:lang")) {
                        od.setLocale(attr.getNodeValue());
                    } else if (name.equals("version")) {
                        od.setVersion(attr.getNodeValue());
                    }
            }
        }
        NodeList list = element.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node node = list.item(loop);
            switch (node.getNodeType()) {
                case Node.ELEMENT_NODE:
                    String name = node.getNodeName();
                    if (name.equals("title")) {
                        visit_title(node, od);
                    } else if (name.equals("maps")) {
                        od.setMap(visit_maps(node));
                    } else if (name.equals("view")) {
                        od.addView(visit_view(node));
                    } else if (name.equals("presentation")) {
                        od.addPresentation(visit_presentation(node));
                    }
                    break;
            }
        }

        return od;
    }

    private void visit_title(Node node, HelpsetOD od) throws Exception {
        NodeList list = node.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node n = list.item(loop);
            switch (n.getNodeType()) {
                case Node.TEXT_NODE:
                    od.setTitle(n.getNodeValue());
            }
        }
    }

    private HelpMapsOD visit_maps(Node node) throws Exception {
        HelpMapsOD od = new HelpMapsOD();

        NodeList list = node.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node n = list.item(loop);
            switch (n.getNodeType()) {
                case Node.ELEMENT_NODE:
                    String name = n.getNodeName();
                    if (name.equals("homeID")) {
                        visit_homeID(n, od);
                    } else if (name.equals("mapref")) {
                        visit_mapref(n, od);
                    }
            }
        }
        return od;
    }

    private ViewOD visit_view(Node node) throws Exception {
        ViewOD od = new ViewOD();

        NamedNodeMap map = node.getAttributes();
        for (int loop = 0; loop < map.getLength(); loop++) {
            Node attr = map.item(loop);
            switch (attr.getNodeType()) {
                case Node.ATTRIBUTE_NODE:
                    String name = attr.getNodeName();
                    if (name.equals("mergetype")) {
                        od.setMergetype(attr.getNodeValue());
                    }
            }
        }
        NodeList list = node.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node n = list.item(loop);
            switch (n.getNodeType()) {
                case Node.ELEMENT_NODE:
                    String name = n.getNodeName();
                    if (name.equals("name")) {
                        visit_name(n, od);
                    } else if (name.equals("label")) {
                        visit_label(n, od);
                    } else if (name.equals("image")) {
                        visit_image(n, od);
                    } else if (name.equals("type")) {
                        visit_type(n, od);
                    } else if (name.equals("data")) {
                        od.setData(visit_data(n));
                    }
            }
        }
        return od;
    }

    private void visit_name(Node node, ViewOD od) throws Exception {
        NodeList list = node.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node n = list.item(loop);
            switch (n.getNodeType()) {
                case Node.TEXT_NODE:
                    od.setName(n.getNodeValue());
            }
        }
    }
    
    private void visit_name(Node node, PresentationOD od) throws Exception {
        NodeList list = node.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node n = list.item(loop);
            switch (n.getNodeType()) {
                case Node.TEXT_NODE:
                    od.setNome(n.getNodeValue());
            }
        }
    }

    private void visit_label(Node node, ViewOD od) throws Exception {
        NodeList list = node.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node n = list.item(loop);
            switch (n.getNodeType()) {
                case Node.TEXT_NODE:
                    od.setLabel(n.getNodeValue());
            }
        }
    }
    
    private void visit_image(Node node, ViewOD od) throws Exception {
        NodeList list = node.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node n = list.item(loop);
            switch (n.getNodeType()) {
                case Node.TEXT_NODE:
                    od.setImage(n.getNodeValue());
            }
        }
    }
    
    private void visit_type(Node node, ViewOD od) throws Exception {
        NodeList list = node.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node n = list.item(loop);
            switch (n.getNodeType()) {
                case Node.TEXT_NODE:
                    od.setType(n.getNodeValue());
            }
        }
    }
    
    private DataOD visit_data(Node node) throws Exception {
        DataOD od = new DataOD();
        NamedNodeMap map = node.getAttributes();
        for (int loop = 0; loop < map.getLength(); loop++) {
            Node attr = map.item(loop);
            switch (attr.getNodeType()) {
                case Node.ATTRIBUTE_NODE:
                    String name = attr.getNodeName();
                    if (name.equals("engine")) {
                        od.setEngine(attr.getNodeValue());
                    }
            }
        }
        NodeList list = node.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node n = list.item(loop);
            switch (n.getNodeType()) {
                case Node.TEXT_NODE:
                    od.setData(n.getNodeValue());
            }
        }
        return od;
    }

    private void visit_homeID(Node node, HelpMapsOD od) throws Exception {
        NodeList list = node.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node n = list.item(loop);
            switch (n.getNodeType()) {
                case Node.TEXT_NODE:
                    od.setHomeID(n.getNodeValue());
            }
        }
    }

    private void visit_mapref(Node node, HelpMapsOD od) throws Exception {
        NamedNodeMap map = node.getAttributes();
        for (int loop = 0; loop < map.getLength(); loop++) {
            Node attr = map.item(loop);
            switch (attr.getNodeType()) {
                case Node.ATTRIBUTE_NODE:
                    String name = attr.getNodeName();
                    if (name.equals("location")) {
                        od.setMapref(attr.getNodeValue());
                    }
            }
        }
    }
    
    private PresentationOD visit_presentation(Node node) throws Exception {
        PresentationOD od = new PresentationOD();

        NamedNodeMap map = node.getAttributes();
        for (int loop = 0; loop < map.getLength(); loop++) {
            Node attr = map.item(loop);
            switch (attr.getNodeType()) {
                case Node.ATTRIBUTE_NODE:
                    String name = attr.getNodeName();
                    if (name.equals("xml:lang")) {
                        od.setLanguage(attr.getNodeValue());
                    } else if (name.equals("default")) {
                        od.setPadrao(Boolean.valueOf(attr.getNodeValue()));
                    } else if (name.equals("displayviews")) {
                        od.setDisplayViews(Boolean.valueOf(attr.getNodeValue()));
                    } else if (name.equals("displayviewimages")) {
                        od.setDisplayViewImages(Boolean.valueOf(attr.getNodeValue()));
                    }
            }
        }
        NodeList list = node.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node n = list.item(loop);
            switch (n.getNodeType()) {
                case Node.ELEMENT_NODE:
                    String name = n.getNodeName();
                    if (name.equals("size")) {
                        od.setSize(visit_size(n));
                    } else if (name.equals("location")) {
                        od.setLocation(visit_location(n));
                    } else if (name.equals("toolbar")) {
                        visit_toolbar(n, od);
                    } else if (name.equals("name")) {
                        visit_name(n, od);
                    }
            }
        }
        return od;
    }
    
    public SizeOD visit_size(Node node) {
        SizeOD od = new SizeOD();
        
        NamedNodeMap map = node.getAttributes();
        for (int loop = 0; loop < map.getLength(); loop++) {
            Node attr = map.item(loop);
            switch (attr.getNodeType()) {
                case Node.ATTRIBUTE_NODE:
                    String name = attr.getNodeName();
                    if (name.equals("width")) {
                        od.setWidth(Integer.valueOf(node.getNodeValue()));
                    } else if (name.equals("height")) {
                        od.setHeight(Integer.valueOf(node.getNodeValue()));
                    }
            }
        }
        return od;
    }
    
    public LocationOD visit_location(Node node) {
        LocationOD od = new LocationOD();
        
        NamedNodeMap map = node.getAttributes();
        for (int loop = 0; loop < map.getLength(); loop++) {
            Node attr = map.item(loop);
            switch (attr.getNodeType()) {
                case Node.ATTRIBUTE_NODE:
                    String name = attr.getNodeName();
                    if (name.equals("x")) {
                        od.setX(Integer.valueOf(node.getNodeValue()));
                    } else if (name.equals("y")) {
                        od.setY(Integer.valueOf(node.getNodeValue()));
                    }
            }
        }
        return od;
    }
    
    private void visit_toolbar(Node node, PresentationOD od) throws Exception {
        NodeList list = node.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node n = list.item(loop);
            switch (n.getNodeType()) {
                case Node.ELEMENT_NODE:
                    String name = n.getNodeName();
                    if (name.equals("helpaction")) {
                        od.addHelpAction(visit_helpaction(node));
                    }
            }
        }
    }
    
    private HelpActionOD visit_helpaction(Node node) throws Exception {
        HelpActionOD od = new HelpActionOD();

        NamedNodeMap map = node.getAttributes();
        for (int loop = 0; loop < map.getLength(); loop++) {
            Node attr = map.item(loop);
            switch (attr.getNodeType()) {
                case Node.ATTRIBUTE_NODE:
                    String name = attr.getNodeName();
                    if (name.equals("image")) {
                        od.setImage(attr.getNodeValue());
                    }
            }
        }
        NodeList list = node.getChildNodes();
        for (int loop = 0; loop < list.getLength(); loop++) {
            Node n = list.item(loop);
            switch (n.getNodeType()) {
                case Node.TEXT_NODE:
                    od.setText(node.getNodeValue());
            }
        }
        return od;
    }
}