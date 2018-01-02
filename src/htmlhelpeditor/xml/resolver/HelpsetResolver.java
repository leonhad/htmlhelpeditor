/*
 * IndexResolver.java
 *
 * Created on 02/10/2007, 12:14:38
 */

package htmlhelpeditor.xml.resolver;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

/**
 *
 * @author leonardo.costa
 */
public class HelpsetResolver implements EntityResolver {
    @Override
    public InputSource resolveEntity(String publicId, String systemId) {
        if (systemId.equals("http://java.sun.com/products/javahelp/index_2_0.dtd")) {
            return new InputSource(getClass().getResourceAsStream("/htmlhelpeditor/dtd/index_2_0.dtd"));
        } else if (systemId.equals("http://java.sun.com/products/javahelp/helpset_2_0.dtd")) {
            return new InputSource(getClass().getResourceAsStream("/htmlhelpeditor/dtd/helpset_2_0.dtd"));
        } else if (systemId.equals("http://java.sun.com/products/javahelp/map_2_0.dtd")) {
            return new InputSource(getClass().getResourceAsStream("/htmlhelpeditor/dtd/map_2_0.dtd"));
        } else if (systemId.equals("http://java.sun.com/products/javahelp/toc_2_0.dtd")) {
            return new InputSource(getClass().getResourceAsStream("/htmlhelpeditor/dtd/toc_2_0.dtd"));
        } else {
            // use the default behaviour
            return null;
        }
    }
}