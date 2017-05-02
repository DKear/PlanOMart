package admin;

import net.miginfocom.swing.MigLayout;

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
}
