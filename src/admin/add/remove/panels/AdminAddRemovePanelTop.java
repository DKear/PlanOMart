package admin.add.remove.panels;

import admin.GUIAdminMain;
import admin.main.panels.AdminMainBodyPanel;
import net.miginfocom.swing.MigLayout;
import store.locations.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Objects;

public class AdminAddRemovePanelTop extends JPanel {

    public JLabel dropBoxLabel;
    public DefaultListModel<String> modelObjectList;
    public JComboBox<String> objectDropBox;
    public JButton removeButton;

    public JList<String> objectList;

    public Store store;

    public GUIAdminMain guiAdminMain;

    public AdminAddRemovePanelTop(Store store) {
        setBorder(new BevelBorder(BevelBorder.RAISED));

        this.store = store;

        dropBoxLabel = new JLabel("Select Type of Object: ");
        dropBoxLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        objectDropBox = new JComboBox<>();
        objectDropBox.setPreferredSize(new Dimension(300, 50));
        objectDropBox.setFont(new Font("Arial", Font.PLAIN, 16));
        objectDropBox.addItem("Select an Object...");
        objectDropBox.addItem("Section");
        objectDropBox.addItem("Aisle");
        objectDropBox.addItem("Rack");
        objectDropBox.addItem("Shelf");
        objectDropBox.addItem("Sale Item");
        objectDropBox.addActionListener(e -> populatingAddRemoveJList());

        removeButton = new JButton("Remove");
        removeButton.setPreferredSize(new Dimension(100, 50));
        removeButton.setFont(new Font("Arial", Font.PLAIN, 16));
        removeButton.addActionListener(this::removeButtonClicked);

        modelObjectList = new DefaultListModel<>();
        objectList = new JList<>(modelObjectList);


        setLayout(new MigLayout("", "[]push[]", "[align center][grow]"));
        add(dropBoxLabel, "");
        add(objectDropBox, "");
        add(removeButton, "wrap");
        add(objectList, "span, grow");
    }

    public void setObjectList(JList objectList) {
        objectList.getSelectionModel().addListSelectionListener(System.out::println);
        remove(this.objectList);
        this.objectList = objectList;
        add(objectList, "span, grow");
    }

    //***Populating the JList for the AdminAddRemovePanelTop
    public void populatingAddRemoveJList() {
        modelObjectList.clear();
        String obj = (String) objectDropBox.getSelectedItem();
        System.out.println("Called: " + obj);
        if (Objects.equals(obj, "Section")) {
            //Populates the JList with all existing Section Objects
            for (String s : store.getSectionsNames(store.getSections())) {
                modelObjectList.addElement(s);
            }
        }
        objectList.repaint();
    }


    //***Lambda Expression for Removing selected object from JList though the JComboBox
    public void removeButtonClicked(ActionEvent e) {
        String selectedValue = objectList.getSelectedValue();
        for (Section s : store.getSections()) {
            if (s.getSectionName().equals(selectedValue)) {
                store.removeSection(s);
            }
        }
    }
}