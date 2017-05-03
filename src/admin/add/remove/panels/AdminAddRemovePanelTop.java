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
}