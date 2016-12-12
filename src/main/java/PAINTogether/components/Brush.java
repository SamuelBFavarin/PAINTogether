package PAINTogether.components;

import PAINTogether.components.ComponentFactory.ComponentType;

import java.awt.*;

/**
 * Created by Lucas Baragatti on 12/12/2016.
 */
public class Brush {
    private static Brush instance;
    private Size size = new Size(20, 20);
    private Color color = Color.BLACK;
    private ComponentType shape = ComponentType.CIRCLE;

    public static Brush getInstance() {
        if (instance == null)
            instance = new Brush();

        return instance;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ComponentType getShape() {
        return shape;
    }

    public void setShape(ComponentType shape) {
        this.shape = shape;
    }
}
