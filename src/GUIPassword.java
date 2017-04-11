import javax.swing.*;
import java.awt.*;

/**
 * Created by Jamie on 4/10/2017.
 */
public class GUIPassword extends JDialog {
    JPasswordField passwordField;
    JButton submitButton;
    private char[] password = {'P','l','a','n','O','M','a','r','t'};

    public GUIPassword(){
        setSize(400,300);
        passwordField = new JPasswordField(20);
        submitButton = new JButton("Submit");
        setVisible(false);
        //addListeners();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
    }

    public boolean correctPassword(char[] in){
        if(in.equals(password)){
            return true;
        } else {
            return false;
        }
    }



}
