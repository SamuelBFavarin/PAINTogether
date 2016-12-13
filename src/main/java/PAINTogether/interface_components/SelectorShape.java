package PAINTogether.interface_components;

import PAINTogether.components.Brush;
import PAINTogether.components.Circle;
import PAINTogether.components.ComponentFactory;
import PAINTogether.components.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by samuel on 13/12/16.
 */
public class SelectorShape extends JPanel {


    private int shape = 0; //0 -> rectangle 1-> circle
    private Color color = Color.green;

    public SelectorShape() {
        //this.setBackground(Color.DARK_GRAY);
        if (shape == 0) {
            new Rectangle(0, 0, 20, 20, this.color);
        } else {
            new Circle(0, 0, 20, 20, this.color);
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (shape == 1) {
                    Brush.getInstance().setShape(ComponentFactory.ComponentType.RECTANGLE);
                    shape = 0;
                } else {
                    Brush.getInstance().setShape(ComponentFactory.ComponentType.CIRCLE);
                    shape = 1;
                }
            }
        });
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
