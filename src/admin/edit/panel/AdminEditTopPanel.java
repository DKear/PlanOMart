package admin.edit.panel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class AdminEditTopPanel extends JPanel {
    private JLabel title;
    private JTextField searchField;

    public AdminEditTopPanel(){
        title = new JLabel("Plan-O-Mart");
        title.setPreferredSize(new Dimension(400,600));
        title.setFont(new Font("Arial", Font.BOLD, 64));

        searchField = new JTextField("Search");
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));
        searchField.setPreferredSize(new Dimension(300,50));

        setLayout(new MigLayout("", "[grow]", "[]push[]"));

        add(title, "grow");
        add(searchField, "align right");
    }
}