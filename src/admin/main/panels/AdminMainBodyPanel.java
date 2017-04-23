package admin.main.panels;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class AdminMainBodyPanel extends JPanel{

    private JTable returnField;
    public DropBoxPanel dropBoxPanel;

    public AdminMainBodyPanel(){
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

        dropBoxPanel = new DropBoxPanel();

        setLayout(new MigLayout("","[grow]","[grow]"));
        add(returnField, "grow");
        add(dropBoxPanel, "grow");
    }
}

class DropBoxPanel extends JPanel {
    public JComboBox<String> sectionDropbox;
    public JComboBox<Integer> aisleDropbox;
    public JComboBox<String> rackDropbox;
    public JComboBox<Integer> shelfDropbox;

    private JLabel sectionLabel;
    private JLabel aisleLabel;
    private JLabel rackLabel;
    private JLabel shelfLabel;

    private JButton searchButton;

    DropBoxPanel() {

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

        setLayout(new MigLayout("", "[align center]", "[align center]"));
        add(sectionLabel, "cell 0 0");
        add(sectionDropbox, "cell 1 0");

        add(aisleLabel, "cell 0 1");
        add(aisleDropbox, "cell 1 1");

        add(rackLabel, "cell 0 2");
        add(rackDropbox, "cell 1 2");

        add(shelfLabel, "cell 0 3");
        add(shelfDropbox, "cell 1 3");

        add(searchButton, "cell 1 4");


    }
    /*public void populateComboBox(String[] s){
    for(int i = 0; i < s.length; i++ ) {
        sectionDropbox.addItem(s[i]);

    }

    }*/
}