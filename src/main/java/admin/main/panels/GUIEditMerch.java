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
    public JTextField merchEditDescriptionField;
    public JButton merchEditDescriptionSubmit;
    public JRadioButton saleButton;
    public JTextField merchSalePriceField;
    public JButton merchSaleSubmit;
    public JTextField saleDescriptionField;
    //public JButton saleDescriptionSubmit;
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
        merchEditDescriptionField = new JTextField(15);
        merchEditDescriptionSubmit = new JButton("Edit description");
        saleButton = new JRadioButton("Sale");
        merchSalePriceField = new JTextField(15);
        merchSaleSubmit = new JButton("Submit sale price and description");
        saleDescriptionField = new JTextField(15);
        //saleDescriptionSubmit = new JButton("Submit sale price");
        backButton = new JButton("Return");

        em.gridx = em.gridy = 0;
        add(new JLabel("Change name:"),em);
        em.gridx = 1;
        add(merchNameField, em);
        em.gridx = 0;
        em.gridwidth = 2;
        em.gridy++;
        add(merchNameSubmit, em);
        em.gridwidth = 1;
        em.gridy++;
        add(new JLabel("Change price:"), em);
        em.gridx = 1;
        add(merchPriceField, em);
        em.gridx = 0;
        em.gridwidth = 2;
        em.gridy++;
        add(merchPriceSubmit, em);
        em.gridwidth = 1;
        em.gridy++;
        add(new JLabel("Add tag:"), em);
        em.gridx = 1;
        add(merchAddTagField, em);
        em.gridx = 0;
        em.gridwidth = 2;
        em.gridy++;
        add(merchAddTagSubmit, em);
        em.gridwidth = 1;
        em.gridy++;
        add(new JLabel("Remove tag:"), em);
        em.gridx = 1;
        add(merchRemoveTagBox, em);
        em.gridy++;
        em.gridx = 0;
        em.gridwidth = 2;
        //em.gridy++;
        add(merchRemoveSubmit, em);
        em.gridy++;
        em.gridwidth = 1;
        add(new JLabel("Edit description:"), em);
        em.gridx = 1;
        add(merchEditDescriptionField,em);
        em.gridx = 0;
        em.gridwidth = 2;
        em.gridy++;
        add(merchEditDescriptionSubmit, em);
        em.gridy++;
        add(saleButton, em);
        em.gridy++;
        em.gridwidth = 1;
        add(new JLabel("Sale price:"), em);
        em.gridx = 1;
        add(merchSalePriceField, em);
        em.gridx = 0;
        em.gridwidth = 1;
        em.gridy++;
        add(new JLabel("Sale description"), em);
        em. gridx = 1;
        add(saleDescriptionField, em);
        em.gridx = 0;
        em.gridwidth = 2;
        em.gridy++;
        add(merchSaleSubmit, em);
        em.gridy++;
        add(backButton, em);
    }
}
