package admin;

import net.miginfocom.swing.MigLayout;
import store.locations.*;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;

public class GUIAddItemDialog extends JDialog {

    public GUIAddItemDialog() {

    }
}

class AddItemDialogPanel extends JPanel {

    private JTextField itemNameField;
    private String itemName;

    private JLabel item;
    private JFormattedTextField itemPriceField;
    private double itemPrice;

    private JTextField itemDescriptionField;
    private String itemDecription;

    private JLabel locationLabel;

    private JComboBox<Store> storeDropBox;
    private JComboBox<Section> sectionDropBox;
    private JComboBox<Aisle> aisleDropBox;
    private JComboBox<Rack> rackDropBox;
    private JComboBox<Shelf> shelfDropBox;

    private JButton submitButton;

    public AddItemDialogPanel() {

        //Constructing and designing itemName stuff
        itemNameField = new JTextField();
        itemNameField.setFont(new Font("Arial", Font.PLAIN, 16));
        itemNameField.setPreferredSize(new Dimension(300, 50));

        itemName = itemNameField.getText();

        //Constructing and designing itemPrice stuff
        itemPriceField = new JFormattedTextField(new NumberFormatter());
        itemPriceField.setFont(new Font("Arial", Font.PLAIN, 16));
        itemPriceField.setPreferredSize(new Dimension(300, 50));

        itemPrice = Double.parseDouble(itemPriceField.getText());

        //Constructing and designing itemDescription stuff
        itemDescriptionField = new JTextField("<Item Description>");
        itemDescriptionField.setFont(new Font("Arial", Font.PLAIN, 16));
        itemDescriptionField.setPreferredSize(new Dimension(300, 50));

        itemDecription = itemDescriptionField.getText();

        //Constructing and designing locationLabel
        locationLabel = new JLabel("Location of Item: ");
        locationLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        //Constructing and designing storeDropBox
        storeDropBox = new JComboBox<>();
        storeDropBox.setPreferredSize(new Dimension(300, 50));
        storeDropBox.setFont(new Font("Arial", Font.PLAIN, 16));

        //Constructing and designing sectionDropBox
        sectionDropBox = new JComboBox<>();
        sectionDropBox.setPreferredSize(new Dimension(300, 50));
        sectionDropBox.setFont(new Font("Arial", Font.PLAIN, 16));

        //Constructing and designing aisleDropBox
        aisleDropBox = new JComboBox<>();
        aisleDropBox.setPreferredSize(new Dimension(300, 50));
        aisleDropBox.setFont(new Font("Arial", Font.PLAIN, 16));

        //Constructing and designing rackDropBox
        rackDropBox = new JComboBox<>();
        rackDropBox.setPreferredSize(new Dimension(300, 50));
        rackDropBox.setFont(new Font("Arial", Font.PLAIN, 16));

        //Constructing and designing shelfDropBox
        shelfDropBox = new JComboBox<>();
        shelfDropBox.setPreferredSize(new Dimension(300, 50));
        shelfDropBox.setFont(new Font("Arial", Font.PLAIN, 16));

        //Constructing and designing submitButton
        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 50));
        submitButton.setFont(new Font("Arial", Font.PLAIN, 16));

        //Adding the elements above to the panels
        setLayout(new MigLayout("", "[align center]", "[align center]"));
        add(itemNameField, "cell 0 1");
        add(itemPriceField, "cell 1 1");
        add(itemDescriptionField, "cell 2,1");
        add(locationLabel, "cell 3 0");
        add(storeDropBox, "cell 3 1");
        add(sectionDropBox, "cell 4 1");
        add(aisleDropBox, "cell 5 1");
        add(shelfDropBox, "cell 6 1");
        add(rackDropBox, "cell 7 1");
        add(shelfDropBox, "cell 8 1");
        add(submitButton,"cell 9 1");
    }
}