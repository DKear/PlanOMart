import javax.swing.*;
import java.awt.*;

public class GUIOpeningPanel extends JPanel {
    public JPanel openingContent;
    public JButton openingUserButton;
    JButton openingAdminButton;
    public GUIOpeningPanel(){
        JPanel openingPanel = new JPanel();
        openingContent = new JPanel();
        openingContent.setLayout(new GridBagLayout());
        openingUserButton = new JButton("User");
        openingAdminButton = new JButton("Admin");
        GridBagConstraints o = new GridBagConstraints();
        o.gridwidth = 2;
        o.gridx = 0;
        o.gridy = 0;
        openingContent.add(new JLabel("Select a mode:"), o);
        o.gridwidth = 1;
        o.gridx = 0;
        o.gridy = 1;
        o.weightx = 1;
        o.insets = new Insets(0, 0, 0, 10);
        openingContent.add(openingAdminButton, o);
        o.gridx = 1;
        o.gridy = 1;
        o.insets = new Insets(0, 10, 0, 0);
        openingContent.add(openingUserButton, o);
        openingPanel.add(openingContent);
        add(openingPanel);
    }
}
