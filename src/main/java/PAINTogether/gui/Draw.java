package PAINTogether.gui;

import PAINTogether.components.DrawAdaptor;
import PAINTogether.components.Image;
import PAINTogether.components.Rectangle;
import PAINTogether.components.Triangle;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by samuel on 07/12/16.
 */
public class Draw implements DrawAdaptor {

    private final Map<Image, java.awt.Image> images = new HashMap<>();
    private Graphics graphics;
    private JPanel panel;

    public Draw(JPanel panel) {
        this.panel = panel;
        this.graphics = panel.getGraphics();
    }

    private float getWidth() {
        return panel.getWidth();
    }

    private float getHeight() {
        return panel.getHeight();
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    private void setColor(PAINTogether.components.Color color) {
        graphics.setColor(new Color(
                color.getR(),
                color.getG(),
                color.getB(),
                color.getA()
        ));
    }

    public void drawRectangle(Rectangle rectangle) {
        graphics.setColor(rectangle.getColor());
        graphics.drawRect(
                (int) rectangle.getX(),
                (int) rectangle.getY(),
                (int) rectangle.getWidth(),
                (int) rectangle.getHeight());
    }

    public void drawTriangle(Triangle triangle) {
        //NAO IMPLEMENTADO
    }

    public void drawImage(Image image) {
        graphics.setColor(image.getRectangle().getColor());
        graphics.drawImage(
                loadImage(image),
                (int) (image.getRectangle().getX() * getWidth()),
                (int) (image.getRectangle().getY() * getHeight()),
                (int) (image.getRectangle().getWidth() * getWidth()),
                (int) (image.getRectangle().getHeight() * getHeight()),
                panel);

    }

    private java.awt.Image loadImage(Image image) {
        java.awt.Image loadedImage = images.get(image);
        if (loadedImage == null) {
            loadedImage = new ImageIcon(getClass().getResource(image.getFilename())).getImage();
            images.put(image, loadedImage);
        }
        return loadedImage;
    }
}
