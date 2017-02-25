import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Created by joshu on 2/24/2017.
 */
public class ShelfTest {
    @Test
    public void getRowNumTest(){
        int row = 0;
        Shelf midHigh = new Shelf(row, 50);
        Assertions.assertEquals(midHigh.getRowNum(), row);
    }
    @Test
    public void getNumOfItemsOnShelfTest(){
        Shelf shelf = new Shelf(0, 50);
        Assertions.assertEquals(0, shelf.getNumOfItemsOnShelf());
    }
    @Test
    public void getAvailSizeTest() {
        Shelf shelf = new Shelf(0, 50);
        Assertions.assertEquals(50, shelf.getAvailableSize());
    }
    @Test
    public void getMaxShelfSizeTest() {
        Shelf shelf = new Shelf(0, 50);
        Assertions.assertEquals(1440, shelf.getShelfMaxSize());
    }
    @Test
    public void getProductsOnShelfTest() {
        Shelf shelf = new Shelf(0, 50);
        SaleItem book = new SaleItem(20.00,"Dean Koontz", 76576598, 1, "books", 48);
        shelf.addItem(book);
        SaleItem[] test = {book};
        Assertions.assertArrayEquals(test, shelf.getProductsOnShelf());
    }
    @Test
    public void negativeRowNum() {
        int row = -3;
        Shelf midHeight;
        boolean test = false;
        try {
            midHeight = new Shelf(row, 50);
        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }
    @Test
    public void negativeShelfSizeTest() {
        int size = -3;
        Shelf midHeight;
        boolean test = false;
        try {
            midHeight = new Shelf(3, size);
        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }
    @Test
    public void exceedsMaxShelfSizeTest() {
        int size = 1800;
        Shelf midHeight;
        boolean test = false;
        try {
            midHeight = new Shelf(3, size);
        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }
    @Test
    public void addTooLargeOfItemTest() {
        SaleItem book = new SaleItem(20.00,"Odd Thomas", 76576598, 1, "books", 48);
        Shelf shelf = new Shelf(3, 5);
        Assertions.assertFalse(shelf.addItem(book));
    }
    @Test
    public void itemAdded() {
        SaleItem book = new SaleItem(20.00,"Odd Thomas", 76576598, 1, "books", 48);
        Shelf shelf = new Shelf(3, 1000);
        Assertions.assertTrue(shelf.addItem(book));
    }
    @Test
    public void shelfAvailSizeReducedAfterAddTest() {
        SaleItem book = new SaleItem(20.00, "Odd Thomas",76576598, 1, "books", 48);
        Shelf shelf = new Shelf(3, 1000);
        shelf.addItem(book);
        Assertions.assertEquals(952, shelf.getAvailableSize());
    }
    @Test
    public void quantityAffectsItemSize() {

    }
    @Test
    public void doesNotHaveItemTest() {
        Shelf shelf = new Shelf(0, 50);
        Assertions.assertFalse(shelf.hasItems());
    }
    @Test
    public void hasItemsTest() {
        SaleItem book = new SaleItem(20.00,"Odd Thomas",76576598, 1, "books", 48);
        Shelf shelf = new Shelf(0, 50);
        shelf.addItem(book);
        Assertions.assertTrue(shelf.hasItems());
    }
    @Test
    public void productRemovedFromShelfPositive() {
        SaleItem book = new SaleItem(20.00,"Odd Thomas",76576598, 1, "books", 48);
        Shelf shelf = new Shelf(0, 50);
        shelf.addItem(book);
        Assertions.assertTrue(shelf.removeItems(book));
    }
    @Test
    public void productRemovedFromShelfNegativeTest() {
            SaleItem book = new SaleItem(20.00,"Odd Thomas",76576598, 1, "books", 48);
            Shelf shelf = new Shelf(0, 50);
            Assertions.assertFalse(shelf.removeItems(book));
    }
}
