package PAINTogether.listener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import PAINTogether.components.SocketManager;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import javax.swing.*;

/**
 * @author samuel
 */
public class ServerListener {

    public ServerListener() {
        SocketManager socketManager = SocketManager.getInstance();
        

        socketManager.addEventListener(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... objects) {
                System.out.println("CONECTADO!");
            }
        });

        socketManager.addEventListener("cl_error", new Emitter.Listener() {
            @Override
            public void call(Object... objects) {
                JOptionPane.showMessageDialog(null, "ERRO: " + String.valueOf(objects[0]));
            }
        });

        socketManager.connect();
    }

}
