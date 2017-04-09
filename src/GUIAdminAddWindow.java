/*
IMPORTANT:
THIS IS JUST A PLACE HOLDER FOR NOW, THIS CALSS WILL CONTAIN BUTTONS
THAT WILL REQUEST WHAT YOU WANT TO ADD, FOR NOW IT JUST CONTAINS THE
OPTIONS FOR ADDING A STORE NAME
 */
import javax.swing.*;
public class GUIAdminAddWindow extends JDialog{
    JLabel storeNameLabel;
    JTextField storeNameField;
    JButton submitButton;
    public GUIAdminAddWindow(){
        setSize(400, 400);
        //A label and textfield for where the user will type the store name
        storeNameLabel = new JLabel("Enter your store's name:"); //what the label will output
        storeNameLabel.setLabelFor(storeNameField);// makes it a label for this text field
        storeNameField = new JTextField();
        storeNameField.setColumns(30);//sets the width of the textfield, by characters it can fit

        //Button used for the user to submit text entered
        submitButton = new JButton("Submit");
        setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
