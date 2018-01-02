/*
 * (c) 2007 Leonardo Alves da Costa
 */

package htmlhelpeditor.forms.listeners;

import framework.forms.utils.FrameManager;
import htmlhelpeditor.forms.HelpsetForm;
import htmlhelpeditor.forms.MainForm;
import htmlhelpeditor.od.HelpsetOD;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author leonardo.costa
 */
public class ProcessOpen {

    private static ProcessOpen instance = null;
    private FrameManager manager = FrameManager.getInstance();

    public static ProcessOpen getInstance() {
        if (instance == null) {
            instance = new ProcessOpen();
        }
        return instance;
    }

    public void open(Object obj) {
        MainForm main = MainForm.getInstance();
        if (obj instanceof DefaultMutableTreeNode) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)obj;
            obj = node.getUserObject();
            
            // Helpset
            if (obj instanceof HelpsetOD) {
                HelpsetForm form = HelpsetForm.getInstance();
                form.open(main.getHelp());
                manager.showFrame(form);
            }
        }
    }
}