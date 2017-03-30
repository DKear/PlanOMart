/*
IMPORTANT:
THIS IS JUST A PLACE HOLDER FOR NOW, THIS CALSS WILL CONTAIN BUTTONS
THAT WILL REQUEST WHAT YOU WANT TO ADD, FOR NOW IT JUST CONTAINS THE
OPTIONS FOR ADDING A STORE NAME
 */
import javax.swing.*;
public class GUIAdminAddWindow extends JDialog{
    JTextField storeName;
    JButton submitButton;
    public GUIAdminAddWindow(){
        setSize(400, 400);
        storeName = new JTextField();
        submitButton = new JButton("Submit");
        setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
