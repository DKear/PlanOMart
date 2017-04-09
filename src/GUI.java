import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;              //for layout managers and more
import java.awt.event.*;        //for action events

import java.net.URL;
import java.io.IOException;

//Strategy design pattern
//Factory method (creational)

public class GUI implements ActionListener {

    private JPanel cards;
    private JPanel adminOrgPanel;
    private Container controllingContainer;
    private String ADMINPANEL = "Admin";
    private String USERPANEL = "User";
    private String OPENINGPANEL = "Opening Panel";
    private int panelState = 0;
    private JButton userSwitchButton;
    private JButton adminSwitchButton;
    private JButton adminEditButton;
    private GUIAdminEdit ae;
    private GUIAdminAddWindow aw;
    private JPanel adminEditPanel;
    private JPanel adminAddPanel;
    private JPanel openingPanel;
    private JPanel openingContent;
    private JButton openingUserButton;
    private JButton openingAdminButton;


    public void addComponentToPane(Container pane){
        controllingContainer = pane;
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints p = new GridBagConstraints();
        p.weightx = p.weighty = 1;
        userSwitchButton = new JButton("Switch User Mode");
        userSwitchButton.addActionListener(this);
        adminSwitchButton = new JButton("Switch User Mode");
        adminSwitchButton.addActionListener(this);
        JPanel openingPanel = new JPanel();

        JPanel adminPanel = new JPanel();

        JPanel userPanel = new JPanel();
        userPanel.setLayout(new GridBagLayout());
        GridBagConstraints u = new GridBagConstraints();
        u.weightx = u.weighty = 1;
        u.gridx = 0;
        u.gridy = 1;
        u.anchor = GridBagConstraints.PAGE_START;
        userPanel.add(new JLabel("User"), u);
        u.weightx = u.weighty = 0;
        u.gridx = 0;
        u.gridy = 0;
        u.anchor = GridBagConstraints.FIRST_LINE_START;
        userPanel.add(userSwitchButton, u);

        cards = new JPanel(new CardLayout());
        cards.add(openingPanel, OPENINGPANEL);
        cards.add(userPanel, USERPANEL);
        cards.add(adminPanel, ADMINPANEL);

        openingContent = new JPanel();
        openingContent.setLayout(new GridBagLayout());
        openingUserButton = new JButton("User");
        openingUserButton.addActionListener(this);
        openingAdminButton = new JButton("Admin");
        openingAdminButton.addActionListener(this);
        GridBagConstraints o = new GridBagConstraints();
        o.gridwidth = 2;
        o.gridx = 0;
        o.gridy = 0;

        openingContent.add(new JLabel("Select a mode:"),o);
        o.gridwidth = 1;
        o.gridx = 0;
        o.gridy = 1;
        o.weightx = 1;
        o.insets = new Insets(0,0,0,10);
        openingContent.add(openingAdminButton,o);
        o.gridx = 1;
        o.gridy = 1;
        o.insets = new Insets(0, 10, 0, 0);
        openingContent.add(openingUserButton,o);

        openingPanel.add(openingContent);



        adminEditButton = new JButton("Edit");
        adminEditButton.addActionListener(this);

        //adminOrgPanel = new JPanel();
        adminPanel.setLayout(new GridBagLayout());
        GridBagConstraints a = new GridBagConstraints();

        a.weightx = a.weighty = 0;
        a.gridx = 0;
        a.gridy = 0;
        a.anchor = GridBagConstraints.FIRST_LINE_START;
        adminPanel.add(adminSwitchButton, a);
        a.weightx = a.weighty = 1;
        a.gridx = 0;
        a.gridy = 1;
        a.anchor = GridBagConstraints.PAGE_START;
        adminPanel.add(new JLabel("Admin"), a);
        a.gridy = 2;
        adminPanel.add(adminEditButton, a);
        //adminPanel.add(adminPanel);

        pane.add(panel, BorderLayout.PAGE_START);
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

        adminAddPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        adminAddPanel.add(aw.storeNameField, c);
        c.gridx = 0;
        c.gridy = 1;
        adminAddPanel.add(aw.submitButton, c);

        aw.add(adminAddPanel);

        //customer comments window
        GUICustomerComments custComments = new GUICustomerComments(); //creates window based on that class
        custComments.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);//makes into a dialog box
        JPanel custComm = new JPanel();// makes a panel to place all the components in
        custComm.setLayout(new GridBagLayout());//sets layout to grid layout
        GridBagConstraints grid = new GridBagConstraints();//tells the component where in the grid it will be placed
        grid.gridx = 0;//uses entire width
        grid.gridy = 0;//starts at top
        grid.anchor = GridBagConstraints.WEST;
        custComm.add(custComments.subjectLabel, grid);// adds the label to this part of the grid
        grid.anchor = GridBagConstraints.NONE;
        grid.gridy = 1;//one further down
        custComm.add(custComments.subjectField, grid);
        grid.anchor = GridBagConstraints.WEST;
        grid.gridy = 2;//one further down
        custComm.add(custComments.commentLabel, grid);
        grid.anchor = GridBagConstraints.NONE;
        grid.gridy = 3;//one further down
        custComm.add(custComments.commentField, grid);
        grid.anchor = GridBagConstraints.WEST;
        grid.gridy = 4;//one further down
        custComm.add(custComments.contactLabel, grid);
        grid.anchor = GridBagConstraints.NONE;
        grid.gridy = 5;//one further down
        custComm.add(custComments.contactField, grid);
        grid.anchor = GridBagConstraints.EAST;
        grid.gridy = 6;//one further down
        custComm.add(custComments.submitButton, grid);
        custComments.add(custComm);
    }

    public void actionPerformed(ActionEvent e){
        CardLayout cl = (CardLayout)(cards.getLayout());

        if(e.getSource() == openingAdminButton){
            cl.show(cards, ADMINPANEL);
        }
        if(e.getSource() == openingUserButton){
            cl.show(cards, USERPANEL);
        }
        if(e.getSource() == userSwitchButton|| e.getSource()==adminSwitchButton){
            cl.show(cards, OPENINGPANEL);
        }

        if(e.getSource()==adminEditButton){
            ae.setVisible(true);
        }

       /* if(e.getSource() == ae.addButton){
            aw.setVisible(true);
        }*/




    }
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("PLAN-O-MART");
        frame.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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