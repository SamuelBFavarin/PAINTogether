package PAINTogether.draw;

import PAINTogether.components.Component;
import PAINTogether.components.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by samuel on 09/12/16.
 */
public class DrawImage extends DrawComponent {

    private Image image;

    @Override
    public void draw(Component component) {
        this.image = (Image) component;
    }

    @Override
    public void paintComponent(Graphics g) {
        File filename = new File(image.getFilename());
        super.paintComponent(g);

        try {
            BufferedImage img = ImageIO.read(new File(String.valueOf(filename)));
            g.drawImage(
                    img,
                    (int) image.getRectangle().getX(),
                    (int) image.getRectangle().getY(),
                    (int) image.getRectangle().getWidth(),
                    (int) image.getRectangle().getWidth(),
                    this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
