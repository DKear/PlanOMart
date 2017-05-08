package admin.add.remove.panels;

import admin.GUIAdminMain;
import admin.main.panels.AdminMainBodyPanel;
import admin.main.panels.AdminMainBottomPanel;
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
    public JComboBox<String> objectDropBox;

    public JButton removeButton;

    public DefaultListModel<String> modelObjectList;
    public JList<String> objectList;
    public JScrollPane scrollPane;

    public AdminAddRemovePanelTop() {
        setBorder(new BevelBorder(BevelBorder.RAISED));

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

        removeButton = new JButton("Remove");
        removeButton.setPreferredSize(new Dimension(100, 50));
        removeButton.setFont(new Font("Arial", Font.PLAIN, 16));

        modelObjectList = new DefaultListModel<>();

        objectList = new JList<>(modelObjectList);
        objectList.setFont(new Font("Arial", Font.PLAIN, 16));

        scrollPane = new JScrollPane(objectList);


        setLayout(new MigLayout("", "[]push[]", "[align center][grow]"));
        add(dropBoxLabel, "");
        add(objectDropBox, "");
        add(removeButton, "wrap");
        add(scrollPane, "span, grow");
    }

    public void setObjectList(JList objectList) {
        objectList.getSelectionModel().addListSelectionListener(System.out::println);
        remove(this.objectList);
        this.objectList = objectList;
        add(objectList, "span, grow");
    }
    //******************************************************
    //***Populating the JList for the AdminAddRemovePanelTop
    public void populatingAddRemoveJList(Store store) {
        modelObjectList.clear();
        String obj = (String) AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.objectDropBox.getSelectedItem();
        if (Objects.equals(obj, "Section")) {
            for (String str : store.getSectionsNames(store.getSections())) {
                modelObjectList.addElement(str);
            }
        } else if (Objects.equals(obj, "Aisle")) {
            for (Section sec : store.getSections()) {
                for (Aisle ais : sec.getAisles()) {
                    modelObjectList.addElement(ais.getAisleDisplayName());
                }}
        } else if (Objects.equals(obj, "Rack")) {
            for (Section sec : store.getSections()) {
                for (Aisle ais : sec.getAisles()) {
                    for (Rack rac : ais.getRack()) {
                        modelObjectList.addElement(rac.getRackDisplayName());
                    }}}
        } else if (Objects.equals(obj, "Shelf")) {
            for (Section sec : store.getSections()) {
                for (Aisle ais : sec.getAisles()) {
                    for (Rack rac : ais.getRack()) {
                        for (Shelf she : rac.getShelf()) {
                            modelObjectList.addElement(she.getRowDisplayName());
                        }}}}
        } else if (Objects.equals(obj, "Sale Item")) {
            for (Section sec : store.getSections()) {
                for (Aisle ais : sec.getAisles()) {
                    for (Rack rac : ais.getRack()) {
                        for (Shelf she : rac.getShelf()) {
                            for (SaleItem sal : she.getItemsOnShelf()) {
                                modelObjectList.addElement(sal.getName());
                            }}}}}}
        repaint();
    }

    //*********************************************************************************
    //***Lambda Expression for Removing selected object from JList though the JComboBox
    public void removeButtonClicked(Store store, ActionEvent e) {
        System.out.println("Made it to the listener");
        int selectedDropBoxIndex = objectDropBox.getSelectedIndex();
        String selectedListValue = objectList.getSelectedValue();
        //For Removing Section
        if (selectedDropBoxIndex == 1) {
            for (Section sec : store.getSections()) {
                if (sec.getSectionName().equals(selectedListValue)) {
                    store.removeSection(sec);
                }}}
        //For Removing Aisle
        if (selectedDropBoxIndex == 2) {
            System.out.println("Found DropBox selected on 'Aisle'");
            for (Section sec : store.getSections()) {
                System.out.println("1st ForLoop: for every Section in the Store");
                for (Aisle ais : sec.getAisles()) {
                    System.out.println("2nd ForLoop: for every Aisle in the Section");
                    if (ais.getAisleDisplayName().equals(selectedListValue)) {
                        System.out.println("Removing: " + ais + " from " + ais.getSection().getSectionName());
                        sec.removeAisle(ais);
                    }}}}
        //For Removing Rack
        if (selectedDropBoxIndex == 3) {
            for (Section sec : store.getSections()) {
                for (Aisle ais : sec.getAisles()) {
                    for (Rack rac : ais.getRack()) {
                        if (rac.getRackDisplayName().equals(selectedListValue)) {
                            ais.removeRack(rac);
                        }}}}}
        //For Removing Shelf
        if (selectedDropBoxIndex == 4) {
            for (Section sec : store.getSections()) {
                for (Aisle ais : sec.getAisles()) {
                    for (Rack rac : ais.getRack()) {
                        for (Shelf slf : rac.getShelf()) {
                            if (slf.getRowDisplayName().equals(selectedListValue)) {
                                rac.removeShelf(slf);
                            }}}}}}
        //For Removing SaleItem
        if (selectedDropBoxIndex == 5) {
            for (Section sec : store.getSections()) {
                for (Aisle ais : sec.getAisles()) {
                    for (Rack rac : ais.getRack()) {
                        for (Shelf slf : rac.getShelf()) {
                            for (SaleItem sal : slf.getItemsOnShelf()) {
                                if (sal.getName().equals(selectedListValue)) {
                                    slf.removeItems(sal);
                                }}}}}}}
        populatingAddRemoveJList(store);
        repaint();
    }
}