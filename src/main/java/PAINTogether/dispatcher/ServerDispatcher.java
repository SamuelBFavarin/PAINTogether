package PAINTogether.dispatcher;

import PAINTogether.components.Component;
import PAINTogether.components.SocketManager;
import com.google.gson.Gson;

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

    public void joinRoom(int roomId) {
        SocketManager.getInstance().emit("sv_join_room", roomId);
    }

    public void addComponent(Component component) {
        components.add(component);

        if (components.size() >= maxComponents)
            dispatch();
    }

    public void dispatch() {
        if (components.size() == 0)
            return;

        System.out.println("Disparando " + components.size() + " objetos");

        String json = new Gson().toJson(components);
        SocketManager.getInstance().emit("sv_send_data", json);


        components.clear();
    }

}
