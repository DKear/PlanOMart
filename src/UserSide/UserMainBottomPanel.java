package UserSide;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UserMainBottomPanel extends JPanel {

    public JButton switchUserButton;
    //COMMENT BUTTON;

    public UserMainBottomPanel(UserMainBodyPanel panel) {
        setBorder(new BevelBorder(BevelBorder.RAISED));

        //switchUserButton is created and given functionality with a lambda expression
        switchUserButton = new JButton("Switch User");
        switchUserButton.setPreferredSize(new Dimension(100, 50));
        switchUserButton.setFont(new Font("Arial", Font.PLAIN, 16));
        switchUserButton.addActionListener(this::switchUserButtonClicked);

//        //mapButton is created and given functionality with a lambda expression
//        mapButton = new JButton("Map");
//        mapButton.setPreferredSize(new Dimension(100,50));
//        mapButton.setFont(new Font("Arial", Font.PLAIN, 16));
//        mapButton.addActionListener(this::mapButtonClicked);

        //setting the general layout (position) of the buttons that were constructed
        setLayout(new MigLayout("", "[align center]", "[align center]"));
        add(switchUserButton);
//        add(commentButton);
//        add(mapButton);
    }

    //Below are the actual methods that the lambda expressions use
    private void switchUserButtonClicked(ActionEvent e) {
        getParent().setVisible(false);
    }

//    public void mapButtonClicked(ActionEvent e){
//        if (e.getSource() == mapButton) {
//            mapDialogWindow.setVisible(true);
//        }
//    }
}