package admin;

import UserSide.CustomerComments;
import UserSide.GUICreateComments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUIViewComments extends JDialog{
    private JButton deleteButton;
    private JButton viewCommentButton;
    private JPanel viewCustComm;
    private GridBagConstraints viewCommGrid; //layout used
    private DefaultListModel listOfCommentSubjects; //a pre-list for JList
    private JList<String> subjectList;//list populated by subjects of comments. Placed in scrollPane
    private JScrollPane paneOfSubjects;
    private JLabel viewCommentLabel;//placed above scroll pane
    private ReadComment read = new ReadComment();


    public GUIViewComments() {
        setSize(800, 800);
        //making the admin side
        //delete button will remove selected comment object from the arraylist
        deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(100, 30));
        deleteButton.addActionListener(this::deleteButtonListener);

        //view button will make the comment appear on in a separate dialog box
        viewCommentButton = new JButton("View Comment");//
        viewCommentButton.setPreferredSize(new Dimension(100, 30));
        viewCommentButton.addActionListener(this::viewButtonListener);


        //view customer comments window
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);//makes into a dialog box
        viewCustComm = new JPanel();// makes a panels to place all the components in
        viewCustComm.setLayout(new GridBagLayout());//sets layout to createCommGrid layout
        viewCommGrid = new GridBagConstraints();//tells the component where in the createCommGrid it will be placed
        listOfCommentSubjects = new DefaultListModel();
        this.populateList();
        subjectList = new JList<String>(listOfCommentSubjects);
        paneOfSubjects = new JScrollPane(subjectList);
        viewCommGrid.gridy = viewCommGrid.gridx = 0;
        viewCommentLabel = new JLabel("Subject of Messages. Click a subject then the View button to view the comment.");
        viewCommGrid.anchor = GridBagConstraints.LINE_START;
        viewCustComm.add(viewCommentLabel, viewCommGrid);//puts label on top
        viewCommGrid.fill = GridBagConstraints.BOTH;
        viewCommGrid.gridy = 1;
        viewCommGrid.ipady = 50;
        viewCustComm.add(paneOfSubjects, viewCommGrid);//puts scroll list of subjects under label
        viewCommGrid.fill = GridBagConstraints.NONE;
        viewCommGrid.ipadx = 100;
        viewCommGrid.gridx = 1;
        viewCommGrid.anchor = GridBagConstraints.PAGE_START;
        viewCustComm.add(viewCommentButton, viewCommGrid);//places view button to the upper right of the scroll pane
        viewCommGrid.anchor = GridBagConstraints.PAGE_END;
        viewCustComm.add(deleteButton, viewCommGrid);//places delete button under view button
        this.add(viewCustComm);

        setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void populateList() {
        if (!GUICreateComments.comments.isEmpty()) {
            listOfCommentSubjects.clear();
            for (CustomerComments comm : GUICreateComments.comments) {//for every comment in the list
                listOfCommentSubjects.addElement(comm.getSubject());//add the comment subject to the list
            }
        } else {
            if (listOfCommentSubjects.isEmpty()) listOfCommentSubjects.addElement("No Customer Comments Available.");
        }
    }
    public void deleteButtonListener(ActionEvent e) {
        if (e.getSource() == deleteButton) {
            int index = subjectList.getSelectedIndex();
            if (index != -1 && !listOfCommentSubjects.elementAt(index).equals("No Customer Comments Available.")) {
                listOfCommentSubjects.remove(index);
                GUICreateComments.comments.remove(index);
                this.populateList();
            }
        }
    }
   public void viewButtonListener(ActionEvent e) {
        if (e.getSource() == viewCommentButton) {
            int index = subjectList.getSelectedIndex();
            if (index != -1 && !listOfCommentSubjects.elementAt(index).equals("No Customer Comments Available.")) {
                CustomerComments entireComm = GUICreateComments.comments.get(index);
                read.subjectArea.setText(entireComm.getSubject());
                read.commentArea.setText(entireComm.getComment());
                read.contactArea.setText(entireComm.getContact());
                read.setVisible(true);
            }
        }
    }
}
