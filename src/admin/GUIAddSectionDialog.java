package admin;

import admin.add.remove.panels.AdminAddSectionPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class GUIAddSectionDialog extends JDialog {

    public AdminAddSectionPanel adminAddSectionPanel;

    public GUIAddSectionDialog() {
        setSize(new Dimension(500, 300));
        setModalityType(ModalityType.APPLICATION_MODAL);

        adminAddSectionPanel = new AdminAddSectionPanel();

        setLayout(new MigLayout("align center"));
        add(adminAddSectionPanel, "grow");
    }
}
