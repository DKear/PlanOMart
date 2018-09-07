package UserSide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GUICreateComments extends JDialog{
    private JLabel subjectLabel; //top label
    private JTextField subjectField;//top textfield
    private JLabel commentLabel; //middle label
    private JTextField commentField;//middle and largest textfield
    private JLabel contactLabel; //bottom label
    private JTextField contactField;//bottom textfield
    private JButton submitButton;//the submit button
    private JPanel createCustComm; //panel all things are placed in
    private GridBagConstraints createCommGrid; //layout used
    private CustomerComments comm;
    public static ArrayList<CustomerComments> comments = new ArrayList<>();//stores the customers' comments

    public GUICreateComments() {
        setSize(600, 600);
        //making the customer side
        //the subject label and text field
        subjectLabel = new JLabel("Subject of comment:");//top label for the subject of the comment
        subjectLabel.setLabelFor(subjectField); // don't know if this does anything
        subjectField = new JTextField();

        //the comment label and comment text field
        commentLabel = new JLabel("Comment:");
        commentLabel.setLabelFor(commentField);
        commentField = new JTextField();

        //the contact label and text field
        contactLabel = new JLabel("Contact info (Used to provide you with a discount next time you shop):");
        contactLabel.setLabelFor(contactField);
        contactField = new JTextField();

        //Button used for the user to submit text entered
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this::submitListener);

        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);//makes into a dialog box
        createCustComm = new JPanel();// makes a panels to place all the components in
        createCustComm.setLayout(new GridBagLayout());//sets layout to createCommGrid layout
        createCommGrid = new GridBagConstraints();//tells the component where in the createCommGrid it will be placed
        //create customer comments window
        createCommGrid.gridx = createCommGrid.gridy = 0;//uses entire width
        //starts at top
        createCommGrid.anchor = GridBagConstraints.LINE_START;
        createCustComm.add(subjectLabel, createCommGrid);// adds the label to this part of the createCommGrid
        createCommGrid.fill = GridBagConstraints.BOTH;
        createCommGrid.gridy = 1;//one further down
        createCustComm.add(subjectField, createCommGrid);
        createCommGrid.anchor = GridBagConstraints.LINE_START;
        createCommGrid.gridy = 2;//one further down
        createCustComm.add(commentLabel, createCommGrid);
        createCommGrid.fill = GridBagConstraints.BOTH;
        createCommGrid.gridy = 3;//one further down
        createCommGrid.ipady = 40; //makes this cell taller
        createCustComm.add(commentField, createCommGrid);
        createCommGrid.anchor = GridBagConstraints.LINE_START;
        createCommGrid.gridy = 4;//one further down
        createCommGrid.ipady = 0;//brings cell height back to default
        createCustComm.add(contactLabel, createCommGrid);
        createCommGrid.fill = GridBagConstraints.BOTH;
        createCommGrid.gridy = 5;//one further down
        createCustComm.add(contactField, createCommGrid);
        createCommGrid.anchor = GridBagConstraints.LINE_END;
        createCommGrid.gridy = 6;//one further down
        createCustComm.add(submitButton, createCommGrid);
        this.add(createCustComm);

        this.setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    private void submitListener(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String subject = subjectField.getText();  //Creating a string to store the text in the storeNameField
            subjectField.setText("");  //Erasing whatever input is in the text field after submit
            String comment = commentField.getText();
            commentField.setText("");
            String contact = contactField.getText();
            contactField.setText("");
            comm = new CustomerComments(subject, comment, contact);
            if (comm.validateComment(comm)) {
                comments.add(comm);
            }
            setVisible(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //Closing the dialog box.
        }
    }
}