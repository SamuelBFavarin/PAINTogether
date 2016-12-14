package PAINTogether.listener;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by samuel on 13/12/16.
 */
public class SimpleMouseListener extends MouseAdapter {
    private MousePressEvent handler = null;

    public SimpleMouseListener(JComponent component) {
        component.addMouseListener(this);
    }

    public void setMousePressHandler(MousePressEvent handler) {
        this.handler = handler;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (handler != null)
            handler.onMousePress(e);
    }

    public interface MousePressEvent {
        void onMousePress(MouseEvent e);
    }
}
