import UserSide.GUIUserMain;
import UserSide.UserMainTopPanel;
import admin.*;
import admin.main.panels.AdminMainBottomPanel;
import admin.main.panels.AdminMainTopPanel;
import admin.main.panels.GUIEditMerch;
import admin.main.panels.GUIPasswordChange;
import store.locations.*;
import javax.swing.*;
import java.awt.*;              //for layout managers and more
import java.awt.event.*;        //for action events
import java.util.Arrays;
import java.util.Objects;

public class GUI implements ActionListener {
    private Container controllingContainer;
    private String ADMINPANEL = "Admin";
    private String USERPANEL = "User";
    private String OPENINGPANEL = "Opening Panel";
    private GUIAdminEdit ae;
    private JPanel adminEditCard, cards;
    private JButton adminEditButton, adminSwitchButton, userSwitchButton;
    private Boolean storeExists = false;
    private GUIPassword pw;
    private char[] passwordInput;
    public Store store;
    public Section section;
    public Aisle aisle;
    public Rack rack;
    public Shelf shelf;
    public SaleItem item;
    public GUIAdminMain adminPanel = new GUIAdminMain();
    private GUIEditMerchPanel adminEditMerchPanel;
    public GUIEditPanel es, ea, er, esh;
    public String selected;
    public GUIEditMerch em = new GUIEditMerch();
    public GUIPasswordChange pc = new GUIPasswordChange();
    public GUIAddItemDialog addItemDialog;
    private GUIAddShelfDialog addShelfDialog = new GUIAddShelfDialog();
    private GUIAddRackDialog addRackDialog = new GUIAddRackDialog();
    private GUIAddAisleDialog addAisleDialog = new GUIAddAisleDialog();
    private GUIAddSectionDialog addSectionDialog = new GUIAddSectionDialog();
    private GUIInitialSetup is = new GUIInitialSetup();
    private GUIUserMain userPanel;
    private GUIAdminEditLocation adminEditLocation = new GUIAdminEditLocation();
    private GUIAdminEditPanel adminEditPanel = new GUIAdminEditPanel();
    private GUIOpeningPanel openingPanel = new GUIOpeningPanel();

    public void addComponentToPane(Container pane) {
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

        adminPanel.adminEditBottomPanel.switchUserButton.addActionListener(this);
        adminPanel.adminEditBottomPanel.editButton.addActionListener(this);
        adminPanel.adminEditBottomPanel.adminPanel.dropBoxPanel.searchButton.addActionListener(this);

        userPanel = new GUIUserMain();
        userPanel.userMainBodyPanel.userDropBoxPanel.searchButton.addActionListener(this);

        openingPanel.openingUserButton.addActionListener(this);
        openingPanel.openingAdminButton.addActionListener(this);

        cards = new JPanel(new CardLayout());
        cards.add(openingPanel, OPENINGPANEL);
        cards.add(userPanel, USERPANEL);
        cards.add(adminPanel, ADMINPANEL);

        adminEditButton = new JButton("Edit");
        adminEditButton.addActionListener(this);

        pane.add(panel, BorderLayout.WEST);
        pane.add(cards, BorderLayout.CENTER);

        ae = new GUIAdminEdit();
        ae.locationButton.addActionListener(this);
        ae.changePassButton.addActionListener(this);
        ae.merchandiseButton.addActionListener(this);
        ae.locationButton.addActionListener(this);

        adminEditCard = new JPanel();
        adminEditCard.setLayout(new CardLayout());

        adminEditCard.add(adminEditPanel, "Edit");
        adminEditCard.add(adminEditLocation, "Locations");

        adminEditLocation.editSectionButton.addActionListener(this);
        adminEditLocation.editAisleButton.addActionListener(this);
        adminEditLocation.editRackButton.addActionListener(this);
        adminEditLocation.editShelfButton.addActionListener(this);
        adminEditLocation.editReturn.addActionListener(this);

        adminEditMerchPanel = new GUIEditMerchPanel();
        adminEditMerchPanel.editMerchButton.addActionListener(this);
        adminEditMerchPanel.merchReturn.addActionListener(this);

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

        pw = new GUIPassword();
        pw.submitButton.addActionListener(this);

        is.submitButton.addActionListener(this);

        AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addItemButton.addActionListener(this);
        addItemDialog = new GUIAddItemDialog();
        addItemDialog.sectionDropBox.addActionListener(this);
        addItemDialog.submitButton.addActionListener(this);
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
        }}

    public void reloadComboBoxes() {
        adminEditLocation.editSectionComboBox.removeAllItems();
        adminEditLocation.editAisleComboBox.removeAllItems();
        adminEditLocation.editRackComboBox.removeAllItems();
        adminEditLocation.editShelfComboBox.removeAllItems();
        adminEditMerchPanel.editMerchCombobox.removeAllItems();
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
            adminEditLocation.editSectionComboBox.addItem(section.getSectionName());
            adminPanel.adminEditBodyPanel.dropBoxPanel.sectionDropbox.addItem(section.getSectionName());
            userPanel.userMainBodyPanel.userDropBoxPanel.sectionDropbox.addItem(section.getSectionName());
            for (int j = 0; j < section.getAisles().length; j++) {
                aisle = section.getAisles()[j];
                adminEditLocation.editAisleComboBox.addItem(aisle.getAisleDisplayName());
                adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.addItem(aisle.getAisleDisplayName());
                userPanel.userMainBodyPanel.userDropBoxPanel.aisleDropbox.addItem(aisle.getAisleDisplayName());
                for (int k = 0; k < aisle.getRack().length; k++) {
                    rack = aisle.getRack()[k];
                    adminEditLocation.editRackComboBox.addItem(rack.getRackDisplayName());
                    adminPanel.adminEditBodyPanel.dropBoxPanel.rackDropbox.addItem(rack.getRackDisplayName());
                    userPanel.userMainBodyPanel.userDropBoxPanel.rackDropbox.addItem(rack.getRackDisplayName());
                    for (int l = 0; l < rack.getShelf().length; l++) {
                        shelf = rack.getShelf()[l];
                        adminEditLocation.editShelfComboBox.addItem(shelf.getRowDisplayName());
                        adminPanel.adminEditBodyPanel.dropBoxPanel.shelfDropbox.addItem(shelf.getRowDisplayName());
                        userPanel.userMainBodyPanel.userDropBoxPanel.shelfDropbox.addItem(shelf.getRowDisplayName());
                        for (int m = 0; m < shelf.getItemsOnShelf().length; m++) {
                            item = shelf.getItemsOnShelf()[m];
                            adminEditMerchPanel.editMerchCombobox.addItem(item.getName());
                        }}}}}}

    public void printItem(SaleItem i, JTextArea t, boolean isUser) {
        t.append("Search results: '" + i.getName() + "'");
        if (i.onSale()){
            t.append(" SALE!\n");
            t.append("Location: " + i.getShelf().getRowDisplayName() + "\n");
            t.append("Price: $" + i.getSalePrice() + "\n");
            t.append("Sale: " + i.getSaleDescription()+ "\n");
        } else{
            t.append("\n");
            t.append("Location: " + i.getShelf().getRowDisplayName() + "\n");
            t.append("Price: $" + i.getPrice() + "\n");
        }
        t.append("Description:\n");
        if(i.getDescription().equals("")){
            t.append("No description found\n");
        } else{
            t.append(i.getDescription() + "\n");
        }
        if(isUser) {

        }else{
            if (i.getTags().size() > 0) {
                t.append("Tags:\n");
                for (int n = 0; n < i.getTags().size(); n++) {
                    t.append(i.getTags().get(n) + "\n");
                }
            } else{
                t.append("No tags found");
            }}}

    public void printSection(Section s, JTextArea t, boolean isUser){
        t.append("Search result: '" + s.getSectionName() + "'\n");
        t.append("Aisles:\n");
        if(s.hasAisle()) {
            for (int k = 0; k < section.getAisles().length; k++) {
                aisle = section.getAisles()[k];
                t.append(aisle.getAisleName() + "\n");
            }
        } else{
            t.append("none\n");
        }
        if(isUser){

        } else {
            if (s.getTags().size() > 0) {
                t.append("Tags:\n");
                for (int j = 0; j < s.getTags().size(); j++) {
                    t.append(section.getTags().get(j) + "\n");
                }}}}

    public void printAisle(Aisle a, JTextArea t, boolean isUser){
        t.append("Search result: '" + a.getAisleDisplayName() + "'\n");
        t.append("Racks:\n");
        if (a.hasRacks()){
            for (int k = 0; k < a.getRack().length; k++){
                rack = a.getRack()[k];
                t.append(rack.getRackName() + "\n");
            }
        } else{
            t.append("none\n");
        }

        if(isUser){

        }else {
            if (a.getTags().size() > 0) {
                t.append("Tags:\n");
                for (int m = 0; m < a.getTags().size(); m++) {
                    t.append(a.getTags().get(m) + "\n");
                }}}}
    public void printRack(Rack r, JTextArea t, boolean isUser){
        t.append("Search result: '" + r.getRackDisplayName() +"'\n");
        t.append("Shelves:\n");
        if(r.hasShelves()){
            for (int m = 0; m < r.getShelf().length; m++){
                shelf = r.getShelf()[m];
                t.append(shelf.rowName + "\n");
            }
        } else{
            t.append("none\n");
        }if(isUser){

        }else {
            if (r.getTags().size() > 0) {
                t.append("Tags:\n");
                for (int n = 0; n < r.getTags().size(); n++) {
                    t.append(r.getTags().get(n) + "\n");
                }}}}

    public void printShelf(Shelf s, JTextArea t, boolean isUser){
        t.append("Search results: '" + s.getRowDisplayName() + "'\n");
        t.append("Items on shelf:\n");
        if(s.hasItems()){
            for (int m = 0; m < s.getItemsOnShelf().length; m++){
                item = s.getItemsOnShelf()[m];
                t.append(item.getName()+"\n");
            }
        } else{
            t.append("none\n");
        }
        if(isUser){

        }else {
            if (s.getTags().size() > 0) {
                t.append("Tags:\n");
                for (int n = 0; n < s.getTags().size(); n++) {
                    t.append(s.getTags().get(n) + "\n");
                }}}}

    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        CardLayout ecl = (CardLayout) (adminEditCard.getLayout());

        if (e.getSource() == openingPanel.openingAdminButton) {
            pw.setVisible(true);
        }
        if (e.getSource() == openingPanel.openingUserButton) {
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
                store = new Store(storeName);
                AdminMainTopPanel.title.setText(store.getStoreName());
                UserMainTopPanel.title.setText(store.getStoreName());
                for (int i = 0; i < sectionInt; i++) {
                    section = new Section("Section: " + Integer.toString(i + 1));
                    store.addSection(section);
                    adminEditLocation.editSectionComboBox.addItem(section.getSectionName());
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
                        adminEditLocation.editAisleComboBox.addItem(aisle.getAisleDisplayName());
                        adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.addItem(aisle.getAisleDisplayName());
                        userPanel.userMainBodyPanel.userDropBoxPanel.aisleDropbox.addItem(aisle.getAisleDisplayName());
                        for (int k = 0; k < rackInt; k++) {
                            rack = new Rack("Rack: " + Integer.toString(k + 1));
                            aisle.addRack(rack);
                            rack.setAisle(aisle);
                            adminEditLocation.editRackComboBox.addItem(rack.getRackDisplayName());
                            adminPanel.adminEditBodyPanel.dropBoxPanel.rackDropbox.addItem(rack.getRackDisplayName());
                            userPanel.userMainBodyPanel.userDropBoxPanel.rackDropbox.addItem(rack.getRackDisplayName());
                            for (int l = 0; l < shelfInt; l++) {
                                shelf = new Shelf("Shelf: " + Integer.toString(l + 1));
                                rack.addShelf(shelf);
                                shelf.setRack(rack);
                                adminEditLocation.editShelfComboBox.addItem(shelf.getRowDisplayName());
                                adminPanel.adminEditBodyPanel.dropBoxPanel.shelfDropbox.addItem(shelf.getRowDisplayName());
                                userPanel.userMainBodyPanel.userDropBoxPanel.shelfDropbox.addItem(shelf.getRowDisplayName());
                            }}}}
                JOptionPane.showMessageDialog(controllingContainer, "Store created! You may give names to store objects in the 'Edit' tab. ");
                is.setVisible(false);
                cl.show(cards, ADMINPANEL);
                storeExists = true;
            }}
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
        if (e.getSource() == adminEditLocation.editReturn || e.getSource() == es.backButton || e.getSource() == ea.backButton
                || e.getSource() == er.backButton || e.getSource() == esh.backButton || e.getSource() == pc.backButton
                || e.getSource() == adminEditMerchPanel.merchReturn || e.getSource() == em.backButton) {
            es.removeTagComboBox.removeAllItems();
            ea.removeTagComboBox.removeAllItems();
            er.removeTagComboBox.removeAllItems();
            esh.removeTagComboBox.removeAllItems();
            em.merchRemoveTagBox.removeAllItems();
            ecl.show(adminEditCard, "Edit");
        }
        if (e.getSource() == adminEditLocation.editSectionButton) {
            selected = adminEditLocation.editSectionComboBox.getSelectedItem().toString();
            for (int i = 0; i < store.getSections().length; i++) {
                if (store.getSections()[i].getSectionName().equalsIgnoreCase(selected)) {
                    section = store.sections.get(i);
                }}
            for (int i = 0; i < section.getTags().size(); i++) {
                es.removeTagComboBox.addItem(section.getTagsArray()[i]);
            }
            es.editNameField.setText(selected);
            ecl.show(adminEditCard, "Edit Section");
        }
        if (e.getSource() == adminEditLocation.editAisleButton) {
            selected = adminEditLocation.editAisleComboBox.getSelectedItem().toString();
            for (int i = 0; i < store.getSections().length; i++) {
                section = store.sections.get(i);
                for (int j = 0; j < section.getAisles().length; j++) {
                    if (section.getAisles()[j].getAisleDisplayName().equalsIgnoreCase(selected)) {
                        aisle = section.getAisles()[j];
                    }}}
            for (int i = 0; i < aisle.getTags().size(); i++) {
                ea.removeTagComboBox.addItem(aisle.getTagsArray()[i]);
            }
            ea.editNameField.setText(aisle.getAisleName());
            ecl.show(adminEditCard, "Edit Aisle");
        }
        if (e.getSource() == adminEditLocation.editRackButton) {
            selected = adminEditLocation.editRackComboBox.getSelectedItem().toString();
            for (int i = 0; i < store.getSections().length; i++) {
                section = store.sections.get(i);
                for (int j = 0; j < section.getAisles().length; j++) {
                    aisle = section.getAisles()[j];
                    for (int k = 0; k < aisle.getRack().length; k++) {
                        if (aisle.getRack()[k].getRackDisplayName().equalsIgnoreCase(selected)) {
                            rack = aisle.getRack()[k];
                        }}}}
            //er.removeTagComboBox.addItem("remove tag...");
            for (int i = 0; i < rack.getTags().size(); i++) {
                er.removeTagComboBox.addItem(rack.getTagsArray()[i]);
            }
            er.editNameField.setText(rack.getRackName());
            ecl.show(adminEditCard, "Edit Rack");
        }
        if (e.getSource() == adminEditLocation.editShelfButton) {
            selected = adminEditLocation.editShelfComboBox.getSelectedItem().toString();
            for (int i = 0; i < store.getSections().length; i++) {
                section = store.sections.get(i);
                for (int j = 0; j < section.getAisles().length; j++) {
                    aisle = section.getAisles()[j];
                    for (int k = 0; k < aisle.getRack().length; k++) {
                        rack = aisle.getRack()[k];
                        for (int l = 0; l < rack.getShelf().length; l++) {
                            if (rack.getShelf()[l].getRowDisplayName().equalsIgnoreCase(selected)) {
                                shelf = rack.getShelf()[l];
                            }}}}}
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
            for (int i = 0; i < store.getSections().length; i++) {
                if (store.getSections()[i].getSectionName().equalsIgnoreCase(newName)) {
                    section = store.getSections()[i];
                }}}
        if (e.getSource() == ea.editNameButton) {
            String newName = ea.editNameField.getText();
            aisle.setAisleName(newName);
            String newDisplayName = aisle.getAisleDisplayName();
            reloadComboBoxes();
            for (int i = 0; i < store.getSections().length; i++) {
                section = store.getSections()[i];
                for (int j = 0; j < section.getAisles().length; j++) {
                    if (section.getAisles()[j].getAisleDisplayName().equalsIgnoreCase(newDisplayName)) {
                        aisle = section.getAisles()[j];
                    }}}}
        if (e.getSource() == er.editNameButton) {
            String newName = er.editNameField.getText();
            rack.setRackName(newName);
            String newDisplayName = rack.getRackDisplayName();
            reloadComboBoxes();
            for (int i = 0; i < store.getSections().length; i++) {
                section = store.getSections()[i];
                for (int j = 0; j < section.getAisles().length; j++) {
                    aisle = section.getAisles()[j];
                    for (int k = 0; k < aisle.getRack().length; k++) {
                        if (aisle.getRack()[k].getRackDisplayName().equals(newDisplayName)) {
                            rack = aisle.getRack()[k];
                        }}}}}
        if (e.getSource() == esh.editNameButton) {
            String newName = esh.editNameField.getText();
            shelf.setRowName(newName);
            String newDisplayName = shelf.getRowDisplayName();
            reloadComboBoxes();
            for (int i = 0; i < store.getSections().length; i++) {
                section = store.getSections()[i];
                for (int j = 0; j < section.getAisles().length; j++) {
                    aisle = section.getAisles()[j];
                    for (int k = 0; k < aisle.getRack().length; k++) {
                        rack = aisle.getRack()[k];
                        for (int l = 0; l < rack.getShelf().length; l++) {
                            if (rack.getShelf()[l].getRowDisplayName().equals(newDisplayName)) {
                                shelf = rack.getShelf()[l];
                            }}}}}}
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
                }}}
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
                }}}
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
                }}}
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
                }}}
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
                }}
        if (e.getSource() == adminEditMerchPanel.editMerchButton) {
            selected = adminEditMerchPanel.editMerchCombobox.getSelectedItem().toString();
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
                                }}}}}}
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
            }}
        if (e.getSource() == em.merchNameSubmit) {
            String newName = em.merchNameField.getText();
            item.setName(newName);
            reloadComboBoxes();
            for (int i = 0; i < store.getSections().length; i++) {
                section = store.getSections()[i];
                for (int j = 0; j < section.getAisles().length; j++) {
                    aisle = section.getAisles()[j];
                    for (int k = 0; k < aisle.getRack().length; k++) {
                        rack = aisle.getRack()[k];
                        for (int l = 0; l < rack.getShelf().length; l++) {
                            shelf = rack.getShelf()[l];
                            for (int m = 0; m < shelf.getItemsOnShelf().length; m++) {
                                if (shelf.getItemsOnShelf()[m].getName().equals(newName)) {
                                    item = shelf.getItemsOnShelf()[m];
                                }}}}}}}
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
                }}}

        if (e.getSource() == em.merchEditDescriptionSubmit) {
            item.setDescription(em.merchEditDescriptionField.getText());
        }

        if (e.getSource() == em.merchSaleSubmit) {
            item.setSalePrice(Double.parseDouble(em.merchSalePriceField.getText()));
            item.setSaleDescription(em.saleDescriptionField.getText());
        }
        if (e.getSource() == adminPanel.adminEditBottomPanel.adminPanel.dropBoxPanel.searchButton) {
            if (!adminPanel.adminEditBodyPanel.dropBoxPanel.searchField.getText().equals("")) {
                adminPanel.adminEditBodyPanel.returnField.append("Search query: " + "'" + adminPanel.adminEditBodyPanel.dropBoxPanel.searchField.getText() + "'\n");
                selected = adminPanel.adminEditBodyPanel.dropBoxPanel.searchField.getText();
                for (int i = 0; i < store.getSections().length; i++) {
                    if (store.getSections()[i].getSectionName().equalsIgnoreCase(selected)) {
                        section = store.sections.get(i);
                        printSection(section, adminPanel.adminEditBodyPanel.returnField, false);
                    }}
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        if (section.getAisles()[j].getAisleDisplayName().equalsIgnoreCase(selected)) {
                            aisle = section.getAisles()[j];
                            printAisle(aisle, adminPanel.adminEditBodyPanel.returnField, false);
                        }}}
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for (int k = 0; k < aisle.getRack().length; k++) {
                            if (aisle.getRack()[k].getRackDisplayName().equalsIgnoreCase(selected)) {
                                rack = aisle.getRack()[k];
                                printRack(rack, adminPanel.adminEditBodyPanel.returnField, false);
                            }}}}
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for (int k = 0; k < aisle.getRack().length; k++) {
                            rack = aisle.getRack()[k];
                            for (int l = 0; l < rack.getShelf().length; l++) {
                                if (rack.getShelf()[l].getRowDisplayName().equalsIgnoreCase(selected)) {
                                    shelf = rack.getShelf()[l];
                                    printShelf(shelf, adminPanel.adminEditBodyPanel.returnField, false);
                                }}}}}
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for (int k = 0; k < aisle.getRack().length; k++) {
                            rack = aisle.getRack()[k];
                            for (int l = 0; l < rack.getShelf().length; l++) {
                                shelf = rack.getShelf()[l];
                                for (int m = 0; m < shelf.getItemsOnShelf().length; m++) {
                                    if (shelf.getItemsOnShelf()[m].getName().equalsIgnoreCase(selected)) {
                                        item = shelf.getItemsOnShelf()[m];
                                        printItem(item, adminPanel.adminEditBodyPanel.returnField, false);
                                    }}}}}}
                //start substring item search
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for (int k = 0; k < aisle.getRack().length; k++) {
                            rack = aisle.getRack()[k];
                            for (int l = 0; l < rack.getShelf().length; l++) {
                                shelf = rack.getShelf()[l];
                                for (int m = 0; m < shelf.getItemsOnShelf().length; m++) {
                                    item = shelf.getItemsOnShelf()[m];
                                    for (int n = 0; n <= (item.getName().length() - selected.length()); n++) {
                                        if (item.getName().regionMatches(true, n, selected, 0, selected.length()) && !item.getName().equalsIgnoreCase(selected)) {
                                            printItem(item, adminPanel.adminEditBodyPanel.returnField, false);
                                        }}}}}}}
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int a = 0; a < section.getTags().size(); a++) {
                        if (section.getTags().get(a).equalsIgnoreCase(selected)) {
                            printSection(section, adminPanel.adminEditBodyPanel.returnField, false);
                        }}
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for (int b = 0; b < aisle.getTags().size(); b++) {
                            if (aisle.getTags().get(b).equalsIgnoreCase(selected)) {
                                printAisle(aisle, adminPanel.adminEditBodyPanel.returnField, false);
                            }}
                        for (int k = 0; k < aisle.getRack().length; k++) {
                            rack = aisle.getRack()[k];
                            for (int c = 0; c < rack.getTags().size(); c++) {
                                if (rack.getTags().get(c).equalsIgnoreCase(selected)) {
                                    printRack(rack, adminPanel.adminEditBodyPanel.returnField, false);
                                }}
                            for (int l = 0; l < rack.getShelf().length; l++) {
                                shelf = rack.getShelf()[l];
                                for (int d = 0; d < shelf.getTags().size(); d++) {
                                    if (shelf.getTags().get(d).equalsIgnoreCase(selected)) {
                                        printShelf(shelf, adminPanel.adminEditBodyPanel.returnField, false);
                                    }}
                                for (int m = 0; m < shelf.getItemsOnShelf().length; m++) {
                                    item = shelf.getItemsOnShelf()[m];
                                    for (int f = 0; f < item.getTags().size(); f++) {
                                        if (item.getTags().get(f).equalsIgnoreCase(selected)) {
                                            printItem(item, adminPanel.adminEditBodyPanel.returnField, false);
                                        }}}}}}}}
            if (!adminPanel.adminEditBodyPanel.dropBoxPanel.sectionDropbox.getSelectedItem().equals("Select Section...")) {
                selected = adminPanel.adminEditBodyPanel.dropBoxPanel.sectionDropbox.getSelectedItem().toString();
                for (int i = 0; i < store.getSections().length; i++) {
                    if (store.getSections()[i].getSectionName().equalsIgnoreCase(selected)) {
                        section = store.sections.get(i);
                        printSection(section, adminPanel.adminEditBodyPanel.returnField, false);
                    }}}
            if (!adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.getSelectedItem().equals("Select Aisle...")) {
                selected = adminPanel.adminEditBodyPanel.dropBoxPanel.aisleDropbox.getSelectedItem().toString();
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        if (section.getAisles()[j].getAisleDisplayName().equalsIgnoreCase(selected)) {
                            aisle = section.getAisles()[j];
                            printAisle(aisle, adminPanel.adminEditBodyPanel.returnField, false);
                        }}}}
            if (!adminPanel.adminEditBodyPanel.dropBoxPanel.rackDropbox.getSelectedItem().equals("Select Rack...")) {
                selected = adminPanel.adminEditBodyPanel.dropBoxPanel.rackDropbox.getSelectedItem().toString();
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for (int k = 0; k < aisle.getRack().length; k++) {
                            if (aisle.getRack()[k].getRackDisplayName().equalsIgnoreCase(selected)) {
                                rack = aisle.getRack()[k];
                                printRack(rack, adminPanel.adminEditBodyPanel.returnField, false);
                            }}}}}
            if (!adminPanel.adminEditBodyPanel.dropBoxPanel.shelfDropbox.getSelectedItem().equals("Select Shelf...")) {
                selected = adminPanel.adminEditBodyPanel.dropBoxPanel.shelfDropbox.getSelectedItem().toString();
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for (int k = 0; k < aisle.getRack().length; k++) {
                            rack = aisle.getRack()[k];
                            for (int l = 0; l < rack.getShelf().length; l++) {
                                if (rack.getShelf()[l].getRowDisplayName().equalsIgnoreCase(selected)) {
                                    shelf = rack.getShelf()[l];
                                    printShelf(shelf, adminPanel.adminEditBodyPanel.returnField, false);
                                }}}}}}}
        if (e.getSource() == userPanel.userMainBodyPanel.userDropBoxPanel.searchButton) {
            if (!userPanel.userMainBodyPanel.userDropBoxPanel.searchField.getText().equals("")) {
                userPanel.userMainBodyPanel.returnField.append("Search query: " + "'" + userPanel.userMainBodyPanel.userDropBoxPanel.searchField.getText() + "'\n");
                selected = userPanel.userMainBodyPanel.userDropBoxPanel.searchField.getText();
                for (int i = 0; i < store.getSections().length; i++) {
                    if (store.getSections()[i].getSectionName().equalsIgnoreCase(selected)) {
                        section = store.sections.get(i);
                        printSection(section, userPanel.userMainBodyPanel.returnField, true);
                    }}
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        if (section.getAisles()[j].getAisleDisplayName().equalsIgnoreCase(selected)) {
                            aisle = section.getAisles()[j];
                            printAisle(aisle, userPanel.userMainBodyPanel.returnField, true);
                        }}}
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for (int k = 0; k < aisle.getRack().length; k++) {
                            if (aisle.getRack()[k].getRackDisplayName().equalsIgnoreCase(selected)) {
                                rack = aisle.getRack()[k];
                                printRack(rack, userPanel.userMainBodyPanel.returnField, true);
                            }}}}
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for (int k = 0; k < aisle.getRack().length; k++) {
                            rack = aisle.getRack()[k];
                            for (int l = 0; l < rack.getShelf().length; l++) {
                                if (rack.getShelf()[l].getRowDisplayName().equalsIgnoreCase(selected)) {
                                    shelf = rack.getShelf()[l];
                                    printShelf(shelf, userPanel.userMainBodyPanel.returnField, true);
                                }}}}}
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for (int k = 0; k < aisle.getRack().length; k++) {
                            rack = aisle.getRack()[k];
                            for (int l = 0; l < rack.getShelf().length; l++) {
                                shelf = rack.getShelf()[l];
                                for (int m = 0; m < shelf.getItemsOnShelf().length; m++) {
                                    if (shelf.getItemsOnShelf()[m].getName().equalsIgnoreCase(selected)) {
                                        item = shelf.getItemsOnShelf()[m];
                                        printItem(item, userPanel.userMainBodyPanel.returnField, true);
                                    }}}}}}
                //start substring item search
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for (int k = 0; k < aisle.getRack().length; k++) {
                            rack = aisle.getRack()[k];
                            for (int l = 0; l < rack.getShelf().length; l++) {
                                shelf = rack.getShelf()[l];
                                for (int m = 0; m < shelf.getItemsOnShelf().length; m++) {
                                    item = shelf.getItemsOnShelf()[m];
                                    for (int n = 0; n <= (item.getName().length() - selected.length()); n++) {
                                        if (item.getName().regionMatches(true, n, selected, 0, selected.length()) && !item.getName().equalsIgnoreCase(selected)) {
                                            printItem(item, userPanel.userMainBodyPanel.returnField, true);
                                        }}}}}}}
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int a = 0; a < section.getTags().size(); a++) {
                        if (section.getTags().get(a).equals(selected)) {
                            printSection(section, userPanel.userMainBodyPanel.returnField, true);
                        }}
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for (int b = 0; b < aisle.getTags().size(); b++) {
                            if (aisle.getTags().get(b).equals(selected)) {
                                printAisle(aisle, userPanel.userMainBodyPanel.returnField, true);
                            }}
                        for (int k = 0; k < aisle.getRack().length; k++) {
                            rack = aisle.getRack()[k];
                            for (int c = 0; c < rack.getTags().size(); c++) {
                                if (rack.getTags().get(c).equals(selected)) {
                                    printRack(rack, userPanel.userMainBodyPanel.returnField, true);
                                }}
                            for (int l = 0; l < rack.getShelf().length; l++) {
                                shelf = rack.getShelf()[l];
                                for (int d = 0; d < shelf.getTags().size(); d++) {
                                    if (shelf.getTags().get(d).equals(selected)) {
                                        printShelf(shelf, userPanel.userMainBodyPanel.returnField, true);
                                    }}
                                for (int m = 0; m < shelf.getItemsOnShelf().length; m++) {
                                    item = shelf.getItemsOnShelf()[m];
                                    for (int f = 0; f < item.getTags().size(); f++) {
                                        if (item.getTags().get(f).equals(selected)) {
                                            printItem(item, userPanel.userMainBodyPanel.returnField, true);
                                        }}}}}}}}
            if (!userPanel.userMainBodyPanel.userDropBoxPanel.sectionDropbox.getSelectedItem().equals("Select Section...")) {
                selected = userPanel.userMainBodyPanel.userDropBoxPanel.sectionDropbox.getSelectedItem().toString();
                for (int i = 0; i < store.getSections().length; i++) {
                    if (store.getSections()[i].getSectionName().equals(selected)) {
                        section = store.sections.get(i);
                        printSection(section, userPanel.userMainBodyPanel.returnField, true);
                    }}}

            if (!userPanel.userMainBodyPanel.userDropBoxPanel.aisleDropbox.getSelectedItem().equals("Select Aisle...")) {
                selected = userPanel.userMainBodyPanel.userDropBoxPanel.aisleDropbox.getSelectedItem().toString();
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        if (section.getAisles()[j].getAisleDisplayName().equals(selected)) {
                            aisle = section.getAisles()[j];
                            printAisle(aisle, userPanel.userMainBodyPanel.returnField, true);
                        }}}}

            if (!userPanel.userMainBodyPanel.userDropBoxPanel.rackDropbox.getSelectedItem().equals("Select Rack...")) {
                selected = userPanel.userMainBodyPanel.userDropBoxPanel.rackDropbox.getSelectedItem().toString();
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for (int k = 0; k < aisle.getRack().length; k++) {
                            if (aisle.getRack()[k].getRackDisplayName().equalsIgnoreCase(selected)) {
                                rack = aisle.getRack()[k];
                                printRack(rack, userPanel.userMainBodyPanel.returnField, true);
                            }}}}}

            if (!userPanel.userMainBodyPanel.userDropBoxPanel.shelfDropbox.getSelectedItem().equals("Select Shelf...")) {
                selected = userPanel.userMainBodyPanel.userDropBoxPanel.shelfDropbox.getSelectedItem().toString();
                for (int i = 0; i < store.getSections().length; i++) {
                    section = store.sections.get(i);
                    for (int j = 0; j < section.getAisles().length; j++) {
                        aisle = section.getAisles()[j];
                        for (int k = 0; k < aisle.getRack().length; k++) {
                            rack = aisle.getRack()[k];
                            for (int l = 0; l < rack.getShelf().length; l++) {
                                if (rack.getShelf()[l].getRowDisplayName().equalsIgnoreCase(selected)) {
                                    shelf = rack.getShelf()[l];
                                    printShelf(shelf, userPanel.userMainBodyPanel.returnField, true);
                                }}}}}}}
        //starts methods for adding an item
        if (e.getSource() == AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addItemButton) {
            reloadAddSectionDropBoxes();
            addItemDialog.setVisible(true);
        }
        if (e.getSource() == addItemDialog.sectionDropBox) {//populate the aisle box
            addItemDialog.populateAisleBox(store);
            addItemDialog.aisleDropBox.addActionListener(this);
        }
        if (e.getSource() == addItemDialog.aisleDropBox) {//populate the rack box
            addItemDialog.populateRackBox(store);
            addItemDialog.rackDropBox.addActionListener(this);
        }
        if (e.getSource() == addItemDialog.rackDropBox) {//populate the shelf box
            addItemDialog.poplateShelfBox(store);
        }
        if (e.getSource() == addItemDialog.submitButton) {//making a new item with click of submit button
            addItemDialog.addTheItem(store);
            adminEditMerchPanel.editMerchCombobox.addItem(addItemDialog.name);
            reloadComboBoxes();
        }
        //starts methods for adding a shelf
        if (e.getSource() == AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addShelfButton) {
            reloadAddSectionDropBoxes();
            addShelfDialog.setVisible(true);
        }
        if (e.getSource() == addShelfDialog.sectionDropBox) {//populate the aisle box
            addShelfDialog.aisleDropBox.addActionListener(this);
            addShelfDialog.populateAisleBox(store);
        }
        if (e.getSource() == addShelfDialog.aisleDropBox) {//populate the rack box
            addShelfDialog.rackDropBox.addActionListener(this);
            addShelfDialog.populateRackBox(store);
        }
        if (e.getSource() == addShelfDialog.submitButton) {//making a new shelf with click of submit button
            addShelfDialog.addTheShelf(store);
            reloadComboBoxes();
        }
        //starts methods for adding a rack
        if (e.getSource() == AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addRackButton) {
            reloadAddSectionDropBoxes();
            addRackDialog.setVisible(true);
        }
        if (e.getSource() == addRackDialog.sectionDropBox) {//populate the aisle box
            addRackDialog.populateAisleBox(store);
            addRackDialog.aisleDropBox.addActionListener(this);
        }
        if (e.getSource() == addRackDialog.submitButton) {//making a new rack with click of submit button
            addRackDialog.addTheRack(store);
            reloadComboBoxes();
        }
        //start of adding aisle methods
        if (e.getSource() == AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addAisleButton) {
            reloadAddSectionDropBoxes();
            addAisleDialog.setVisible(true);
        }
        if (e.getSource() == addAisleDialog.submitButton) {//making a new aisle with click of submit button
            addAisleDialog.addTheAisle(store);
            reloadComboBoxes();
        }
        //start of adding section methods
        if (e.getSource() == AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelBottom.addSectionButton) {
            addSectionDialog.setVisible(true);
        }
        if (e.getSource() == addSectionDialog.submitButton) {//making a new section with click of submit button
            addSectionDialog.addTheSection(store);
            adminEditLocation.editSectionComboBox.addItem(addSectionDialog.newSection.getSectionName());
            adminPanel.adminEditBodyPanel.dropBoxPanel.sectionDropbox.addItem(addSectionDialog.newSection.getSectionName());
            reloadComboBoxes();
        }
    }
    //******************************************************
    //***Populating the JList for the AdminAddRemovePanelTop
    public void populatingAddRemoveJList(ActionEvent e) {
        AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.modelObjectList.clear();
        String obj = (String) AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.objectDropBox.getSelectedItem();
        if (Objects.equals(obj, "Section")) {
            for (String str : store.getSectionsNames(store.getSections())) {
                AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.modelObjectList.addElement(str);
            }
        } else if (Objects.equals(obj, "Aisle")) {
            for (Section sec : store.getSections()) {
                for (Aisle ais : sec.getAisles()) {
                    AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.modelObjectList.addElement(ais.getAisleDisplayName());
                }}
        } else if (Objects.equals(obj, "Rack")) {
            for (Section sec : store.getSections()) {
                for (Aisle ais : sec.getAisles()) {
                    for (Rack rac : ais.getRack()) {
                        AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.modelObjectList.addElement(rac.getRackDisplayName());
                    }}}
        } else if (Objects.equals(obj, "Shelf")) {
            for (Section sec : store.getSections()) {
                for (Aisle ais : sec.getAisles()) {
                    for (Rack rac : ais.getRack()) {
                        for (Shelf she : rac.getShelf()) {
                            AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.modelObjectList.addElement(she.getRowDisplayName());
                        }}}}
        } else if (Objects.equals(obj, "Sale Item")) {
            for (Section sec : store.getSections()) {
                for (Aisle ais : sec.getAisles()) {
                    for (Rack rac : ais.getRack()) {
                        for (Shelf she : rac.getShelf()) {
                            for (SaleItem sal : she.getItemsOnShelf()) {
                                AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.modelObjectList.addElement(sal.getName());
                            }}}}}}
        AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.repaint();
    }

    //*********************************************************************************
    //***Lambda Expression for Removing selected object from JList though the JComboBox
    public void removeButtonClicked(ActionEvent e) {
        System.out.println("Made it to the listener");
        int selectedDropBoxIndex = AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.objectDropBox.getSelectedIndex();
        String selectedListValue = AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.objectList.getSelectedValue();
        //For Removing Section
        if (selectedDropBoxIndex == 1) {
            for (Section sec : store.getSections()) {
                if (sec.getSectionName().equals(selectedListValue)) {
                    store.removeSection(sec);
                }}}
        //For Removing Aisle
        if (selectedDropBoxIndex == 2) {
            System.out.println("Found DropBox selected on 'Aisle'");
            for (Section sec : store.getSections()) {
                System.out.println("1st ForLoop: for every Section in the Store");
                for (Aisle ais : sec.getAisles()) {
                    System.out.println("2nd ForLoop: for every Aisle in the Section");
                    if (ais.getAisleDisplayName().equals(selectedListValue)) {
                        System.out.println("Removing: " + ais + " from " + ais.getSection().getSectionName());
                        sec.removeAisle(ais);
                    }}}}
        //For Removing Rack
        if (selectedDropBoxIndex == 3) {
            for (Section sec : store.getSections()) {
                for (Aisle ais : sec.getAisles()) {
                    for (Rack rac : ais.getRack()) {
                        if (rac.getRackDisplayName().equals(selectedListValue)) {
                            ais.removeRack(rac);
                        }}}}}
        //For Removing Shelf
        if (selectedDropBoxIndex == 4) {
            for (Section sec : store.getSections()) {
                for (Aisle ais : sec.getAisles()) {
                    for (Rack rac : ais.getRack()) {
                        for (Shelf slf : rac.getShelf()) {
                            if (slf.getRowDisplayName().equals(selectedListValue)) {
                                rac.removeShelf(slf);
                            }}}}}}
        //For Removing SaleItem
        if (selectedDropBoxIndex == 5) {
            for (Section sec : store.getSections()) {
                for (Aisle ais : sec.getAisles()) {
                    for (Rack rac : ais.getRack()) {
                        for (Shelf slf : rac.getShelf()) {
                            for (SaleItem sal : slf.getItemsOnShelf()) {
                                if (sal.getName().equals(selectedListValue)) {
                                    slf.removeItems(sal);
                                }}}}}}}
        populatingAddRemoveJList(e);
        AdminMainBottomPanel.guiAddRemoveWindow.adminAddRemovePanelTop.repaint();
        reloadComboBoxes();
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
    }}