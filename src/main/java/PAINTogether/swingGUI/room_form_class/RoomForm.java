package PAINTogether.swingGUI.room_form_class;

import PAINTogether.listener.DrawMouseListener;

import javax.swing.*;
import java.awt.*;

/**
 * @author samuel
 */
public class RoomForm extends JFrame {

    public RoomForm() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(500, 700));
        this.setLayout(new BorderLayout());

        DrawArea drawArea = new DrawArea();
        TopBar topbar = new TopBar();

        this.add(topbar, BorderLayout.NORTH);
        this.add(new LeftBar(), BorderLayout.WEST);
        this.add(drawArea, BorderLayout.CENTER);

        new DrawMouseListener(drawArea);

        
        this.setVisible(true);
    }

}
