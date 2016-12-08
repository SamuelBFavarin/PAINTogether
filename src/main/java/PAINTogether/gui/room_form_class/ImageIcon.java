package PAINTogether.gui.room_form_class;

import PAINTogether.components.Image;

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

    private final String imgName;
    private BufferedImage image;

    public ImageIcon(Image img) {
        this.imgName = img.getFilename();
        try {
            this.image = ImageIO.read(new File(this.imgName));
        } catch (IOException e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, this);
    }

}
