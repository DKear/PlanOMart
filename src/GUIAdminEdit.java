import javax.swing.*;
public class GUIAdminEdit extends JDialog {
    JButton addButton;

    public GUIAdminEdit(){
        setSize(400,400);
        addButton = new JButton("Add Store");
        setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}
