import javax.swing.*;




public class GUIInitialSetup extends JDialog {
    JTextField storeNameField;
    JTextField numberOfSectionField;
    JTextField numberOfAislesField;
    JTextField numberOfRacksField;
    JTextField numberOfShelvesField;
    JButton submitButton;

    public GUIInitialSetup(){

        storeNameField = new JTextField(10);
        numberOfSectionField = new JTextField(10);
        numberOfAislesField = new JTextField(10);
        numberOfRacksField = new JTextField(10);
        numberOfShelvesField = new JTextField(10);
        submitButton = new JButton("Submit");
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
