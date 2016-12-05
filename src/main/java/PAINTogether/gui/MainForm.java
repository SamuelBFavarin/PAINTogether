package PAINTogether.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author samuel
 */
public class MainForm extends JFrame {
   
    public MainForm() throws HeadlessException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 500);
        this.setLocationRelativeTo(null);
        
        this.setLayout(new BorderLayout());
        this.add(initTopLayout(),BorderLayout.NORTH);
        this.add(initCenterLayout(), BorderLayout.CENTER);
        this.setVisible(true);
    }
    
    public JPanel initTopLayout(){
        JPanel topPanel = new JPanel();
        JLabel title = new JLabel("PAINTogether");
        title.setFont(new Font("Arial", Font.BOLD, 32));;
        title.setForeground (Color.WHITE);
        topPanel.add(title);
        topPanel.setBackground(Color.DARK_GRAY);
        return topPanel;
    }
    
    public JPanel initCenterLayout(){
        JPanel centerPanel = new JPanel();
        JTextField txtField = new JTextField("Room Number");
        txtField.setSize(20,50);
        JButton btnEnter = new JButton("ENTER");
        btnEnter.setSize(50, 100);
        JButton btnCreate = new JButton("Create Project");
        btnCreate.setSize(50, 100);
        
        centerPanel.setLayout(new BoxLayout(centerPanel,BoxLayout.PAGE_AXIS));
        centerPanel.add(Box.createRigidArea(new Dimension(100, 100)));
        centerPanel.add(txtField);
        centerPanel.add(btnEnter);
        centerPanel.add(btnCreate);
        
        return centerPanel;
            
    }
    
    
}
