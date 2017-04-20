import javax.swing.*;
import java.awt.*;

public class GUIAdminEdit extends JDialog {
    public JButton locationButton;
    public JButton merchandiseButton;
    public JButton changePassButton;

    public GUIAdminEdit(){
        setSize(400,400);
        Dimension buttonSize = new Dimension(150, 30);
        locationButton = new JButton("Location object");

        locationButton.setPreferredSize(buttonSize);
        merchandiseButton = new JButton("Merchandise object");
        merchandiseButton.setPreferredSize(buttonSize);
        changePassButton = new JButton("Change password");
        changePassButton.setPreferredSize(buttonSize);

        setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
    }

}
