/*
IMPORTANT:
THIS IS JUST A PLACE HOLDER FOR NOW, THIS CLASS WILL CONTAIN BUTTONS
THAT WILL REQUEST WHAT YOU WANT TO ADD, FOR NOW IT JUST CONTAINS THE
OPTIONS FOR ADDING A STORE NAME
 */
import javax.swing.*;
import java.awt.*;

public class GUIAdminAddWindow extends JDialog{
    JTextField storeNameField;
    JButton submitButton;
    public GUIAdminAddWindow(){
        setSize(400, 400);
        storeNameField = new JTextField(10);
        //storeName.setMaximumSize(new Dimension(150,25));
        submitButton = new JButton("Submit");
        setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
