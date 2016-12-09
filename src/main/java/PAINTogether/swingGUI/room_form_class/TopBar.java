package PAINTogether.swingGUI.room_form_class;

import javax.swing.*;
import java.awt.*;

/**
 * Created by samuel on 08/12/16.
 */
public class TopBar extends JPanel {

    public TopBar() {
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());

        JButton btnExit = new JButton("Close Project"); //EXIT BUTTON
        this.add(initTextInformation(), BorderLayout.WEST);
        this.add(btnExit, BorderLayout.EAST);

    }

    private JPanel initTextInformation() {
        JPanel txtPanel = new JPanel();
        txtPanel.setBackground(Color.DARK_GRAY);

        JLabel txtRoom = new JLabel("Number Room: ");
        JLabel txtNum = new JLabel("445846");
        JLabel txtUsers = new JLabel("    Users Online: ");
        JLabel txtNumUsers = new JLabel("3");

        txtRoom.setForeground(Color.white);
        txtNum.setForeground(Color.cyan);
        txtUsers.setForeground(Color.white);
        txtNumUsers.setForeground(Color.green);

        txtPanel.add(txtRoom);
        txtPanel.add(txtNum);
        txtPanel.add(txtUsers);
        txtPanel.add(txtNumUsers);

        return txtPanel;
    }
}
