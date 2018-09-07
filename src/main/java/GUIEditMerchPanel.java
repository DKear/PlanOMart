import javax.swing.*;
import java.awt.*;

public class GUIEditMerchPanel extends JPanel {
    public JComboBox editMerchCombobox;
    public JPanel adminEditMerchPanel;
    public JButton editMerchButton;
    public JButton merchReturn;

    public GUIEditMerchPanel() {

        adminEditMerchPanel = new JPanel();
        adminEditMerchPanel.setLayout(new GridBagLayout());
        GridBagConstraints aem = new GridBagConstraints();
        aem.gridx = aem.gridy = 0;
        editMerchCombobox = new JComboBox();
        adminEditMerchPanel.add(editMerchCombobox, aem);
        aem.gridx = 1;
        editMerchButton = new JButton("Edit merchandise");
        adminEditMerchPanel.add(editMerchButton, aem);
        aem.gridx = 0;
        aem.gridy = 1;
        aem.gridwidth = 2;
        merchReturn = new JButton("Return");
        adminEditMerchPanel.add(merchReturn, aem);
        add(adminEditMerchPanel);
    }
}
