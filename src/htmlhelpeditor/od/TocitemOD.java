/*
 * TocitemOD.java
 *
 * Created on 02/10/2007, 16:44:21
 */

package htmlhelpeditor.od;

import java.util.ArrayList;

/**
 *
 * @author leonardo.costa
 */
public class TocitemOD {

    private String target;
    private String text;
    private String image;
    private String mergetype;
    private boolean expand = false;
    private String presentationtype;
    private String presentationname;
    private ArrayList<TocitemOD> filhos = new ArrayList<TocitemOD>();

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append("[");
        buffer.append(this.getClass().getName());
        buffer.append(":\n");
        buffer.append("\ttarget: ");
        buffer.append(target);
        buffer.append("\n\timage: ");
        buffer.append(image);
        buffer.append("\n\ttext: ");
        buffer.append(text);
        buffer.append("\n\tmergetype: ");
        buffer.append(mergetype);
        buffer.append("\n\texpand: ");
        buffer.append(expand);
        buffer.append("\n\tpresentationtype: ");
        buffer.append(presentationtype);
        buffer.append("\n\tpresentationname: ");
        buffer.append(presentationname);
        buffer.append("\n");
        if (filhos != null) {
            buffer.append(filhos.toString());
        }
        buffer.append("\n]");
        return buffer.toString();
    }
    
    public void addFilho(TocitemOD itemOD) {
        filhos.add(itemOD);
    }
    
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMergetype() {
        return mergetype;
    }

    public void setMergetype(String mergetype) {
        this.mergetype = mergetype;
    }

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }

    public String getPresentationtype() {
        return presentationtype;
    }

    public void setPresentationtype(String presentationtype) {
        this.presentationtype = presentationtype;
    }

    public String getPresentationname() {
        return presentationname;
    }

    public void setPresentationname(String presentationname) {
        this.presentationname = presentationname;
    }

    public ArrayList<TocitemOD> getFilhos() {
        return filhos;
    }

    public void setFilhos(ArrayList<TocitemOD> filhos) {
        this.filhos = filhos;
    }
}