package admin.add.remove.panels;

import admin.*;
import admin.main.panels.AdminMainBottomPanel;
import admin.add.remove.panels.AdminAddSectionPanel;

import admin.main.panels.GUIAddRackDialog;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminAddRemovePanelBottom extends JPanel {

    public JButton returnButton;
    public JButton addSectionButton;
    public JButton addAisleButton;
    public JButton addRackButton;
    public JButton addShelfButton;
    public JButton addItemButton;

    public GUIAddItemDialog guiAddItemDialog;
    public static GUIAddSectionDialog guiAddSectionDialog;
    public static GUIAddAisleDialog guiAddAisleDialog;
    public static GUIAddRackDialog guiAddRackDialog;

    public AdminAddRemovePanelBottom() {
        setBorder(new BevelBorder(BevelBorder.RAISED));

        returnButton = new JButton("Return");
        returnButton.setPreferredSize(new Dimension(100, 50));
        returnButton.setFont(new Font("Arial", Font.PLAIN, 16));
        returnButton.addActionListener(this::returnButtonClicked);

        addSectionButton = new JButton("Add Section");
        addSectionButton.setPreferredSize(new Dimension(100, 50));
        addSectionButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addSectionButton.addActionListener(this::addSectionButtonClicked);

        addAisleButton = new JButton("Add Aisle");
        addAisleButton.setPreferredSize(new Dimension(100, 50));
        addAisleButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addAisleButton.addActionListener(this::addAisleButtonClicked);

        addRackButton = new JButton("Add Rack");
        addRackButton.setPreferredSize(new Dimension(100, 50));
        addRackButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addRackButton.addActionListener(this::addRackButtonClicked);

        addShelfButton = new JButton("Add Shelf");
        addShelfButton.setPreferredSize(new Dimension(100, 50));
        addShelfButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addShelfButton.addActionListener(this::addShelfButtonClicked);

        addItemButton = new JButton("Add Item");
        addItemButton.setPreferredSize(new Dimension(100, 50));
        addItemButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addItemButton.addActionListener(this::addItemButtonClicked);

        setLayout(new MigLayout("", "[align center]", "[align center]"));
        add(returnButton, "cell 0 0");
        add(addSectionButton, "cell 1 0");
        add(addAisleButton, "cell 2 0");
        add(addRackButton, "cell 3 0");
        add(addShelfButton, "cell 4 0");
        add(addItemButton, "cell 5 0");
    }

    //The ActionListener Methods that the Lambda Expressions use:

    public void returnButtonClicked(ActionEvent e) {
        AdminMainBottomPanel.guiAddRemoveWindow.setVisible(false);
    }

    public void addSectionButtonClicked(ActionEvent e) {
        guiAddSectionDialog = new GUIAddSectionDialog();
        guiAddSectionDialog.setVisible(true);
    }

    public void addAisleButtonClicked(ActionEvent e) {
        guiAddAisleDialog = new GUIAddAisleDialog();
        guiAddAisleDialog.setVisible(true);
    }

    public void addRackButtonClicked(ActionEvent e) {
        guiAddRackDialog = new GUIAddRackDialog();
        guiAddRackDialog.setVisible(true);
    }

    public void addShelfButtonClicked(ActionEvent e) {

    }

    public void addItemButtonClicked(ActionEvent e) {
        guiAddItemDialog = new GUIAddItemDialog();
        guiAddItemDialog.pack();
        guiAddItemDialog.setVisible(true);
    }
}