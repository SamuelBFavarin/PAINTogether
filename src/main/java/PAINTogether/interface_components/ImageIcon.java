package PAINTogether.interface_components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Created by samuel on 08/12/16.
 */
public class ImageIcon extends JPanel {

    private final String urlImage;

    public ImageIcon(PAINTogether.components.Image image) {
        this.urlImage = image.getFilename();
    }

    @Override
    public void paintComponent(Graphics g) {
        File filename = new File(urlImage);
        super.paintComponent(g);

        try {
            BufferedImage image = ImageIO.read(new File(String.valueOf(filename)));
            g.drawImage(image, 0, 0, 50, 50, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
