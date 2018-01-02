/*
 * IndexOD.java
 *
 * Created on 02/10/2007, 11:35:16
 */

package htmlhelpeditor.od;

import java.util.ArrayList;

/**
 *
 * @author leonardo.costa
 */
public class IndexOD {

    private String target;
    private String text;
    private String mergetype;
    private boolean expand = false;
    private String presentationtype;
    private String presentationname;
    private ArrayList<IndexOD> filhos = new ArrayList<IndexOD>();

    @Override
    public String toString() {
        return text;
    }
    
    public void addFilhos(IndexOD od) {
        filhos.add(od);
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

    public ArrayList<IndexOD> getFilhos() {
        return filhos;
    }

    public void setFilhos(ArrayList<IndexOD> filhos) {
        this.filhos = filhos;
    }
}