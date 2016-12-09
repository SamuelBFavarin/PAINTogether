package PAINTogether.draw;

import PAINTogether.components.Component;
import PAINTogether.components.Rectangle;

import java.awt.*;


/**
 * Created by samuel on 09/12/16.
 */
public class DrawRectangle extends DrawComponent {

    private Rectangle rectangle;

    @Override
    public void draw(Component component) {
        this.rectangle = (Rectangle) rectangle;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(rectangle.getColor());
        g.drawRect(
                (int) rectangle.getX(),
                (int) rectangle.getY(),
                (int) rectangle.getWidth(),
                (int) rectangle.getHeight());
    }
}
