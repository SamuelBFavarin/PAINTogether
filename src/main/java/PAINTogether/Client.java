package PAINTogether;

import PAINTogether.swingGUI.Renderer;

import javax.swing.*;

/**
 *
 * @author samuel
 */
public class Client {
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        new Renderer(Renderer.Form.MAIN_FORM);
    }
    
}
