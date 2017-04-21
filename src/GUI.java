import UserSide.GUICreateComments;
import admin.GUIAdminMain;
import store.locations.*;

import javax.swing.*;

import java.awt.*;              //for layout managers and more
import java.awt.event.*;        //for action events


public class GUI implements ActionListener {

    private JPanel cards;
    private Container controllingContainer;
    private String ADMINPANEL = "Admin";
    private String USERPANEL = "User";
    private String OPENINGPANEL = "Opening Panel";
    private JButton userSwitchButton;
    private JButton adminSwitchButton;
    private JButton adminEditButton;
    private GUIAdminEdit ae;
    private GUIAdminAddWindow aw;
    //private JPanel adminEditPanel;
    private JPanel adminEditCard;
    private JPanel adminAddPanel;
    private JPanel openingContent;
    private JButton openingUserButton;
    private JButton openingAdminButton;
    private Boolean storeExists = false;
    private JPanel passwordPanel;
    private GUIPassword pw;
    private char[] passwordInput;
    private JPanel initialSetupPanel;
    private GUIInitialSetup is;
    public Store store;
    public Section section;
    public Aisle aisle;
    public Rack rack;
    public Shelf shelf;
    public GUIAdminMain adminPanel;
    public JComboBox locationComboBox;
    public JPanel adminEditLocation;

    JButton switchButton;
    private JButton commentCreateButton = new JButton("Comment");
    GUICreateComments createCustomComments = new GUICreateComments();


    public void addComponentToPane(Container pane) {
        store = new Store("store");
        //store.sections.add(new Section("Dank"));
        controllingContainer = pane;
        pane.setPreferredSize(new Dimension(1920, 1080));

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());
        GridBagConstraints p = new GridBagConstraints();
        p.weightx = p.weighty = 1;
        userSwitchButton = new JButton("Switch User Mode");
        userSwitchButton.addActionListener(this);
        adminSwitchButton = new JButton("Switch User Mode");
        adminSwitchButton.addActionListener(this);
        JPanel openingPanel = new JPanel();


//<<<<<<< HEAD

        //adminPanel.adminEditBottomPanel();
//=======
        adminPanel = new GUIAdminMain();
        adminPanel.adminEditBottomPanel.switchUserButton.addActionListener(this);
        adminPanel.adminEditBottomPanel.editButton.addActionListener(this);
//>>>>>>> origin/master

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

        openingContent.add(new JLabel("Select a mode:"), o);
        o.gridwidth = 1;
        o.gridx = 0;
        o.gridy = 1;
        o.weightx = 1;
        o.insets = new Insets(0, 0, 0, 10);
        openingContent.add(openingAdminButton, o);
        o.gridx = 1;
        o.gridy = 1;
        o.insets = new Insets(0, 10, 0, 0);
        openingContent.add(openingUserButton, o);
        openingPanel.add(openingContent);

        adminEditButton = new JButton("Edit");
        adminEditButton.addActionListener(this);

//        adminPanel.setLayout(new GridBagLayout());
//        GridBagConstraints a = new GridBagConstraints();
//
//        a.weightx = a.weighty = 0;
//        a.gridx = a.gridy = 0;
//        a.anchor = GridBagConstraints.FIRST_LINE_START;
//        adminPanel.add(adminSwitchButton, a);
//        a.weightx = a.weighty = 1;
//        a.gridy = 1;
//        a.anchor = GridBagConstraints.PAGE_START;
//        adminPanel.add(new JLabel("Admin"), a);
//        a.gridy = 2;
//        adminPanel.add(adminEditButton, a);

        pane.add(panel, BorderLayout.WEST);
        pane.add(cards, BorderLayout.CENTER);

        ae = new GUIAdminEdit();
        ae.locationButton.addActionListener(this);

        adminEditCard = new JPanel();
        adminEditCard.setLayout(new CardLayout());

        JPanel adminEditPanel = new JPanel();
        adminEditPanel.setLayout(new GridBagLayout());
        GridBagConstraints aec = new GridBagConstraints();
        aec.gridx = aec.gridy = 0;
        adminEditPanel.add(ae.locationButton, aec);
        ae.locationButton.addActionListener(this);
        aec.gridy = 1;
        adminEditPanel.add(ae.merchandiseButton, aec);
        ae.merchandiseButton.addActionListener(this);
        aec.gridy = 2;
        adminEditPanel.add(ae.changePassButton, aec);
        ae.changePassButton.addActionListener(this);

        adminEditCard.add(adminEditPanel, "Edit");

        adminEditLocation = new JPanel();
        adminEditLocation.setLayout(new GridBagLayout());
        GridBagConstraints ael = new GridBagConstraints();
        ael.gridx = ael.gridy = 0;
        locationComboBox = new JComboBox(store.getSectionsNames(store.getSections()));
        locationComboBox.setPreferredSize(new Dimension(200,50));
        adminEditLocation.add(locationComboBox, ael);

        adminEditCard.add(adminEditLocation, "Locations");


        JPanel adminEditMerchandise = new JPanel();

        adminEditCard.add(adminEditMerchandise, "Merchandise");

        JPanel adminEditChangePass = new JPanel();

        adminEditCard.add(adminEditChangePass, "Change password");


        ae.add(adminEditCard);





        aw = new GUIAdminAddWindow();
        adminAddPanel = new JPanel();

        adminAddPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        aw.add(adminAddPanel);

        passwordPanel = new JPanel();
        passwordPanel.setLayout(new GridBagLayout());
        GridBagConstraints pwc = new GridBagConstraints();
        pw = new GUIPassword();
        pwc.gridx = pwc.gridy = 0;
        passwordPanel.add(new JLabel("Enter password (default is 'PlanOMart') "), pwc);
        pwc.gridy = 1;
        passwordPanel.add(pw.passwordField, pwc);
        pwc.gridy = 2;
        passwordPanel.add(pw.submitButton, pwc);
        pw.submitButton.addActionListener(this);
        pw.add(passwordPanel);

        initialSetupPanel = new JPanel();
        initialSetupPanel.setLayout(new GridBagLayout());
        GridBagConstraints isp = new GridBagConstraints();
        is = new GUIInitialSetup();
        isp.gridx = isp.gridy = 0;
        isp.anchor = GridBagConstraints.PAGE_START;
        isp.gridwidth = 2;
        initialSetupPanel.add(new JLabel("Welcome to PlanOMart! Please enter some information about your store."), isp);
        isp.gridwidth = 1;
        isp.gridy = 1;
        isp.anchor = GridBagConstraints.CENTER;
        initialSetupPanel.add(new JLabel("Store name:"), isp);
        isp.gridx = 1;
        initialSetupPanel.add(is.storeNameField, isp);
        isp.gridx = 0;
        isp.gridy = 2;
        initialSetupPanel.add(new JLabel("Number of sections:"), isp);
        isp.gridx = 1;
        initialSetupPanel.add(is.numberOfSectionField, isp);
        isp.gridx = 0;
        isp.gridy = 3;
        initialSetupPanel.add(new JLabel("Number of aisles in each section"), isp);
        isp.gridx = 1;
        initialSetupPanel.add(is.numberOfAislesField, isp);
        isp.gridx = 0;
        isp.gridy = 4;
        initialSetupPanel.add(new JLabel("Number of racks in each aisle"), isp);
        isp.gridx = 1;
        initialSetupPanel.add(is.numberOfRacksField, isp);
        isp.gridx = 0;
        isp.gridy = 5;
        initialSetupPanel.add(new JLabel("Number of shelves in each rack"), isp);
        isp.gridx = 1;
        initialSetupPanel.add(is.numberOfShelvesField, isp);
        isp.gridwidth = 2;
        isp.gridx = 0;
        isp.gridy = 6;
        initialSetupPanel.add(is.submitButton, isp);
        is.submitButton.addActionListener(this);
        is.add(initialSetupPanel);


        userPanel.add(commentCreateButton); //adds a button to the userPanel to the create comment dialog
        commentCreateButton.addActionListener(this);// allows the button to do above on click
    }
//<<<<<<< HEAD
    public void actionPerformed(ActionEvent e){
        CardLayout cl = (CardLayout)(cards.getLayout());
        CardLayout ecl = (CardLayout)(adminEditCard.getLayout());

        if(e.getSource() == openingAdminButton){
//=======

            pw.setVisible(true);
        }
        if (e.getSource() == openingUserButton) {
            cl.show(cards, USERPANEL);
        }
        if (e.getSource() == userSwitchButton || e.getSource() == adminPanel.adminEditBottomPanel.switchUserButton) {
            cl.show(cards, OPENINGPANEL);
        }

        if (e.getSource() == adminEditButton) {
            ae.setVisible(true);

        }


        if (e.getSource() == commentCreateButton) {
            createCustomComments.setVisible(true);
        }

        if (e.getSource() == pw.submitButton) {
            passwordInput = pw.passwordField.getPassword();
            if (pw.correctPassword(passwordInput)) {
                pw.setVisible(false);
                if (!storeExists) {
                    is.setVisible(true);
                } else {
                    cl.show(cards, ADMINPANEL);
                }
                pw.passwordField.setText("");
            } else {
                JOptionPane.showMessageDialog(controllingContainer, "Incorrect password");
                pw.passwordField.setText("");
            }
        }
        if (e.getSource() == is.submitButton) {
            String storeName = "";
            Integer sectionInt = 0;
            Integer aisleInt = 0;
            Integer rackInt = 0;
            Integer shelfInt = 0;
            int valid = 0;
            if (!is.storeNameField.getText().equals("")) {
                storeName = is.storeNameField.getText();
                valid++;
            } else {
                JOptionPane.showMessageDialog(controllingContainer, "Enter a store name");
            }
//<<<<<<< HEAD
            if(is.isNumber(is.numberOfSectionField.getText()) && Integer.parseInt(is.numberOfSectionField.getText().trim())>= 0){
                sectionInt = Integer.parseInt(is.numberOfSectionField.getText().trim());

                valid++;
            } else {
                JOptionPane.showMessageDialog(controllingContainer, "Invalid section input");
            }

//<<<<< HEAD
            if(is.isNumber(is.numberOfAislesField.getText()) && Integer.parseInt(is.numberOfAislesField.getText().trim())>= 0){
                aisleInt = Integer.parseInt(is.numberOfAislesField.getText().trim());

                valid++;
            } else {
                JOptionPane.showMessageDialog(controllingContainer, "Invalid aisle input");
            }
//<<<<<<< HEAD
            if(is.isNumber(is.numberOfRacksField.getText())&& Integer.parseInt(is.numberOfRacksField.getText().trim())>= 0){
                rackInt = Integer.parseInt(is.numberOfRacksField.getText().trim());
                valid++;
            } else {
                JOptionPane.showMessageDialog(controllingContainer, "Invalid rack input");
            }
//<<<<<<< HEAD
            if(is.isNumber(is.numberOfShelvesField.getText())&& Integer.parseInt(is.numberOfShelvesField.getText().trim())>= 0){
                shelfInt = Integer.parseInt(is.numberOfShelvesField.getText().trim());

                valid++;
            } else {
                JOptionPane.showMessageDialog(controllingContainer, "Invalid shelf input");
            }

            if (valid == 5) {
                store.storeName = storeName;
                for (int i = 0; i < sectionInt; i++) {
                    section = new Section("Section: " + Integer.toString(i + 1));
                    store.addSection(section);
                    locationComboBox.addItem(store.getSectionsNames(store.getSections())[i]);
                    for (int j = 0; j < aisleInt; j++) {
                        aisle = new Aisle("Section: " + i + "Aisle: " + Integer.toString(j+ 1));
                        section.addAisle(aisle);
                        for (int k = 0; k < rackInt; k++) {
                            rack = new Rack("Section: " + i + "Aisle: " + j + "Rack: " + Integer.toString(k + 1));
                            aisle.addRack(rack);
                            for (int l = 0; l < shelfInt; l++) {
                                shelf = new Shelf("Section: " + i + "Aisle: " + j + "Rack: " + k + "Shelf: " + Integer.toString(l + 1));
                                rack.addShelf(shelf);
                            }
                        }
                    }
                }
                JOptionPane.showMessageDialog(controllingContainer, "Store created! You may give names to store objects in the 'Edit' tab. ");
                is.setVisible(false);
                cl.show(cards, ADMINPANEL);
                storeExists = true;
            }
        }

        if(e.getSource() == adminPanel.adminEditBottomPanel.editButton){
            //locationComboBox.add;
            ae.setVisible(true);

        }

        if(e.getSource() == ae.locationButton){
            ecl.show(adminEditCard, "Locations");
        }
        if(e.getSource() == ae.merchandiseButton){
            ecl.show(adminEditCard, "Merchandise");
        }
        if(e.getSource() == ae.changePassButton){
            ecl.show(adminEditCard, "Change password");
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