/*
 * DataOD.java
 *
 * Created on 02/10/2007, 17:36:11
 */

package htmlhelpeditor.od;

/**
 *
 * @author leonardo.costa
 */
public class DataOD {

    private String data;
    private String engine;
    
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append("[");
        buffer.append(this.getClass().getName());
        buffer.append(":\n");
        buffer.append("\tdata: ");
        buffer.append(data);
        buffer.append("\n\tengine: ");
        buffer.append(engine);
        buffer.append("\n]");
        return buffer.toString();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}