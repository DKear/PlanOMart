import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GUIPassword extends JDialog {
    JPasswordField passwordField;
    JButton submitButton;
    private char[] password = {'P','l','a','n','O','M','a','r','t'};
    private JPanel passwordPanel;

    public GUIPassword(){

        setSize(400,300);
        passwordField = new JPasswordField(20);
        submitButton = new JButton("Submit");

        passwordPanel = new JPanel();
        passwordPanel.setLayout(new GridBagLayout());
        GridBagConstraints pwc = new GridBagConstraints();
        pwc.gridx = pwc.gridy = 0;
        passwordPanel.add(new JLabel("Enter password (default is 'PlanOMart') "), pwc);
        pwc.gridy = 1;
        passwordPanel.add(passwordField, pwc);
        pwc.gridy = 2;
        passwordPanel.add(submitButton, pwc);

        add(passwordPanel);
        setVisible(false);
        //addListeners();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
    }

    public boolean correctPassword(char[] in){
        if(in.length != password.length){
            return false;
        } else {
            return Arrays.equals(in, password);
        }
    }

    public void changePassword(char[] newPass){
        password = newPass;
    }


}
