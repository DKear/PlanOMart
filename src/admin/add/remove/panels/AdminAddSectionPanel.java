package admin.add.remove.panels;

import javax.swing.*;

import admin.main.panels.AdminMainBodyPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

public class AdminAddSectionPanel extends JPanel {

    public JLabel sectionNameLabel;
    public JTextField sectionNameField;

    public JLabel sectionTagLabel;
    public JTextField sectionTagField;
    public JLabel sectionTagDescLabel;

    public JButton submitButton;

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

        sectionTagDescLabel = new JLabel("Use a coma followed by a space to separate tags.");
        sectionTagDescLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 50));
        submitButton.setFont(new Font("Arial", Font.PLAIN, 16));
    }
}
