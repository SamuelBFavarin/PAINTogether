package PAINTogether.musicThreads;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by samuel on 14/12/16.
 */
public class SoundFXThread extends Thread {

    private String soundFile;

    @Override
    public void run() {
        Player player = null;
        try {
            Thread.sleep(100);
            player = new Player(new FileInputStream("Assets/SoundFX/" + soundFile));
            player.play();
        } catch (InterruptedException ex) {
            if (player != null)
                player.close();

            Thread.currentThread().interrupt();
        } catch (FileNotFoundException | JavaLayerException e1) {
            e1.printStackTrace();
        }
    }

    public void setSoundFile(String soundFile) {
        this.soundFile = soundFile;
    }
}
