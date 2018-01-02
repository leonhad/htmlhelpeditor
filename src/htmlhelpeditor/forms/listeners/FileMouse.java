/*
 * (c) 2007 Leonardo Alves da Costa
 */

package htmlhelpeditor.forms.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTree;

/**
 *
 * @author leonardo.costa
 */
public class FileMouse extends MouseAdapter {
    private JTree owner = null;
    private ProcessOpen process = ProcessOpen.getInstance();
    
    public FileMouse(JTree owner) {
        this.owner = owner;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
            process.open(owner.getSelectionPath().getLastPathComponent());
        }
    }
}