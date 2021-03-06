package PAINTogether.interface_components;

import PAINTogether.components.Brush;
import PAINTogether.musicThreads.SoundFXThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Created by samuel on 08/12/16.
 */
public class ColorBox extends JPanel {
    private final int x = 20;
    private final int y = 20;

    public ColorBox(final Color color) {
        initColor(color);
        initSize();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                SoundFXThread thread = new SoundFXThread();
                thread.setSoundFile("color.mp3");
                thread.start();
                Brush.getInstance().setColor(color);
            }
        });
    }

    private void initColor(Color color) {
        this.setBackground(color);
    }

    private void initSize() {
        this.setMinimumSize(new Dimension(this.x, this.y));
    }

}
