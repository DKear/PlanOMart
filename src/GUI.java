import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;              //for layout managers and more
import java.awt.event.*;        //for action events

import java.net.URL;
import java.io.IOException;

public class GUI implements ActionListener {

    JPanel cards;

    private Container controllingContainer;
    //String ADMINPANEL = "Admin";
    //String USERPANEL = "User";
    int adminInt;

    public void addComponentToPane(Container pane){
        controllingContainer = pane;
        JPanel panel = new JPanel();
        //String panelNames[] = {ADMINPANEL, USERPANEL};
        JButton switchButton = new JButton("Switch User");
        switchButton.addActionListener(this);
        panel.add(switchButton);

        JPanel adminPanel = new JPanel();
        adminPanel.add(new JLabel("Admin"));

        JPanel userPanel = new JPanel();
        userPanel.add(new JLabel("User"));

        cards = new JPanel(new CardLayout());
        cards.add(userPanel);
        cards.add(adminPanel);

        pane.add(panel, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e){
        CardLayout cl = (CardLayout)(cards.getLayout());

        if(adminInt == 0){
            JOptionPane.showMessageDialog(controllingContainer, "Enter a password");
            adminInt = 1;
            cl.next(cards);
        } else{
            cl.next(cards);
            adminInt = 0;
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