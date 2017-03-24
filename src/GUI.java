import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;              //for layout managers and more
import java.awt.event.*;        //for action events

import java.net.URL;
import java.io.IOException;

public class GUI implements ActionListener {

    JPanel cards;
    String ADMINPANEL = "Admin";
    String USERPANEL = "User";

    public void addComponentToPane(Container pane){
        JPanel panel = new JPanel();
        String panelNames[] = {ADMINPANEL, USERPANEL};
        JButton switchButton = new JButton("Switch User");
        switchButton.addActionListener(this);
        panel.add(switchButton);

        JPanel adminPanel = new JPanel();
        adminPanel.add(new JLabel("Admin"));

        JPanel userPanel = new JPanel();
        userPanel.add(new JLabel("User"));

        cards = new JPanel(new CardLayout());
        cards.add(adminPanel);
        cards.add(userPanel);

        pane.add(panel, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e){
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.next(cards);
    }
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
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