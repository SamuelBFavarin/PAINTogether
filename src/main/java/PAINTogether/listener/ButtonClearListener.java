package PAINTogether.listener;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by samuel on 13/12/16.
 */
public class ButtonClearListener extends MouseAdapter {

    private final JButton btn;

    public ButtonClearListener(JButton btn) {
        this.btn = btn;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("teste");
    }
}
