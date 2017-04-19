package admin.add.remove.panels;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class AdminAddRemovePanelBottom extends JPanel {

    private JButton returnButton;
    private JButton addItemButton;
    private JButton addStructure;

    public AdminAddRemovePanelBottom() {

        returnButton = new JButton("Return");
        returnButton.setPreferredSize(new Dimension(100, 50));
        returnButton.setFont(new Font("Arial", Font.PLAIN, 16));

        addItemButton = new JButton("Add Item");
        addItemButton.setPreferredSize(new Dimension(100, 50));
        addItemButton.setFont(new Font("Arial", Font.PLAIN, 16));

        addStructure = new JButton("Add Structure");
        addStructure.setPreferredSize(new Dimension(100, 50));
        addStructure.setFont(new Font("Arial", Font.PLAIN, 16));

        setLayout(new MigLayout("","[align center]","[align center]"));
        add(returnButton, "cell 0 0");
        add(addItemButton, "cell 1 0");
        add(addStructure, "cell 2 0");
    }
}
