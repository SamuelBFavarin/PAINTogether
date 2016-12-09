package PAINTogether.swingGUI.room_form_class;


import PAINTogether.components.Rectangle;
import PAINTogether.swingGUI.SwingDrawAdaptor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by samuel on 08/12/16.
 */
public class DrawArea extends JPanel {

    public DrawArea() {

        this.setLayout(new BorderLayout());
        SwingDrawAdaptor draw = new SwingDrawAdaptor(this, this.getGraphics());
        draw.drawRectangle(new Rectangle(10, 10, 10, 10, Color.BLUE));
        this.repaint();
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.darkGray));
    }
}
