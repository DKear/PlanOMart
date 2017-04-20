package admin;

import javax.swing.*;
import java.awt.*;

/**
 * Created by joshu on 4/20/2017.
 */
public class ReadComment extends JDialog {
    private JLabel subjectLabel = new JLabel("Subject: ");
    private JTextArea subjectArea;
    private JLabel commentLabel = new JLabel("Customer's Comment: ");
    private JTextArea commentArea;
    private JLabel contactLabel = new JLabel("Contact Information:");
    private JTextArea contactArea;
    private JPanel readComm; //panel all things are placed in
    private GridBagConstraints createCommGrid; //layout used

    public ReadComment() {
        setSize(600, 600);
        //making the customer side
        //the subject label and text field
        subjectLabel = new JLabel("Subject of comment:");//top label for the subject of the comment
        subjectLabel.setLabelFor(subjectArea); // don't know if this does anything
        subjectArea = new JTextArea();

        //the comment label and comment text field
        commentLabel = new JLabel("Comment:");
        commentLabel.setLabelFor(commentArea);
        commentArea = new JTextArea();

        //the contact label and text field
        contactLabel = new JLabel("Contact info (Used to provide you with a discount next time you shop):");
        contactLabel.setLabelFor(contactArea);
        contactArea = new JTextArea();

        this.setModalityType(ModalityType.APPLICATION_MODAL);//makes into a dialog box
        readComm = new JPanel();// makes a panels to place all the components in
        readComm.setLayout(new GridBagLayout());//sets layout to createCommGrid layout
        createCommGrid = new GridBagConstraints();//tells the component where in the createCommGrid it will be placed
        //create customer comments window
        createCommGrid.gridx = createCommGrid.gridy = 0;//uses entire width
        //starts at top
        createCommGrid.anchor = GridBagConstraints.LINE_START;
        readComm.add(subjectLabel, createCommGrid);// adds the label to this part of the createCommGrid
        createCommGrid.fill = GridBagConstraints.BOTH;
        createCommGrid.gridy = 1;//one further down
        readComm.add(subjectArea, createCommGrid);
        createCommGrid.anchor = GridBagConstraints.LINE_START;
        createCommGrid.gridy = 2;//one further down
        readComm.add(commentLabel, createCommGrid);
        createCommGrid.fill = GridBagConstraints.BOTH;
        createCommGrid.gridy = 3;//one further down
        createCommGrid.ipady = 40; //makes this cell taller
        readComm.add(commentArea, createCommGrid);
        createCommGrid.anchor = GridBagConstraints.LINE_START;
        createCommGrid.gridy = 4;//one further down
        createCommGrid.ipady = 0;//brings cell height back to default
        readComm.add(contactLabel, createCommGrid);
        createCommGrid.fill = GridBagConstraints.BOTH;
        createCommGrid.gridy = 5;//one further down
        readComm.add(contactArea, createCommGrid);
        this.add(readComm);

        this.setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
