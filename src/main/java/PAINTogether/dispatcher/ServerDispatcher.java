package PAINTogether.dispatcher;

import PAINTogether.components.Component;
import PAINTogether.components.SocketManager;
import PAINTogether.shared.ServerCallback;
import PAINTogether.utils.Serializer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author samuel
 */
public class ServerDispatcher {
    private static ServerDispatcher instance;
    private static int maxComponents = 50;
    private List<Component> components = new ArrayList<>();

    public static ServerDispatcher getInstance() {
        if (instance == null)
            instance = new ServerDispatcher();

        return instance;
    }

    public void joinRoom(int roomId, ServerCallback callback) {
        SocketManager.getInstance().emit("sv_join_room", roomId, callback);
    }

    public void createRoom(ServerCallback callback) {
        SocketManager.getInstance().emit("sv_create_room", null, callback);
    }

    public void addComponent(Component component) {
        components.add(component);

        if (components.size() >= maxComponents)
            dispatch();
    }

    public void dispatch() {
        if (components.size() == 0)
            return;

        SocketManager.getInstance().emit("sv_send_data", Serializer.toJson(Serializer.wrapComponents(components)));

        components.clear();
    }

    public void clearComponents() {
        components.clear();
    }

    public void clearRoom() {
        SocketManager.getInstance().emit("sv_clear_room", null);
    }

}
