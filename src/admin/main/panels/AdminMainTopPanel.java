package admin.main.panels;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminMainTopPanel extends JPanel {
    private JLabel title;
    private JTextField searchField;

    public AdminMainTopPanel(){
        title = new JLabel("Plan-O-Mart");
        title.setPreferredSize(new Dimension(400,600));
        title.setFont(new Font("Arial", Font.BOLD, 64));

        searchField = new JTextField("Search");
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));
        searchField.setPreferredSize(new Dimension(300,50));
        searchField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchField.setText("");
            }
        });

        setLayout(new MigLayout("", "[grow]", "[]push[]"));

        add(title, "grow");
        add(searchField, "align right");
    }
}