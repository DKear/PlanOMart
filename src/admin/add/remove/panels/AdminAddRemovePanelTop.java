package admin.add.remove.panels;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class AdminAddRemovePanelTop extends JPanel {

    private JLabel dropBoxLabel;
    private JComboBox<Object> objectDropBox;
    private JButton removeButton;
    private JTable objectTable;

    public AdminAddRemovePanelTop() {

        dropBoxLabel = new JLabel("Select Type of Object: ");
        dropBoxLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        objectDropBox = new JComboBox<>();
        objectDropBox.setPreferredSize(new Dimension(300, 50));
        objectDropBox.setFont(new Font("Arial", Font.PLAIN, 16));

        removeButton = new JButton("Remove");
        removeButton.setPreferredSize(new Dimension(100, 50));
        removeButton.setFont(new Font("Arial", Font.PLAIN, 16));

        //ADDING DUMBY DATA (delete after)
        String[] columns = {
                "Hello",
                "Goodbye"
        };

        Object[][] data = {
                {
                        "Hi", 5
                },
                {
                        "Bye", 8
                },
                {
                        "Cya", 42
                }
        };

        objectTable = new JTable(data, columns);

        setLayout(new MigLayout("","[align center]","[align center]"));
            add(dropBoxLabel, "cell 0 0");
            add(objectDropBox, "cell 1 0");
            add(removeButton, "cell 2 0");
            add(objectTable, "cell 3 0");
    }
}