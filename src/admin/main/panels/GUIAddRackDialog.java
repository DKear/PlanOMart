package admin.main.panels;

import admin.add.remove.panels.AdminAddRackPanel;
import admin.add.remove.panels.AdminAddSectionPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class GUIAddRackDialog extends JDialog {
    public AdminAddRackPanel adminAddRackPanel;

    public GUIAddRackDialog() {
        setSize(new Dimension(500, 350));
        setModalityType(ModalityType.APPLICATION_MODAL);

        adminAddRackPanel = new AdminAddRackPanel();

        setLayout(new MigLayout("align center"));
        add(adminAddRackPanel, "grow");
    }
}
