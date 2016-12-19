package PAINTogether.musicThreads;

import javazoom.jl.player.Player;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;



/**
 * Created by samuel on 14/12/16.
 */
public class MusicThread extends Thread {
    private static String assetsPath = "Assets/";
    Clip clip = null;
    private Player musicPlayer;
    private AudioInputStream musicStream;

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
            File file = new File(assetsPath + "/Musics/music.wav");
            musicStream = AudioSystem.getAudioInputStream(file);

        } catch (IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    private void playMusic() {
        /*
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
        }*/

        DataLine.Info info = new DataLine.Info(Clip.class, musicStream.getFormat());
        try {
            clip = (Clip) AudioSystem.getLine(info);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            try {
                clip.open(musicStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void onInterrupted() {
        if (musicPlayer != null)
            musicPlayer.close();
    }
}
