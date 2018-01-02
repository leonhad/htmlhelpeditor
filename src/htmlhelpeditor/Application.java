/*
 * Application.java
 */

package htmlhelpeditor;

import htmlhelpeditor.forms.MainForm;
import javax.swing.UIManager;

/**
 * The main class of the application.
 */
public class Application {

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        MainForm form = MainForm.getInstance();
        form.setVisible(true);
    }
}
