package PAINTogether.interface_components;

import PAINTogether.components.Brush;
import PAINTogether.components.ComponentFactory.ComponentType;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by samuel on 13/12/16.
 */
public class SelectorShape extends JPanel {
    private static SelectorShape instance;

    public SelectorShape() {
        this.setBackground(Color.darkGray);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new Thread() {
                    @Override
                    public void run() {
                        Player player = null;
                        try {
                            Thread.sleep(100);
                            player = new Player(new FileInputStream("Assets/SoundFX/button.mp3"));
                            player.play();
                        } catch (InterruptedException ex) {
                            if (player != null)
                                player.close();

                            Thread.currentThread().interrupt();
                        } catch (FileNotFoundException | JavaLayerException e1) {
                            e1.printStackTrace();
                        }

                    }
                }.start();

                switch (Brush.getInstance().getShape()) {
                    case RECTANGLE:
                        Brush.getInstance().setShape(ComponentType.CIRCLE);
                        break;
                    case CIRCLE:
                        Brush.getInstance().setShape(ComponentType.RECTANGLE);
                        break;
                }
                repaint();
            }
        });

    }

    public static SelectorShape getInstance() {
        if (instance == null)
            instance = new SelectorShape();

        return instance;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.clearRect(0, 0, 40, 40);
        g.setColor(Brush.getInstance().getColor());

        switch (Brush.getInstance().getShape()) {
            case RECTANGLE:
                g.fillRect(0, 0, 40, 40);
                break;
            case CIRCLE:
                g.fillOval(0, 0, 40, 40);
                break;
        }

        this.repaint();
    }
}
