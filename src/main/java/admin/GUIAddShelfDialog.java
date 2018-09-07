package admin;

import net.miginfocom.swing.MigLayout;
import store.locations.Shelf;
import store.locations.Store;

import javax.swing.*;
import java.awt.*;

public class GUIAddShelfDialog extends JDialog {

    private JLabel shelfNameLabel = new JLabel("Place shelf row/name here:");
    public JTextField shelfNameField = new JTextField();
    private JLabel shelfTagLabel = new JLabel("Place item tags here, separated by a comma and space.Ex. sliced, white");
    public JTextField shelfTagField = new JTextField();
    public JComboBox<String> sectionDropBox = new JComboBox<>();
    public JComboBox<String> aisleDropBox = new JComboBox<>();
    public JComboBox<String> rackDropBox = new JComboBox<>();
    private JLabel locationLabel = new JLabel("Location of Shelf:");
    public JButton submitButton = new JButton("Submit");
    private boolean fcheck = false;
    String name;

    public GUIAddShelfDialog() {
        setSize(1024, 412);
        JPanel panel = new JPanel();

        //Constructing and designing itemName stuff
        shelfNameField.setPreferredSize(new Dimension(300, 50));

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

        shelfTagField.setPreferredSize(new Dimension(300, 50));

        //Constructing and designing submitButton
        submitButton.setPreferredSize(new Dimension(100, 50));

        //Adding the elements above to the panel
        panel.setLayout(new MigLayout("", "[align center]", "[align center]"));
        panel.add(shelfNameLabel, "cell 2 0");
        panel.add(shelfNameField, "cell 3 0");
        panel.add(shelfTagLabel, "cell 2 1");
        panel.add(shelfTagField, "cell 3 1");
        panel.add(locationLabel, "cell 0 0");
        panel.add(sectionDropBox, "cell 1 0");
        panel.add(aisleDropBox, "cell 1 1");
        panel.add(rackDropBox, "cell 1 2");
        panel.add(submitButton, "cell 3 3");

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
            aisleDropBox.addItem("Select an aisle...");
            if (sectionIndex != 0) {
                for (int i = 0; i < store.getSections()[sectionIndex - 1].getAisles().length; i++) {//first index is the select a ...
                    aisleDropBox.addItem(store.getSections()[sectionIndex - 1].getAisles()[i].getAisleName());
                }}}}
    public void populateRackBox(Store store) {
        int sectionIndex = sectionDropBox.getSelectedIndex();
        int aisleIndex = aisleDropBox.getSelectedIndex();
        if (aisleIndex != -1) {//makes sure an index is selected first, populates racks
            rackDropBox.removeAllItems();//clears the list so only the proper are in the box
            rackDropBox.addItem("Select a rack...");
            if (aisleIndex != 0) {
                for (int i = 0;
                     i < store.getSections()[sectionIndex - 1].getAisles()[aisleIndex - 1].getRack().length;
                     i++) {//first index is the "select a ..."
                    rackDropBox.addItem(store.getSections()[sectionIndex - 1].getAisles()[aisleIndex - 1].getRack()[i].getRackName());
                }}}}

    public void addTheShelf(Store store) {
        name = shelfNameField.getText();
        Shelf newShelf = new Shelf(name);
        String tagsTogether = shelfTagField.getText();
        if (!tagsTogether.equals("")) { //adds tags if there are any
            String[] allTags = tagsTogether.split(", ");
            for (String s : allTags) {
                newShelf.addTag(s);
            }}
        int sectionIndex = sectionDropBox.getSelectedIndex() - 1;
        int aisleIndex = aisleDropBox.getSelectedIndex() - 1;
        int rackIndex = rackDropBox.getSelectedIndex() - 1;
        if (newShelf.validateShelf() && sectionIndex != -1 && aisleIndex != -1 && rackIndex != -1) {//if it's a valid shelf name
            if (store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].hasShelves()) {//if other shelves are in the rack
                for (Shelf s : store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].getShelf()) {
                    boolean check = newShelf.getRowName().equalsIgnoreCase(s.getRowName());//checking to see if it already exists
                    fcheck = check || fcheck; //will return false unless a shelf with that name already exists in the rack
                }
                if (fcheck == false) {
                    store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].addShelf(newShelf);
                    newShelf.setRack(store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex]);
                    newShelf.setAisle(store.getSections()[sectionIndex].getAisles()[aisleIndex]);
                    newShelf.setSection(store.getSections()[sectionIndex]);
                    shelfNameField.setText("");
                    shelfTagField.setText("");
                    setVisible(false);
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                } else {
                    JOptionPane.showMessageDialog(this, "Shelf already exists on Rack.");
                    fcheck = false;
                }
            } else {//if it's a valid shelf and no other shelves are in the rack, it adds it immediately
                store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].addShelf(newShelf);
                newShelf.setRack(store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex]);
                newShelf.setAisle(store.getSections()[sectionIndex].getAisles()[aisleIndex]);
                newShelf.setSection(store.getSections()[sectionIndex]);
                shelfNameField.setText("");
                shelfTagField.setText("");
                setVisible(false);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        } else if (sectionIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select a section first.");
        } else if (aisleIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select an aisle first.");
        } else if (rackIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select a rack first.");
        } else if (!newShelf.validateShelf()) {
            JOptionPane.showMessageDialog(this, "Make sure the name is filled out.");
        }
    }
}
