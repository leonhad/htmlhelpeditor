/*
 * MapOD.java
 *
 * Created on 02/10/2007, 15:52:07
 */

package htmlhelpeditor.od;

/**
 *
 * @author leonardo.costa
 */
public class MapOD {

    private String target;
    private String url;

    @Override
    public String toString() {
        //return url + " (" + target + ")";
        if (url.lastIndexOf("/") == -1 || url.lastIndexOf("/") == url.length()) {
            return url;
        }
        return url.substring(url.lastIndexOf("/") + 1);
    }
    
    public String getType() {
        if (url.lastIndexOf(".") == -1 || url.lastIndexOf(".") == url.length()) {
            return "";
        }
        return url.substring(url.lastIndexOf(".") + 1);
    }
    
    public boolean isHTML() {
        if (getType().equalsIgnoreCase("html") || getType().equalsIgnoreCase("htm")) {
            return true;
        }
        return false;
    }
    
    public boolean isImage() {
        if (getType().equalsIgnoreCase("png") || getType().equalsIgnoreCase("gif")
                 || getType().equalsIgnoreCase("jpg") || getType().equalsIgnoreCase("jpeg")) {
            return true;
        }
        return false;
    }
    
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}