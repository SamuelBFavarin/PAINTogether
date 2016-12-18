package PAINTogether.components;

import PAINTogether.dispatcher.ServerDispatcher;
import PAINTogether.utils.Settings;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Lucas Baragatti on 12/12/2016.
 */
public class Drawer {
    private static Drawer instance;
    private JComponent drawArea;
    private ArrayList<Component> components = new ArrayList<>();

    public static Drawer getInstance() {
        if (instance == null)
            instance = new Drawer();

        return instance;
    }

    public void setDrawArea(JComponent drawArea) {
        this.drawArea = drawArea;
    }

    public void addComponent(Component c) {
        components.add(c);
    }

    public void drawBrush(int x, int y, boolean erase) {
        Brush brush = Brush.getInstance();
        Size size = brush.getSize();
        Color color = (erase) ? Color.WHITE : brush.getColor();
        //Correct position to center mouse
        Point position = new Point((x - (size.getWidth() / 2)), (y - (size.getHeight() / 2)));

        Component c = ComponentFactory.newInstance(brush.getShape(), position.getX(), position.getY(), size.getWidth(),
                size.getHeight(), color);

        components.add(c);

        if (Settings.getInstance().isOnline())
            ServerDispatcher.getInstance().addComponent(c);
    }

    public void draw(Graphics g) {
        for (Component component : components)
            component.draw(g);
    }

    public void repaint() {
        if (drawArea != null)
            drawArea.repaint();
    }

    public void clear() {
        components.clear();

        if (drawArea != null)
            drawArea.repaint();

        if (Settings.getInstance().isOnline())
            ServerDispatcher.getInstance().clearComponents();
    }

}
