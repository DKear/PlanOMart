import javax.swing.*;
import java.awt.*;

public class GUIAdminEdit extends JDialog {
    public static JButton locationButton = new JButton("Location object");;
    public static JButton merchandiseButton = new JButton("Merchandise object");;
    public static JButton changePassButton = new JButton("Change password");;

    public GUIAdminEdit(){
        setSize(400,400);
        Dimension buttonSize = new Dimension(150, 30);

        locationButton.setPreferredSize(buttonSize);
        merchandiseButton.setPreferredSize(buttonSize);
        changePassButton.setPreferredSize(buttonSize);

        setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
    }
}