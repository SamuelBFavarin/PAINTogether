package PAINTogether.components;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.net.URISyntaxException;

/**
 * Created by Lucas Baragatti on 15/12/2016.
 */
public class SocketManager {
    private static SocketManager instance;
    private Socket socket;

    private SocketManager() {
        try {
            socket = IO.socket("http://localhost:90/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static SocketManager getInstance() {
        if (instance == null)
            instance = new SocketManager();

        return instance;
    }

    public void addEventListener(String eventName, Emitter.Listener listener) {
        socket.on(eventName, listener);
    }

    public void connect() {
        socket.connect();
    }

    public void disconnect() {
        socket.disconnect();
    }

    public void emit(String name, Object... args) {
        socket.emit(name, args);
    }
}
