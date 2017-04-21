package admin;

import admin.add.remove.panels.AdminAddRemovePanelBottom;
import admin.add.remove.panels.AdminAddRemovePanelTop;
import admin.main.panels.AdminMainBodyPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAddRemoveWindow extends JPanel {
    private AdminAddRemovePanelTop adminAddRemovePanelTop;
    private AdminAddRemovePanelBottom adminAddRemovePanelBottom;

    public GUIAddRemoveWindow() {
        setPreferredSize(new Dimension(1024, 512));

        adminAddRemovePanelTop = new AdminAddRemovePanelTop();

        adminAddRemovePanelBottom = new AdminAddRemovePanelBottom();

        setLayout(new MigLayout("", "[grow]", "[][grow][]"));
        add(adminAddRemovePanelTop, "wrap, growx, height 300px");
        add(adminAddRemovePanelBottom, "growx, wrap, growy");
    }

    public void setObjectTable(JTable objectTable) {
        adminAddRemovePanelTop.setObjectTable(objectTable);
    }
}
