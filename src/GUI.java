import UserSide.GUICreateComments;
import UserSide.GUIUserMain;
import admin.*;
import admin.add.remove.panels.AdminAddRemovePanelTop;
import admin.main.panels.AdminMainBottomPanel;
import admin.main.panels.GUIEditMerch;
import admin.main.panels.GUIPasswordChange;
import store.locations.*;

import javax.swing.*;

import java.awt.*;              //for layout managers and more
import java.awt.event.*;        //for action events
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Objects;


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
    private JPanel adminEditCard;
    private JPanel openingContent;
    private JButton openingUserButton;
    private JButton openingAdminButton;
    private Boolean storeExists = false;
    private JPanel passwordPanel;
    private GUIPassword pw;
    private char[] passwordInput;
    public Store store;
    public Section section;
    public Aisle aisle;
    public Rack rack;
    public Shelf shelf;
    public SaleItem item;
    public GUIAdminMain adminPanel;
    public JComboBox<String> editSectionComboBox;
    public JButton editSectionButton;
    public JComboBox editAisleComboBox;
    public JButton editAisleButton;
    public JComboBox editRackComboBox;
    public JButton editRackButton;
    public JComboBox editShelfComboBox;
    public JButton editShelfButton;
    public JPanel adminEditLocation;
    public JPanel adminEditMerchPanel;
    public JComboBox editMerchCombobox;
    public JButton editMerchButton;
    public JButton merchReturn;
    public JButton editReturn;
    public GUIEditPanel es;
    public GUIEditPanel ea;
    public GUIEditPanel er;
    public GUIEditPanel esh;
    public String selected;
    public GUIEditMerch em;
    //    private GUIAddItemDialog addItemDialog;
    public GUIPasswordChange pc;
    public GUIAddItemDialog addItemDialog;
    private GUIAddShelfDialog addShelfDialog = new GUIAddShelfDialog();
    private boolean fcheck = false;
    private GUIAddRackDialog addRackDialog = new GUIAddRackDialog();
    private GUIAddAisleDialog addAisleDialog = new GUIAddAisleDialog();
    private GUIAddSectionDialog addSectionDialog = new GUIAddSectionDialog();
    private GUIInitialSetup is = new GUIInitialSetup();
    GUIUserMain userPanel;

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
        adminPanel.adminEditBottomPanel.adminPanel.dropBoxPanel.searchButton.addActionListener(this);
        /*adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.getSelectedItem().equals(store.sections.get(adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.getSelectedIndex()-1).getAisleNames(store.sections.get(adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.getSelectedIndex()-1).getAisles()))){
                    adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.setModel(new DefaultComboBoxModel(store.sections.get(adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.getSelectedIndex()-1).getAisleNames(store.sections.get(adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.getSelectedIndex()-1).getAisles())));
                }
            }
        });*/

        userPanel = new GUIUserMain();
        userPanel.userMainBodyPanel.userDropBoxPanel.searchButton.addActionListener(this);


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
        editSectionComboBox = new JComboBox<>();
        editSectionComboBox.setPreferredSize(new Dimension(250, 50));
        adminEditLocation.add(editSectionComboBox, ael);
        ael.gridx = 1;
        editSectionButton = new JButton("Edit Section");
        editSectionButton.addActionListener(this);
        adminEditLocation.add(editSectionButton, ael);
        ael.gridx = 0;
        ael.gridy = 1;
        editAisleComboBox = new JComboBox();
        editAisleComboBox.setPreferredSize(new Dimension(250, 50));
        adminEditLocation.add(editAisleComboBox, ael);
        ael.gridx = 1;
        editAisleButton = new JButton("Edit Aisle");
        editAisleButton.addActionListener(this);
        adminEditLocation.add(editAisleButton, ael);
        ael.gridx = 0;
        ael.gridy = 2;
        editRackComboBox = new JComboBox();
        editRackComboBox.setPreferredSize(new Dimension(250, 50));
        adminEditLocation.add(editRackComboBox, ael);
        ael.gridx = 1;
        editRackButton = new JButton("Edit Rack");
        editRackButton.addActionListener(this);
        adminEditLocation.add(editRackButton, ael);
        ael.gridx = 0;
        ael.gridy = 3;
        editShelfComboBox = new JComboBox();
        editShelfComboBox.setPreferredSize(new Dimension(250, 50));
        adminEditLocation.add(editShelfComboBox, ael);
        ael.gridx = 1;
        editShelfButton = new JButton("Edit Shelf");
        editShelfButton.addActionListener(this);
        adminEditLocation.add(editShelfButton, ael);
        ael.gridwidth = 2;
        ael.gridx = 0;
        ael.gridy = 4;
        editReturn = new JButton("Return");
        adminEditLocation.add(editReturn, ael);
        editReturn.addActionListener(this);


        adminEditCard.add(adminEditLocation, "Locations");


        adminEditMerchPanel = new JPanel();
        adminEditMerchPanel.setLayout(new GridBagLayout());
        GridBagConstraints aem = new GridBagConstraints();
        aem.gridx = aem.gridy = 0;
        editMerchCombobox = new JComboBox();
        adminEditMerchPanel.add(editMerchCombobox, aem);
        aem.gridx = 1;
        editMerchButton = new JButton("Edit merchandise");
        editMerchButton.addActionListener(this);
        adminEditMerchPanel.add(editMerchButton, aem);
        aem.gridx = 0;
        aem.gridy = 1;
        aem.gridwidth = 2;
        merchReturn = new JButton("Return");
        merchReturn.addActionListener(this);
        adminEditMerchPanel.add(merchReturn, aem);

        em = new GUIEditMerch();
        em.saleButton.addActionListener(this);
        em.backButton.addActionListener(this);
        em.merchRemoveTagBox.addActionListener(this);
        em.merchPriceSubmit.addActionListener(this);
        em.merchNameSubmit.addActionListener(this);
        em.merchAddTagSubmit.addActionListener(this);
        em.merchRemoveSubmit.addActionListener(this);
        em.merchSaleSubmit.addActionListener(this);
        em.merchEditDescriptionSubmit.addActionListener(this);

        es = new GUIEditPanel();
        es.editNameButton.addActionListener(this);
        es.backButton.addActionListener(this);
        es.addTagsButton.addActionListener(this);
        es.removeTagButton.addActionListener(this);

        ea = new GUIEditPanel();
        ea.editNameButton.addActionListener(this);
        ea.backButton.addActionListener(this);
        ea.addTagsButton.addActionListener(this);
        ea.removeTagButton.addActionListener(this);

        er = new GUIEditPanel();
        er.editNameButton.addActionListener(this);
        er.backButton.addActionListener(this);
        er.removeTagButton.addActionListener(this);
        er.addTagsButton.addActionListener(this);

        esh = new GUIEditPanel();
        esh.editNameButton.addActionListener(this);
        esh.backButton.addActionListener(this);
        esh.addTagsButton.addActionListener(this);
        esh.removeTagButton.addActionListener(this);

        pc = new GUIPasswordChange();
        pc.backButton.addActionListener(this);
        pc.changePasswordButton.addActionListener(this);

        adminEditCard.add(es, "Edit Section");
        adminEditCard.add(ea, "Edit Aisle");
        adminEditCard.add(er, "Edit Rack");
        adminEditCard.add(esh, "Edit Shelf");
        adminEditCard.add(pc, "Change password");
        adminEditCard.add(adminEditMerchPanel, "Merchandise");
        adminEditCard.add(em, "Edit Merchandise");

        ae.add(adminEditCard);

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

        is.submitButton.addActionListener(this);

        //writing listener so on click will do the event in this class too
        //this will add an item
        AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addItemButton.addActionListener(this);
        addItemDialog = new GUIAddItemDialog();
        addItemDialog.sectionDropBox.addActionListener(this);
        addItemDialog.submitButton.addActionListener(this);
        //this is for the adding everything else
        AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addShelfButton.addActionListener(this);
        AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addRackButton.addActionListener(this);
        AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addAisleButton.addActionListener(this);
        AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addSectionButton.addActionListener(this);
        addShelfDialog.sectionDropBox.addActionListener(this);
        addShelfDialog.submitButton.addActionListener(this);
        addRackDialog.sectionDropBox.addActionListener(this);
        addRackDialog.submitButton.addActionListener(this);
        addAisleDialog.sectionDropBox.addActionListener(this);
        addAisleDialog.submitButton.addActionListener(this);
        addSectionDialog.submitButton.addActionListener(this);

        AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.removeButton.addActionListener(this::removeButtonClicked);
        AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.objectDropBox.addActionListener(this::populatingAddRemoveJList);
    }

    public void reloadAddSectionDropBoxes() {
        addItemDialog.sectionDropBox.removeAllItems();
        addItemDialog.sectionDropBox.addItem("Select a Section...");
        addShelfDialog.sectionDropBox.removeAllItems();
        addShelfDialog.sectionDropBox.addItem("Select a Section...");
        addRackDialog.sectionDropBox.removeAllItems();
        addRackDialog.sectionDropBox.addItem("Select a Section...");
        addAisleDialog.sectionDropBox.removeAllItems();
        addAisleDialog.sectionDropBox.addItem("Select a Section...");
        for (Section s : store.getSections()) {
            addItemDialog.sectionDropBox.addItem(s.getSectionName());
            addShelfDialog.sectionDropBox.addItem(s.getSectionName());
            addRackDialog.sectionDropBox.addItem(s.getSectionName());
            addAisleDialog.sectionDropBox.addItem(s.getSectionName());
        }
    }

    public void reloadComboBoxes() {
        editSectionComboBox.removeAllItems();
        editAisleComboBox.removeAllItems();
        editRackComboBox.removeAllItems();
        editShelfComboBox.removeAllItems();
        editMerchCombobox.removeAllItems();
        adminPanel.adminEditBodyPanel.dropBoxPanel.sectionDropbox.removeAllItems();
        adminPanel.adminEditBodyPanel.dropBoxPanel.sectionDropbox.addItem("Select Section...");
        adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.removeAllItems();
        adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.addItem("Select Aisle...");
        adminPanel.adminEditBodyPanel.dropBoxPanel.rackDropbox.removeAllItems();
        adminPanel.adminEditBodyPanel.dropBoxPanel.rackDropbox.addItem("Select Rack...");
        adminPanel.adminEditBodyPanel.dropBoxPanel.shelfDropbox.removeAllItems();
        adminPanel.adminEditBodyPanel.dropBoxPanel.shelfDropbox.addItem("Select Shelf...");
        userPanel.userMainBodyPanel.userDropBoxPanel.sectionDropbox.removeAllItems();
        userPanel.userMainBodyPanel.userDropBoxPanel.sectionDropbox.addItem("Select Section...");
        userPanel.userMainBodyPanel.userDropBoxPanel.aisleDropbox.removeAllItems();
        userPanel.userMainBodyPanel.userDropBoxPanel.aisleDropbox.addItem("Select Aisle...");
        userPanel.userMainBodyPanel.userDropBoxPanel.rackDropbox.removeAllItems();
        userPanel.userMainBodyPanel.userDropBoxPanel.rackDropbox.addItem("Select Rack...");
        userPanel.userMainBodyPanel.userDropBoxPanel.shelfDropbox.removeAllItems();
        userPanel.userMainBodyPanel.userDropBoxPanel.shelfDropbox.addItem("Select Shelf...");

        for (int i = 0; i < store.getSections().length; i++) {
            section = store.getSections()[i];
            editSectionComboBox.addItem(section.getSectionName());
            adminPanel.adminEditBodyPanel.dropBoxPanel.sectionDropbox.addItem(section.getSectionName());

            userPanel.userMainBodyPanel.userDropBoxPanel.sectionDropbox.addItem(section.getSectionName());

            for (int j = 0; j < section.getAisles().length; j++) {
                aisle = section.getAisles()[j];
                editAisleComboBox.addItem(aisle.getAisleDisplayName());
                adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.addItem(aisle.getAisleDisplayName());

                userPanel.userMainBodyPanel.userDropBoxPanel.aisleDropbox.addItem(aisle.getAisleDisplayName());

                for (int k = 0; k < aisle.getRack().length; k++) {
                    rack = aisle.getRack()[k];
                    editRackComboBox.addItem(rack.getRackDisplayName());
                    adminPanel.adminEditBodyPanel.dropBoxPanel.rackDropbox.addItem(rack.getRackDisplayName());

                    userPanel.userMainBodyPanel.userDropBoxPanel.rackDropbox.addItem(rack.getRackDisplayName());

                    for (int l = 0; l < rack.getShelf().length; l++) {
                        shelf = rack.getShelf()[l];
                        editShelfComboBox.addItem(shelf.getRowDisplayName());
                        adminPanel.adminEditBodyPanel.dropBoxPanel.shelfDropbox.addItem(shelf.getRowDisplayName());

                        userPanel.userMainBodyPanel.userDropBoxPanel.shelfDropbox.addItem(shelf.getRowDisplayName());
                        for(int m = 0; m < shelf.getItemsOnShelf().length; m++){

                            item = shelf.getItemsOnShelf()[m];
                            editMerchCombobox.addItem(item.getName());
                        }
                    }
                }
            }
        }
    }

    public void printItem(SaleItem i) {
        adminPanel.adminEditBodyPanel.returnField.append("Search results: '" + i.getName() + "'");
        if (i.onSale()){
            adminPanel.adminEditBodyPanel.returnField.append(" SALE!\n");
            adminPanel.adminEditBodyPanel.returnField.append("Location: " + i.getShelf().getRowDisplayName() + "\n");
            adminPanel.adminEditBodyPanel.returnField.append("Price: $" + i.getSalePrice() + "\n");
            adminPanel.adminEditBodyPanel.returnField.append("Sale: " + i.getSaleDescription()+ "\n");
        } else{
            adminPanel.adminEditBodyPanel.returnField.append("\n");
            adminPanel.adminEditBodyPanel.returnField.append("Location: " + i.getShelf().getRowDisplayName() + "\n");
            adminPanel.adminEditBodyPanel.returnField.append("Price: $" + i.getPrice() + "\n");
        }

        adminPanel.adminEditBodyPanel.returnField.append("Description:\n");
        if(i.getDescription().equals("")){
            adminPanel.adminEditBodyPanel.returnField.append("No description found\n");
        } else{
            adminPanel.adminEditBodyPanel.returnField.append(i.getDescription() + "\n");
        }
        if (i.getTags().size() > 0) {
            adminPanel.adminEditBodyPanel.returnField.append("Tags:\n");
            for (int n = 0; n < i.getTags().size(); n++) {
                adminPanel.adminEditBodyPanel.returnField.append(i.getTags().get(n) + "\n");
            }
        }

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

                    editSectionComboBox.addItem(section.getSectionName());

                    adminPanel.adminEditBodyPanel.dropBoxPanel.sectionDropbox.addItem(section.getSectionName());
                    userPanel.userMainBodyPanel.userDropBoxPanel.sectionDropbox.addItem(section.getSectionName());
                    addItemDialog.sectionDropBox.addItem(section.getSectionName());
                    addShelfDialog.sectionDropBox.addItem(section.getSectionName());
                    addRackDialog.sectionDropBox.addItem(section.getSectionName());
                    addAisleDialog.sectionDropBox.addItem(section.getSectionName());

                    for (int j = 0; j < aisleInt; j++) {
                        //aisle = new Aisle("Section: " + (i + 1) + " Aisle: " + Integer.toString(j+ 1));
                        aisle = new Aisle("Aisle: " + Integer.toString(j + 1));
                        section.addAisle(aisle);
                        aisle.setSection(section);
                        editAisleComboBox.addItem(aisle.getAisleDisplayName());
                        adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.addItem(aisle.getAisleDisplayName());
                        userPanel.userMainBodyPanel.userDropBoxPanel.aisleDropbox.addItem(aisle.getAisleDisplayName());
                        for (int k = 0; k < rackInt; k++) {
                            rack = new Rack("Rack: " + Integer.toString(k + 1));
                            aisle.addRack(rack);
                            rack.setAisle(aisle);
                            editRackComboBox.addItem(rack.getRackDisplayName());
                            adminPanel.adminEditBodyPanel.dropBoxPanel.rackDropbox.addItem(rack.getRackDisplayName());
                            userPanel.userMainBodyPanel.userDropBoxPanel.rackDropbox.addItem(rack.getRackDisplayName());
                            for (int l = 0; l < shelfInt; l++) {

                                shelf = new Shelf("Shelf: " + Integer.toString(l + 1));

                                rack.addShelf(shelf);
                                shelf.setRack(rack);
                                editShelfComboBox.addItem(shelf.getRowDisplayName());
                                adminPanel.adminEditBodyPanel.dropBoxPanel.shelfDropbox.addItem(shelf.getRowDisplayName());
                                userPanel.userMainBodyPanel.userDropBoxPanel.shelfDropbox.addItem(shelf.getRowDisplayName());
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


        if (e.getSource() == editReturn || e.getSource() == es.backButton || e.getSource() == ea.backButton || e.getSource() == er.backButton || e.getSource() == esh.backButton || e.getSource() == pc.backButton || e.getSource() == merchReturn || e.getSource() == em.backButton) {

            es.removeTagComboBox.removeAllItems();
            ea.removeTagComboBox.removeAllItems();
            er.removeTagComboBox.removeAllItems();
            esh.removeTagComboBox.removeAllItems();
            em.merchRemoveTagBox.removeAllItems();
            ecl.show(adminEditCard, "Edit");
        }

        if (e.getSource() == editSectionButton) {
            selected = editSectionComboBox.getSelectedItem().toString();
            for (int i = 0; i < store.getSections().length; i++) {
                if (store.getSections()[i].getSectionName().equals(selected)) {
                    section = store.sections.get(i);
                    break;
                }
            }
            //es.removeTagComboBox.addItem("remove tag...");
            for (int i = 0; i < section.getTags().size(); i++) {
                es.removeTagComboBox.addItem(section.getTagsArray()[i]);
            }

            es.editNameField.setText(selected);
            ecl.show(adminEditCard, "Edit Section");
        }

        if (e.getSource() == editAisleButton) {
            selected = editAisleComboBox.getSelectedItem().toString();
            for (int i = 0; i < store.getSections().length; i++) {
                section = store.sections.get(i);
                for (int j = 0; j < section.getAisles().length; j++) {
                    if (section.getAisles()[j].getAisleDisplayName().equals(selected)) {
                        aisle = section.getAisles()[j];
                    }
                }
            }
            //ea.removeTagComboBox.addItem("remove tag...");
            for (int i = 0; i < aisle.getTags().size(); i++) {
                ea.removeTagComboBox.addItem(aisle.getTagsArray()[i]);
            }
            ea.editNameField.setText(aisle.getAisleName());
            ecl.show(adminEditCard, "Edit Aisle");
        }

        if (e.getSource() == editRackButton) {
            selected = editRackComboBox.getSelectedItem().toString();
            for (int i = 0; i < store.getSections().length; i++) {
                section = store.sections.get(i);
                for (int j = 0; j < section.getAisles().length; j++) {
                    aisle = section.getAisles()[j];
                    for (int k = 0; k < aisle.getRack().length; k++) {
                        if (aisle.getRack()[k].getRackDisplayName().equals(selected)) {
                            rack = aisle.getRack()[k];
                        }
                    }
                }
            }
            //er.removeTagComboBox.addItem("remove tag...");
            for (int i = 0; i < rack.getTags().size(); i++) {
                er.removeTagComboBox.addItem(rack.getTagsArray()[i]);
            }
            er.editNameField.setText(rack.getRackName());
            ecl.show(adminEditCard, "Edit Rack");

        }

        if (e.getSource() == editShelfButton) {
            selected = editShelfComboBox.getSelectedItem().toString();
            for (int i = 0; i < store.getSections().length; i++) {
                section = store.sections.get(i);
                for (int j = 0; j < section.getAisles().length; j++) {
                    aisle = section.getAisles()[j];
                    for (int k = 0; k < aisle.getRack().length; k++) {
                        rack = aisle.getRack()[k];
                        for (int l = 0; l < rack.getShelf().length; l++) {
                            if (rack.getShelf()[l].getRowDisplayName().equals(selected)) {
                                shelf = rack.getShelf()[l];
                                break;
                            }
                        }
                    }
                }
            }
            //esh.removeTagComboBox.addItem("remove tag...");
            for (int i = 0; i < shelf.getTags().size(); i++) {
                esh.removeTagComboBox.addItem(shelf.getTagsArray()[i]);
            }
            esh.editNameField.setText(shelf.getRowName());
            ecl.show(adminEditCard, "Edit Shelf");
        }

        if (e.getSource() == es.editNameButton) {
            String newName = es.editNameField.getText();
            section.setSectionName(newName);
            reloadComboBoxes();
            for(int i = 0; i < store.getSections().length; i++){
                if (store.getSections()[i].getSectionName().equals(newName)){
                    section = store.getSections()[i];
                }
            }
        }

        if (e.getSource() == ea.editNameButton) {
            String newName = ea.editNameField.getText();
            aisle.setAisleName(newName);
            String newDisplayName = aisle.getAisleDisplayName();
            reloadComboBoxes();
            for(int i = 0; i < store.getSections().length; i++) {
                section = store.getSections()[i];
                for (int j = 0; j < section.getAisles().length; j++) {
                    if (section.getAisles()[j].getAisleDisplayName().equals(newDisplayName)) {
                        aisle = section.getAisles()[j];
                    }
                }
            }
        }

        if (e.getSource() == er.editNameButton) {
            String newName = er.editNameField.getText();
            rack.setRackName(newName);
            String newDisplayName = rack.getRackDisplayName();
            reloadComboBoxes();
            for(int i = 0; i < store.getSections().length; i++) {
                section = store.getSections()[i];
                for (int j = 0; j < section.getAisles().length; j++) {
                    aisle = section.getAisles()[j];
                    for (int k = 0; k < aisle.getRack().length; k++) {
                        if (aisle.getRack()[k].getRackDisplayName().equals(newDisplayName)) {
                            rack = aisle.getRack()[k];
                        }
                    }
                }
            }
        }

        if (e.getSource() == esh.editNameButton) {
            String newName = esh.editNameField.getText();
            shelf.setRowName(newName);
            String newDisplayName = shelf.getRowDisplayName();
            reloadComboBoxes();
            for(int i = 0; i < store.getSections().length; i++) {
                section = store.getSections()[i];
                for (int j = 0; j < section.getAisles().length; j++) {
                    aisle = section.getAisles()[j];
                    for (int k = 0; k < aisle.getRack().length; k++) {
                        rack = aisle.getRack()[k];
                        for (int l = 0; l < rack.getShelf().length; l++) {
                            if (rack.getShelf()[l].getRowDisplayName().equals(newDisplayName)) {
                                shelf = rack.getShelf()[l];
                            }
                        }
                    }
                }
            }
        }

        if (e.getSource() == es.addTagsButton) {
            section.addTag(es.addTagsField.getText());
            es.removeTagComboBox.addItem(es.addTagsField.getText());
            es.addTagsField.setText("");
        }

        if (e.getSource() == es.removeTagButton) {
            for (int i = 0; i < section.getTags().size(); i++) {
                if (es.removeTagComboBox.getSelectedItem().toString().equals(section.getTagsArray()[i])) {
                    section.removeTag(es.removeTagComboBox.getSelectedItem().toString());
                    es.removeTagComboBox.removeItem(es.removeTagComboBox.getSelectedItem().toString());
                }
            }
        }

        if (e.getSource() == ea.addTagsButton) {
            aisle.addTag(ea.addTagsField.getText());
            ea.removeTagComboBox.addItem(ea.addTagsField.getText());
            ea.addTagsField.setText("");
        }

        if (e.getSource() == ea.removeTagButton) {
            for (int i = 0; i < aisle.getTags().size(); i++) {
                if (ea.removeTagComboBox.getSelectedItem().toString().equals(aisle.getTagsArray()[i])) {
                    aisle.removeTag(ea.removeTagComboBox.getSelectedItem().toString());
                    ea.removeTagComboBox.removeItem(ea.removeTagComboBox.getSelectedItem().toString());
                }
            }
        }

        if (e.getSource() == er.addTagsButton) {
            rack.addTag(er.addTagsField.getText());
            er.removeTagComboBox.addItem(er.addTagsField.getText());
            er.addTagsField.setText("");
        }

        if (e.getSource() == er.removeTagButton) {
            for (int i = 0; i < rack.getTags().size(); i++) {
                if (er.removeTagComboBox.getSelectedItem().toString().equals(rack.getTagsArray()[i])) {
                    rack.removeTag(er.removeTagComboBox.getSelectedItem().toString());
                    er.removeTagComboBox.removeItem(er.removeTagComboBox.getSelectedItem().toString());
                }
            }
        }

        if (e.getSource() == esh.addTagsButton) {
            shelf.addTag(esh.addTagsField.getText());
            esh.removeTagComboBox.addItem(esh.addTagsField.getText());
            esh.addTagsField.setText("");
        }

        if (e.getSource() == esh.removeTagButton) {
            for (int i = 0; i < shelf.getTags().size(); i++) {
                if (esh.removeTagComboBox.getSelectedItem().toString().equals(shelf.getTagsArray()[i])) {
                    shelf.removeTag(esh.removeTagComboBox.getSelectedItem().toString());
                    esh.removeTagComboBox.removeItem(esh.removeTagComboBox.getSelectedItem().toString());
                }
            }
        }

        if (e.getSource() == pc.changePasswordButton)
            if (pc.changePasswordField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(controllingContainer, "Enter a new password");
            } else {
                if (Arrays.equals(pc.changePasswordField.getPassword(), pc.changePasswordFieldVerify.getPassword())) {
                    pw.changePassword(pc.changePasswordField.getPassword());
                    pc.changePasswordField.setText("");
                    pc.changePasswordFieldVerify.setText("");
                    JOptionPane.showMessageDialog(controllingContainer, "Password successfully changed");
                } else {
                    JOptionPane.showMessageDialog(controllingContainer, "Passwords do not match");

                }
            }

        if (e.getSource() == editMerchButton) {
            selected = editMerchCombobox.getSelectedItem().toString();
            for (int i = 0; i < store.getSections().length; i++) {
                section = store.sections.get(i);
                for (int j = 0; j < section.getAisles().length; j++) {
                    aisle = section.getAisles()[j];
                    for (int k = 0; k < aisle.getRack().length; k++) {
                        rack = aisle.getRack()[k];
                        for (int l = 0; l < rack.getShelf().length; l++) {
                            shelf = rack.getShelf()[l];
                            for (int m = 0; m < shelf.getItemsOnShelf().length; m++) {
                                if (shelf.getItemsOnShelf()[m].getName().equals(selected)) {
                                    item = shelf.getItemsOnShelf()[m];
                                }
                            }

                        }
                    }
                }
            }
            for (int i = 0; i < item.getTags().size(); i++) {
                em.merchRemoveTagBox.addItem(item.getTagsArray()[i]);
            }
            em.merchNameField.setText(item.getName());
            em.merchPriceField.setText(String.valueOf(item.getPrice()));
            em.merchSalePriceField.setText(String.valueOf(item.getSalePrice()));
            em.saleDescriptionField.setText(item.getSaleDescription());
            em.merchEditDescriptionField.setText(item.getDescription());
            if (item.onSale()) {
                em.saleButton.setSelected(true);
            } else {
                em.saleButton.setSelected(false);
            }
            ecl.show(adminEditCard, "Edit Merchandise");

        }

        if (e.getSource() == em.saleButton) {
            if (em.saleButton.isSelected()) {
                item.setSaleTrue();
            } else {
                item.setSaleFalse();
            }
        }

        if (e.getSource() == em.merchNameSubmit) {
            String newName = em.merchNameField.getText();
            item.setName(newName);
            reloadComboBoxes();
            for(int i = 0; i < store.getSections().length; i++) {
                section = store.getSections()[i];
                for (int j = 0; j < section.getAisles().length; j++) {
                    aisle = section.getAisles()[j];
                    for (int k = 0; k < aisle.getRack().length; k++) {
                        rack = aisle.getRack()[k];
                        for (int l = 0; l < rack.getShelf().length; l++) {
                            shelf = rack.getShelf()[l];
                            for (int m = 0; m < shelf.getItemsOnShelf().length; m++){
                                if(shelf.getItemsOnShelf()[m].getName().equals(newName)){
                                    item = shelf.getItemsOnShelf()[m];
                                }
                            }
                        }
                    }
                }
            }
        }

        if (e.getSource() == em.merchPriceSubmit) {
            Double newPrice = Double.parseDouble(em.merchPriceField.getText());
            item.setPrice(newPrice);
        }

        if (e.getSource() == em.merchAddTagSubmit) {
            item.addTag(em.merchAddTagField.getText());
            em.merchRemoveTagBox.addItem(em.merchAddTagField.getText());
            em.merchAddTagField.setText("");
        }

        if (e.getSource() == em.merchRemoveSubmit) {
            for (int i = 0; i < item.getTags().size(); i++) {
                if (em.merchRemoveTagBox.getSelectedItem().toString().equals(item.getTagsArray()[i])) {
                    item.removeTag(em.merchRemoveTagBox.getSelectedItem().toString());
                    em.merchRemoveTagBox.removeItem(em.merchRemoveTagBox.getSelectedItem().toString());
                }
            }
        }

        if (e.getSource() == em.merchEditDescriptionSubmit) {
            item.setDescription(em.merchEditDescriptionField.getText());
        }

        if (e.getSource() == em.merchSaleSubmit) {
            item.setSalePrice(Double.parseDouble(em.merchSalePriceField.getText()));
            item.setSaleDescription(em.saleDescriptionField.getText());
        }

        if(e.getSource() == adminPanel.adminEditBottomPanel.adminPanel.dropBoxPanel.searchButton){

            if(!adminPanel.adminEditBodyPanel.dropBoxPanel.searchField.getText().equals("")){
                adminPanel.adminEditBodyPanel.returnField.append("Search query: " + "'" + adminPanel.adminEditBodyPanel.dropBoxPanel.searchField.getText() + "'\n");
                selected = adminPanel.adminEditBodyPanel.dropBoxPanel.searchField.getText();
                for (int i = 0; i < store.getSections().length; i++) {
                    if (store.getSections()[i].getSectionName().equals(selected)) {
                        section = store.sections.get(i);
                        adminPanel.adminEditBodyPanel.returnField.append("Search result: '" + section.getSectionName() + "'\n");
                        adminPanel.adminEditBodyPanel.returnField.append("Aisles:\n");
                        if(section.hasAisle()) {
                            for (int k = 0; k < section.getAisles().length; k++) {
                                aisle = section.getAisles()[k];
                                adminPanel.adminEditBodyPanel.returnField.append(aisle.getAisleName() + "\n");
                            }
                        } else{
                            adminPanel.adminEditBodyPanel.returnField.append("none\n");
                        }
                        if(section.getTags().size() > 0) {
                            adminPanel.adminEditBodyPanel.returnField.append("Tags:\n");
                            for (int j = 0; j < section.getTags().size(); j++) {
                                adminPanel.adminEditBodyPanel.returnField.append(section.getTags().get(j) + "\n");
                            }
                        }
                    }
                }
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        if (section.getAisles()[j].getAisleDisplayName().equals(selected)) {
                            aisle = section.getAisles()[j];
                            adminPanel.adminEditBodyPanel.returnField.append("Search result: '" + aisle.getAisleDisplayName() + "'\n");
                            adminPanel.adminEditBodyPanel.returnField.append("Racks:\n");
                            if (aisle.hasRacks()){
                                for (int k = 0; k < aisle.getRack().length; k++){
                                    rack = aisle.getRack()[k];
                                    adminPanel.adminEditBodyPanel.returnField.append(rack.getRackName() + "\n");
                                }
                            } else{
                                adminPanel.adminEditBodyPanel.returnField.append("none\n");
                            }
                            if(aisle.getTags().size() > 0){
                                adminPanel.adminEditBodyPanel.returnField.append("Tags:\n");
                                for (int m = 0; m < aisle.getTags().size(); m ++){
                                    adminPanel.adminEditBodyPanel.returnField.append(aisle.getTags().get(m)+ "\n");
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for(int k = 0; k < aisle.getRack().length; k++){
                            if(aisle.getRack()[k].getRackDisplayName().equals(selected)){
                                rack = aisle.getRack()[k];
                                adminPanel.adminEditBodyPanel.returnField.append("Search result: '" + rack.getRackDisplayName() +"'\n");
                                adminPanel.adminEditBodyPanel.returnField.append("Shelves:\n");
                                if(rack.hasShelves()){
                                    for (int m = 0; m < rack.getShelf().length; m++){
                                        shelf = rack.getShelf()[m];
                                        adminPanel.adminEditBodyPanel.returnField.append(shelf.rowName + "\n");
                                    }
                                } else{
                                    adminPanel.adminEditBodyPanel.returnField.append("none\n");
                                }
                                if(rack.getTags().size() > 0){
                                    adminPanel.adminEditBodyPanel.returnField.append("Tags:\n");
                                    for(int n = 0; n < rack.getTags().size(); n++){
                                        adminPanel.adminEditBodyPanel.returnField.append(rack.getTags().get(n) + "\n");
                                    }
                                }

                            }
                        }
                    }
                }
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for(int k = 0; k < aisle.getRack().length; k++){
                            rack = aisle.getRack()[k];
                            for(int l = 0; l < rack.getShelf().length; l++){
                                if(rack.getShelf()[l].getRowDisplayName().equals(selected)){
                                    shelf = rack.getShelf()[l];
                                    adminPanel.adminEditBodyPanel.returnField.append("Search results: '" + shelf.getRowDisplayName() + "'\n");
                                    adminPanel.adminEditBodyPanel.returnField.append("Items on shelf:\n");
                                    if(shelf.hasItems()){
                                        for (int m = 0; m < shelf.getItemsOnShelf().length; m++){
                                            item = shelf.getItemsOnShelf()[m];
                                            adminPanel.adminEditBodyPanel.returnField.append(item.getName()+"\n");
                                        }
                                    } else{
                                        adminPanel.adminEditBodyPanel.returnField.append("none\n");
                                    }
                                    if (shelf.getTags().size() > 0){
                                        adminPanel.adminEditBodyPanel.returnField.append("Tags:\n");
                                        for(int n = 0; n < shelf.getTags().size(); n++){
                                            adminPanel.adminEditBodyPanel.returnField.append(shelf.getTags().get(n) + "\n");
                                        }
                                    }
                                }
                            }
                        }
                    }
            }
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for(int k = 0; k < aisle.getRack().length; k++){
                            rack = aisle.getRack()[k];
                            for(int l = 0; l < rack.getShelf().length; l++){
                                shelf = rack.getShelf()[l];
                                for(int m = 0; m < shelf.getItemsOnShelf().length; m++){
                                    if(shelf.getItemsOnShelf()[m].getName().equals(selected)){
                                        item = shelf.getItemsOnShelf()[m];
                                        printItem(item);
                                    }
                                }
                            }
                        }
                    }
                }
                //start substring item search
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for(int k = 0; k < aisle.getRack().length; k++){
                            rack = aisle.getRack()[k];
                            for(int l = 0; l < rack.getShelf().length; l++){
                                shelf = rack.getShelf()[l];
                                for(int m = 0; m < shelf.getItemsOnShelf().length; m++){
                                    item = shelf.getItemsOnShelf()[m];
                                    for (int n = 0; n <= (item.getName().length() - selected.length()); n++){
                                        if(item.getName().regionMatches(true, n, selected, 0, selected.length())&& !item.getName().equalsIgnoreCase(selected)){
                                                printItem(item);
                                        }

                                    }

                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int a = 0; a < section.getTags().size(); a++){
                        if(section.getTags().get(a).equals(selected)){
                            adminPanel.adminEditBodyPanel.returnField.append("Search result: '" + section.getSectionName() + "'\n");
                            adminPanel.adminEditBodyPanel.returnField.append("Aisles:\n");
                            if(section.hasAisle()) {
                                for (int k = 0; k < section.getAisles().length; k++) {
                                    aisle = section.getAisles()[k];
                                    adminPanel.adminEditBodyPanel.returnField.append(aisle.getAisleName() + "\n");
                                }
                            } else{
                                adminPanel.adminEditBodyPanel.returnField.append("none\n");
                            }
                            if(section.getTags().size() > 0) {
                                adminPanel.adminEditBodyPanel.returnField.append("Tags:\n");
                                for (int j = 0; j < section.getTags().size(); j++) {
                                    adminPanel.adminEditBodyPanel.returnField.append(section.getTags().get(j) + "\n");
                                }
                            } break;
                        }
                    }
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for (int b = 0; b < aisle.getTags().size(); b++){
                            if(aisle.getTags().get(b).equals(selected)){
                                adminPanel.adminEditBodyPanel.returnField.append("Search result: '" + aisle.getAisleDisplayName() + "'\n");
                                adminPanel.adminEditBodyPanel.returnField.append("Racks:\n");
                                if (aisle.hasRacks()){
                                    for (int k = 0; k < aisle.getRack().length; k++){
                                        rack = aisle.getRack()[k];
                                        adminPanel.adminEditBodyPanel.returnField.append(rack.getRackName() + "\n");
                                    }
                                } else{
                                    adminPanel.adminEditBodyPanel.returnField.append("none\n");
                                }
                                if(aisle.getTags().size() > 0){
                                    adminPanel.adminEditBodyPanel.returnField.append("Tags:\n");
                                    for (int m = 0; m < aisle.getTags().size(); m ++){
                                        adminPanel.adminEditBodyPanel.returnField.append(aisle.getTags().get(m)+ "\n");
                                    }
                                }break;
                            }
                        }
                        for(int k = 0; k < aisle.getRack().length; k++){
                            rack = aisle.getRack()[k];
                            for (int c = 0; c < rack.getTags().size(); c++){
                                if(rack.getTags().get(c).equals(selected)){
                                    adminPanel.adminEditBodyPanel.returnField.append("Search result: '" + rack.getRackDisplayName() +"'\n");
                                    adminPanel.adminEditBodyPanel.returnField.append("Shelves:\n");
                                    if(rack.hasShelves()){
                                        for (int m = 0; m < rack.getShelf().length; m++){
                                            shelf = rack.getShelf()[m];
                                            adminPanel.adminEditBodyPanel.returnField.append(shelf.rowName + "\n");
                                        }
                                    } else{
                                        adminPanel.adminEditBodyPanel.returnField.append("none\n");
                                    }
                                    if(rack.getTags().size() > 0){
                                        adminPanel.adminEditBodyPanel.returnField.append("Tags:\n");
                                        for(int n = 0; n < rack.getTags().size(); n++){
                                            adminPanel.adminEditBodyPanel.returnField.append(rack.getTags().get(n) + "\n");
                                        }
                                    }break;
                                }
                            }
                            for(int l = 0; l < rack.getShelf().length; l++){
                                shelf = rack.getShelf()[l];
                                for (int d = 0; d < shelf.getTags().size(); d++){
                                    if(shelf.getTags().get(d).equals(selected)){
                                        adminPanel.adminEditBodyPanel.returnField.append("Search results: '" + shelf.getRowDisplayName() + "'\n");
                                        adminPanel.adminEditBodyPanel.returnField.append("Items on shelf:\n");
                                        if(shelf.hasItems()){
                                            for (int m = 0; m < shelf.getItemsOnShelf().length; m++){
                                                item = shelf.getItemsOnShelf()[m];
                                                adminPanel.adminEditBodyPanel.returnField.append(item.getName()+"\n");
                                            }
                                        } else{
                                            adminPanel.adminEditBodyPanel.returnField.append("none\n");
                                        }
                                        if (shelf.getTags().size() > 0){
                                            adminPanel.adminEditBodyPanel.returnField.append("Tags:\n");
                                            for(int n = 0; n < shelf.getTags().size(); n++){
                                                adminPanel.adminEditBodyPanel.returnField.append(shelf.getTags().get(n) + "\n");
                                            }
                                        }break;
                                    }
                                }
                                for(int m = 0; m < shelf.getItemsOnShelf().length; m++){
                                    item = shelf.getItemsOnShelf()[m];
                                    for (int f = 0; f<item.getTags().size(); f++){
                                        if(item.getTags().get(f).equals(selected)){
                                            printItem(item);
                                            break;
                                        }
                                    }
                                }//here

                            }
                        }
                    }
                }


            }

            if(!adminPanel.adminEditBodyPanel.dropBoxPanel.sectionDropbox.getSelectedItem().equals("Select Section...")){
                selected = adminPanel.adminEditBodyPanel.dropBoxPanel.sectionDropbox.getSelectedItem().toString();
                for (int i = 0; i < store.getSections().length; i++) {
                    if (store.getSections()[i].getSectionName().equals(selected)) {
                        section = store.sections.get(i);
                        adminPanel.adminEditBodyPanel.returnField.append("Search result: '" + section.getSectionName() + "'\n");
                        adminPanel.adminEditBodyPanel.returnField.append("Aisles:\n");
                        if(section.hasAisle()) {
                            for (int k = 0; k < section.getAisles().length; k++) {
                                aisle = section.getAisles()[k];
                                adminPanel.adminEditBodyPanel.returnField.append(aisle.getAisleName() + "\n");
                            }
                        } else{
                            adminPanel.adminEditBodyPanel.returnField.append("none\n");
                        }
                        if(section.getTags().size() > 0) {
                            adminPanel.adminEditBodyPanel.returnField.append("Tags:\n");
                            for (int j = 0; j < section.getTags().size(); j++) {
                                adminPanel.adminEditBodyPanel.returnField.append(section.getTags().get(j) + "\n");
                            }
                        }
                    }
                }
            }
            if(!adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.getSelectedItem().equals("Select Aisle...")){
                selected = adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.getSelectedItem().toString();
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        if (section.getAisles()[j].getAisleDisplayName().equals(selected)) {
                            aisle = section.getAisles()[j];
                            adminPanel.adminEditBodyPanel.returnField.append("Search result: '" + aisle.getAisleDisplayName() + "'\n");
                            adminPanel.adminEditBodyPanel.returnField.append("Racks:\n");
                            if (aisle.hasRacks()){
                                for (int k = 0; k < aisle.getRack().length; k++){
                                    rack = aisle.getRack()[k];
                                    adminPanel.adminEditBodyPanel.returnField.append(rack.getRackName() + "\n");
                                }
                            } else{
                                adminPanel.adminEditBodyPanel.returnField.append("none\n");
                            }
                            if(aisle.getTags().size() > 0){
                                adminPanel.adminEditBodyPanel.returnField.append("Tags:\n");
                                for (int m = 0; m < aisle.getTags().size(); m ++){
                                    adminPanel.adminEditBodyPanel.returnField.append(aisle.getTags().get(m)+ "\n");
                                }
                            }
                        }
                    }
                }
            }
            if(!adminPanel.adminEditBodyPanel.dropBoxPanel.rackDropbox.getSelectedItem().equals("Select Rack...")){
                selected = adminPanel.adminEditBodyPanel.dropBoxPanel.rackDropbox.getSelectedItem().toString();
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for(int k = 0; k < aisle.getRack().length; k++){
                            if(aisle.getRack()[k].getRackDisplayName().equals(selected)){
                                rack = aisle.getRack()[k];
                                adminPanel.adminEditBodyPanel.returnField.append("Search result: '" + rack.getRackDisplayName() +"'\n");
                                adminPanel.adminEditBodyPanel.returnField.append("Shelves:\n");
                                if(rack.hasShelves()){
                                    for (int m = 0; m < rack.getShelf().length; m++){
                                        shelf = rack.getShelf()[m];
                                        adminPanel.adminEditBodyPanel.returnField.append(shelf.rowName + "\n");
                                    }
                                } else{
                                    adminPanel.adminEditBodyPanel.returnField.append("none\n");
                                }
                                if(rack.getTags().size() > 0){
                                    adminPanel.adminEditBodyPanel.returnField.append("Tags:\n");
                                    for(int n = 0; n < rack.getTags().size(); n++){
                                        adminPanel.adminEditBodyPanel.returnField.append(rack.getTags().get(n) + "\n");
                                    }
                                }

                            }
                        }
                    }
                }
            }
            if(!adminPanel.adminEditBodyPanel.dropBoxPanel.shelfDropbox.getSelectedItem().equals("Select Shelf...")){
                selected = adminPanel.adminEditBodyPanel.dropBoxPanel.shelfDropbox.getSelectedItem().toString();
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for(int k = 0; k < aisle.getRack().length; k++){
                            rack = aisle.getRack()[k];
                            for(int l = 0; l < rack.getShelf().length; l++){
                                if(rack.getShelf()[l].getRowDisplayName().equals(selected)){
                                    shelf = rack.getShelf()[l];
                                    adminPanel.adminEditBodyPanel.returnField.append("Search results: '" + shelf.getRowDisplayName() + "'\n");
                                    adminPanel.adminEditBodyPanel.returnField.append("Items on shelf:\n");
                                    if(shelf.hasItems()){
                                        for (int m = 0; m < shelf.getItemsOnShelf().length; m++){
                                            item = shelf.getItemsOnShelf()[m];
                                            adminPanel.adminEditBodyPanel.returnField.append(item.getName()+"\n");
                                        }
                                    } else{
                                        adminPanel.adminEditBodyPanel.returnField.append("none\n");
                                    }
                                    if (shelf.getTags().size() > 0){
                                        adminPanel.adminEditBodyPanel.returnField.append("Tags:\n");
                                        for(int n = 0; n < shelf.getTags().size(); n++){
                                            adminPanel.adminEditBodyPanel.returnField.append(shelf.getTags().get(n) + "\n");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        if(e.getSource() == userPanel.userMainBodyPanel.userDropBoxPanel.searchButton){
            if(!userPanel.userMainBodyPanel.userDropBoxPanel.sectionDropbox.getSelectedItem().equals("Select Section...")){
                selected = userPanel.userMainBodyPanel.userDropBoxPanel.sectionDropbox.getSelectedItem().toString();
                for (int i = 0; i < store.getSections().length; i++) {
                    if (store.getSections()[i].getSectionName().equals(selected)) {
                        section = store.sections.get(i);
                        userPanel.userMainBodyPanel.returnField.append("Search result: '" + section.getSectionName() + "'\n");
                        userPanel.userMainBodyPanel.returnField.append("Aisles:\n");
                        if(section.hasAisle()) {
                            for (int k = 0; k < section.getAisles().length; k++) {
                                aisle = section.getAisles()[k];
                                userPanel.userMainBodyPanel.returnField.append(aisle.getAisleName() + "\n");
                            }
                        } else{
                            userPanel.userMainBodyPanel.returnField.append("none\n");
                        }

                    }
                }
            }
            if(!userPanel.userMainBodyPanel.userDropBoxPanel.aisleDropbox.getSelectedItem().equals("Select Aisle...")){
                selected = userPanel.userMainBodyPanel.userDropBoxPanel.aisleDropbox.getSelectedItem().toString();
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        if (section.getAisles()[j].getAisleDisplayName().equals(selected)) {
                            aisle = section.getAisles()[j];
                            userPanel.userMainBodyPanel.returnField.append("Search result: '" + aisle.getAisleDisplayName() + "'\n");
                            userPanel.userMainBodyPanel.returnField.append("Racks:\n");
                            if (aisle.hasRacks()){
                                for (int k = 0; k < aisle.getRack().length; k++){
                                    rack = aisle.getRack()[k];
                                    userPanel.userMainBodyPanel.returnField.append(rack.getRackName() + "\n");
                                }
                            } else{
                                userPanel.userMainBodyPanel.returnField.append("none\n");
                            }

                        }
                    }
                }
            }
            if(!userPanel.userMainBodyPanel.userDropBoxPanel.rackDropbox.getSelectedItem().equals("Select Rack...")){
                selected = userPanel.userMainBodyPanel.userDropBoxPanel.rackDropbox.getSelectedItem().toString();
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for(int k = 0; k < aisle.getRack().length; k++){
                            if(aisle.getRack()[k].getRackDisplayName().equals(selected)){
                                rack = aisle.getRack()[k];
                                userPanel.userMainBodyPanel.returnField.append("Search result: '" + rack.getRackDisplayName() +"'\n");
                                userPanel.userMainBodyPanel.returnField.append("Shelves:\n");
                                if(rack.hasShelves()){
                                    for (int m = 0; m < rack.getShelf().length; m++){
                                        shelf = rack.getShelf()[m];
                                        userPanel.userMainBodyPanel.returnField.append(shelf.rowName + "\n");
                                    }
                                } else{
                                    userPanel.userMainBodyPanel.returnField.append("none\n");
                                }


                            }
                        }
                    }
                }
            }
            if(!userPanel.userMainBodyPanel.userDropBoxPanel.shelfDropbox.getSelectedItem().equals("Select Shelf...")){
                selected = userPanel.userMainBodyPanel.userDropBoxPanel.shelfDropbox.getSelectedItem().toString();
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for(int k = 0; k < aisle.getRack().length; k++){
                            rack = aisle.getRack()[k];
                            for(int l = 0; l < rack.getShelf().length; l++){
                                if(rack.getShelf()[l].getRowDisplayName().equals(selected)){
                                    shelf = rack.getShelf()[l];
                                    userPanel.userMainBodyPanel.returnField.append("Search results: '" + shelf.getRowDisplayName() + "'\n");
                                    userPanel.userMainBodyPanel.returnField.append("Items on shelf:\n");
                                    if(shelf.hasItems()){
                                        for (int m = 0; m < shelf.getItemsOnShelf().length; m++){
                                            item = shelf.getItemsOnShelf()[m];
                                            userPanel.userMainBodyPanel.returnField.append(item.getName()+"\n");
                                        }
                                    } else{
                                        userPanel.userMainBodyPanel.returnField.append("none\n");
                                    }

                                }
                            }
                        }
                    }
                }
            }

        }

        //starts methods for adding an item
        if (e.getSource() == AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addItemButton) {
            reloadAddSectionDropBoxes();
            addItemDialog.setVisible(true);
        }
        if (e.getSource() == addItemDialog.sectionDropBox) {//populate the aisle box
            int sectionIndex = addItemDialog.sectionDropBox.getSelectedIndex();
            if (sectionIndex != -1) {//makes sure an index is selected first, populates aisles
                addItemDialog.aisleDropBox.removeAllItems();//clears the list so only the proper are in the box
                addItemDialog.rackDropBox.removeAllItems();
                addItemDialog.shelfDropBox.removeAllItems();
                addItemDialog.aisleDropBox.addItem("Select an Aisle...");
                addItemDialog.rackDropBox.addItem("Select a Rack...");
                addItemDialog.shelfDropBox.addItem("Select a Shelf...");
                if (sectionIndex != 0) {
                    for (int i = 0; i < store.getSections()[sectionIndex - 1].getAisles().length; i++) {//first index is the select a ...
                        addItemDialog.aisleDropBox.addItem(store.getSections()[sectionIndex - 1].getAisles()[i].getAisleName());
                        addItemDialog.aisleDropBox.addActionListener(this);
                    }
                }
            }
        }
        if (e.getSource() == addItemDialog.aisleDropBox) {//populate the rack box
            int sectionIndex = addItemDialog.sectionDropBox.getSelectedIndex();
            int aisleIndex = addItemDialog.aisleDropBox.getSelectedIndex();
            if (aisleIndex != -1) {//makes sure an index is selected first, populates racks
                addItemDialog.rackDropBox.removeAllItems();//clears the list so only the proper are in the box
                addItemDialog.shelfDropBox.removeAllItems();
                addItemDialog.rackDropBox.addItem("Select a Rack...");
                addItemDialog.shelfDropBox.addItem("Select a Shelf...");
                if (aisleIndex != 0) {
                    for (int i = 0;
                         i < store.getSections()[sectionIndex - 1].getAisles()[aisleIndex - 1].getRack().length;
                         i++) {//first index is the "select a ..."
                        addItemDialog.rackDropBox.addItem(store.getSections()[sectionIndex - 1].getAisles()[aisleIndex - 1].getRack()[i].getRackName());
                        addItemDialog.rackDropBox.addActionListener(this);
                    }
                }
            }
        }
        if (e.getSource() == addItemDialog.rackDropBox) {//populate the shelf box
            int sectionIndex = addItemDialog.sectionDropBox.getSelectedIndex();
            int aisleIndex = addItemDialog.aisleDropBox.getSelectedIndex();
            int rackIndex = addItemDialog.rackDropBox.getSelectedIndex();
            if (rackIndex != -1) {
                addItemDialog.shelfDropBox.removeAllItems();//clears the list so only the proper are in the box
                addItemDialog.shelfDropBox.addItem("Select a shelf...");
                if (rackIndex != 0) {
                    for (int i = 0;
                         i < store.getSections()[sectionIndex - 1].getAisles()[aisleIndex - 1].getRack()[rackIndex - 1].getShelf().length;
                         i++) {//first index is the "select a ..."
                        addItemDialog.shelfDropBox.addItem(store.getSections()[sectionIndex - 1].getAisles()[aisleIndex - 1].getRack()[rackIndex - 1].getShelf()[i].getRowName());
                    }
                }
            }
        }
        if (e.getSource() == addItemDialog.submitButton) {//making a new item with click of submit button
            String name = addItemDialog.itemNameField.getText();
            double price;
            if (!addItemDialog.itemPriceField.getText().equals("")) {
                try {
                    price = Double.parseDouble(addItemDialog.itemPriceField.getText());
                } catch (NumberFormatException n) {
                    price = -1;
                }
            } else {
                price = -1;
            }
            String desc = addItemDialog.itemDescriptionField.getText();
            SaleItem newItem = new SaleItem(price, name, desc);
            editMerchCombobox.addItem(name);
            String tagsTogether = addItemDialog.itemTagField.getText();
            if (!tagsTogether.equals("")) { //adds tags if there are any
                String[] allTags = tagsTogether.split(", ");
                for (String s : allTags) {
                    newItem.addTag(s);
                }
            }
            int sectionIndex = addItemDialog.sectionDropBox.getSelectedIndex() - 1;
            int aisleIndex = addItemDialog.aisleDropBox.getSelectedIndex() - 1;
            int rackIndex = addItemDialog.rackDropBox.getSelectedIndex() - 1;
            int shelfIndex = addItemDialog.shelfDropBox.getSelectedIndex() - 1;
            if (newItem.validateItem() && sectionIndex != -1 && aisleIndex != -1 && rackIndex != -1 && shelfIndex != -1) {//if it's a valid item
                if (store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].getShelf()[shelfIndex].hasItems()) {//if other items are on the shelf
                    for (SaleItem s : store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].getShelf()[shelfIndex].getItemsOnShelf()) {
                        boolean check = newItem.getName().equalsIgnoreCase(s.getName());//checking to see if it already exists
                        fcheck = check || fcheck; //will return false unless an item with that name and brand already exists on the shelf
                    }
                    if (fcheck == false) {
                        store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].getShelf()[shelfIndex].addItem(newItem);
                        newItem.setShelf(store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].getShelf()[shelfIndex]);
                        addItemDialog.setVisible(false);
                        addItemDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        reloadComboBoxes();
                    } else {
                        JOptionPane.showMessageDialog(controllingContainer, "Item already exists on shelf.");
                        fcheck = false;
                    }
                } else { //if it's a valid item and no other items are on the shelf, it adds it immediately
                    store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].getShelf()[shelfIndex].addItem(newItem);
                    newItem.setShelf(store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].getShelf()[shelfIndex]);
                    addItemDialog.setVisible(false);
                    addItemDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    reloadComboBoxes();
                }
            } else if (sectionIndex == -1) {
                JOptionPane.showMessageDialog(controllingContainer, "Select a section first.");
            } else if (aisleIndex == -1) {
                JOptionPane.showMessageDialog(controllingContainer, "Select an aisle first.");
            } else if (rackIndex == -1) {
                JOptionPane.showMessageDialog(controllingContainer, "Select a rack first.");
            } else if (shelfIndex == -1) {
                JOptionPane.showMessageDialog(controllingContainer, "Select a shelf first.");
            } else if (!newItem.validateItem()) {
                JOptionPane.showMessageDialog(controllingContainer, "Make sure all item fields are filled out properly. Ex. price #.##");
            }
        }
        //starts methods for adding a shelf
        if (e.getSource() == AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addShelfButton) {
            reloadAddSectionDropBoxes();
            addShelfDialog.setVisible(true);
        }
        if (e.getSource() == addShelfDialog.sectionDropBox) {//populate the aisle box
            int sectionIndex = addShelfDialog.sectionDropBox.getSelectedIndex();
            if (sectionIndex != -1) {//makes sure an index is selected first, populates aisles
                addShelfDialog.aisleDropBox.removeAllItems();//clears the list so only the proper are in the box
                addShelfDialog.aisleDropBox.addItem("Select an aisle...");
                if (sectionIndex != 0) {
                    for (int i = 0; i < store.getSections()[sectionIndex - 1].getAisles().length; i++) {//first index is the select a ...
                        addShelfDialog.aisleDropBox.addItem(store.getSections()[sectionIndex - 1].getAisles()[i].getAisleName());
                        addShelfDialog.aisleDropBox.addActionListener(this);
                    }
                }
            }
        }
        if (e.getSource() == addShelfDialog.aisleDropBox) {//populate the rack box
            int sectionIndex = addShelfDialog.sectionDropBox.getSelectedIndex();
            int aisleIndex = addShelfDialog.aisleDropBox.getSelectedIndex();
            if (aisleIndex != -1) {//makes sure an index is selected first, populates racks
                addShelfDialog.rackDropBox.removeAllItems();//clears the list so only the proper are in the box
                addShelfDialog.rackDropBox.addItem("Select a rack...");
                if (aisleIndex != 0) {
                    for (int i = 0;
                         i < store.getSections()[sectionIndex - 1].getAisles()[aisleIndex - 1].getRack().length;
                         i++) {//first index is the "select a ..."
                        addShelfDialog.rackDropBox.addItem(store.getSections()[sectionIndex - 1].getAisles()[aisleIndex - 1].getRack()[i].getRackName());
                        addShelfDialog.rackDropBox.addActionListener(this);
                    }
                }
            }
        }
        if (e.getSource() == addShelfDialog.submitButton) {//making a new shelf with click of submit button
            String name = addShelfDialog.shelfNameField.getText();
            Shelf newShelf = new Shelf(name);
            String tagsTogether = addShelfDialog.shelfTagField.getText();
            if (!tagsTogether.equals("")) { //adds tags if there are any
                String[] allTags = tagsTogether.split(", ");
                for (String s : allTags) {
                    newShelf.addTag(s);
                }
            }
            int sectionIndex = addShelfDialog.sectionDropBox.getSelectedIndex() - 1;
            int aisleIndex = addShelfDialog.aisleDropBox.getSelectedIndex() - 1;
            int rackIndex = addShelfDialog.rackDropBox.getSelectedIndex() - 1;
            if (newShelf.validateShelf() && sectionIndex != -1 && aisleIndex != -1 && rackIndex != -1) {//if it's a valid shelf name
                if (store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].hasShelves()) {//if other shelves are in the rack
                    for (Shelf s : store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].getShelf()) {
                        boolean check = newShelf.getRowName().equalsIgnoreCase(s.getRowName());//checking to see if it already exists
                        fcheck = check || fcheck; //will return false unless a shelf with that name already exists in the rack
                    }
                    if (fcheck == false) {
                        store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].addShelf(newShelf);
                        newShelf.setRack(store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex]);
                        newShelf.setAisle(store.getSections()[sectionIndex].getAisles()[aisleIndex]);
                        newShelf.setSection(store.getSections()[sectionIndex]);
                        addShelfDialog.shelfNameField.setText("");
                        addShelfDialog.shelfTagField.setText("");
                        addShelfDialog.setVisible(false);
                        addShelfDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        reloadComboBoxes();
                    } else {
                        JOptionPane.showMessageDialog(controllingContainer, "Shelf already exists on Rack.");
                        fcheck = false;
                    }
                } else {//if it's a valid shelf and no other shelves are in the rack, it adds it immediately
                    store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex].addShelf(newShelf);
                    newShelf.setRack(store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()[rackIndex]);
                    newShelf.setAisle(store.getSections()[sectionIndex].getAisles()[aisleIndex]);
                    newShelf.setSection(store.getSections()[sectionIndex]);
                    addShelfDialog.shelfNameField.setText("");
                    addShelfDialog.shelfTagField.setText("");
                    addItemDialog.setVisible(false);
                    addItemDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    reloadComboBoxes();
                }
            } else if (sectionIndex == -1) {
                JOptionPane.showMessageDialog(controllingContainer, "Select a section first.");
            } else if (aisleIndex == -1) {
                JOptionPane.showMessageDialog(controllingContainer, "Select an aisle first.");
            } else if (rackIndex == -1) {
                JOptionPane.showMessageDialog(controllingContainer, "Select a rack first.");
            } else if (!newShelf.validateShelf()) {
                JOptionPane.showMessageDialog(controllingContainer, "Make sure the name is filled out.");
            }
        }
        //starts methods for adding a rack
        if (e.getSource() == AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addRackButton) {
            reloadAddSectionDropBoxes();
            addRackDialog.setVisible(true);
        }
        if (e.getSource() == addRackDialog.sectionDropBox) {//populate the aisle box
            int sectionIndex = addRackDialog.sectionDropBox.getSelectedIndex();
            if (sectionIndex != -1) {//makes sure an index is selected first, populates aisles
                addRackDialog.aisleDropBox.removeAllItems();//clears the list so only the proper are in the box
                addRackDialog.aisleDropBox.addItem("Select an aisle...");
                if (sectionIndex != 0) {
                    for (int i = 0; i < store.getSections()[sectionIndex - 1].getAisles().length; i++) {//first index is the select a ...
                        addRackDialog.aisleDropBox.addItem(store.getSections()[sectionIndex - 1].getAisles()[i].getAisleName());
                        addRackDialog.aisleDropBox.addActionListener(this);
                    }
                }
            }
        }
        if (e.getSource() == addRackDialog.submitButton) {//making a new rack with click of submit button
            String name = addRackDialog.rackNameField.getText();
            Rack newRack = new Rack(name);
            String tagsTogether = addRackDialog.rackTagField.getText();
            if (!tagsTogether.equals("")) { //adds tags if there are any
                String[] allTags = tagsTogether.split(", ");
                for (String s : allTags) {
                    newRack.addTag(s);
                }
            }
            int sectionIndex = addRackDialog.sectionDropBox.getSelectedIndex() - 1;
            int aisleIndex = addRackDialog.aisleDropBox.getSelectedIndex() - 1;
            if (newRack.validateRack() && sectionIndex != -1 && aisleIndex != -1) {//if it's a valid rack name
                if (store.getSections()[sectionIndex].getAisles()[aisleIndex].hasRacks()) {//if other racks are in the aisle
                    for (Rack r : store.getSections()[sectionIndex].getAisles()[aisleIndex].getRack()) {
                        boolean check = newRack.getRackName().equalsIgnoreCase(r.getRackName());//checking to see if it already exists
                        fcheck = check || fcheck; //will return false unless a rack with that name already exists in the aisle
                    }
                    if (fcheck == false) {
                        store.getSections()[sectionIndex].getAisles()[aisleIndex].addRack(newRack);
                        newRack.setAisle(store.getSections()[sectionIndex].getAisles()[aisleIndex]);
                        newRack.setSection(store.getSections()[sectionIndex]);
                        addRackDialog.rackNameField.setText("");
                        addRackDialog.rackTagField.setText("");
                        addRackDialog.setVisible(false);
                        addRackDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        reloadComboBoxes();
                    } else {
                        JOptionPane.showMessageDialog(controllingContainer, "Rack already exists in Aisle.");
                        fcheck = false;
                    }
                } else { //if it's a valid rack and no other racks are in the aisle, it adds it immediately
                    store.getSections()[sectionIndex].getAisles()[aisleIndex].addRack(newRack);
                    newRack.setAisle(store.getSections()[sectionIndex].getAisles()[aisleIndex]);
                    newRack.setSection(store.getSections()[sectionIndex]);
                    addRackDialog.rackNameField.setText("");
                    addRackDialog.rackTagField.setText("");
                    addRackDialog.setVisible(false);
                    addRackDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    reloadComboBoxes();
                }
            } else if (sectionIndex == -1) {
                JOptionPane.showMessageDialog(controllingContainer, "Select a section first.");
            } else if (aisleIndex == -1) {
                JOptionPane.showMessageDialog(controllingContainer, "Select an aisle first.");
            } else if (!newRack.validateRack()) {
                JOptionPane.showMessageDialog(controllingContainer, "Make sure the name is filled out.");
            }
        }
        //start of adding aisles
        if (e.getSource() == AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addAisleButton) {
            reloadAddSectionDropBoxes();
            addAisleDialog.setVisible(true);
        }
        if (e.getSource() == addAisleDialog.submitButton) {//making a new aisle with click of submit button
            String name = addAisleDialog.aisleNameField.getText();
            Aisle newAisle = new Aisle(name);
            String tagsTogether = addAisleDialog.aisleTagField.getText();
            if (!tagsTogether.equals("")) { //adds tags if there are any
                String[] allTags = tagsTogether.split(", ");
                for (String s : allTags) {
                    newAisle.addTag(s);
                }
            }
            int sectionIndex = addAisleDialog.sectionDropBox.getSelectedIndex() - 1;
            if (newAisle.validateAisle() && sectionIndex != -1) {//if it's a valid aisle name
                if (store.getSections()[sectionIndex].hasAisle()) {//if other aisles are in the section
                    for (Aisle a : store.getSections()[sectionIndex].getAisles()) {
                        boolean check = newAisle.getAisleName().equalsIgnoreCase(a.getAisleName());//checking to see if it already exists
                        fcheck = check || fcheck; //will return false unless an aisle with that name already exists in that section
                    }
                    if (fcheck == false) {
                        store.getSections()[sectionIndex].addAisle(newAisle);
                        newAisle.setSection(store.getSections()[sectionIndex]);
                        addAisleDialog.aisleNameField.setText("");
                        addAisleDialog.aisleTagField.setText("");
                        addAisleDialog.setVisible(false);
                        addAisleDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        reloadComboBoxes();
                    } else {
                        JOptionPane.showMessageDialog(controllingContainer, "Aisle already exists in Section.");
                        fcheck = false;
                    }
                } else { //if it's a valid aisle and no other aisles are in that section, it adds it immediately
                    store.getSections()[sectionIndex].addAisle(newAisle);
                    newAisle.setSection(store.getSections()[sectionIndex]);
                    addAisleDialog.aisleNameField.setText("");
                    addAisleDialog.aisleTagField.setText("");
                    addAisleDialog.setVisible(false);
                    addAisleDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    reloadComboBoxes();
                }
            } else if (sectionIndex == -1) {
                JOptionPane.showMessageDialog(controllingContainer, "Select a section first.");
            } else if (!newAisle.validateAisle()) {
                JOptionPane.showMessageDialog(controllingContainer, "Make sure the name is filled out.");
            }
        }
        //start of adding section methods
        if (e.getSource() == AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addSectionButton) {
            addSectionDialog.setVisible(true);
        }
        if (e.getSource() == addSectionDialog.submitButton) {//making a new section with click of submit button
            String name = addSectionDialog.sectionNameField.getText();
            Section newSection = new Section(name);
            String tagsTogether = addSectionDialog.sectionTagField.getText();
            if (!tagsTogether.equals("")) { //adds tags if there are any
                String[] allTags = tagsTogether.split(", ");
                for (String s : allTags) {
                    newSection.addTag(s);
                }
            }
            if (newSection.validateSection()) {//if it's a valid section name
                for (Section s : store.getSections()) {
                    boolean check = newSection.getSectionName().equalsIgnoreCase(s.getSectionName());//checking to see if it already exists
                    fcheck = check || fcheck; //will return false unless a section with that name already exists in the store
                }
                if (fcheck == false) {
                    store.addSection(newSection);
                    newSection.setStore(store);
                    editSectionComboBox.addItem(newSection.getSectionName());
                    adminPanel.adminEditBodyPanel.dropBoxPanel.sectionDropbox.addItem(newSection.getSectionName());
                    addSectionDialog.sectionNameField.setText("");
                    addSectionDialog.sectionTagField.setText("");
                    addSectionDialog.setVisible(false);
                    addSectionDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    reloadComboBoxes();
                } else {
                    JOptionPane.showMessageDialog(controllingContainer, "Section already exists in Store.");
                    fcheck = false;
                }
            } else {
                JOptionPane.showMessageDialog(controllingContainer, "Make sure the name is filled out.");
            }
        }
        //***************************************************
        // ***Populating the JList for the AdminAddRemovePan
    }

    public void populatingAddRemoveJList(ActionEvent e) {
        AdminAddRemovePanelTop adminAddRemovePanelTop = AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop;
        adminAddRemovePanelTop.modelObjectList.clear();
        String obj = (String) adminAddRemovePanelTop.objectDropBox.getSelectedItem();
        if (Objects.equals(obj, "Section")) {
            for (String s : store.getSectionsNames(store.getSections())) {
                adminAddRemovePanelTop.modelObjectList.addElement(s);
            }
        } else if (Objects.equals(obj, "Aisle")) {
            for (Section s : store.getSections()) {
                for (Aisle a : s.getAisles()) {
                    String name = a.getAisleName();
                    adminAddRemovePanelTop.modelObjectList.addElement(name);
                }
            }
        } else if (Objects.equals(obj, "Rack")) {
            for (String s : aisle.getRacksNames(aisle.getRack())) {
                int count = 0;
                adminAddRemovePanelTop.modelObjectList.addElement(s);
            }
        } else if (Objects.equals(obj, "Shelf")) {
            for (String s : rack.getShelfNames(rack.getShelf())) {
                int count = 0;
                adminAddRemovePanelTop.modelObjectList.addElement(s);
            }
        } else if (Objects.equals(obj, "Sale Item")) {
            for (SaleItem s : shelf.getItemsOnShelf()) {
                int count = 0;
                adminAddRemovePanelTop.modelObjectList.addElement(s.toString());
            }
        }
        AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.repaint();
    }

    //***Lambda Expression for Removing selected object from JList though the JComboBox

    public void removeButtonClicked(ActionEvent e) {
        int selectedValue = AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.objectList.getSelectedIndex();
        if (selectedValue == 1) {
            for (Section s : store.getSections()) {
                if (s.getSectionName().equals(selectedValue)) {
                    store.removeSection(s);
                }
            }
        }
        if (selectedValue == 2) {
            for (Aisle a : section.getAisles()) {
                if (a.getAisleName().equals(selectedValue)) {
                    section.removeAisle(a);
                }
            }
        }
        if (selectedValue == 3) {
            for (Rack r : aisle.getRack()) {
                if (r.getRackName().equals(selectedValue)) {
                    aisle.removeRack(r);
                }
            }
        }
        if (selectedValue == 4) {
            for (Shelf s : rack.getShelf()) {
                if (s.getRowName().equals(selectedValue)) {
                    rack.removeShelf(s);
                }
            }
        }
        if (selectedValue == 5) {
            for (SaleItem i : shelf.getItemsOnShelf()) {
                if (i.getName().equals(selectedValue)) {
                    shelf.removeItems(i);
                }
            }
        }
        populatingAddRemoveJList(e);
        reloadComboBoxes();
        AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.repaint();
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