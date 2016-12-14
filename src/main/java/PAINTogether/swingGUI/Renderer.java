/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAINTogether.swingGUI;

import PAINTogether.musicThreads.Music;
import PAINTogether.swingGUI.room_form_class.RoomForm;

/**
 * @author samuel
 */
public class Renderer {

    public Renderer(Form form) {
        switch (form) {
            case MAIN_FORM:
                new MainForm();
                break;
            case ROOM_FORM:
                new RoomForm();
                Music music = new Music();
                music.start();
                break;
        }
    }

    public enum Form {
        MAIN_FORM, ROOM_FORM;
    }


}
