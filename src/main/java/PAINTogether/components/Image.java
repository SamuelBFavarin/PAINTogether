package PAINTogether.components;

import java.awt.*;

/**
 * Created by samuel on 07/12/16.
 */
public class Image extends Component {
    private String filename;
    private Rectangle rectangle;

    public Image(int x, int y, int width, int height, Color color) {
        super(null, x, y, width, height, color);
    }

    public String getFilename() {
        return this.filename;
    }

    public Rectangle getRectangle() {
        return this.rectangle;
    }

    @Override
    public void draw(Graphics g) {

    }
}
