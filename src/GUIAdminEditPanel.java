import javax.swing.*;
import java.awt.*;

public class GUIAdminEditPanel extends JPanel{

    public GUIAdminEditPanel() {
        JPanel adminEditPanel = new JPanel();
        adminEditPanel.setLayout(new GridBagLayout());
        GridBagConstraints aec = new GridBagConstraints();
        aec.gridx = aec.gridy = 0;
        adminEditPanel.add(GUIAdminEdit.locationButton, aec);
        aec.gridy = 1;
        adminEditPanel.add(GUIAdminEdit.merchandiseButton, aec);
        aec.gridy = 2;
        adminEditPanel.add(GUIAdminEdit.changePassButton, aec);
        add(adminEditPanel);
    }
}
