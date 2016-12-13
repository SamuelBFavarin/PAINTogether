package PAINTogether.swingGUI.room_form_class;

import PAINTogether.listener.ButtonClearListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by samuel on 08/12/16.
 */
public class TopBar extends JPanel {

    public TopBar() {

        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, 2));
        btnPanel.setBackground(Color.DARK_GRAY);

        JButton btnClear = new JButton("Clear Project"); //CLEAR BUTTON
        JButton btnExit = new JButton("Close Project"); //EXIT BUTTON

        btnPanel.add(btnClear);
        btnPanel.add(btnExit);


        new ButtonClearListener(btnClear);

        this.add(initTextInformation(), BorderLayout.WEST);
        this.add(btnPanel, BorderLayout.EAST);

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
