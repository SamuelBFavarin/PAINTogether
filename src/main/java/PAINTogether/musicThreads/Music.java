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
public class Music extends Thread {

    public void run() {

        try {
            File file = new File("Assets/Musics/music.mp3");
            FileInputStream io = new FileInputStream(file);
            BufferedInputStream bo = new BufferedInputStream(io);
            try {
                Player player = new Player(bo);
                player.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
