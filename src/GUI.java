import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;              //for layout managers and more
import java.awt.event.*;        //for action events

import java.net.URL;
import java.io.IOException;

public class GUI implements ActionListener {

    JPanel cards;
    JPanel adminOrgPanel;
    private Container controllingContainer;
    String ADMINPANEL = "Admin";
    String USERPANEL = "User";
    int adminInt;
    JButton switchButton;
    JButton adminEditButton;
    GUIAdminEdit ae;
    GUIAdminAddWindow aw;
    JPanel adminEditPanel;
    JPanel adminAddPanel;

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
        adminAddPanel.add(aw.storeName);
        adminAddPanel.add(aw.submitButton);
        aw.add(adminAddPanel);
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