import javax.swing.*;
import java.awt.*;

public class GUIAdminEdit extends JDialog {
    JButton addButton;
    JButton removeButton;
    JButton viewCommentButton;

    public GUIAdminEdit(){
        setSize(400,400);
        Dimension buttonSize = new Dimension(150, 30);
        addButton = new JButton("Add");

        addButton.setPreferredSize(buttonSize);
        removeButton = new JButton("Remove");
        removeButton.setPreferredSize(buttonSize);
        viewCommentButton = new JButton("View comments");
        viewCommentButton.setPreferredSize(buttonSize);

        setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
    }

}
