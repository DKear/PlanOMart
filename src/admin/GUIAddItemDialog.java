package admin;

import net.miginfocom.swing.MigLayout;
import store.locations.*;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUIAddItemDialog extends JDialog {
    private JLabel itemNameLabel = new JLabel("Place item name here:");
    private JTextField itemNameField = new JTextField();
    private JLabel itemPriceLabel = new JLabel("Enter item price here:");
    private JFormattedTextField itemPriceField = new JFormattedTextField(new NumberFormatter());
    private JLabel itemBrandLabel = new JLabel("Enter item brand here:");
    private JTextField itemBrandField = new JTextField();
    private JLabel itemDescriptionLabel = new JLabel("Enter item description here");
    private JTextField itemDescriptionField = new JTextField();
    private JLabel locationLabel = new JLabel("Location of Item:");;
    public JComboBox<String> sectionDropBox = new JComboBox<>();
    public JComboBox<String> aisleDropBox = new JComboBox<>();
    public JComboBox<String> rackDropBox = new JComboBox<>();
    public JComboBox<String> shelfDropBox = new JComboBox<>();
    private JButton submitButton = new JButton("Submit");

    public GUIAddItemDialog() {
        setModalityType(ModalityType.APPLICATION_MODAL);
        setVisible(false);
        setSize(1024, 512);

        //Constructing and designing itemName stuff
        itemNameField.setPreferredSize(new Dimension(300, 50));

        //itemName = itemNameField.getText();

        //Constructing and designing itemPrice stuff
        itemPriceField.setPreferredSize(new Dimension(300, 50));

        //itemPrice = Double.parseDouble(itemPriceField.getText());
        itemBrandField.setPreferredSize((new Dimension(300, 50)));

        //Constructing and designing itemDescription stuff
        itemDescriptionField.setPreferredSize(new Dimension(300, 50));

        //itemDecription = itemDescriptionField.getText();

        //Constructing and designing sectionDropBox
        sectionDropBox.setPreferredSize(new Dimension(300, 50));

        //Constructing and designing aisleDropBox
        aisleDropBox.setPreferredSize(new Dimension(300, 50));

        //Constructing and designing rackDropBox
        rackDropBox.setPreferredSize(new Dimension(300, 50));

        //Constructing and designing shelfDropBox
        shelfDropBox.setPreferredSize(new Dimension(300, 50));

        //Constructing and designing submitButton
        submitButton.setPreferredSize(new Dimension(100, 50));

        //Adding the elements above to the panels
        setLayout(new MigLayout("", "[align center]", "[align center]"));
        add(itemNameLabel, " cell 2 0");
        add(itemNameField, "cell 3 0");
        add(itemPriceLabel, "cell 2 1");
        add(itemPriceField, "cell 3 1");
        add(itemBrandLabel, "cell 2 2");
        add(itemBrandField, "cell 3 2");
        add(itemDescriptionLabel, "cell 2 3");
        add(itemDescriptionField, "cell 3 3");
        add(locationLabel, "cell 0 0");
        add(sectionDropBox, "cell 1 0");
        add(aisleDropBox, "cell 1 1");
        add(rackDropBox, "cell 1 2");
        add(shelfDropBox, "cell 1 3");
        add(submitButton,"cell 1 4");
    }
}