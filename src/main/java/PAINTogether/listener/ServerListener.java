package PAINTogether.listener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import PAINTogether.components.Component;
import PAINTogether.components.Drawer;
import PAINTogether.components.SocketManager;
import PAINTogether.shared.ComponentWrapper;
import PAINTogether.utils.Serializer;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.util.ArrayList;

/**
 * @author samuel
 */
public class ServerListener {

    public ServerListener(SocketManager socketManager) {
        socketManager.addEventListener(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... objects) {
                System.out.println("CONECTADO!");
            }
        });

        socketManager.addEventListener("cl_clear_room", new Emitter.Listener() {
            @Override
            public void call(Object... objects) {
                Drawer.getInstance().clear();
            }
        });

        socketManager.addEventListener("cl_receive_data", new Emitter.Listener() {
            @Override
            public void call(Object... objects) {
                ComponentWrapper[] componentWrappers = Serializer.fromJson(String.valueOf(objects[0]), ComponentWrapper[].class);

                if (componentWrappers.length > 0) {
                    ArrayList<Component> componentList = Serializer.unwrapComponents(componentWrappers);

                    for (Component c : componentList)
                        Drawer.getInstance().addComponent(c);

                    Drawer.getInstance().repaint();
                }
            }
        });

        socketManager.addEventListener("cl_user_count", new Emitter.Listener() {
            @Override
            public void call(Object... objects) {
                int userCount = Integer.parseInt(String.valueOf(objects[0]));
                //TODO implementar atualizacao do numero de usuarios la na topbar
                //TODO a variavel userCount eh atualizada com o numero de usuarios na sala
            }
        });
    }


}
