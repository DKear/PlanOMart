import javax.swing.*;
import java.awt.*;

public class GUIAdminEditLocation extends JPanel{
    public JPanel adminEditLocation;
    public JComboBox<String> editSectionComboBox;
    public JButton editSectionButton;
    public JComboBox editAisleComboBox;
    public JButton editAisleButton;
    public JComboBox editRackComboBox;
    public JButton editRackButton;
    public JComboBox editShelfComboBox;
    public JButton editShelfButton;
    public JButton editReturn;

    public GUIAdminEditLocation() {
        adminEditLocation = new JPanel();
        adminEditLocation.setLayout(new GridBagLayout());
        GridBagConstraints ael = new GridBagConstraints();
        ael.gridx = ael.gridy = 0;
        editSectionComboBox = new JComboBox<>();
        editSectionComboBox.setPreferredSize(new Dimension(250, 50));
        adminEditLocation.add(editSectionComboBox, ael);
        ael.gridx = 1;
        editSectionButton = new JButton("Edit Section");
        adminEditLocation.add(editSectionButton, ael);
        ael.gridx = 0;
        ael.gridy = 1;
        editAisleComboBox = new JComboBox();
        editAisleComboBox.setPreferredSize(new Dimension(250, 50));
        adminEditLocation.add(editAisleComboBox, ael);
        ael.gridx = 1;
        editAisleButton = new JButton("Edit Aisle");
        adminEditLocation.add(editAisleButton, ael);
        ael.gridx = 0;
        ael.gridy = 2;
        editRackComboBox = new JComboBox();
        editRackComboBox.setPreferredSize(new Dimension(250, 50));
        adminEditLocation.add(editRackComboBox, ael);
        ael.gridx = 1;
        editRackButton = new JButton("Edit Rack");
        adminEditLocation.add(editRackButton, ael);
        ael.gridx = 0;
        ael.gridy = 3;
        editShelfComboBox = new JComboBox();
        editShelfComboBox.setPreferredSize(new Dimension(250, 50));
        adminEditLocation.add(editShelfComboBox, ael);
        ael.gridx = 1;
        editShelfButton = new JButton("Edit Shelf");
        adminEditLocation.add(editShelfButton, ael);
        ael.gridwidth = 2;
        ael.gridx = 0;
        ael.gridy = 4;
        editReturn = new JButton("Return");
        adminEditLocation.add(editReturn, ael);
        add(adminEditLocation);
    }
}
