package PAINTogether.utils;

/**
 * Created by Lucas Baragatti on 14/12/2016.
 */
public class Settings {
    private static Settings instance;
    private boolean online = true;
    private int roomId = 0;

    private Settings() {
    }

    public static Settings getInstance() {
        if (instance == null)
            instance = new Settings();

        return instance;
    }

    public void setRoomId(int roomId) {
        System.out.println("Entrando na sala " + roomId);
        this.roomId = roomId;

        //TODO fazer o numero da sala setada aqui atualizar o numero da TopBar
    }

    public void setRoomId(int roomId) {
        System.out.println("Entrando na sala " + roomId);
        this.roomId = roomId;

        //TODO fazer o numero da sala setada aqui atualizar o numero da TopBar
    }    public int getRoomId() {
        return roomId;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

}
