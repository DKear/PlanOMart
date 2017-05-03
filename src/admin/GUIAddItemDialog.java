package admin;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;

public class GUIAddItemDialog extends JDialog {
    private JLabel itemNameLabel = new JLabel("Place item brand name then item name here, Ex Vans Shoes");
    public JTextField itemNameField = new JTextField();
    private JLabel itemPriceLabel = new JLabel("Enter item price here in the format of #.##:");
    public JTextField itemPriceField = new JTextField();
    private JLabel itemDescriptionLabel = new JLabel("Enter item description here");
    public JTextField itemDescriptionField = new JTextField();
    private JLabel locationLabel = new JLabel("Location of Item:");
    private JLabel itemTagLabel = new JLabel("Place item tags here, separated by a comma and space. Ex. sliced, white");
    public JTextField itemTagField = new JTextField();
    public JComboBox<String> sectionDropBox = new JComboBox<>();
    public JComboBox<String> aisleDropBox = new JComboBox<>();
    public JComboBox<String> rackDropBox = new JComboBox<>();
    public JComboBox<String> shelfDropBox = new JComboBox<>();
    public JButton submitButton = new JButton("Submit");

    public GUIAddItemDialog() {
        setSize(1024, 512);
        JPanel panel = new JPanel();

        //Constructing and designing itemName stuff
        itemNameField.setPreferredSize(new Dimension(300, 50));
        itemPriceField.setPreferredSize(new Dimension(300, 50));
        itemDescriptionField.setPreferredSize(new Dimension(300, 50));
        itemTagField.setPreferredSize(new Dimension(300, 50));

        //Constructing and designing sectionDropBox
        sectionDropBox = new JComboBox<>();
        sectionDropBox.setPreferredSize(new Dimension(300, 50));
        sectionDropBox.addItem("Select a Section...");

        //Constructing and designing aisleDropBox
        aisleDropBox = new JComboBox<>();
        aisleDropBox.setPreferredSize(new Dimension(300, 50));
        aisleDropBox.addItem("Select an Aisle...");

        //Constructing and designing rackDropBox
        rackDropBox = new JComboBox<>();
        rackDropBox.setPreferredSize(new Dimension(300, 50));
        rackDropBox.addItem("Select a Rack...");

        //Constructing and designing shelfDropBox
        shelfDropBox = new JComboBox<>();
        shelfDropBox.setPreferredSize(new Dimension(300, 50));
        shelfDropBox.addItem("Select a Shelf...");

        //Constructing and designing submitButton
        submitButton.setPreferredSize(new Dimension(100, 50));

        //Adding the elements above to the panel
        panel.setLayout(new MigLayout("", "[align center]", "[align center]"));
        panel.add(itemNameLabel, " cell 2 0");
        panel.add(itemNameField, "cell 3 0");
        panel.add(itemPriceLabel, "cell 2 1");
        panel.add(itemPriceField, "cell 3 1");
        panel.add(itemDescriptionLabel, "cell 2 2");
        panel.add(itemDescriptionField, "cell 3 2");
        panel.add(itemTagLabel, "cell 2 3");
        panel.add(itemTagField, "cell 3 3");
        panel.add(locationLabel, "cell 0 0");
        panel.add(sectionDropBox, "cell 1 0");
        panel.add(aisleDropBox, "cell 1 1");
        panel.add(rackDropBox, "cell 1 2");
        panel.add(shelfDropBox, "cell 1 3");
        panel.add(submitButton,"cell 3 4");

        add(panel);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000, 600);

        setVisible(false);
    }
}