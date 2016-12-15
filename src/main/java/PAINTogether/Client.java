package PAINTogether;

import PAINTogether.utils.FormManager;

import javax.swing.*;
import java.util.Locale;

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

        Locale.setDefault(Locale.ENGLISH);

        FormManager.getInstance().openForm(FormManager.FormType.MAIN_FORM);

        //new ServerListener();

        //new Renderer(Renderer.Form.MAIN_FORM);
    }
    
}
