package PAINTogether.Components;

import java.awt.*;

/**
 * Created by samuel on 07/12/16.
 */
public class Rectangle {

    private final float x;
    private final float y;
    private final float width;
    private final float height;
    private final Color color;

    public Rectangle(float x, float y, float width, float height, Color color) {
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
}
