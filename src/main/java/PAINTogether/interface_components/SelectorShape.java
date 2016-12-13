package PAINTogether.interface_components;

import PAINTogether.components.Brush;
import PAINTogether.components.ComponentFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by samuel on 13/12/16.
 */
public class SelectorShape extends JPanel {


    private static SelectorShape instance;
    private int shape = 1; //0 -> rectangle 1-> circle
    private Color color = Color.black;
    private boolean newColor;

    public SelectorShape() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(getColor());
                if (shape == 1) {
                    Brush.getInstance().setShape(ComponentFactory.ComponentType.RECTANGLE);
                    System.out.println(shape);
                    shape--;
                } else if (shape == 0) {
                    Brush.getInstance().setShape(ComponentFactory.ComponentType.CIRCLE);
                    System.out.println(shape);
                    shape++;
                }
            }
        });

    }

    public static SelectorShape getInstance() {
        if (instance == null)
            instance = new SelectorShape();

        return instance;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, 40, 40);
        g.setColor(this.getColor());
        this.repaint();
        if (shape == 0) {
            g.fillRect(0, 0, 40, 40);
        } else if (shape == 1) {
            g.fillOval(0, 0, 40, 40);
        }

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        this.repaint();
    }
}
