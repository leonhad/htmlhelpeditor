/*
 * (c) 2007 Leonardo Alves da Costa
 */

package htmlhelpeditor.forms.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTree;

/**
 *
 * @author leonardo.costa
 */
public class FileKey extends KeyAdapter {
    private JTree owner = null;
    private ProcessOpen process = ProcessOpen.getInstance();
    
    public FileKey(JTree owner) {
        this.owner = owner;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            process.open(owner.getSelectionPath().getLastPathComponent());
        }
    }
}