package admin.main.panels;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class AdminMainBodyPanel extends JPanel{

    private JTable returnField;
    private DropBoxPanel dropBoxPanel;

    public AdminMainBodyPanel(){
        setBorder(new BevelBorder(BevelBorder.RAISED));

        //ADDING DUMBY DATA (delete after)
        String[] columns = {
                "Hello",
                "Goodbye"
        };

        Object[][] data ={
                {
                        "Hi", 5
                },
                {
                        "Bye", 8
                },
                {
                        "Cya", 42
                }
        };
        returnField = new JTable(data, columns);
        returnField.setFont(new Font("Arial", Font.PLAIN, 42));
        returnField.setRowHeight(50);

        dropBoxPanel = new DropBoxPanel();

        setLayout(new MigLayout("insets 0 0","[fill,75%][fill,25%]","[grow]"));
        add(returnField, "grow, span 4");
        add(dropBoxPanel, "grow");
    }

    public JTable getReturnField() {
        return returnField;
    }
}

class DropBoxPanel extends JPanel {
    public JTextField searchField;

    private JComboBox<String> sectionDropbox;
    private JComboBox<Integer> aisleDropbox;
    private JComboBox<String> rackDropbox;
    private JComboBox<Integer> shelfDropbox;

    private JLabel sectionLabel;
    private JLabel aisleLabel;
    private JLabel rackLabel;
    private JLabel shelfLabel;

    private JButton searchButton;

    DropBoxPanel() {
        setBorder(new BevelBorder(BevelBorder.RAISED));
        searchField = new JTextField("Search");
        searchField.setPreferredSize(new Dimension(300, 50));
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));

        sectionLabel = new JLabel("Sections: ");
        sectionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        sectionDropbox = new JComboBox<>();
        sectionDropbox.setPreferredSize(new Dimension(300, 50));
        sectionDropbox.setFont(new Font("Arial", Font.PLAIN, 16));

        aisleLabel = new JLabel("Aisle: ");
        aisleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        aisleDropbox = new JComboBox<>();
        aisleDropbox.setPreferredSize(new Dimension(300,50));
        aisleDropbox.setFont(new Font("Arial", Font.PLAIN, 16));

        rackLabel = new JLabel("Rack: ");
        rackLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        rackDropbox = new JComboBox<>();
        rackDropbox.setPreferredSize(new Dimension(300,50));
        rackLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        shelfLabel = new JLabel("Shelf: ");
        shelfLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        shelfDropbox = new JComboBox<>();
        shelfDropbox.setPreferredSize(new Dimension(300,50));
        shelfDropbox.setFont(new Font("Arial", Font.PLAIN, 16));

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(100,50));
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