/*
 * ViewOD.java
 *
 * Created on 02/10/2007, 17:22:41
 */

package htmlhelpeditor.od;

/**
 *
 * @author leonardo.costa
 */
public class ViewOD {
    public static final String FAVORITOS = "javax.help.FavoritesView";
    public static final String PROCURA = "javax.help.SearchView";
    public static final String CONTEUDO = "javax.help.TOCView";
    public static final String INDICE = "javax.help.IndexView";
    
    private DataOD data;
    private String mergetype;
    private String name;
    private String label;
    private String image;
    private String type;
    
    @Override
    public String toString() {
        return data != null ? data.getData() : "";
    }

    public DataOD getData() {
        return data;
    }

    public void setData(DataOD data) {
        this.data = data;
    }

    public String getMergetype() {
        return mergetype;
    }

    public void setMergetype(String mergetype) {
        this.mergetype = mergetype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}