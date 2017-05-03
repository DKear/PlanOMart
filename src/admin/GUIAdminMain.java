package admin;

import admin.main.panels.AdminMainBodyPanel;
import admin.main.panels.AdminMainBottomPanel;
import admin.main.panels.AdminMainTopPanel;
import admin.main.panels.DropBoxPanel;
import net.miginfocom.swing.MigLayout;
import store.locations.*;

import javax.swing.*;
import java.awt.*;

public class GUIAdminMain extends JPanel {
    public AdminMainTopPanel adminEditTopPanel;
    public AdminMainBottomPanel adminEditBottomPanel;
    public AdminMainBodyPanel adminEditBodyPanel;

    public GUIAdminMain() {
        setPreferredSize(new Dimension(1290, 1080));
        setVisible(false);

        adminEditTopPanel = new AdminMainTopPanel();

        adminEditBodyPanel = new AdminMainBodyPanel();

        adminEditBottomPanel = new AdminMainBottomPanel(adminEditBodyPanel);

        setLayout(new MigLayout("", "[grow]", "[][grow][]"));
        add(adminEditTopPanel, "cell 0 0, wrap, growx, height 100px");
        add(adminEditBodyPanel, "cell 0 1, growx, wrap, growy");
        add(adminEditBottomPanel, "cell 0 2, growx, height 100px");
    }
}