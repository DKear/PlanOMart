package admin;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class GUIAddAisleDialog extends JDialog {

    private JLabel aisleNameLabel = new JLabel("Place aisle name here:");
    public JTextField aisleNameField = new JTextField();
    private JLabel aisleTagLabel = new JLabel("Place aisle tags here, separated by a comma and space. Ex. sliced, white");
    public JTextField aisleTagField = new JTextField();
    public JComboBox<String> sectionDropBox = new JComboBox<>();
    private JLabel locationLabel = new JLabel("Location of Aisle:");
    public JButton submitButton = new JButton("Submit");

    public GUIAddAisleDialog() {
        setSize(1024, 412);
        JPanel panel = new JPanel();

        //Constructing and designing itemName stuff
        aisleNameField.setPreferredSize(new Dimension(300, 50));

        //Constructing and designing sectionDropBox
        sectionDropBox = new JComboBox<>();
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
}