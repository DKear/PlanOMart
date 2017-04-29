package admin.main.panels;

import net.miginfocom.layout.Grid;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jamie on 4/29/2017.
 */
public class GUIPasswordChange extends JPanel {
    public JPasswordField changePasswordField;
    public JPasswordField changePasswordFieldVerify;
    public JButton changePasswordButton;
    public JButton backButton;

    public GUIPasswordChange(){
        setLayout(new GridBagLayout());
        GridBagConstraints pc = new GridBagConstraints();
        setPreferredSize(new Dimension(800,600));
        changePasswordField = new JPasswordField(15);
        changePasswordFieldVerify = new JPasswordField(15);
        changePasswordButton = new JButton("Submit");
        backButton = new JButton("return");
        pc.gridx = pc.gridy = 0;
        add(new JLabel("Enter a new password:") , pc);
        pc.gridy = 1;
        add(changePasswordField,pc);
        pc.gridy = 2;
        add(new JLabel("Re-enter the new password:"),pc);
        pc.gridy = 3;
        add(changePasswordFieldVerify,pc);
        pc.gridy = 4;
        add(changePasswordButton,pc);
        pc.gridy = 5;
        add(backButton,pc);


    }
}
