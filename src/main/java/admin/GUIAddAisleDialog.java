package admin;

import net.miginfocom.swing.MigLayout;
import store.locations.Aisle;
import store.locations.Store;
import javax.swing.*;
import java.awt.*;

public class GUIAddAisleDialog extends JDialog {

    private JLabel aisleNameLabel = new JLabel("Place aisle name here:");
    public JTextField aisleNameField = new JTextField();
    private JLabel aisleTagLabel = new JLabel("Place aisle tags here, separated by a comma and space. Ex. sliced, white");
    public JTextField aisleTagField = new JTextField();
    public JComboBox sectionDropBox;
    private JLabel locationLabel = new JLabel("Location of Aisle:");
    public JButton submitButton = new JButton("Submit");
    private boolean fcheck = false;

    public GUIAddAisleDialog() {
        setSize(1024, 412);
        JPanel panel = new JPanel();

        //Constructing and designing itemName stuff
        aisleNameField.setPreferredSize(new Dimension(300, 50));

        //Constructing and designing sectionDropBox
        sectionDropBox = new JComboBox();
        sectionDropBox.setPreferredSize(new Dimension(300, 50));
        sectionDropBox.addItem("Select a Section...");

        aisleTagField.setPreferredSize(new Dimension(300, 50));

        //Constructing and designing submitButton
        submitButton.setPreferredSize(new Dimension(100, 50));

        //Adding the elements above to the panel
        panel.setLayout(new MigLayout("", "[align center]", "[align center]"));
        panel.add(locationLabel, "cell 0 0");
        panel.add(aisleNameLabel, "cell 2 0");
        panel.add(aisleNameField, "cell 3 0");
        panel.add(aisleTagLabel, "cell 2 1");
        panel.add(aisleTagField, "cell 3 1");
        panel.add(sectionDropBox, "cell 1 0");
        panel.add(submitButton, "cell 3 2");

        add(panel);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000, 600);

        setVisible(false);
    }
    public void addTheAisle(Store store) {
        String name = aisleNameField.getText();
        Aisle newAisle = new Aisle(name);
        String tagsTogether = aisleTagField.getText();
        if (!tagsTogether.equals("")) { //adds tags if there are any
            String[] allTags = tagsTogether.split(", ");
            for (String s : allTags) {
                newAisle.addTag(s);
            }}
        int sectionIndex = sectionDropBox.getSelectedIndex() - 1;
        if (newAisle.validateAisle() && sectionIndex != -1) {//if it's a valid aisle name
            if (store.getSections()[sectionIndex].hasAisle()) {//if other aisles are in the section
                for (Aisle a : store.getSections()[sectionIndex].getAisles()) {
                    boolean check = newAisle.getAisleName().equalsIgnoreCase(a.getAisleName());//checking to see if it already exists
                    fcheck = check || fcheck; //will return false unless an aisle with that name already exists in that section
                }
                if (fcheck == false) {
                    store.getSections()[sectionIndex].addAisle(newAisle);
                    newAisle.setSection(store.getSections()[sectionIndex]);
                    aisleNameField.setText("");
                    aisleTagField.setText("");
                    setVisible(false);
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                } else {
                    JOptionPane.showMessageDialog(this, "Aisle already exists in Section.");
                    fcheck = false;
                }
            } else { //if it's a valid aisle and no other aisles are in that section, it adds it immediately
                store.getSections()[sectionIndex].addAisle(newAisle);
                newAisle.setSection(store.getSections()[sectionIndex]);
                aisleNameField.setText("");
                aisleTagField.setText("");
                setVisible(false);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            }
        } else if (sectionIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select a section first.");
        } else if (!newAisle.validateAisle()) {
            JOptionPane.showMessageDialog(this, "Make sure the name is filled out.");
        }
    }
}