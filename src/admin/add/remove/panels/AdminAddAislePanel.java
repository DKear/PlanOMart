package admin.add.remove.panels;

import net.miginfocom.swing.MigLayout;
import store.locations.Section;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminAddAislePanel extends JPanel {

    public JLabel aisleNameLabel;
    public JTextField aisleNameField;

    public JLabel aisleTagLabel;
    public JTextField aisleTagField;
    public JLabel aisleTagDescLabel;

    public JLabel aisleLocationLabel;
    public JComboBox aisleLocationDropBox;

    public JButton submitButton;

    public String aisleName;
    public String tag;
    public String[] tagArray;
    public Section aisleLocation;

    public AdminAddAislePanel() {
        setBorder(new BevelBorder(BevelBorder.RAISED));

        aisleNameLabel = new JLabel("Name: ");
        aisleNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        aisleNameField = new JTextField();
        aisleNameField.setPreferredSize(new Dimension(300, 50));
        aisleNameField.setFont(new Font("Arial", Font.PLAIN, 16));

        aisleTagLabel = new JLabel("Tags: ");
        aisleTagLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        aisleTagField = new JTextField();
        aisleTagField.setPreferredSize(new Dimension(300, 50));
        aisleTagField.setFont(new Font("Arial", Font.PLAIN, 16));

        aisleTagDescLabel = new JLabel("Use a comma then a space to separate tags.");
        aisleTagDescLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        aisleLocationLabel = new JLabel("Location: ");
        aisleLocationLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        aisleLocationDropBox = new JComboBox<>();
        aisleLocationDropBox.setPreferredSize(new Dimension(300, 50));
        aisleLocationDropBox.setFont(new Font("Arial", Font.PLAIN, 16));

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 50));
        submitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        submitButton.addActionListener(this::submitButtonClicked);

        aisleName = new String();
        tag = new String();

        //Layout and Design of the above GUI implements:
        setLayout(new MigLayout("", "[]push[]", "[]"));
        add(aisleNameLabel, "cell 0 0");
        add(aisleNameField, "cell 1 0, wrap");
        add(aisleTagLabel, "cell 0 1");
        add(aisleTagField, "cell 1 1,wrap");
        add(aisleTagDescLabel, "cell 1 2, wrap");
        add(aisleLocationLabel, "cell 0 3");
        add(aisleLocationDropBox,"cell 1 3, wrap");
        add(submitButton, "cell 0 4");
    }

    //ActionListener Method for above Lambda Expression:
    public void submitButtonClicked(ActionEvent e) {
        aisleName = aisleNameField.getText();
        tag = aisleTagField.getText();
        tagArray = tag.split(", ");
        //Here we'll need to add a function for the Section the Aisle belongs to
        aisleTagField.setText("");
        aisleTagField.setText("");
        AdminAddRemovePanelBottom.guiAddAisleDialog.setVisible(false);
    }
}
