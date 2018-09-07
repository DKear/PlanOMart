package UserSide;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class UserMainTopPanel extends JPanel {
    public static JLabel title = new JLabel();
    private JLabel userLabel;

    public UserMainTopPanel() {
        setBorder(new BevelBorder(BevelBorder.RAISED));

        title.setFont(new Font("Arial", Font.BOLD, 64));

        userLabel = new JLabel("User Account");
        userLabel.setFont(new Font("Arials", Font.PLAIN, 32));

        setLayout(new MigLayout("", "[]", "[]push[]"));
        add(title, "align left");
        add(userLabel, "align center");
    }
}
