package PAINTogether.swingGUI.room_form_class;

import PAINTogether.components.Drawer;
import PAINTogether.dispatcher.ServerDispatcher;
import PAINTogether.listener.SimpleMouseListener;
import PAINTogether.utils.FormManager;
import PAINTogether.utils.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by samuel on 08/12/16.
 */
public class TopBar extends JPanel {
    private JLabel roomNumberLabel;
    private JLabel userCountLabel;

    public TopBar() {
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());

        Drawer.getInstance().setTopBar(this);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, 2));
        btnPanel.setBackground(Color.DARK_GRAY);

        JButton btnClear = new JButton("Clear Project"); //CLEAR BUTTON
        JButton btnExit = new JButton("Close Project"); //EXIT BUTTON

        btnPanel.add(btnClear);
        btnPanel.add(btnExit);

        //CLEAR BUTTON EVENT
        SimpleMouseListener btnClearListener = new SimpleMouseListener(btnClear);
        btnClearListener.setMousePressHandler(new SimpleMouseListener.MousePressEvent() {
            @Override
            public void onMousePress(MouseEvent e) {
                String message = "Do you want to CLEAN this project?";
                String title = "Alert Clear Project";
                int confirmation = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    Drawer.getInstance().clear();

                    if (Settings.getInstance().isOnline())
                        ServerDispatcher.getInstance().clearRoom();
                }
            }
        });

        //CLOSE BUTTON EVENT
        SimpleMouseListener btnCloseListener = new SimpleMouseListener(btnExit);
        btnCloseListener.setMousePressHandler(new SimpleMouseListener.MousePressEvent() {
            @Override
            public void onMousePress(MouseEvent e) {
                String message = "Do you want to CLOSE this project?";
                String title = "Alert Close Project";
                int confirmation = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    Drawer.getInstance().clear();
                    ServerDispatcher.getInstance().leaveRoom();
                    FormManager.getInstance().closeCurrentForm();
                }
            }
        });

        //TOP TEXT ONLINE E OFFLINE MODE//
        if (Settings.getInstance().isOnline())
            this.add(initTextInformationOnline(), BorderLayout.WEST);
        else
            this.add(initTextInformationOffline(), BorderLayout.WEST);

        this.add(btnPanel, BorderLayout.EAST);

    }

    private JPanel initTextInformationOnline() {
        JPanel txtPanel = new JPanel();
        txtPanel.setBackground(Color.DARK_GRAY);

        JLabel txtRoom = new JLabel("Room Number: ");
        roomNumberLabel = new JLabel(String.valueOf(Settings.getInstance().getRoomId()));
        JLabel txtUsers = new JLabel("    Users Online: ");
        userCountLabel = new JLabel("1");

        txtRoom.setForeground(Color.white);
        roomNumberLabel.setForeground(Color.cyan);
        txtUsers.setForeground(Color.white);
        userCountLabel.setForeground(Color.green);

        txtPanel.add(txtRoom);
        txtPanel.add(roomNumberLabel);
        txtPanel.add(txtUsers);
        txtPanel.add(userCountLabel);

        return txtPanel;
    }

    private JPanel initTextInformationOffline() {
        JPanel txtPanel = new JPanel();
        txtPanel.setBackground(Color.DARK_GRAY);

        JLabel txtMessage = new JLabel("Offline Poject");

        txtMessage.setForeground(Color.cyan);
        txtPanel.add(txtMessage);

        return txtPanel;
    }

    public JLabel getRoomNumberLabel() {
        return roomNumberLabel;
    }

    public JLabel getUserCountLabel() {
        return userCountLabel;
    }

}
