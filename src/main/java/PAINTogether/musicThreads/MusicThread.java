package PAINTogether.musicThreads;

import javazoom.jl.player.Player;

import java.io.FileInputStream;


/**
 * Created by samuel on 14/12/16.
 */
public class MusicThread extends Thread {

    private Player music;
    private String fileMusic = "Assets/Musics/music.mp3";

    @Override
    public void run() {
        playMusic();
    }

    @Override
    public void interrupt() {
        onInterrupted();
        super.interrupt();
    }

    private void playMusic() {
        try {
            do {
                FileInputStream buff = new FileInputStream(fileMusic);
                music = new Player(buff);
                music.play();
            } while (true);
        } catch (Exception e) {
            e.fillInStackTrace();
        }

    }

    public void onInterrupted() {
        if (music != null)
            music.close();
    }
}
