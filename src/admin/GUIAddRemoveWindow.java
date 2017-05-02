package admin;

import admin.add.remove.panels.AdminAddRemovePanelBottom;
import admin.add.remove.panels.AdminAddRemovePanelTop;
import net.miginfocom.swing.MigLayout;
import store.locations.*;

import javax.swing.*;
import java.awt.*;

public class GUIAddRemoveWindow extends JDialog {
    private AdminAddRemovePanelTop adminAddRemovePanelTop;
    public AdminAddRemovePanelBottom adminAddRemovePanelBottom;

    public GUIAddRemoveWindow(Store store) {
        setSize(new Dimension(1024, 512));

        adminAddRemovePanelTop = new AdminAddRemovePanelTop(store);

        adminAddRemovePanelBottom = new AdminAddRemovePanelBottom();

        setLayout(new MigLayout("", "[grow]", "[][grow][]"));
        add(adminAddRemovePanelTop, "wrap, growx, height 300px");
        add(adminAddRemovePanelBottom, "growx, wrap, growy");
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

//    public void setObjectTable(JTable objectTable) {
//        adminAddRemovePanelTop.setObjectTable(objectTable);
//    }
}