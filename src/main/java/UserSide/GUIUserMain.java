package UserSide;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class GUIUserMain extends JPanel{
    public UserMainTopPanel userMainTopPanel;
    public UserMainBodyPanel userMainBodyPanel;
    public UserMainBottomPanel userMainBottomPanel;

    public GUIUserMain() {
        setPreferredSize(new Dimension(1290, 1080));
        setVisible(false);

        userMainTopPanel = new UserMainTopPanel();

        userMainBodyPanel = new UserMainBodyPanel();

        userMainBottomPanel = new UserMainBottomPanel(userMainBodyPanel);

        setLayout(new MigLayout("", "[grow]", "[][grow][]"));
        add(userMainTopPanel, "wrap, growx, height 100px");
        add(userMainBodyPanel, "growx, wrap, growy");
        add(userMainBottomPanel, "growx, height 100px");
    }
}
