package admin;

import admin.add.remove.panels.AdminAddRemovePanelBottom;
import admin.add.remove.panels.AdminAddRemovePanelTop;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class GUIAddRemoveWindow extends JDialog {

    private AdminAddRemovePanelTop adminAddRemovePanelTop;
    private AdminAddRemovePanelBottom adminAddRemovePanelBottom;

    public GUIAddRemoveWindow() {
        setPreferredSize(new Dimension(1024, 512));
        setBackground(Color.green);

        adminAddRemovePanelTop = new AdminAddRemovePanelTop();
        adminAddRemovePanelTop.setBackground(Color.red);

        adminAddRemovePanelBottom = new AdminAddRemovePanelBottom();
        adminAddRemovePanelBottom.setBackground(Color.blue);

        setLayout(new MigLayout("", "[grow]", "[][grow][]"));
        add(adminAddRemovePanelTop, "wrap, growx, height 300px");
        add(adminAddRemovePanelBottom, "growx, wrap, growy");
    }
}
