import UserSide.GUICreateComments;
import admin.GUIAddItemDialog;
import admin.GUIAdminMain;
import admin.GUIEditSectionPanel;
import admin.main.panels.AdminMainBottomPanel;
import store.locations.*;

import javax.swing.*;

import java.awt.*;              //for layout managers and more
import java.awt.event.*;        //for action events
import java.text.ParseException;
import java.util.regex.Pattern;


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
    public JComboBox editSectionComboBox;
    public DefaultComboBoxModel editSectionComboBoxM;
    public JButton editSectionButton;
    public JComboBox editAisleComboBox;
    public JButton editAisleButton;
    public JComboBox editRackComboBox;
    public JButton editRackButton;
    public JComboBox editShelfComboBox;
    public JButton editShelfButton;
    public JPanel adminEditLocation;
    public JButton editReturn;
    public GUIEditSectionPanel es;
    public String selected;
    public GUIAddItemDialog addItemDialog;
    private JButton commentCreateButton = new JButton("Comment");
    private GUICreateComments createCustomComments = new GUICreateComments();

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

        //adminPanel.adminEditBottomPanel();

        adminPanel = new GUIAdminMain();
        adminPanel.adminEditBottomPanel.switchUserButton.addActionListener(this);
        adminPanel.adminEditBottomPanel.editButton.addActionListener(this);
        /*adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.getSelectedItem().equals(store.sections.get(adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.getSelectedIndex()-1).getAisleNames(store.sections.get(adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.getSelectedIndex()-1).getAisles()))){
                    adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.setModel(new DefaultComboBoxModel(store.sections.get(adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.getSelectedIndex()-1).getAisleNames(store.sections.get(adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.getSelectedIndex()-1).getAisles())));
                }
            }
        });*/

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
        editSectionComboBox = new JComboBox();
        editSectionComboBoxM = new DefaultComboBoxModel();
        editSectionComboBox.setPreferredSize(new Dimension(250,50));
        adminEditLocation.add(editSectionComboBox, ael);
        ael.gridx = 1;
        editSectionButton = new JButton("Edit Section");
        editSectionButton.addActionListener(this);
        adminEditLocation.add(editSectionButton, ael);
        ael.gridx = 0;
        ael.gridy = 1;
        editAisleComboBox = new JComboBox();
        editAisleComboBox.setPreferredSize(new Dimension(250,50));
        adminEditLocation.add(editAisleComboBox, ael);
        ael.gridx = 1;
        editAisleButton = new JButton("Edit Aisle");
        adminEditLocation.add(editAisleButton, ael);
        ael.gridx = 0;
        ael.gridy  =2;
        editRackComboBox = new JComboBox();
        editRackComboBox.setPreferredSize(new Dimension(250,50));
        adminEditLocation.add(editRackComboBox, ael);
        ael.gridx = 1;
        editRackButton = new JButton("Edit Rack");
        adminEditLocation.add(editRackButton, ael);
        ael.gridx = 0;
        ael.gridy = 3;
        editShelfComboBox = new JComboBox();
        editShelfComboBox.setPreferredSize(new Dimension (250, 50));
        adminEditLocation.add(editShelfComboBox, ael);
        ael.gridx = 1;
        editShelfButton = new JButton("Edit Shelf");
        adminEditLocation.add(editShelfButton, ael);
        ael.gridwidth = 2;
        ael.gridx = 0;
        ael.gridy = 4;
        editReturn = new JButton("Return");
        adminEditLocation.add(editReturn, ael);
        editReturn.addActionListener(this);



        adminEditCard.add(adminEditLocation, "Locations");


        JPanel adminEditMerchandise = new JPanel();

        adminEditCard.add(adminEditMerchandise, "Merchandise");

        JPanel adminEditChangePass = new JPanel();

        adminEditCard.add(adminEditChangePass, "Change password");

        es = new GUIEditSectionPanel();
        es.editNameButton.addActionListener(this);
        es.backButton.addActionListener(this);

        adminEditCard.add(es, "Edit Section");

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

        //writing listener so on click will do the event in this class too
        AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addItemButton.addActionListener(this);
        addItemDialog = new GUIAddItemDialog();
        addItemDialog.sectionDropBox.addActionListener(this);
        addItemDialog.submitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        CardLayout ecl = (CardLayout) (adminEditCard.getLayout());

        if (e.getSource() == openingAdminButton) {

            //Insert That one thing here Dylan to bypass initial setup!!!!!!!!!!!!!!!!!!!
            //Comment out this thing ↓
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
            if (is.isNumber(is.numberOfSectionField.getText()) && Integer.parseInt(is.numberOfSectionField.getText().trim()) >= 0) {
                sectionInt = Integer.parseInt(is.numberOfSectionField.getText().trim());

                valid++;
            } else {
                JOptionPane.showMessageDialog(controllingContainer, "Invalid section input");
            }


            if (is.isNumber(is.numberOfAislesField.getText()) && Integer.parseInt(is.numberOfAislesField.getText().trim()) >= 0) {
                aisleInt = Integer.parseInt(is.numberOfAislesField.getText().trim());

                valid++;
            } else {
                JOptionPane.showMessageDialog(controllingContainer, "Invalid aisle input");
            }

            if (is.isNumber(is.numberOfRacksField.getText()) && Integer.parseInt(is.numberOfRacksField.getText().trim()) >= 0) {
                rackInt = Integer.parseInt(is.numberOfRacksField.getText().trim());
                valid++;
            } else {
                JOptionPane.showMessageDialog(controllingContainer, "Invalid rack input");
            }

            if (is.isNumber(is.numberOfShelvesField.getText()) && Integer.parseInt(is.numberOfShelvesField.getText().trim()) >= 0) {
                shelfInt = Integer.parseInt(is.numberOfShelvesField.getText().trim());

                valid++;
            } else {
                JOptionPane.showMessageDialog(controllingContainer, "Invalid shelf input");
            }

            if (valid == 5) {
                store.storeName = storeName;
                for (int i = 0; i < sectionInt; i++) {
                    //section = new Section("Section: " + Integer.toString(i + 1));
                    section = new Section("Section: " + Integer.toString(i + 1));
                    store.addSection(section);
                    editSectionComboBoxM.addElement(section.getSectionName());
                    editSectionComboBox.setModel(editSectionComboBoxM);
                    adminPanel.adminEditBodyPanel.dropBoxPanel.sectionDropbox.addItem(section.getSectionName());
                    addItemDialog.sectionDropBox.addItem(section.getSectionName());

                    for (int j = 0; j < aisleInt; j++) {
                        //aisle = new Aisle("Section: " + (i + 1) + " Aisle: " + Integer.toString(j+ 1));
                        aisle = new Aisle("Section: " + (i + 1) + " Aisle: " + Integer.toString(j + 1));
                        section.addAisle(aisle);
                        aisle.setSection(section);
                        editAisleComboBox.addItem(aisle.getAisleName());
                        adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.addItem(aisle.getAisleName());
                        for (int k = 0; k < rackInt; k++) {
                            rack = new Rack("Section: " + (i + 1) + " Aisle: " + (j + 1) + " Rack: " + Integer.toString(k + 1));
                            aisle.addRack(rack);
                            rack.setAisle(aisle);
                            editRackComboBox.addItem(rack.getRackName());
                            adminPanel.adminEditBodyPanel.dropBoxPanel.rackDropbox.addItem(rack.getRackName());
                            for (int l = 0; l < shelfInt; l++) {
                                shelf = new Shelf("Section: " + (i + 1) + " Aisle: " + (j + 1) + " Rack: " + (k + 1) + " Shelf: " + Integer.toString(l + 1));
                                rack.addShelf(shelf);
                                shelf.setRack(rack);
                                editShelfComboBox.addItem(shelf.getRowName());
                                adminPanel.adminEditBodyPanel.dropBoxPanel.shelfDropbox.addItem(shelf.getRowName());
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

        if (e.getSource() == adminPanel.adminEditBottomPanel.editButton) {

            ae.setVisible(true);

        }

        if (e.getSource() == ae.locationButton) {
            ecl.show(adminEditCard, "Locations");
        }
        if (e.getSource() == ae.merchandiseButton) {
            ecl.show(adminEditCard, "Merchandise");
        }
        if (e.getSource() == ae.changePassButton) {
            ecl.show(adminEditCard, "Change password");
        }

        if (e.getSource() == adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox) {
            JOptionPane.showMessageDialog(controllingContainer, "Aaa");
            for (int i = 0; i < store.sections.size(); i++) {
                if (adminPanel.adminEditBodyPanel.dropBoxPanel.sectionDropbox.getSelectedItem().equals(store.getSectionsNames(store.getSections())[i])) {
                    adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.setModel(new DefaultComboBoxModel(store.sections.get(i).getAisleNames(store.sections.get(i).getAisles())));
                }
            }
        }

        if(e.getSource() == editReturn || e.getSource() == es.backButton){
            ecl.show(adminEditCard, "Edit");
        }

        if (e.getSource() == editSectionButton) {
            selected = editSectionComboBox.getSelectedItem().toString();
            for (int i = 0; i < store.sections.size(); i++) {
                if (store.sections.get(i).getSectionName().equals(selected)) {
                    section = store.sections.get(i);
                }
            }
            es.removeTagComboBox.addItem("remove tag...");
            for (int i = 0; i < section.getTags().length; i++) {
                es.removeTagComboBox.addItem(section.getTags()[i]);
            }

            es.editNameField.setText(selected);
            ecl.show(adminEditCard, "Edit Section");
        }



        if(e.getSource() == es.editNameButton){
            String oldName = section.getSectionName();
            String newName = es.editNameField.getText();
            DefaultComboBoxModel newComboBox = new DefaultComboBoxModel();
            section.setSectionName(newName);
            editSectionComboBoxM.addElement(section.getSectionName());
            editSectionComboBox.setModel(editSectionComboBoxM);
            adminPanel.adminEditBodyPanel.dropBoxPanel.sectionDropbox.addItem(section.getSectionName());
            for(int i = 0; i < section.getAisles().length; i++){
                //section.getAisles()[i].getAisleName()
            }
        }

        //int shelfIndex = addItemDialog.shelfDropBox.getSelectedIndex();
//        if(e.getSource() == adminPanel.adminEditBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addItemButton) {
//           //populating the combo boxes in GUIAddItemDialog, populates sections
//            addItemDialog.sectionDropBox = new JComboBox<String[]>(store.getSectionsNames(store.getSections()));
//
//            }


        if (e.getSource() == AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addItemButton) {
            addItemDialog.setVisible(true);
            //addItemDialog.setVisible(true);
        }

        if (e.getSource() == addItemDialog.sectionDropBox) {//populate the aisle box
            int sectionIndex = addItemDialog.sectionDropBox.getSelectedIndex();
            if (sectionIndex != -1 && sectionIndex != 0) {//makes sure an index is selected first, populates aisles
                addItemDialog.aisleDropBox.removeAllItems();//clears the list so only the proper are in the box
                addItemDialog.aisleDropBox.addItem("Select an aisle...");
                for (int i = 0; i < store.getSections()[sectionIndex - 1].getAisles().length; i++) {//first index is the select a ...
                    addItemDialog.aisleDropBox.addItem(store.getSections()[sectionIndex - 1].getAisles()[i].aisleName);
                    addItemDialog.aisleDropBox.addActionListener(this);
                }
            }
        }

        if (e.getSource() == addItemDialog.aisleDropBox) {//populate the rack box
            int sectionIndex = addItemDialog.sectionDropBox.getSelectedIndex();
            int aisleIndex = addItemDialog.aisleDropBox.getSelectedIndex();
            if (aisleIndex != -1 && aisleIndex != 0) {//makes sure an index is selected first, populates racks
                addItemDialog.rackDropBox.removeAllItems();//clears the list so only the proper are in the box
                addItemDialog.rackDropBox.addItem("Select a rack...");
                for (int i = 0;
                     i < store.getSections()[sectionIndex - 1].getAisles()[aisleIndex - 1].getRack().length;
                     i++) {//first index is the "select a ..."
                    addItemDialog.rackDropBox.addItem(store.getSections()[sectionIndex - 1].getAisles()[aisleIndex - 1].getRack()[i].getRackName());
                    addItemDialog.rackDropBox.addActionListener(this);
                }
            }
        }

        if (e.getSource() == addItemDialog.rackDropBox) {//populate the shelf box
            int sectionIndex = addItemDialog.sectionDropBox.getSelectedIndex();
            int aisleIndex = addItemDialog.aisleDropBox.getSelectedIndex();
            int rackIndex = addItemDialog.rackDropBox.getSelectedIndex();
            if (rackIndex != -1 && rackIndex != 0) {
                addItemDialog.shelfDropBox.removeAllItems();//clears the list so only the proper are in the box
                addItemDialog.shelfDropBox.addItem("Select a shelf...");
                for (int i = 0;
                     i < store.getSections()[sectionIndex - 1].getAisles()[aisleIndex - 1].getRack()[rackIndex - 1].getShelf().length;
                     i++) {//first index is the "select a ..."

                    addItemDialog.shelfDropBox.addItem(store.getSections()[sectionIndex - 1].getAisles()[aisleIndex - 1].getRack()[rackIndex - 1].getShelf()[i].getRowName());
                }
            }
        }
        if (e.getSource() == addItemDialog.submitButton) {//making a new item with click of submit button
            String name = addItemDialog.itemNameField.getText();
            double price;
            if (!addItemDialog.itemPriceField.getText().equals("")) {
                try {
                    price = Double.parseDouble(addItemDialog.itemPriceField.getText());
                } catch (NumberFormatException n){
                    price = -1;
                }
            } else {
                price = -1;
            }
            String brand = addItemDialog.itemBrandField.getText();
            String desc = addItemDialog.itemDescriptionField.getText();
            SaleItem newItem = new SaleItem(price, name, brand, desc);
            int sectionIndex = addItemDialog.sectionDropBox.getSelectedIndex() - 1;
            int aisleIndex = addItemDialog.aisleDropBox.getSelectedIndex() - 1;
            int rackIndex = addItemDialog.rackDropBox.getSelectedIndex() - 1;
            int shelfIndex = addItemDialog.shelfDropBox.getSelectedIndex() - 1;
            if (newItem.validateItem(newItem) && sectionIndex != -1 && aisleIndex != -1 && rackIndex != -1 && shelfIndex != -1) {
                store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].getShelf()[shelfIndex].addItem(newItem);
                addItemDialog.setVisible(false);
                addItemDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            } else if (sectionIndex == -1) {
                JOptionPane.showMessageDialog(controllingContainer, "Select a section first.");
            } else if (aisleIndex == -1) {
                JOptionPane.showMessageDialog(controllingContainer, "Select an aisle first.");
            } else if (rackIndex == -1) {
                JOptionPane.showMessageDialog(controllingContainer, "Select a rack first.");
            } else if (shelfIndex == -1) {
                JOptionPane.showMessageDialog(controllingContainer, "Select a shelf first.");
            } else if (!newItem.validateItem(newItem)) {
                JOptionPane.showMessageDialog(controllingContainer, "Make sure all item fields are filled out properly. Ex. price #.##");
            }
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