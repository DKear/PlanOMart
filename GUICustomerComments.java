/**
 * Created by joshu on 4/2/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUICustomerComments extends JDialog{
    JLabel subjectLabel; //top label
    JTextField subjectField;//top textfield
    JLabel commentLabel; //middle label
    JTextField commentField;//middle and largest textfield
    JLabel contactLabel; //bottom label
    JTextField contactField;//bottom textfield
    JButton submitButton;//the submit button
    JButton deleteButton;
    JButton viewCommentButton;
    private CustomerComments comm;
    ArrayList<CustomerComments> comments = new ArrayList<>();//stores the customers' comments
    DefaultListModel listOfCommentSubjects = new DefaultListModel();
    JList subjectList = new JList(listOfCommentSubjects);


    public GUICustomerComments() {
        setSize(500, 500);
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
        addListeners();
        setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //making the admin side
        //delete button will remove selected comment object from the arraylist
        deleteButton = new JButton("Delete");
        //view button will make the comment appear on in a separate dialog box
        viewCommentButton = new JButton("View Comment");

    }
    private void addListeners() {
        submitButton.addActionListener(e -> {
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
        });
    }
}