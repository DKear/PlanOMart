/*
IMPORTANT:
THIS IS JUST A PLACE HOLDER FOR NOW, THIS CLASS WILL CONTAIN BUTTONS
THAT WILL REQUEST WHAT YOU WANT TO ADD, FOR NOW IT JUST CONTAINS THE
OPTIONS FOR ADDING A STORE NAME
 */
import javax.swing.*;

public class GUIAdminAddWindow extends JDialog {
    JTextField storeNameField;
    JButton submitButton;

    public GUIAdminAddWindow() {
        setSize(400, 400);
        storeNameField = new JTextField(10);
        //storeName.setMaximumSize(new Dimension(150,25));
        submitButton = new JButton("Submit");
        addListeners();
        setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void addListeners() {
        submitButton.addActionListener(e -> {
            String storeName = storeNameField.getText();         //Creating a string to store the text in the storeNameField
            Store theStore = new Store(storeName);               //Creating a Store object and setting the string, storeName, to it
            storeNameField.setText("");                          //Erasing whatever input is in the text field after submit
            setVisible(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //Closing the dialog box, aw.
        });
    }
}