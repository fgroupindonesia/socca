package helper.ui;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author (c) www.fgroupindonesia.com
 */
public class TextEffect {

    final String DEFAULT_TEXT = "type something here";
    JTextField txtfield = null;
    JPasswordField passfield = null;
    JTextArea txtarea = null;

    private final int CONTAINER_TEXTFIELD = 1, CONTAINER_PASSWORD = 2, CONTAINER_TEXTAREA = 3;

    public void switchCaret() {
        if (txtfield != null) {
            txtfield.setCaret(new MyCaret());
        }

        if (passfield != null) {
            passfield.setCaret(new MyCaret());
        }
        
        if (txtarea != null) {
            txtarea.setCaret(new MyCaret());
        }
    }

    public void addTextfield(JTextField objText) {
        txtfield = objText;
    }

    public void addTextarea(JTextArea objText) {
        txtarea = objText;
    }

    public void addPasswordfield(JPasswordField objText) {
        passfield = objText;
    }

    public void animateFocusGain_JPassword() {

        if (isTextContainerEmpty(passfield, CONTAINER_PASSWORD) == false) {
            if (isTextContainerDefault(passfield, CONTAINER_PASSWORD) == true) {
                // clear up   
                passfield.setText("");
            }
        }

    }

    public void animateFocusGain_JTextfield() {

        // if the textbox is not empty
        if (isTextContainerEmpty(txtfield, CONTAINER_TEXTFIELD) == false) {
            if (isTextContainerDefault(txtfield, CONTAINER_TEXTFIELD) == true) {
                // clear up   
                txtfield.setText("");
            }
        }

    }

    public void animateFocusGain_JTextarea() {

        // if the textbox is not empty
        if (isTextContainerEmpty(txtarea, CONTAINER_TEXTAREA) == false) {
            if (isTextContainerDefault(txtarea, CONTAINER_TEXTAREA) == true) {
                // clear up   
                txtarea.setText("");
            }
        }

    }

    public void animateFocusLost_JPassword() {

        if (isTextContainerEmpty(passfield, CONTAINER_PASSWORD) == true) {
            passfield.setText(DEFAULT_TEXT);
        }

    }

    public void animateFocusLost_JTextfield() {
        if (isTextContainerEmpty(txtfield, CONTAINER_TEXTFIELD) == true) {
            txtfield.setText(DEFAULT_TEXT);
        }
    }

    public void animateFocusLost_JTextarea() {
        if (isTextContainerEmpty(txtarea, CONTAINER_TEXTAREA) == true) {
            txtarea.setText(DEFAULT_TEXT);
        }
    }

    private boolean isTextContainerDefault(Object obj, int containerMode) {

        JPasswordField passkontener;
        JTextField textkontener;
        JTextArea textkontener2;

        switch (containerMode) {
            case CONTAINER_PASSWORD:
                passkontener = (JPasswordField) obj;

                if (passkontener.getText().equalsIgnoreCase(DEFAULT_TEXT)) {
                    return true;
                }
                break;
            case CONTAINER_TEXTAREA:
                textkontener2 = (JTextArea) obj;

                if (textkontener2.getText().equalsIgnoreCase(DEFAULT_TEXT)) {
                    return true;
                }
                break;
            case CONTAINER_TEXTFIELD:
                textkontener = (JTextField) obj;

                if (textkontener.getText().equalsIgnoreCase(DEFAULT_TEXT)) {
                    return true;
                }
                break;
            default:
                break;
        }

        return false;
    }

    // checking for either TextField or PasswordField or TextArea
    private boolean isTextContainerEmpty(Object obj, int containerMode) {

        // containerMode : 
        // 1 - textfield,
        // 2 - password,
        // 3 - textarea
        if (obj != null) {

            JPasswordField kontener = null;
            JTextField kontener2 = null;
            JTextArea kontener3 = null;

            switch (containerMode) {
                case CONTAINER_PASSWORD:
                    kontener = (JPasswordField) obj;
                    if (kontener.getText().length() != 0) {
                        return false;
                    }
                    break;
                case CONTAINER_TEXTFIELD:
                    kontener2 = (JTextField) obj;
                    if (kontener2.getText().length() != 0) {
                        return false;
                    }
                    break;
                case CONTAINER_TEXTAREA:
                    kontener3 = (JTextArea) obj;
                    if (kontener3.getText().length() != 0) {
                        return false;
                    }
                    break;
                default:
                    break;
            }

        }

        return true;
    }

}
