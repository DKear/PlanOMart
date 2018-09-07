package admin;

import net.miginfocom.swing.MigLayout;
import store.locations.SaleItem;
import store.locations.Store;
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
    private boolean fcheck = false;
    public String name;

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
    public void populateAisleBox(Store store) {
        int sectionIndex = sectionDropBox.getSelectedIndex();
        if (sectionIndex != -1) {//makes sure an index is selected first, populates aisles
            aisleDropBox.removeAllItems();//clears the list so only the proper are in the box
            rackDropBox.removeAllItems();
            shelfDropBox.removeAllItems();
            aisleDropBox.addItem("Select an Aisle...");
            rackDropBox.addItem("Select a Rack...");
            shelfDropBox.addItem("Select a Shelf...");
            if (sectionIndex != 0) {
                for (int i = 0; i < store.getSections()[sectionIndex - 1].getAisles().length; i++) {//first index is the select a ...
                    aisleDropBox.addItem(store.getSections()[sectionIndex - 1].getAisles()[i].getAisleName());
                }}}}
    public void populateRackBox(Store store) {
        int sectionIndex = sectionDropBox.getSelectedIndex();
        int aisleIndex = aisleDropBox.getSelectedIndex();
        if (aisleIndex != -1) {//makes sure an index is selected first, populates racks
            rackDropBox.removeAllItems();//clears the list so only the proper are in the box
            shelfDropBox.removeAllItems();
            rackDropBox.addItem("Select a Rack...");
            shelfDropBox.addItem("Select a Shelf...");
            if (aisleIndex != 0) {
                for (int i = 0; i < store.getSections()[sectionIndex - 1].getAisles()[aisleIndex - 1].getRack().length; i++) {//first index is the "select a ..."
                    rackDropBox.addItem(store.getSections()[sectionIndex - 1].getAisles()[aisleIndex - 1].getRack()[i].getRackName());
                }}}}
    public void poplateShelfBox(Store store) {
        int sectionIndex = sectionDropBox.getSelectedIndex();
        int aisleIndex = aisleDropBox.getSelectedIndex();
        int rackIndex = rackDropBox.getSelectedIndex();
        if (rackIndex != -1) {
            shelfDropBox.removeAllItems();//clears the list so only the proper are in the box
            shelfDropBox.addItem("Select a shelf...");
            if (rackIndex != 0) {
                for (int i = 0; i < store.getSections()[sectionIndex - 1].getAisles()[aisleIndex - 1].getRack()[rackIndex - 1].getShelf().length;
                     i++) {//first index is the "select a ..."
                     shelfDropBox.addItem(store.getSections()[sectionIndex - 1].getAisles()[aisleIndex - 1].getRack()[rackIndex - 1].getShelf()[i].getRowName());
                }}}}
    public void addTheItem(Store store) {
        double price;
        if (!itemPriceField.getText().equals("")) {
            try {
                price = Double.parseDouble(itemPriceField.getText());
            } catch (NumberFormatException n) {
                price = -1;
            }
        } else {
            price = -1;
        }
        String desc = itemDescriptionField.getText();
        name  = itemNameField.getText();
        SaleItem newItem = new SaleItem(price, name, desc);
        String tagsTogether = itemTagField.getText();
        if (!tagsTogether.equals("")) { //adds tags if there are any
            String[] allTags = tagsTogether.split(", ");
            for (String s : allTags) {
                newItem.addTag(s);
            }}
        int sectionIndex = sectionDropBox.getSelectedIndex() - 1;
        int aisleIndex = aisleDropBox.getSelectedIndex() - 1;
        int rackIndex = rackDropBox.getSelectedIndex() - 1;
        int shelfIndex = shelfDropBox.getSelectedIndex() - 1;
        if (newItem.validateItem() && sectionIndex != -1 && aisleIndex != -1 && rackIndex != -1 && shelfIndex != -1) {//if it's a valid item
            if (store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].getShelf()[shelfIndex].hasItems()) {//if other items are on the shelf
                for (SaleItem s : store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].getShelf()[shelfIndex].getItemsOnShelf()) {
                    boolean check = newItem.getName().equalsIgnoreCase(s.getName());//checking to see if it already exists
                    fcheck = check || fcheck; //will return false unless an item with that name and brand already exists on the shelf
                }
                if (fcheck == false) {
                    store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].getShelf()[shelfIndex].addItem(newItem);
                    newItem.setShelf(store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].getShelf()[shelfIndex]);
                    setVisible(false);
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                } else {
                    JOptionPane.showMessageDialog(this, "Item already exists on shelf.");
                    fcheck = false;
                }
            } else { //if it's a valid item and no other items are on the shelf, it adds it immediately
                store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].getShelf()[shelfIndex].addItem(newItem);
                newItem.setShelf(store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].getShelf()[shelfIndex]);
                setVisible(false);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        } else if (sectionIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select a section first.");
        } else if (aisleIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select an aisle first.");
        } else if (rackIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select a rack first.");
        } else if (shelfIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select a shelf first.");
        } else if (!newItem.validateItem()) {
            JOptionPane.showMessageDialog(this, "Make sure all item fields are filled out properly. Ex. price #.##");
        }
    }
}