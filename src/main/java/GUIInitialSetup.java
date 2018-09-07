import javax.swing.*;
import java.awt.*;


public class GUIInitialSetup extends JDialog {
    JTextField storeNameField;
    JTextField numberOfSectionField;
    JTextField numberOfAislesField;
    JTextField numberOfRacksField;
    JTextField numberOfShelvesField;
    JButton submitButton;
    private JPanel initialSetupPanel;

    public GUIInitialSetup(){
        setSize(new Dimension(600,500));

        storeNameField = new JTextField(10);
        numberOfSectionField = new JTextField(10);
        numberOfAislesField = new JTextField(10);
        numberOfRacksField = new JTextField(10);
        numberOfShelvesField = new JTextField(10);
        submitButton = new JButton("Submit");

        initialSetupPanel = new JPanel();
        initialSetupPanel.setLayout(new GridBagLayout());
        GridBagConstraints isp = new GridBagConstraints();
        isp.gridx = isp.gridy = 0;
        isp.anchor = GridBagConstraints.PAGE_START;
        isp.gridwidth = 2;
        initialSetupPanel.add(new JLabel("Welcome to PlanOMart! Please enter some information about your store."), isp);
        isp.gridwidth = 1;
        isp.gridy = 1;
        isp.anchor = GridBagConstraints.CENTER;
        initialSetupPanel.add(new JLabel("Store name:"), isp);
        isp.gridx = 1;
        initialSetupPanel.add(storeNameField, isp);
        isp.gridx = 0;
        isp.gridy = 2;
        initialSetupPanel.add(new JLabel("Number of sections:"), isp);
        isp.gridx = 1;
        initialSetupPanel.add(numberOfSectionField, isp);
        isp.gridx = 0;
        isp.gridy = 3;
        initialSetupPanel.add(new JLabel("Number of aisles in each section"), isp);
        isp.gridx = 1;
        initialSetupPanel.add(numberOfAislesField, isp);
        isp.gridx = 0;
        isp.gridy = 4;
        initialSetupPanel.add(new JLabel("Number of racks in each aisle"), isp);
        isp.gridx = 1;
        initialSetupPanel.add(numberOfRacksField, isp);
        isp.gridx = 0;
        isp.gridy = 5;
        initialSetupPanel.add(new JLabel("Number of shelves in each rack"), isp);
        isp.gridx = 1;
        initialSetupPanel.add(numberOfShelvesField, isp);
        isp.gridwidth = 2;
        isp.gridx = 0;
        isp.gridy = 6;
        initialSetupPanel.add(submitButton, isp);
        add(initialSetupPanel);

        setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);

    }
    public boolean isNumber(String str){
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }


}
