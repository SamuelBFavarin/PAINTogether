package PAINTogether.swingGUI.room_form_class;

import PAINTogether.listener.DrawMouseListener;
import PAINTogether.musicThreads.MusicThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author samuel
 */
public class RoomForm extends JFrame {
    private MusicThread soundsThread;

    public RoomForm() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(500, 700));
        this.setLayout(new BorderLayout());

        DrawArea drawArea = new DrawArea();
        TopBar topbar = new TopBar();

        this.add(topbar, BorderLayout.NORTH);
        this.add(new LeftBar(), BorderLayout.WEST);
        this.add(drawArea, BorderLayout.CENTER);

        new DrawMouseListener(drawArea);

        this.setVisible(true);

        soundsThread = new MusicThread();
        soundsThread.start();

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {
                if (soundsThread.isAlive() && !soundsThread.isInterrupted())
                    soundsThread.interrupt();
            }
        });
    }

    public MusicThread getSoundsThread() {
        return soundsThread;
    }

}
