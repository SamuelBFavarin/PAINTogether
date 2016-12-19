package PAINTogether.swingGUI.room_form_class;

import PAINTogether.interface_components.ColorBox;
import PAINTogether.interface_components.SelectorShape;
import PAINTogether.interface_components.SliderSize;

import javax.swing.*;
import java.awt.*;

/**
 * Created by samuel on 08/12/16.
 */
public class LeftBar extends JPanel {

    public LeftBar() {
        this.setLayout(new BorderLayout());

        this.setPreferredSize(new Dimension(42, this.getHeight()));
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createLineBorder(Color.darkGray));

        this.add(initColorBoxes(), BorderLayout.CENTER);
        this.add(initReferenceColor(), BorderLayout.NORTH);
        this.add(initSouthArea(), BorderLayout.SOUTH);
    }

    private JPanel initColorBoxes() {
        JPanel colorsPanel = new JPanel();
        colorsPanel.setLayout(new GridLayout(6, 0));

        JPanel boxRed = new ColorBox(Color.RED);
        JPanel boxBlue = new ColorBox(Color.BLUE);
        JPanel boxYellow = new ColorBox(Color.YELLOW);
        JPanel boxGreen = new ColorBox(Color.GREEN);
        JPanel boxOrange = new ColorBox(Color.ORANGE);
        JPanel boxCyan = new ColorBox(Color.CYAN);
        JPanel boxPink = new ColorBox(Color.PINK);
        JPanel boxMagenta = new ColorBox(Color.magenta);
        JPanel boxBlack = new ColorBox(Color.BLACK);
        JPanel boxWhite = new ColorBox(Color.WHITE);
        JPanel boxLightGray = new ColorBox(Color.lightGray);
        JPanel boxGray = new ColorBox(Color.GRAY);
        JPanel boxBrown = new ColorBox(new Color(41, 0, 0));
        JPanel boxViollet = new ColorBox(new Color(191, 0, 255));
        JPanel boxStrongOrange = new ColorBox(new Color(255, 64, 0));
        JPanel boxStrongGreen = new ColorBox((new Color(0, 128, 0)));
        JPanel boxOceanBlue = new ColorBox(new Color(0, 21, 77));
        JPanel boxGoldMetalic = new ColorBox(new Color(173, 173, 133));

        colorsPanel.add(boxRed);
        colorsPanel.add(boxBlue);
        colorsPanel.add(boxYellow);
        colorsPanel.add(boxGreen);
        colorsPanel.add(boxOrange);
        colorsPanel.add(boxCyan);
        colorsPanel.add(boxPink);
        colorsPanel.add(boxMagenta);
        colorsPanel.add(boxWhite);
        colorsPanel.add(boxBrown);
        colorsPanel.add(boxViollet);
        colorsPanel.add(boxStrongOrange);
        colorsPanel.add(boxStrongGreen);
        colorsPanel.add(boxOceanBlue);
        colorsPanel.add(boxGoldMetalic);
        colorsPanel.add(boxLightGray);
        colorsPanel.add(boxGray);
        colorsPanel.add(boxBlack);

        colorsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        return colorsPanel;
    }

    private JPanel initReferenceColor() {
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.darkGray);
        topPanel.setLayout(new GridLayout(0, 1));
        topPanel.add(new SelectorShape());
        topPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        return topPanel;
    }

    private JPanel initSouthArea() {
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.darkGray);
        southPanel.setLayout(new GridLayout(0, 1));
        southPanel.add(new SliderSize());
        return southPanel;
    }
}
