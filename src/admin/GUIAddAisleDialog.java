package admin;

import admin.add.remove.panels.AdminAddAislePanel;
import admin.add.remove.panels.AdminAddSectionPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class GUIAddAisleDialog extends JDialog {

    public AdminAddAislePanel adminAddAislePanel;

    public GUIAddAisleDialog() {
        setSize(new Dimension(500, 350));
        setModalityType(ModalityType.APPLICATION_MODAL);

        adminAddAislePanel = new AdminAddAislePanel();

        setLayout(new MigLayout("align center"));
        add(adminAddAislePanel, "grow");
    }
}