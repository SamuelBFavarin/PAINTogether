/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAINTogether.gui;

/**
 *
 * @author samuel
 */
public class Renderer {

    public Renderer() {
        //initMainForm();
        initRooForm();
        
    }
    
    public void initMainForm(){
        new MainForm();
    }

    public void initRooForm() {
        new RoomForm();
    }


}
