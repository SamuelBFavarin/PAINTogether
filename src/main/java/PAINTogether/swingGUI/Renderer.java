/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAINTogether.swingGUI;

import PAINTogether.swingGUI.room_form_class.RoomForm;

/**
 * @author samuel
 */
public class Renderer {

    public Renderer() {
        initMainForm();
        //initRoomForm();
    }

    public void initMainForm() {
        new MainForm();

    }

    public void initRoomForm() {
        new RoomForm();
    }

}
