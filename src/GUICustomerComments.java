/**
 * Created by joshu on 4/2/2017.
 */

import javax.swing.*;
public class GUICustomerComments extends JDialog{
    JLabel subjectLabel; //top label
    JTextField subjectField;//top textfield
    JLabel commentLabel; //middle label
    JTextField commentField;//middle and largest textfield
    JLabel contactLabel; //bottom label
    JTextField contactField;//bottom textfield
    JButton submitButton;//the submit button
    public GUICustomerComments(){
        setSize(500, 500);
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
        setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
