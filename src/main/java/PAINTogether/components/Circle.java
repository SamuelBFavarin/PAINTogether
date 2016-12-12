package PAINTogether.components;

import java.awt.*;

/**
 * Created by samuel on 07/12/16.
 */
public class Circle extends Component {

    public Circle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }
}
