package PAINTogether;

import PAINTogether.listener.ServerListener;
import PAINTogether.utils.FormManager;

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

        FormManager.getInstance().openForm(FormManager.FormType.MAIN_FORM);

        new ServerListener();

        //new Renderer(Renderer.Form.MAIN_FORM);
    }
    
}
