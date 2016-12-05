package PAINTogether;

import PAINTogether.gui.Renderer;

import javax.swing.*;

/**
 *
 * @author samuel
 */
public class Client {
    
    public static void main(String[] args) {
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        new Renderer();
    }
    
    
}
