package admin;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jamie on 4/25/2017.
 */
public class GUIEditSectionPanel extends JPanel {
    public JTextField editNameField;
    public JTextField addTagsField;
    public JButton addTagsButton;
    public JComboBox removeTagComboBox;
    public JButton removeTagButton;
    public GUIEditSectionPanel(){

        this.setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(600,600));
        editNameField = new JTextField(20);
        addTagsField = new JTextField(10);
        addTagsButton = new JButton("Add tag");
        removeTagComboBox = new JComboBox();
        removeTagButton = new JButton("Remove tag");

        GridBagConstraints es = new GridBagConstraints();
        es.gridx = es.gridy = 0;
        add(editNameField, es);
        es.gridy = 1;
        add(addTagsField, es);
        es.gridy = 2;
        add(addTagsButton, es);
        es.gridy = 3;
        add(removeTagComboBox, es);
        es.gridy = 4;
        add(removeTagButton, es);

    }
}
