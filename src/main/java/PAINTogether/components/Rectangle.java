package PAINTogether.components;

import java.awt.*;

/**
 * Created by samuel on 07/12/16.
 */
public class Rectangle implements Component {

    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Color color;

    public Rectangle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String typeComponent() {
        return "Rectangle";
    }
}
