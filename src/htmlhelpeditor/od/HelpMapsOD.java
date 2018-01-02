/*
 * HelpMapsOD.java
 * 
 * Created on 02/10/2007, 17:22:12
 */

package htmlhelpeditor.od;

/**
 *
 * @author leonardo.costa
 */
public class HelpMapsOD {
    private String homeID;
    private String mapref;
    
    @Override
    public String toString() {
        return mapref;
    }

    public String getHomeID() {
        return homeID;
    }

    public void setHomeID(String homeID) {
        this.homeID = homeID;
    }

    public String getMapref() {
        return mapref;
    }

    public void setMapref(String mapref) {
        this.mapref = mapref;
    }
}
