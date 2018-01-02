/*
 * (c) 2007 Leonardo Alves da Costa
 */

package htmlhelpeditor.od;

import java.util.ArrayList;

/**
 *
 * @author leonardo.costa
 */
public class PresentationOD {
    private String nome;
    private String language;
    private boolean padrao;
    private boolean displayViews;
    private boolean displayViewImages;
    private SizeOD size;
    private LocationOD location;
    private ArrayList<HelpActionOD> toolbar = new ArrayList<HelpActionOD>();

    @Override
    public String toString() {
        return nome;
    }
    
    public void addHelpAction(HelpActionOD od) {
        toolbar.add(od);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPadrao() {
        return padrao;
    }

    public void setPadrao(boolean padrao) {
        this.padrao = padrao;
    }

    public boolean isDisplayViews() {
        return displayViews;
    }

    public void setDisplayViews(boolean displayviews) {
        this.displayViews = displayviews;
    }

    public boolean isDisplayViewImages() {
        return displayViewImages;
    }

    public void setDisplayViewImages(boolean displayviewimages) {
        this.displayViewImages = displayviewimages;
    }

    public SizeOD getSize() {
        return size;
    }

    public void setSize(SizeOD size) {
        this.size = size;
    }

    public LocationOD getLocation() {
        return location;
    }

    public void setLocation(LocationOD location) {
        this.location = location;
    }

    public ArrayList<HelpActionOD> getToolbar() {
        return toolbar;
    }

    public void setToolbar(ArrayList<HelpActionOD> toolbar) {
        this.toolbar = toolbar;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
