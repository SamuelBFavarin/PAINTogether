package PAINTogether.utils;

import PAINTogether.swingGUI.MainForm;
import PAINTogether.swingGUI.room_form_class.RoomForm;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Lucas Baragatti on 14/12/2016.
 */
public class FormManager {
    private static FormManager instance;
    private ArrayList<Form> forms = new ArrayList<>();

    public static FormManager getInstance() {
        if (instance == null)
            instance = new FormManager();

        return instance;
    }

    public JFrame getCurrentForm() {
        return forms.get(forms.size() - 1).getInstance();
    }

    public void closeCurrentForm() {
        Form form = forms.get(forms.size() - 1);

        form.getInstance().dispose();

        forms.remove(form);

        if (forms.size() > 0)
            forms.get(forms.size() - 1).getInstance().setVisible(true);
    }

    public void openForm(FormType formType) {
        Form form = null;
        switch (formType) {
            case MAIN_FORM:
                form = new Form(formType, new MainForm());
                break;
            case ROOM_FORM:
                form = new Form(formType, new RoomForm());
                break;
        }

        if (form != null) {
            if (forms.size() > 0)
                forms.get(forms.size() - 1).getInstance().setVisible(false);

            forms.add(form);
        }
    }

    public enum FormType {
        MAIN_FORM, ROOM_FORM;
    }

    private class Form {
        private FormType formType;
        private JFrame instance;

        Form(FormType formType, JFrame instance) {
            this.formType = formType;
            this.instance = instance;
        }

        public JFrame getInstance() {
            return instance;
        }

        public FormType getFormType() {
            return formType;
        }
    }
}
