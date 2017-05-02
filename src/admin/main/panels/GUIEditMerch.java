package admin.main.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jamie on 4/30/2017.
 */
public class GUIEditMerch extends JPanel{
    public JTextField merchNameField;
    public JButton merchNameSubmit;
    public JTextField merchPriceField;
    public JButton merchPriceSubmit;
    public JTextField merchAddTagField;
    public JButton merchAddTagSubmit;
    public JComboBox merchRemoveTagBox;
    public JButton merchRemoveSubmit;
    public JRadioButton saleButton;
    public JTextField merchSalePriceField;
    public JButton merchSalePriceSubmit;
    public JTextField saleDescriptionField;
    public JButton saleDescriptionSubmit;
    public JButton backButton;

    public GUIEditMerch(){
        setLayout(new GridBagLayout());
        GridBagConstraints em = new GridBagConstraints();
        setPreferredSize(new Dimension(850,600));
        merchNameField = new JTextField(15);
        merchNameSubmit = new JButton("Change name");
        merchPriceField = new JTextField(15);
        merchPriceSubmit = new JButton("Change Price");
        merchAddTagField = new JTextField(15);
        merchAddTagSubmit = new JButton("Add Tag");
        merchRemoveTagBox = new JComboBox();
        merchRemoveSubmit = new JButton("Remove Tag");
        saleButton = new JRadioButton("Sale");
        merchSalePriceField = new JTextField(15);
        merchSalePriceSubmit = new JButton("Submit sale price");
        saleDescriptionField = new JTextField(15);
        saleDescriptionSubmit = new JButton("Submit sale price");
        backButton = new JButton("Return");

        em.gridx = em.gridy = 0;
        add(new JLabel("Change name:"),em);
        em.gridx = 1;
        add(merchNameField, em);
        em.gridx = 0;
        em.gridwidth = 2;
        em.gridy = 1;
        add(merchNameSubmit, em);
        em.gridwidth = 1;
        em.gridy = 2;
        add(new JLabel("Change price:"), em);
        em.gridx = 1;
        add(merchPriceField, em);
        em.gridx = 0;
        em.gridwidth = 2;
        em.gridy = 3;
        add(merchPriceSubmit, em);
        em.gridwidth = 1;
        em.gridy = 4;
        add(new JLabel("Add tag:"), em);
        em.gridx = 1;
        add(merchAddTagField, em);
        em.gridx = 0;
        em.gridwidth = 2;
        em.gridy = 5;
        add(merchAddTagSubmit, em);
        em.gridwidth = 1;
        em.gridy = 6;
        add(new JLabel("Remove tag:"), em);
        em.gridx = 1;
        add(merchRemoveTagBox, em);
        em.gridx = 0;
        em.gridwidth = 2;
        em.gridy = 7;
        add(merchRemoveSubmit, em);
        em.gridy = 8;
        add(saleButton, em);
        em.gridy = 9;
        em.gridwidth = 1;
        add(new JLabel("Sale price:"), em);
        em.gridx = 1;
        add(merchSalePriceField, em);
        em.gridx = 0;
        em.gridwidth = 2;
        em.gridy = 10;
        add(merchSalePriceSubmit, em);
        em.gridwidth = 1;
        em.gridy = 11;
        add(new JLabel("Sale description"), em);
        em. gridx = 1;
        add(saleDescriptionField, em);
        em.gridx = 0;
        em.gridwidth = 2;
        em.gridy = 12;
        add(merchSalePriceSubmit, em);
        em.gridy =13;
        add(backButton, em);




    }
}
