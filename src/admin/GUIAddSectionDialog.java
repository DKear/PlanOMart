package admin;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class GUIAddSectionDialog extends JDialog {

    private JLabel sectionNameLabel = new JLabel("Place section name here:");
    public JTextField sectionNameField = new JTextField();
    private JLabel sectionTagLabel = new JLabel("Place section tags here, separated by a comma and space. Ex. sliced, white");
    public JTextField sectionTagField = new JTextField();
    public JButton submitButton = new JButton("Submit");

    public GUIAddSectionDialog() {
        setSize(1024, 412);
        JPanel panel = new JPanel();

        //Constructing and designing itemName stuff
        sectionNameField.setPreferredSize(new Dimension(300, 50));

        sectionTagField.setPreferredSize(new Dimension(300, 50));

        //Constructing and designing submitButton
        submitButton.setPreferredSize(new Dimension(100, 50));

        //Adding the elements above to the panel
        panel.setLayout(new MigLayout("", "[align center]", "[align center]"));
        panel.add(sectionNameLabel, "cell 0 0");
        panel.add(sectionNameField, "cell 1 0");
        panel.add(sectionTagLabel, "cell 0 1");
        panel.add(sectionTagField, "cell 1 1");
        panel.add(submitButton, "cell 1 2");

        add(panel);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000, 600);

        setVisible(false);
    }
}
