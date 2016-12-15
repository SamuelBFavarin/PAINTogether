package PAINTogether.musicThreads;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * Created by samuel on 14/12/16.
 */
public class MusicThread extends Thread {
    private static String assetsPath = "Assets/";
    private Player musicPlayer;
    private BufferedInputStream musicStream;

    @Override
    public void run() {
        loadMusicStream();
        playMusic();
    }

    @Override
    public void interrupt() {
        onInterrupted();

        super.interrupt();
    }

    private void loadMusicStream() {
        try {
            File file = new File(assetsPath + "/Musics/music.mp3");
            FileInputStream io = new FileInputStream(file);
            musicStream = new BufferedInputStream(io);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void playMusic() {
        if (musicStream == null)
            return;
        try {
            if (musicPlayer == null)
                musicPlayer = new Player(musicStream);

            musicPlayer.play();
            if (musicPlayer.isComplete()) {
                musicPlayer.play();
            }
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void onInterrupted() {
        if (musicPlayer != null)
            musicPlayer.close();
    }
}
