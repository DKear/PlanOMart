import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;              //for layout managers and more
import java.awt.event.*;        //for action events

import java.net.URL;
import java.io.IOException;
import java.util.ArrayList;

public class GUI implements ActionListener {

    JPanel cards;
    JPanel adminOrgPanel;
    private Container controllingContainer;
    String ADMINPANEL = "Admin";
    String USERPANEL = "User";
    int adminInt;
    JButton switchButton;
    JButton adminEditButton;
    JButton commentButton = new JButton("Comment");
    GUIAdminEdit ae;
    GUIAdminAddWindow aw;
    JPanel adminEditPanel;
    JPanel adminAddPanel;
    GUICustomerComments custComments;
    ArrayList<String> comments = new ArrayList<>();//stores the customers' comments

    public void addComponentToPane(Container pane){
        controllingContainer = pane;

        JPanel panel = new JPanel();
        switchButton = new JButton("Switch User");
        switchButton.addActionListener(this);
        panel.add(switchButton);

        JPanel adminPanel = new JPanel();
        //adminPanel.add(new JLabel("Admin"));

        JPanel userPanel = new JPanel();
        userPanel.add(new JLabel("User"));

        cards = new JPanel(new CardLayout());
        cards.add(userPanel, USERPANEL);
        cards.add(adminPanel, ADMINPANEL);

        adminEditButton = new JButton("Edit");
        adminEditButton.addActionListener(this);

        adminOrgPanel = new JPanel();
        adminOrgPanel.setLayout(new BoxLayout(adminOrgPanel, BoxLayout.Y_AXIS));
        adminOrgPanel.add(new JLabel("Admin"));
        adminOrgPanel.add(adminEditButton);
        adminPanel.add(adminOrgPanel);

        pane.add(panel, BorderLayout.WEST);
        pane.add(cards, BorderLayout.CENTER);

        ae = new GUIAdminEdit();
        ae.addButton.addActionListener(this);
        ae.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        adminEditPanel = new JPanel();
        adminEditPanel.setLayout(new BoxLayout(adminEditPanel, BoxLayout.Y_AXIS));
        adminEditPanel.add(ae.addButton);
        ae.add(adminEditPanel);

        aw = new GUIAdminAddWindow();
        aw.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        adminAddPanel = new JPanel();
        adminAddPanel.setLayout(new BoxLayout(adminAddPanel, BoxLayout.Y_AXIS));
        adminAddPanel.add(aw.storeNameField);
        adminAddPanel.add(aw.submitButton);
        aw.add(adminAddPanel);

        //customer comments window
        custComments = new GUICustomerComments(); //creates window based on that class
        custComments.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);//makes into a dialog box
        JPanel custComm = new JPanel();// makes a panel to place all the components in
        custComm.setLayout(new GridBagLayout());//sets layout to grid layout
        GridBagConstraints grid = new GridBagConstraints();//tells the component where in the grid it will be placed
        grid.gridx = 0;//uses entire width
        grid.gridy = 0;//starts at top
        grid.anchor = GridBagConstraints.LINE_START;
        custComm.add(custComments.subjectLabel, grid);// adds the label to this part of the grid
        grid.fill = GridBagConstraints.BOTH;
        grid.gridy = 1;//one further down
        custComm.add(custComments.subjectField, grid);
        grid.anchor = GridBagConstraints.LINE_START;
        grid.gridy = 2;//one further down
        custComm.add(custComments.commentLabel, grid);
        grid.fill = GridBagConstraints.BOTH;
        grid.gridy = 3;//one further down
        grid.ipady = 40;
        custComm.add(custComments.commentField, grid);
        grid.anchor = GridBagConstraints.LINE_START;
        grid.gridy = 4;//one further down
        grid.ipady = 0;
        custComm.add(custComments.contactLabel, grid);
        grid.fill = GridBagConstraints.BOTH;
        grid.gridy = 5;//one further down
        custComm.add(custComments.contactField, grid);
        grid.anchor = GridBagConstraints.LINE_END;
        grid.gridy = 6;//one further down
        custComm.add(custComments.submitButton, grid);
        custComments.add(custComm);//adds the JPanel with everything in it to the dialog box
        userPanel.add(commentButton); //adds a button to the userPanel to open this dialog
        commentButton.addActionListener(this);// allows the button to do something on click
    }

    public void actionPerformed(ActionEvent e){
        CardLayout cl = (CardLayout)(cards.getLayout());
        if(e.getSource() == switchButton) {
            if (adminInt == 0) {
                JOptionPane.showMessageDialog(controllingContainer, "Enter a password");
                adminInt = 1;
                //cl.next(cards);
                cl.show(cards, ADMINPANEL);
            } else {
                cl.show(cards, USERPANEL);
                adminInt = 0;
            }
        }
        if(e.getSource()==adminEditButton){
            ae.setVisible(true);
        }

        if(e.getSource() == ae.addButton){
            aw.setVisible(true);
        }

        if(e.getSource() == commentButton) {
            custComments.setVisible(true);
        }


    }
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("PLAN-O-MART");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        GUI demo = new GUI();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }

        });
    }
}