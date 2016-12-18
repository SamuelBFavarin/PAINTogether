package PAINTogether.components;

import java.awt.*;

import static PAINTogether.components.ComponentFactory.ComponentType;

/**
 * Created by samuel on 09/12/16.
 */
public abstract class Component {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private ComponentType type;

    public Component(ComponentType type, int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    abstract void draw(Graphics g);

    public ComponentType getType() {
        return type;
    }
}
