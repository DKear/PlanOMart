package admin.add.remove.panels;

import javax.swing.*;

import admin.GUIAddSectionDialog;
import admin.main.panels.AdminMainBodyPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdminAddSectionPanel extends JPanel {

    public JLabel sectionNameLabel;
    public JTextField sectionNameField;
    public JLabel sectionTagLabel;

    public JTextField sectionTagField;
    public JLabel sectionTagDescLabel;
    public JButton submitButton;


    public String sectionName;
    public String tag;
    public String[] tagArray;

    public AdminAddSectionPanel() {
        setBorder(new BevelBorder(BevelBorder.RAISED));

        sectionNameLabel = new JLabel("Section Name: ");
        sectionNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        sectionNameField = new JTextField();
        sectionNameField.setPreferredSize(new Dimension(300, 50));
        sectionNameField.setFont(new Font("Arial", Font.PLAIN, 16));

        sectionTagLabel = new JLabel("Tags: ");
        sectionTagLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        sectionTagField = new JTextField();
        sectionTagField.setPreferredSize(new Dimension(300, 50));
        sectionTagField.setFont(new Font("Arial", Font.PLAIN, 16));

        sectionTagDescLabel = new JLabel("Use a comma then a space to separate tags.");
        sectionTagDescLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 50));
        submitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        submitButton.addActionListener(this::submitButtonClicked);

        sectionName = new String();
        tag = new String();

        //Adding the elements above to the panels
        setLayout(new MigLayout("", "[]push[]", "[]"));
        add(sectionNameLabel, "cell 0 0");
        add(sectionNameField, "cell 1 0, wrap, growx");
        add(sectionTagLabel, "cell 0 1");
        add(sectionTagField, "cell 1 1, wrap, growx");
        add(sectionTagDescLabel, "cell 1 2, wrap");
        add(submitButton, "cell 1 3");
    }

    //ActionListener Method for above Lambda Expression:
    public void submitButtonClicked(ActionEvent e) {
        sectionName = sectionNameField.getText();
        tag = sectionTagField.getText();
        tagArray = tag.split(", ");
        sectionTagField.setText("");
        sectionTagField.setText("");
        AdminAddRemovePanelBottom.guiAddSectionDialog.setVisible(false);
    }
}
