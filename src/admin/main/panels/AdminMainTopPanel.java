package admin.main.panels;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;


public class AdminMainTopPanel extends JPanel {
    private JLabel title;
    private JLabel adminLabel;

    public AdminMainTopPanel() {

        setBorder(new BevelBorder(BevelBorder.RAISED));
        title = new JLabel("Plan-O-Mart");
        title.setFont(new Font("Arial", Font.BOLD, 64));

        adminLabel = new JLabel("Administrator Account");
        adminLabel.setFont(new Font("Arials", Font.PLAIN, 32));

        setLayout(new MigLayout("", "[]", "[]push[]"));
        add(title, "align left");
        add(adminLabel, "align center");
    }
}