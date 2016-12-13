package PAINTogether.interface_components;


import PAINTogether.components.Brush;
import PAINTogether.components.Size;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by samuel on 13/12/16.
 */
public class SliderSize extends JSlider {

    private static final int max = 300;
    private static final int min = 5;

    public SliderSize() {
        this.setMaximum(max);
        this.setMinimum(min);
        this.setOrientation(JSlider.VERTICAL);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Brush.getInstance().setSize(new Size(SliderSize.super.getValue(), SliderSize.super.getValue()));
            }
        });
    }
}
