package PAINTogether.components;

import PAINTogether.listener.ServerListener;
import PAINTogether.shared.ServerCallback;
import io.socket.client.Ack;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.net.URISyntaxException;

/**
 * Created by Lucas Baragatti on 15/12/2016.
 */
public class SocketManager {
    private static SocketManager instance;
    //private static String serverIP = "http://localhost:9090/"; //LOCAL
    private static String serverIP = "http://ec2-52-67-227-224.sa-east-1.compute.amazonaws.com:9090/"; //ONLINE
    private Socket socket;

    private SocketManager() {
        try {
            socket = IO.socket(serverIP);
            new ServerListener(this);
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

    public void emit(String name, Object args) {
        socket.emit(name, args);
    }

    public void emit(String name, Object args, ServerCallback callback) {
        socket.emit(name, args, new Ack() {
            @Override
            public void call(Object... objects) {
                if (objects.length > 1) {
                    if (objects[0].equals("1"))
                        callback.onSuccess(objects[1]);
                    else
                        callback.onError(objects[1]);
                }
            }
        });
    }
}
