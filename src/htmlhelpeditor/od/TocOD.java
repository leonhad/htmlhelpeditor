/*
 * TocOD.java
 *
 * Created on 02/10/2007, 16:41:40
 */

package htmlhelpeditor.od;

import java.util.ArrayList;

/**
 *
 * @author leonardo.costa
 */
public class TocOD {

    private String categoryopenimage;
    private String categoryclosedimage;
    private String topicimage;
    private ArrayList<TocitemOD> filhos = new ArrayList<TocitemOD>();

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append("[");
        buffer.append(this.getClass().getName());
        buffer.append(":\n");
        buffer.append("\tcategoryopenimage: ");
        buffer.append(categoryopenimage);
        buffer.append("\n\tcategoryclosedimage: ");
        buffer.append(categoryclosedimage);
        buffer.append("\n\ttopicimage: ");
        buffer.append(topicimage);
        if (filhos != null) {
            buffer.append(filhos.toString());
        }
        buffer.append("\n]");
        
        return buffer.toString();
    }
    
    public void addFilho(TocitemOD itemOD) {
        filhos.add(itemOD);
    }
    
    public String getCategoryopenimage() {
        return categoryopenimage;
    }

    public void setCategoryopenimage(String categoryopenimage) {
        this.categoryopenimage = categoryopenimage;
    }

    public String getCategoryclosedimage() {
        return categoryclosedimage;
    }

    public void setCategoryclosedimage(String categoryclosedimage) {
        this.categoryclosedimage = categoryclosedimage;
    }

    public String getTopicimage() {
        return topicimage;
    }

    public void setTopicimage(String topicimage) {
        this.topicimage = topicimage;
    }

    public ArrayList<TocitemOD> getFilhos() {
        return filhos;
    }

    public void setFilhos(ArrayList<TocitemOD> filhos) {
        this.filhos = filhos;
    }
}