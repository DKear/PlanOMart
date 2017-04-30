package admin;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by joshu on 4/29/2017.
 */
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
}
