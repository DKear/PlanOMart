package admin;

import javax.swing.*;
import java.awt.*;

import static java.awt.GridBagConstraints.CENTER;
import static java.awt.GridBagConstraints.LINE_END;
import static java.awt.GridBagConstraints.LINE_START;

public class GUIEditPanel extends JPanel {
    public JTextField editNameField;
    public JButton editNameButton;
    public JTextField addTagsField;
    public JButton addTagsButton;
    public JComboBox removeTagComboBox;
    public JButton removeTagButton;
    public JButton backButton;
    public GUIEditPanel(){

        this.setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(800,600));
        editNameField = new JTextField(20);
        editNameButton = new JButton("Submit");
        addTagsField = new JTextField(10);
        addTagsButton = new JButton("Add tag");
        removeTagComboBox = new JComboBox();
        removeTagButton = new JButton("Remove tag");
        backButton = new JButton("Back");

        GridBagConstraints es = new GridBagConstraints();
        es.gridx = es.gridy = 0;
        add(new JLabel("Change Location Name: "), es);
        es.gridx = 1;
        add(editNameField, es);
        es.gridx = 0;
        es.gridy = 1;
        es.gridwidth = 2;
        add(editNameButton, es);
        es.gridwidth = 1;
        es.gridy = 2;
        es.anchor = LINE_END;
        add(new JLabel("Add Tag: "), es);
        es.gridx = 1;
        es.anchor = LINE_START;
        add(addTagsField, es);
        es.anchor = CENTER;
        es.gridx = 0;
        es.gridy = 3;
        es.gridwidth = 2;
        add(addTagsButton, es);

        es.gridy = 4;
        add(removeTagComboBox, es);
        es.gridy = 5;
        add(removeTagButton, es);
        es.gridy = 6;
        add(backButton, es);
    }
}
