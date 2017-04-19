package admin.main.panel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class AdminEditBottomPanel extends JPanel{

    private JButton switchUserButton;
    private JButton editButton;
    private JButton addRemoveButton;
    private JButton viewCommentButton;
    private JButton mapButton;

    public AdminEditBottomPanel() {
        switchUserButton = new JButton("Switch User");
        switchUserButton.setPreferredSize(new Dimension(100,50));
        switchUserButton.setFont(new Font("Arial", Font.PLAIN, 16));

        editButton = new JButton("Edit Items");
        editButton.setPreferredSize(new Dimension(100,50));
        editButton.setFont(new Font("Arial", Font.PLAIN, 16));

        addRemoveButton = new JButton("Add/Remove Objects");
        addRemoveButton.setPreferredSize(new Dimension(100,50));
        addRemoveButton.setFont(new Font("Arial", Font.PLAIN, 16));

        viewCommentButton = new JButton("View Comments");
        viewCommentButton.setPreferredSize(new Dimension(100,50));
        viewCommentButton.setFont(new Font("Arial", Font.PLAIN, 16));

        mapButton = new JButton("Map");
        mapButton.setPreferredSize(new Dimension(100,50));
        mapButton.setFont(new Font("Arial", Font.PLAIN, 16));

        setLayout(new MigLayout("", "[align center]", "[align center]"));
        add(switchUserButton);
        add(editButton);
        add(addRemoveButton);
        add(viewCommentButton);
        add(mapButton);
    }

    public void actionPerformed(){

    }
}
