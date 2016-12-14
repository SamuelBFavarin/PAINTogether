package PAINTogether.listener;

import PAINTogether.components.Drawer;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by samuel on 13/12/16.
 */
public class ButtonClearListener extends MouseAdapter {

    public ButtonClearListener(JButton btn) {
        btn.addMouseListener(this);
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        Drawer.getInstance().clear();
    }
}
