/**
 * Created by joshu on 4/11/2017.
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommentsTest {
    @Test
    public void getSubjectTest() {
        CustomerComments com1 = new CustomerComments("Service", "The service here was absolutely wonderful!", "Don't");
        Assertions.assertEquals("Service", com1.getSubject());
    }
    @Test
    public void getCommentTest() {
        CustomerComments com1 = new CustomerComments("Service", "The service here was absolutely wonderful!", "Don't");
        Assertions.assertEquals("The service here was absolutely wonderful!", com1.getComment());
    }
    @Test
    public void getContactTest() {
        CustomerComments com1 = new CustomerComments("Service", "The service here was absolutely wonderful!", "Don't");
        Assertions.assertEquals("Don't", com1.getContact());
    }
    @Test
    public void validSubjectTest() {
        CustomerComments com1 = new CustomerComments("", "The service here was absolutely wonderful!", "Don't");
        Assertions.assertFalse(com1.validateComment(com1));
    }
    @Test
    public void validCommentTest() {
        CustomerComments com1 = new CustomerComments("Service", "", "Don't");
        Assertions.assertFalse(com1.validateComment(com1));
    }
    @Test
    public void emptyContactTest() {
        CustomerComments com1 = new CustomerComments("Service", "The service here was absolutely wonderful!", "");
        Assertions.assertEquals("No Contact Information.", com1.getContact());
    }
}
