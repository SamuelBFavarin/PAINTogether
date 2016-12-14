package PAINTogether.utils;

/**
 * Created by Lucas Baragatti on 14/12/2016.
 */
public class Settings {
    private static Settings instance;
    private boolean online = true;

    private Settings() {
    }

    public static Settings getInstance() {
        if (instance == null)
            instance = new Settings();

        return instance;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

}
