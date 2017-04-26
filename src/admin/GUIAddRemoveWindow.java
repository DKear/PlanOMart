package admin;

import admin.add.remove.panels.AdminAddRemovePanelBottom;
import admin.add.remove.panels.AdminAddRemovePanelTop;
import admin.main.panels.AdminMainBodyPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAddRemoveWindow extends JDialog {
    private AdminAddRemovePanelTop adminAddRemovePanelTop;
    public AdminAddRemovePanelBottom adminAddRemovePanelBottom;

    public GUIAddRemoveWindow() {
        setSize(new Dimension(1024, 512));

        adminAddRemovePanelTop = new AdminAddRemovePanelTop();

        adminAddRemovePanelBottom = new AdminAddRemovePanelBottom();

        setLayout(new MigLayout("", "[grow]", "[][grow][]"));
        add(adminAddRemovePanelTop, "wrap, growx, height 300px");
        add(adminAddRemovePanelBottom, "growx, wrap, growy");
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void setObjectTable(JTable objectTable) {
        adminAddRemovePanelTop.setObjectTable(objectTable);
    }
}