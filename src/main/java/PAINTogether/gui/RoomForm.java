package PAINTogether.gui;

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

        this.add(TopPanel(), BorderLayout.NORTH);
        this.add(LeftPanel(), BorderLayout.WEST);
        this.setVisible(true);
    }

    public JPanel TopPanel() {
        JPanel topPanel = new JPanel();
        JPanel txtPanel = new JPanel();
        topPanel.setBackground(Color.DARK_GRAY);
        topPanel.setLayout(new BorderLayout());
        txtPanel.setBackground(Color.DARK_GRAY);

        //TEXTO
        JLabel txtRoom = new JLabel("Number Room: ");
        JLabel txtNum = new JLabel("445846");
        JLabel txtUsers = new JLabel("    Users Online: ");
        JLabel txtNumUsers = new JLabel("3");

        txtRoom.setForeground(Color.white);
        txtNum.setForeground(Color.cyan);
        txtUsers.setForeground(Color.white);
        txtNumUsers.setForeground(Color.green);

        //BOTAO
        JButton btnExit = new JButton("Close Project");

        txtPanel.add(txtRoom);
        txtPanel.add(txtNum);
        txtPanel.add(txtUsers);
        txtPanel.add(txtNumUsers);
        topPanel.add(txtPanel, BorderLayout.WEST);
        topPanel.add(btnExit, BorderLayout.EAST);

        return topPanel;
    }

    public JPanel LeftPanel() {
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.DARK_GRAY);

        //Rectangle rctRed = new Rectangle(0f,0f,20f,20f, Color.RED);

        return leftPanel;

    }
    
}
