package PAINTogether.utils;

/**
 * Created by Lucas Baragatti on 14/12/2016.
 */
public class Configuracoes {
    private static Configuracoes instance;
    private boolean online = true;

    private Configuracoes() {
    }

    public static Configuracoes getInstance() {
        if (instance == null)
            instance = new Configuracoes();

        return instance;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

}
