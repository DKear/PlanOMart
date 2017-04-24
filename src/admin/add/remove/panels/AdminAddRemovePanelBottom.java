package admin.add.remove.panels;

import admin.GUIAddItemDialog;
import admin.GUIAddRemoveWindow;
import admin.GUIAdminMain;
import admin.main.panels.AdminMainBottomPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminAddRemovePanelBottom extends JPanel {

    public JButton returnButton;
    public JButton addItemButton;
    public GUIAddItemDialog guiAddItemDialog;

    public AdminAddRemovePanelBottom() {
        setBorder(new BevelBorder(BevelBorder.RAISED));

        returnButton = new JButton("Return");
        returnButton.setPreferredSize(new Dimension(100, 50));
        returnButton.setFont(new Font("Arial", Font.PLAIN, 16));
        returnButton.addActionListener(this::returnButtonClicked);

        addItemButton = new JButton("Add Item");
        addItemButton.setPreferredSize(new Dimension(100, 50));
        addItemButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addItemButton.addActionListener(this::addItemButtonClicked);

        setLayout(new MigLayout("", "[align center]", "[align center]"));
        add(returnButton, "cell 0 0");
        add(addItemButton, "cell 1 0");
        guiAddItemDialog = new GUIAddItemDialog();
    }

    public void returnButtonClicked(ActionEvent e) {
        AdminMainBottomPanel.guiAddRemoveWindow.setVisible(false);
    }

    public void addItemButtonClicked(ActionEvent e) {
        guiAddItemDialog.setVisible(true);
    }
}