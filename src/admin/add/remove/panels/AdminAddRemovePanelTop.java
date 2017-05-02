package admin.add.remove.panels;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class AdminAddRemovePanelTop extends JPanel {

    private JLabel dropBoxLabel;
    private JComboBox<Object> objectDropBox;
    private JButton removeButton;

    private JTable objectTable;

    public AdminAddRemovePanelTop() {
        setBorder(new BevelBorder(BevelBorder.RAISED));

        dropBoxLabel = new JLabel("Select Type of Object: ");
        dropBoxLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        objectDropBox = new JComboBox<>();
        objectDropBox.setPreferredSize(new Dimension(300, 50));
        objectDropBox.setFont(new Font("Arial", Font.PLAIN, 16));
        objectDropBox.addItem("Section");
        objectDropBox.addItem("Aisle");
        objectDropBox.addItem("Rack");
        objectDropBox.addItem("Shelf");
        objectDropBox.addItem("Sale Item");

        removeButton = new JButton("Remove");
        removeButton.setPreferredSize(new Dimension(100, 50));
        removeButton.setFont(new Font("Arial", Font.PLAIN, 16));
        objectTable = new JTable();

        setLayout(new MigLayout("","[]push[]","[align center][grow]"));
            add(dropBoxLabel, "");
            add(objectDropBox, "");
            add(removeButton, "wrap");
            add(objectTable, "span, grow");
    }

    public void setObjectTable(JTable objectTable) {
        objectTable.getSelectionModel().addListSelectionListener(System.out::println);
        remove(this.objectTable);
        this.objectTable = objectTable;
        add(objectTable, "span, grow");
    }
}