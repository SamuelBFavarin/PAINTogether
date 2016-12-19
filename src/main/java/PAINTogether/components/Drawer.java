package PAINTogether.components;

import PAINTogether.dispatcher.ServerDispatcher;
import PAINTogether.swingGUI.room_form_class.DrawArea;
import PAINTogether.swingGUI.room_form_class.TopBar;
import PAINTogether.utils.Settings;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Lucas Baragatti on 12/12/2016.
 */
public class Drawer {
    private static Drawer instance;
    private DrawArea drawArea;
    private TopBar topBar;
    private ArrayList<Component> components = new ArrayList<>();

    public static Drawer getInstance() {
        if (instance == null)
            instance = new Drawer();

        return instance;
    }

    public void setDrawArea(DrawArea drawArea) {
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
        for (int i = 0; i < components.size(); i++) {
            Component c = components.get(i);

            if (c != null)
                c.draw(g);
        }
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

    public TopBar getTopBar() {
        return topBar;
    }

    public void setTopBar(TopBar topBar) {
        this.topBar = topBar;
    }
}
