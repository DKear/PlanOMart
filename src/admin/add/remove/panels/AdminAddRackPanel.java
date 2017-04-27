package admin.add.remove.panels;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminAddRackPanel extends JPanel {
    public JLabel rackNameLabel;
    public JTextField rackNameField;

    public JLabel rackTagLabel;
    public JTextField rackTagField;
    public JLabel rackTagDescLabel;

    public JLabel rackLocationLabel;
    public JComboBox rackLocationDropBox;

    public JButton submitButton;

    public String rackName;
    public String tag;
    public String[] tagArray;

    public AdminAddRackPanel() {
        setBorder(new BevelBorder(BevelBorder.RAISED));

        rackNameLabel = new JLabel("Rack Name: ");
        rackNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        rackNameField = new JTextField();
        rackNameField.setPreferredSize(new Dimension(300, 50));
        rackNameField.setFont(new Font("Arial", Font.PLAIN, 16));

        rackTagLabel = new JLabel("Tags: ");
        rackTagLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        rackTagField = new JTextField();
        rackTagField.setPreferredSize(new Dimension(300, 50));
        rackTagField.setFont(new Font("Arial", Font.PLAIN, 16));

        rackTagDescLabel = new JLabel("Use a comma then a space to separate tags.");
        rackTagDescLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        rackLocationLabel = new JLabel("Location: ");
        rackLocationLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        rackLocationDropBox = new JComboBox<>();
        rackLocationDropBox.setPreferredSize(new Dimension(300, 50));
        rackLocationDropBox.setFont(new Font("Arial", Font.PLAIN, 16));

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 50));
        submitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        submitButton.addActionListener(this::submitButtonClicked);

        rackName = new String();
        tag = new String();

        //Adding the elements above to the panel
        setLayout(new MigLayout("", "[]push[]", "[]"));
        add(rackNameLabel, "cell 0 0");
        add(rackNameField, "cell 1 0, wrap, growx");
        add(rackTagLabel, "cell 0 1");
        add(rackTagField, "cell 1 1, wrap, growx");
        add(rackTagDescLabel, "cell 1 2, wrap");
        add(rackLocationLabel, "cell 0 3");
        add(rackLocationDropBox, "cell 1 3, wrap");
        add(submitButton, "cell 1 4");
    }

    //ActionListener Method for above Lambda Expression:
    public void submitButtonClicked(ActionEvent e) {
        rackName = rackNameField.getText();
        tag = rackTagField.getText();
        tagArray = tag.split(", ");
        rackTagField.setText("");
        rackTagField.setText("");
        AdminAddRemovePanelBottom.guiAddRackDialog.setVisible(false);
    }
}
