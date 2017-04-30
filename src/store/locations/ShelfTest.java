package store.locations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by joshu on 2/24/2017.
 */
public class ShelfTest {
    @Test
    public void getRowNumTest() {
        String row = "0";
        Shelf midHigh = new Shelf(row);
        Assertions.assertEquals(midHigh.getRowName(), row);
    }

    @Test
    public void getNumOfItemsOnShelfTest() {
        Shelf shelf = new Shelf("0");
        Assertions.assertEquals(0, shelf.getNumOfItemsOnShelf());
    }

    @Test
    public void getProductsOnShelfTest() {
        Shelf shelf = new Shelf("0");
        SaleItem book = new SaleItem(20.00, "Odd Thomas", "Dean Koontz","books");
        shelf.addItem(book);
        SaleItem[] test = {book};
        Assertions.assertArrayEquals(test, shelf.getItemsOnShelf());
    }


    @Test
    public void itemAdded() {
        SaleItem book = new SaleItem(20.00, "Odd Thomas", "Dean Koontz","books");
        Shelf shelf = new Shelf("3");
        Assertions.assertTrue(shelf.addItem(book));
    }

    @Test
    public void doesNotHaveItemTest() {
        Shelf shelf = new Shelf("0");
        Assertions.assertFalse(shelf.hasItems());
    }

    @Test
    public void hasItemsTest() {
        SaleItem book = new SaleItem(20.00, "Odd Thomas", "Dean Koontz","books");
        Shelf shelf = new Shelf("0");
        shelf.addItem(book);
        Assertions.assertTrue(shelf.hasItems());
    }

    @Test
    public void getItemsTest() {
        SaleItem book = new SaleItem(20.00, "Odd Thomas", "Dean Koontz","books");
        Shelf shelf = new Shelf("0");
        shelf.addItem(book);
        Assertions.assertTrue(shelf.getItemsOnShelf()[0] == book);
    }

    @Test
    public void noItemsToGetTest() {
        Shelf shelf = new Shelf("0");
        boolean test = false;
        try {
            shelf.getItemsOnShelf();
        } catch (ArrayStoreException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }

    @Test
    public void productRemovedFromShelfPositive() {
        SaleItem book = new SaleItem(20.00, "Odd Thomas", "Dean Koontz","books");
        Shelf shelf = new Shelf("0");
        shelf.addItem(book);
        Assertions.assertTrue(shelf.removeItems(book));
    }

    @Test
    public void productRemovedFromShelfNegativeTest() {
        SaleItem book = new SaleItem(20.00, "Odd Thomas", "Dean Koontz","books");
        Shelf shelf = new Shelf("0");
        Assertions.assertFalse(shelf.removeItems(book));
    }

    @Test
    public void setgetRackTest(){
        Rack rack = new Rack("Rack");
        Shelf shelf = new Shelf("1");
        rack.addShelf(shelf);
        shelf.setRack(rack);
        Assertions.assertTrue(rack.getShelf()[0].equals(shelf) & shelf.getRack().equals(rack));
    }
    @Test
    public void validateShelfPositiveTest() {
        Shelf shelf = new Shelf("Name");
        Assertions.assertTrue(shelf.validateShelf());
    }
    @Test
    public void validateShelfNegativeTest() {
        Shelf shelf = new Shelf("");
        Assertions.assertFalse(shelf.validateShelf());
    }
}
