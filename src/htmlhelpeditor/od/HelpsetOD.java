/*
 * HelpsetOD.java
 * 
 * Created on 02/10/2007, 17:20:56
 */

package htmlhelpeditor.od;

import java.util.ArrayList;

/**
 *
 * @author leonardo.costa
 */
public class HelpsetOD {
    private String file;
    private String version;
    private String locale;
    private String title;
    private HelpMapsOD map = new HelpMapsOD();
    private ArrayList<ViewOD> view = new ArrayList<ViewOD>();
    private ArrayList<PresentationOD> presentation = new ArrayList<PresentationOD>();
    private ArrayList<IndexOD> indices = new ArrayList<IndexOD>();
    private ArrayList<MapOD> maps = new ArrayList<MapOD>();

    @Override
    public String toString() {
        return file;
    }
    
    public void addView(ViewOD od) {
        view.add(od);
    }
    
    public void addPresentation(PresentationOD od) {
        getPresentation().add(od);
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HelpMapsOD getMap() {
        return map;
    }

    public void setMap(HelpMapsOD map) {
        this.map = map;
    }

    public ArrayList<ViewOD> getView() {
        return view;
    }

    public void setView(ArrayList<ViewOD> view) {
        this.view = view;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ArrayList<PresentationOD> getPresentation() {
        return presentation;
    }

    public void setPresentation(ArrayList<PresentationOD> presentation) {
        this.presentation = presentation;
    }

    public ArrayList<IndexOD> getIndices() {
        return indices;
    }

    public void setIndices(ArrayList<IndexOD> indices) {
        this.indices = indices;
    }

    public ArrayList<MapOD> getMaps() {
        return maps;
    }

    public void setMaps(ArrayList<MapOD> maps) {
        this.maps = maps;
    }
}
