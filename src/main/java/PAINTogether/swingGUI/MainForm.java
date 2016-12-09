package PAINTogether.swingGUI;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author samuel
 */
public class MainForm extends JFrame {
   
    public MainForm() throws HeadlessException {
        //DEFINIÇOES DO FRAME
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(300, 300));
        this.setResizable(false);
        
        this.setLayout(new BorderLayout());
        this.add(initTopLayout(),BorderLayout.NORTH);
        this.add(initCenterLayout(), BorderLayout.CENTER);
        this.setVisible(true);
    }
    
    public JPanel initTopLayout(){
        //DEFINIÇOES DA BARRA DE TITULO
        JPanel topPanel = new JPanel();
        JLabel title = new JLabel("PAINTogether");
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground (Color.WHITE);
        topPanel.add(title);
        topPanel.setBackground(Color.DARK_GRAY);
        return topPanel;
    }
    
    public JPanel initCenterLayout(){
        //CRIAÇAO DOS JPANELS
        JPanel centerPanel = new JPanel();
        JPanel enterPanel = new JPanel();
        JPanel createPanel = new JPanel();

        //CAIXA DE TEXTO
        JTextField txtField = new JTextField("Room Number");
        txtField.setMaximumSize(new Dimension(this.getWidth() * 100, 20));

        //BOTAO ENTER
        JButton btnEnter = new JButton("ENTER");
        btnEnter.setMinimumSize(new Dimension(0, 0));

        //TEXTO
        JLabel txtOr = new JLabel("Enter in room");
        txtOr.setFont(new Font("Arial", Font.BOLD, 12));
        txtOr.setForeground(Color.DARK_GRAY);

        //INCLUSAO DOS COMPONENTES CAIXA DE TEXTO E BOTAO ENTER NO ENTER_PANEL
        enterPanel.add(txtField);
        enterPanel.add(btnEnter);
        enterPanel.setMaximumSize(new Dimension(this.getWidth(), 250));

        //TEXTO
        JLabel txt = new JLabel("Create a new room");
        txt.setFont(new Font("Arial", Font.BOLD, 12));
        txt.setForeground(Color.DARK_GRAY);

        //BOTAO CREATE
        JButton btnCreate = new JButton("Create Project");
        btnCreate.setSize(this.getWidth(), 50);

        //INCLUSAO DO BOTAO CREATE NO CREATE_PANEL
        createPanel.setLayout(null);
        createPanel.add(btnCreate);

        //INCLUSAO DOS SUB PANELS NO PANEL PRINCIPAL
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        centerPanel.add(enterPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(30, 30)));
        centerPanel.add(createPanel);

        
        return centerPanel;
            
    }
    
    
}
