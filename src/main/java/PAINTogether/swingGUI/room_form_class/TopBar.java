package PAINTogether.swingGUI.room_form_class;

import PAINTogether.components.Drawer;
import PAINTogether.listener.SimpleMouseListener;
import PAINTogether.utils.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

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

        //CLEAR BUTTON EVENT
        SimpleMouseListener btnClearListener = new SimpleMouseListener(btnClear);
        btnClearListener.setMousePressHandler(new SimpleMouseListener.MousePressEvent() {
            @Override
            public void onMousePress(MouseEvent e) {
                Drawer.getInstance().clear();
                System.out.println("CLEAR");
            }
        });

        //CLOSE BUTTON EVENT
        SimpleMouseListener btnCloseListener = new SimpleMouseListener(btnExit);
        btnCloseListener.setMousePressHandler(new SimpleMouseListener.MousePressEvent() {
            @Override
            public void onMousePress(MouseEvent e) {
                //RoomForm.super.dispose();

                System.out.println("FECHAR TELA");
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

    private JPanel initTextInformationOffline() {
        JPanel txtPanel = new JPanel();
        txtPanel.setBackground(Color.DARK_GRAY);

        JLabel txtMessage = new JLabel("Offline Poject");

        txtMessage.setForeground(Color.cyan);
        txtPanel.add(txtMessage);

        return txtPanel;
    }


}
