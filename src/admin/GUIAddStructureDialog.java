package admin;

import javax.swing.*;

public class GUIAddStructureDialog extends JDialog {

    public GUIAddStructureDialog(){

    }
}

class AddStructureDialogPanel extends JPanel {

    private JLabel nameLabel;
    private JTextField nameField;
    private String name;

    private JLabel objectTypeLabel;
    private JComboBox objectTypeDropBox;

    private JLabel locatedInLabel;


    private JButton submitButton;

    public AddStructureDialogPanel(){
        nameLabel = new JLabel("Name: ");
        nameField = new JTextField();
        name = nameField.getText();

        objectTypeLabel = new JLabel("Object Type: ");
        objectTypeDropBox = new JComboBox();

        locatedInLabel = new JLabel("Location: ");
    }
}
