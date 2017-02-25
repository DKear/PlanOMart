import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Created by joshu on 2/24/2017.
 */
public class SaleItemTest {
    @Test
    public void getPriceTest() {
        SaleItem bread = new SaleItem(1.39, "Classic White", "Wonder Bread", 832756, 1, "Bread", 56);
        Assertions.assertEquals(1.39, bread.getPrice());
    }
    @Test
    public void tooLowOfPriceTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(0, "Classic White", "Wonder Bread", 832756, 1, "Bread", 56);
        } catch(IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
    }
    @Test
    public void getNameTest() {
        SaleItem bread = new SaleItem(1.39, "Classic White", "Wonder Bread", 832756, 1, "Bread", 56);
        Assertions.assertTrue(bread.getName().equals("Classic White"));
    }
    @Test
    public void nullNameTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, null, "Wonder Bread", 832756, 1, "Bread", 56);
        } catch (NullPointerException e) {
            test = true;
            Assertions.assertTrue(test);
        }
    }
    @Test
    public void emptyStringNameTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, "", "Wonder Bread", 832756, 1, "Bread", 56);
        } catch (NullPointerException e) {
            test = true;
            Assertions.assertTrue(test);
        }
    }
    @Test
    public void nullBrandTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, "Classic White", null, 832756, 1, "Bread", 56);
        } catch (NullPointerException e) {
            test = true;
            Assertions.assertTrue(test);
        }
    }
    @Test
    public void emptyStringBrandTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, "Classic White", "", 832756, 1, "Bread", 56);
        } catch (NullPointerException e) {
            test = true;
            Assertions.assertTrue(test);
        }
    }
    @Test
    public void getUPCTest() {
        SaleItem bread = new SaleItem(1.39, "Classic White", "Wonder Bread", 832756, 1, "Bread", 56);
        Assertions.assertEquals(832756, bread.getUPC());
    }

}
