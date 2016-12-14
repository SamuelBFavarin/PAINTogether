package PAINTogether.interface_components;

import PAINTogether.components.Brush;
import PAINTogether.components.ComponentFactory.ComponentType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by samuel on 13/12/16.
 */
public class SelectorShape extends JPanel {
    private static SelectorShape instance;

    public SelectorShape() {
        this.setBackground(Color.darkGray);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                switch (Brush.getInstance().getShape()) {
                    case RECTANGLE:
                        Brush.getInstance().setShape(ComponentType.CIRCLE);
                        break;
                    case CIRCLE:
                        Brush.getInstance().setShape(ComponentType.RECTANGLE);
                        break;
                }
                repaint();
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
        super.paintComponent(g);

        g.clearRect(0, 0, 40, 40);
        g.setColor(Brush.getInstance().getColor());

        switch (Brush.getInstance().getShape()) {
            case RECTANGLE:
                g.fillRect(0, 0, 40, 40);
                break;
            case CIRCLE:
                g.fillOval(0, 0, 40, 40);
                break;
        }

        this.repaint();
    }
}
