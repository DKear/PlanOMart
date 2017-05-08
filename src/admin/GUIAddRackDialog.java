package admin;

import net.miginfocom.swing.MigLayout;
import store.locations.Rack;
import store.locations.Store;
import javax.swing.*;
import java.awt.*;

public class GUIAddRackDialog extends JDialog {
    private JLabel rackNameLabel = new JLabel("Place rack name here:");
    public JTextField rackNameField = new JTextField();
    private JLabel rackTagLabel = new JLabel("Place item tags here, separated by a comma and space. Ex. sliced, white");
    public JTextField rackTagField = new JTextField();
    public JComboBox<String> sectionDropBox = new JComboBox<>();
    public JComboBox<String> aisleDropBox = new JComboBox<>();
    private JLabel locationLabel = new JLabel("Location of Rack:");
    public JButton submitButton = new JButton("Submit");
    private boolean fcheck = false;
    String name;

    public GUIAddRackDialog() {
        setSize(1024, 412);
        JPanel panel = new JPanel();

        //Constructing and designing itemName stuff
        rackNameField.setPreferredSize(new Dimension(300, 50));

        //Constructing and designing sectionDropBox
        sectionDropBox = new JComboBox<>();
        sectionDropBox.setPreferredSize(new Dimension(300, 50));
        sectionDropBox.addItem("Select a Section...");

        //Constructing and designing aisleDropBox
        aisleDropBox = new JComboBox<>();
        aisleDropBox.setPreferredSize(new Dimension(300, 50));
        aisleDropBox.addItem("Select an Aisle...");

        rackTagField.setPreferredSize(new Dimension(300, 50));

        //Constructing and designing submitButton
        submitButton.setPreferredSize(new Dimension(100, 50));

        //Adding the elements above to the panel
        panel.setLayout(new MigLayout("", "[align center]", "[align center]"));
        panel.add(rackNameLabel, "cell 2 0");
        panel.add(rackNameField, "cell 3 0");
        panel.add(rackTagLabel, "cell 2 1");
        panel.add(rackTagField, "cell 3 1");
        panel.add(locationLabel, "cell 0 0");
        panel.add(sectionDropBox, "cell 1 0");
        panel.add(aisleDropBox, "cell 1 1");
        panel.add(submitButton, "cell 3 2");

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
    public void addTheRack(Store store) {
        name = rackNameField.getText();
        Rack newRack = new Rack(name);
        String tagsTogether = rackTagField.getText();
        if (!tagsTogether.equals("")) { //adds tags if there are any
            String[] allTags = tagsTogether.split(", ");
            for (String s : allTags) {
                newRack.addTag(s);
            }}
        int sectionIndex = sectionDropBox.getSelectedIndex() - 1;
        int aisleIndex = aisleDropBox.getSelectedIndex() - 1;
        if (newRack.validateRack() && sectionIndex != -1 && aisleIndex != -1) {//if it's a valid rack name
            if (store.getSections()[sectionIndex].getAisles()[aisleIndex].hasRacks()) {//if other racks are in the aisle
                for (Rack r : store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()) {
                    boolean check = newRack.getRackName().equalsIgnoreCase(r.getRackName());//checking to see if it already exists
                    fcheck = check || fcheck; //will return false unless a rack with that name already exists in the aisle
                }
                if (fcheck == false) {
                    store.getSections()[sectionIndex].getAisles()[aisleIndex].addRack(newRack);
                    newRack.setAisle(store.getSections()[sectionIndex].getAisles()[aisleIndex]);
                    newRack.setSection(store.getSections()[sectionIndex]);
                    rackNameField.setText("");
                    rackTagField.setText("");
                    setVisible(false);
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                } else {
                    JOptionPane.showMessageDialog(this, "Rack already exists in Aisle.");
                    fcheck = false;
                }
            } else { //if it's a valid rack and no other racks are in the aisle, it adds it immediately
                store.getSections()[sectionIndex].getAisles()[aisleIndex].addRack(newRack);
                newRack.setAisle(store.getSections()[sectionIndex].getAisles()[aisleIndex]);
                newRack.setSection(store.getSections()[sectionIndex]);
                rackNameField.setText("");
                rackTagField.setText("");
                setVisible(false);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        } else if (sectionIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select a section first.");
        } else if (aisleIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select an aisle first.");
        } else if (!newRack.validateRack()) {
            JOptionPane.showMessageDialog(this, "Make sure the name is filled out.");
        }
    }
}
