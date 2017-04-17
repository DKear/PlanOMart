/*
IMPORTANT:
THIS IS JUST A PLACE HOLDER FOR NOW, THIS CALSS WILL CONTAIN BUTTONS
THAT WILL REQUEST WHAT YOU WANT TO ADD, FOR NOW IT JUST CONTAINS THE
OPTIONS FOR ADDING A STORE NAME
 */
import javax.swing.*;
import java.awt.*;
//<<<<<<< HEAD



public class GUIAdminAddWindow extends JDialog{
    JLabel storeNameLabel;
    JTextField storeNameField;
    JButton submitButton;

    public GUIAdminAddWindow() {
        setSize(400, 400);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        //Button used for the user to submit text entered
        submitButton = new JButton("Submit");
        addListeners();
        setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void addListeners() {
        submitButton.addActionListener(e -> {

        });
    }
}