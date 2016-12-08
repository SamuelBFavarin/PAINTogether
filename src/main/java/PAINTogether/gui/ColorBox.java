package PAINTogether.gui;

import javax.swing.*;
import java.awt.*;


/**
 * Created by samuel on 08/12/16.
 */
public class ColorBox extends JPanel {

    private static final int x = 20;
    private static final int y = 20;
    private final Color color;

    public ColorBox(Color color) {
        this.color = color;
        initColor(color);
        initSize();
    }

    private void initColor(Color color) {
        this.setBackground(color);
    }

    private void initSize() {
        this.setMinimumSize(new Dimension(this.x, this.y));
    }
}
