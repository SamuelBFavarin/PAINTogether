package PAINTogether.swingGUI.room_form_class;


import PAINTogether.components.Component;
import PAINTogether.components.Image;
import PAINTogether.components.Rectangle;
import PAINTogether.draw.DrawImage;

import javax.swing.*;
import java.awt.*;


/**
 * Created by samuel on 08/12/16.
 */
public class DrawArea extends JPanel {

    public DrawArea() {

        this.setLayout(new BorderLayout());

        Component img = new Image("design.png", new Rectangle(0, 0, 50, 50, Color.BLUE));
        DrawImage drawImg = new DrawImage();
        drawImg.draw(img);

        /*Component rct = new Rectangle(60,60,78,96,Color.BLUE);
        DrawRectangle drawRectangle = new DrawRectangle();
        drawRectangle.draw(rct);*/

        this.add(drawImg);
        //this.add(drawRectangle);
        this.repaint();
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.darkGray));
    }
}
