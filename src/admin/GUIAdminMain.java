package admin;

import admin.main.panels.AdminMainBodyPanel;
import admin.main.panels.AdminMainBottomPanel;
import admin.main.panels.AdminMainTopPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class GUIAdminMain extends JPanel {
    public AdminMainTopPanel adminEditTopPanel;
    public AdminMainBodyPanel adminEditBodyPanel;
    public AdminMainBottomPanel adminEditBottomPanel;

    public GUIAdminMain() {
        setPreferredSize(new Dimension(1290, 1080));

        adminEditTopPanel = new AdminMainTopPanel();

        adminEditBodyPanel = new AdminMainBodyPanel();

        adminEditBottomPanel = new AdminMainBottomPanel(adminEditBodyPanel);

        setLayout(new MigLayout("", "[grow]", "[][grow][]"));
        add(adminEditTopPanel, "wrap, growx, height 100px");
        add(adminEditBodyPanel, "growx, wrap, growy");
        add(adminEditBottomPanel, "growx, height 100px");
    }
}