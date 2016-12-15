package PAINTogether.swingGUI;

import PAINTogether.dispatcher.ServerDispatcher;
import PAINTogether.listener.SimpleMouseListener;
import PAINTogether.utils.FormManager;
import PAINTogether.utils.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;

/**
 * @author samuel
 */
public class MainForm extends JFrame {

    public MainForm() throws HeadlessException {
        //DEFINIÇOES DO FRAME
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 350);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(300, 350));
        this.setResizable(false);

        this.setLayout(new BorderLayout());
        this.add(initTopLayout(), BorderLayout.NORTH);
        this.add(initCenterLayout(), BorderLayout.CENTER);
        this.setVisible(true);
    }

    private JPanel initTopLayout() {
        //TITLE BAR
        JPanel topPanel = new JPanel();
        JLabel title = new JLabel("PAINTogether");
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(Color.WHITE);
        topPanel.add(title);
        topPanel.setBackground(Color.DARK_GRAY);
        return topPanel;
    }

    private JPanel initCenterLayout() {
        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        centerPanel.add(initEnterArea());
        centerPanel.add(Box.createRigidArea(new Dimension(30, 30)));
        centerPanel.add(initCreateArea());
        centerPanel.add(Box.createRigidArea(new Dimension(5, 5)));
        centerPanel.add(initOfflineArea());

        return centerPanel;
    }

    private JPanel initEnterArea() {
        JPanel enterPanel = new JPanel();

        JTextField txtField = new JTextField();
        txtField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                txtField.setText(txtField.getText().replaceAll("[^0-9]", ""));
            }
        });
        txtField.setPreferredSize(new Dimension(60, 20));
        //txtField.setMaximumSize(new Dimension(this.getWidth() * 100, 20));

        JButton btnEnter = new JButton("ENTER");
        btnEnter.setMinimumSize(new Dimension(0, 0));

        SimpleMouseListener btnEnterClick = new SimpleMouseListener(btnEnter);
        btnEnterClick.setMousePressHandler(new SimpleMouseListener.MousePressEvent() {
            @Override
            public void onMousePress(MouseEvent e) {
                txtField.setText(txtField.getText().replaceAll("[^0-9]", ""));
                if (!txtField.getText().isEmpty())
                    ServerDispatcher.getInstance().joinRoom(Integer.parseInt(txtField.getText()));
            }
        });

        enterPanel.add(txtField);
        enterPanel.add(btnEnter);
        enterPanel.setMaximumSize(new Dimension(this.getWidth(), 250));

        return enterPanel;
    }

    private JPanel initCreateArea() {
        JPanel createPanel = new JPanel();

        JLabel txt = new JLabel("Create a new room");
        txt.setFont(new Font("Arial", Font.BOLD, 12));
        txt.setForeground(Color.DARK_GRAY);

        JButton btnCreate = new JButton("Create Project");
        btnCreate.setSize(this.getWidth(), 50);
        createPanel.setLayout(null);
        createPanel.add(btnCreate);

        //CREATE ONLINE PROJECT EVENT
        SimpleMouseListener mouseListener = new SimpleMouseListener(btnCreate);
        mouseListener.setMousePressHandler(new SimpleMouseListener.MousePressEvent() {
            @Override
            public void onMousePress(MouseEvent e) {
                Settings.getInstance().setOnline(true);
                FormManager.getInstance().openForm(FormManager.FormType.ROOM_FORM);
            }
        });

        return createPanel;

    }

    private JPanel initOfflineArea() {
        JPanel offlinePanel = new JPanel();

        JButton btnOff = new JButton("Create Offline Project");
        btnOff.setSize(this.getWidth(), 50);
        offlinePanel.setLayout(null);
        offlinePanel.add(btnOff);

        //CREATE OFFLINE PROJECT EVENT
        SimpleMouseListener mouseListener = new SimpleMouseListener(btnOff);
        mouseListener.setMousePressHandler(new SimpleMouseListener.MousePressEvent() {
            @Override
            public void onMousePress(MouseEvent e) {
                Settings.getInstance().setOnline(false);
                FormManager.getInstance().openForm(FormManager.FormType.ROOM_FORM);
            }
        });

        return offlinePanel;
    }


}
