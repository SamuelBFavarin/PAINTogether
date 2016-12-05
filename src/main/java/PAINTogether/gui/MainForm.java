package PAINTogether.gui;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author samuel
 */
public class MainForm extends JFrame {
   
    public MainForm() throws HeadlessException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 500);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(300, 500));
        
        this.setLayout(new BorderLayout());
        this.add(initTopLayout(),BorderLayout.NORTH);
        this.add(initCenterLayout(), BorderLayout.CENTER);
        this.setVisible(true);
    }
    
    public JPanel initTopLayout(){
        JPanel topPanel = new JPanel();
        JLabel title = new JLabel("PAINTogether");
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground (Color.WHITE);
        topPanel.add(title);
        topPanel.setBackground(Color.DARK_GRAY);
        return topPanel;
    }
    
    public JPanel initCenterLayout(){
        JPanel centerPanel = new JPanel();
        JPanel enterPanel = new JPanel();

        JTextField txtField = new JTextField("Room Number");
        txtField.setMaximumSize(new Dimension(this.getWidth() * 100, 20));

        JButton btnEnter = new JButton("ENTER");
        btnEnter.setMinimumSize(new Dimension(0, 0));

        JButton btnCreate = new JButton("Create Project");
        btnCreate.setSize(50, 100);

        enterPanel.add(txtField);
        enterPanel.add(btnEnter);

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        centerPanel.add(enterPanel);
        centerPanel.add(btnCreate);
        
        return centerPanel;
            
    }
    
    
}
