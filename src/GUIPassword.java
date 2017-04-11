import javax.swing.*;
import java.awt.*;

/**
 * Created by Jamie on 4/10/2017.
 */
public class GUIPassword extends JDialog {
    JPasswordField passwordField;
    JButton submitButton;
    private char[] password = {'P','l','a','n','O','M','a','r', 't'};
    private char[] input;
    private JFrame controllingFrame ;
    public GUIPassword(){
        setSize(400,300);
        passwordField = new JPasswordField(20);
        submitButton = new JButton("Submit");
        setVisible(false);
        addListeners();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
    }

    private void addListeners() {
        submitButton.addActionListener(e -> {
            input = passwordField.getPassword();
            if(input.length != password.length){
                JOptionPane.showMessageDialog(this, "Incorrect password");
                passwordField.setText("");
            } else {
                if (input.equals(password)){

                }
            }
        });

}
}
