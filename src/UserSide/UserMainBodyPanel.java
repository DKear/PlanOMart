package UserSide;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class UserMainBodyPanel extends JPanel {

    public JTextArea returnField;
    public UserDropBoxPanel userDropBoxPanel;

    public UserMainBodyPanel() {
        setBorder(new BevelBorder(BevelBorder.RAISED));

        returnField = new JTextArea();
        returnField.setLineWrap(true);
        returnField.setWrapStyleWord(true);
        returnField.setFont(new Font("Arial", Font.PLAIN, 42));
        returnField.setEditable(false);

        userDropBoxPanel = new UserDropBoxPanel();

        setLayout(new MigLayout("insets 0 0","[fill,70%][fill,30%]","[grow]"));
        add(returnField, "grow, span 4");
        add(userDropBoxPanel, "grow");
    }

    public JTextArea getReturnField() {
        return returnField;
    }
}