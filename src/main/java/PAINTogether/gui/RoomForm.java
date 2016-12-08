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
        leftPanel.setLayout(new BorderLayout());

        JPanel colorsPanel = new JPanel();
        colorsPanel.setLayout(new GridLayout(4, 0));

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

        colorsPanel.add(boxRed);
        colorsPanel.add(boxBlue);
        colorsPanel.add(boxYellow);
        colorsPanel.add(boxGreen);
        colorsPanel.add(boxOrange);
        colorsPanel.add(boxCyan);
        colorsPanel.add(boxPink);
        colorsPanel.add(boxMagenta);
        colorsPanel.add(boxWhite);
        colorsPanel.add(boxLightGray);
        colorsPanel.add(boxGray);
        colorsPanel.add(boxBlack);


        //***********************************************************************//

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.darkGray);

        topPanel.add(Box.createRigidArea(new Dimension(20, 50)));

        //***********************************************************************//

        leftPanel.add(colorsPanel, BorderLayout.CENTER);
        leftPanel.add(topPanel, BorderLayout.NORTH);
        leftPanel.add(new ColorBox(Color.DARK_GRAY), BorderLayout.WEST);
        leftPanel.add(new ColorBox(Color.DARK_GRAY), BorderLayout.EAST);
        leftPanel.add(new ColorBox(Color.DARK_GRAY), BorderLayout.SOUTH);

        leftPanel.setBackground(Color.DARK_GRAY);

        return leftPanel;

    }
    
}
