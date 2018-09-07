package UserSide;

public class CustomerComments {
    private String subject, comment, contact;

    public CustomerComments (String s, String com, String con) {
        subject = s;
        comment = com;
        contact = con;
    }
    public String getSubject() {
        return subject;
    }
    public String getComment() {
        return comment;
    }
    public String getContact() {
        if (!contact.equals("")) {
            return contact;
        } else {
            return "No Contact Information.";
        }
    }

    public boolean validateComment(CustomerComments c) {
        return !(c.getSubject().equals("") || c.getComment().equals(""));
    }
}
