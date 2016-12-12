package PAINTogether.swingGUI.room_form_class;


import PAINTogether.components.Drawer;

import javax.swing.*;
import java.awt.*;


/**
 * Created by samuel on 08/12/16.
 */
public class DrawArea extends JPanel {

    public DrawArea() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        this.repaint();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Drawer.getInstance().draw(g);

        super.repaint();
    }
}
