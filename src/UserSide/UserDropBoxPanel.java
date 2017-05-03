package UserSide;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserDropBoxPanel extends JPanel{

    public JComboBox<String> sectionDropbox;
    public JComboBox<String> aisleDropbox;
    public JComboBox<String> rackDropbox;
    public JComboBox<String> shelfDropbox;
    public JTextField searchField;

    private JLabel sectionLabel;
    private JLabel aisleLabel;
    private JLabel rackLabel;
    private JLabel shelfLabel;

    private JButton searchButton;

    UserDropBoxPanel() {
        setBorder(new BevelBorder(BevelBorder.RAISED));
        searchField = new JTextField("Search");
        searchField.setPreferredSize(new Dimension(300, 50));
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));
        searchField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchField.setText("");
            }
        });

        sectionLabel = new JLabel("Sections: ");
        sectionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        sectionDropbox = new JComboBox<>();
        sectionDropbox.addItem("Select a Section...");
        sectionDropbox.setPreferredSize(new Dimension(300, 50));
        sectionDropbox.setFont(new Font("Arial", Font.PLAIN, 16));

        aisleLabel = new JLabel("Aisle: ");
        aisleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        aisleDropbox = new JComboBox<>();
        aisleDropbox.addItem("Select an Aisle...");
        aisleDropbox.setPreferredSize(new Dimension(300, 50));
        aisleDropbox.setFont(new Font("Arial", Font.PLAIN, 16));


        rackLabel = new JLabel("Rack: ");
        rackLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        rackDropbox = new JComboBox<>();
        rackDropbox.addItem("Select a Rack...");
        rackDropbox.setPreferredSize(new Dimension(300, 50));
        rackLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        shelfLabel = new JLabel("Shelf: ");
        shelfLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        shelfDropbox = new JComboBox<>();
        shelfDropbox.addItem("Select a Shelf...");
        shelfDropbox.setPreferredSize(new Dimension(300, 50));
        shelfDropbox.setFont(new Font("Arial", Font.PLAIN, 16));

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(100, 50));
        searchButton.setFont(new Font("Arial", Font.PLAIN, 16));

        setLayout(new MigLayout("", "[align center]", "[align center fill,10%]"));
        add(searchField, "cell 0 0, span");

        add(sectionLabel, "cell 0 1");
        add(sectionDropbox, "cell 1 1 , span");

        add(aisleLabel, "cell 0 2");
        add(aisleDropbox, "cell 1 2, span");

        add(rackLabel, "cell 0 3");
        add(rackDropbox, "cell 1 3, span");

        add(shelfLabel, "cell 0 4");
        add(shelfDropbox, "cell 1 4, span");

        add(searchButton, "cell 1 5");
    }
}
