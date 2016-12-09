package PAINTogether.swingGUI;

import PAINTogether.components.*;
import PAINTogether.components.Image;
import PAINTogether.components.Rectangle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by samuel on 07/12/16.
 */
public class SwingDrawAdaptor implements DrawAdaptor {


    private final JPanel panel;
    private Graphics g;

    public SwingDrawAdaptor(JPanel panel) {
        this.panel = panel;
    }

    public SwingDrawAdaptor(JPanel panel, Graphics g) {
        this.panel = panel;
        this.g = g;
    }

    public void drawComponent(Components component) {
        if (component.typeComponent().equals("Rectangle")) drawRectangle((Rectangle) component);
        else if (component.typeComponent().equals("Image")) drawImage((Image) component);
        else if (component.typeComponent().equals("Circle")) drawCircle((Circle) component);
    }

    @Override
    public void drawRectangle(Rectangle rectangle) {
        g.setColor(rectangle.getColor());
        g.drawRect((int) rectangle.getWidth(), (int) rectangle.getHeight(), (int) rectangle.getX(), (int) rectangle.getY());
    }

    @Override
    public void drawCircle(Circle circle) {

    }

    @Override
    public void drawImage(Image image) {
        try {
            File filename = new File(image.getFilename());
            BufferedImage img = ImageIO.read(new File(String.valueOf(filename)));
            g.drawImage(
                    img,
                    (int) image.getRectangle().getX(),
                    (int) image.getRectangle().getY(),
                    (int) image.getRectangle().getWidth(),
                    (int) image.getRectangle().getHeight(),
                    panel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
