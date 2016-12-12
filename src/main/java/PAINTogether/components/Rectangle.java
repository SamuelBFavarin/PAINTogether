package PAINTogether.components;

import java.awt.*;

/**
 * Created by samuel on 07/12/16.
 */
public class Rectangle extends Component {

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

}
