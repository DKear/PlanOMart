package admin.main.panels;

import admin.GUIAddRemoveWindow;
import admin.add.remove.panels.AdminAddRemovePanelBottom;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminMainBottomPanel extends JPanel {

    private JButton switchUserButton;
    private JButton editButton;
    private JButton addRemoveButton;
    private JButton viewCommentButton;
    //    private JButton mapButton;
    public GUIAddRemoveWindow guiAddRemoveWindow;
    public AdminMainBodyPanel adminPanel;
    public static JDialog addRemovePopUp;

    public AdminMainBottomPanel(AdminMainBodyPanel panel) {
        setBorder(new BevelBorder(BevelBorder.RAISED));
        adminPanel = panel;

        //switchUserButton is created and given functionality with a lambda expression
        switchUserButton = new JButton("Switch User");
        switchUserButton.setPreferredSize(new Dimension(100, 50));
        switchUserButton.setFont(new Font("Arial", Font.PLAIN, 16));
        switchUserButton.addActionListener(this::switchUserButtonClicked);

        //editButton is created and given functionality with a lambda expression
        editButton = new JButton("Edit Items");
        editButton.setPreferredSize(new Dimension(100, 50));
        editButton.setFont(new Font("Arial", Font.PLAIN, 16));
        editButton.addActionListener(this::editButtonClicked);

        //addRemoveButton is created and given functionality with a lambda expression
        addRemoveButton = new JButton("Add/Remove Objects");
        addRemoveButton.setPreferredSize(new Dimension(100, 50));
        addRemoveButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addRemoveButton.addActionListener(this::addRemoveButtonClicked);

        //viewCommentButton is created and given functionality with a lambda expression
        viewCommentButton = new JButton("View Comments");
        viewCommentButton.setPreferredSize(new Dimension(100, 50));
        viewCommentButton.setFont(new Font("Arial", Font.PLAIN, 16));
        viewCommentButton.addActionListener(this::viewCommentButtonClicked);

//        //mapButton is created and given functionality with a lambda expression
//        mapButton = new JButton("Map");
//        mapButton.setPreferredSize(new Dimension(100,50));
//        mapButton.setFont(new Font("Arial", Font.PLAIN, 16));
//        mapButton.addActionListener(this::mapButtonClicked);

        //setting the general layout (position) of the buttons that were constructed
        setLayout(new MigLayout("", "[align center]", "[align center]"));
        add(switchUserButton);
        add(editButton);
        add(addRemoveButton);
        add(viewCommentButton);
//        add(mapButton);

        //initializing the JPanel used
        guiAddRemoveWindow = new GUIAddRemoveWindow();
    }

    //Below are the actual methods that the lambda expressions use
    private void switchUserButtonClicked(ActionEvent e) {
        getParent().setVisible(false);
    }

    private void editButtonClicked(ActionEvent e) {

    }

    private void addRemoveButtonClicked(ActionEvent e) {
        addRemovePopUp = new JDialog();
        addRemovePopUp.setContentPane(guiAddRemoveWindow);
        guiAddRemoveWindow.setObjectTable(adminPanel.getReturnField());
        addRemovePopUp.setTitle("Add & Remove");
        addRemovePopUp.pack();
        addRemovePopUp.setVisible(true);
    }

    private void viewCommentButtonClicked(ActionEvent e) {

    }

//    public void mapButtonClicked(ActionEvent e){
//        if (e.getSource() == mapButton) {
//            mapDialogWindow.setVisible(true);
//        }
//    }
}