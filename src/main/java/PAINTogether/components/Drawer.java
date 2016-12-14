package PAINTogether.components;

import PAINTogether.dispatcher.ServerDispatcher;
import PAINTogether.utils.Configuracoes;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Lucas Baragatti on 12/12/2016.
 */
public class Drawer {
    private static Drawer instance;
    private ArrayList<Component> components = new ArrayList<>();

    public static Drawer getInstance() {
        if (instance == null)
            instance = new Drawer();

        return instance;
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

        if (Configuracoes.getInstance().isOnline())
            ServerDispatcher.getInstance().addComponent(c);
    }

    public void draw(Graphics g) {
        for (int i = 0; i < components.size(); i++) {
            components.get(i).draw(g);
        }
    }

    public void clear() {
        components.clear();
    }

}
