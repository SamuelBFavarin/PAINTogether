package PAINTogether.gui.room_form_class;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author samuel
 */
public class RoomForm extends JFrame {

    public RoomForm() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(500, 300));
        this.setLayout(new BorderLayout());

        this.add(new TopBar(), BorderLayout.NORTH);
        this.add(new LeftBar(), BorderLayout.WEST);
        this.add(new DrawArea(), BorderLayout.CENTER);

        this.setVisible(true);
    }


}
