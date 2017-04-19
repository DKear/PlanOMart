import admin.main.panel.AdminEditBodyPanel;
import admin.main.panel.AdminEditBottomPanel;
import admin.main.panel.AdminEditTopPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class GUIAdmin extends JPanel {
    private AdminEditTopPanel adminEditTopPanel;
    private AdminEditBodyPanel adminEditBodyPanel;
    private AdminEditBottomPanel adminEditBottomPanel;

    public GUIAdmin() {
        setPreferredSize(new Dimension(1024, 512));
        setBackground(Color.CYAN);

        adminEditTopPanel = new AdminEditTopPanel();
        adminEditTopPanel.setBackground(Color.red);

        adminEditBodyPanel = new AdminEditBodyPanel();
        adminEditBodyPanel.setBackground(Color.black);

        adminEditBottomPanel = new AdminEditBottomPanel();
        adminEditBottomPanel.setBackground(Color.yellow);

        setLayout(new MigLayout("", "[grow]", "[][grow][]"));
        add(adminEditTopPanel, "wrap, growx, height 100px");
        add(adminEditBodyPanel, "growx, wrap, growy");
        add(adminEditBottomPanel, "growx, height 100px");
    }
}