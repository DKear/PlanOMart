import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by joshu on 2/24/2017.
 */
public class SaleItemTest {
    @Test
    public void getPriceTest() {
        SaleItem bread = new SaleItem(1.39, "White Bread", "Wonder Bread", "bread");
        Assertions.assertEquals(1.39, bread.getPrice());
    }

    @Test
    public void tooLowOfPriceTest() {
        SaleItem bread = new SaleItem(-1.39, "White Classic", "Wonder Bread", "bread");
        Assertions.assertFalse(bread.validateItem(bread));
    }

    @Test
    public void getNameTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", "bread");
        Assertions.assertTrue(bread.getName().equals("White Classic"));
    }


    @Test
    public void emptyStringNameTest() {
        SaleItem bread = new SaleItem(1.39, "", "Wonder Bread", "bread");
        Assertions.assertFalse(bread.validateItem(bread));
    }

    @Test
    public void getBrandTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", "bread");
        Assertions.assertTrue(bread.getBrand().equals("Wonder Bread"));
    }


    @Test
    public void emptyStringBrandTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "", "bread");
        Assertions.assertFalse(bread.validateItem(bread));
    }

    @Test
    public void doesNotHaveTagTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", "bread");
        Assertions.assertFalse(bread.hasTags());
    }

    @Test
    public void hasTagsTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", "bread");
        String tag = "sliced";
        bread.addTag(tag);
        Assertions.assertTrue(bread.hasTags());
    }

    @Test
    public void getTagsTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", "bread");
        String tag = "sliced";
        bread.addTag(tag);
        Assertions.assertTrue(bread.getTags()[0].equals("sliced"));
    }

    @Test
    public void noTagsToGetTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", "bread");
        boolean test = false;
        try {
            bread.getTags();
        } catch (ArrayStoreException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }

    @Test
    public void tagRemovedFromItemPositive() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", "bread");
        String tag = "sliced";
        bread.addTag(tag);
        Assertions.assertTrue(bread.removeTag(tag));
    }

    @Test
    public void tagRemovedFromItemNegativeTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", "bread");
        String tag = "sliced";
        Assertions.assertFalse(bread.removeTag(tag));
    }

    @Test
    public void getSalePriceTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", "bread");
        bread.setSalePercentage(10);
        Assertions.assertEquals(1.25, bread.getSalePrice());
    }
    /*@Test
    public void itemSalePriceTooLowTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", "bread");
        boolean test = false;
        try {
            bread.setSalePercentage(100); //anything less than -100 would make the sale price higher than the actual

        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }
    */
    @Test
    public void itemSalePriceTooHighTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", "bread");
        boolean test = false;
        try {
            bread.setSalePercentage(0);
        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }
    @Test
    public void getSaleDescriptionTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", "bread");
        bread.setSaleDescription("Buy One Get One");
        Assertions.assertTrue(bread.getSaleDescription().equals("Buy One Get One"));
    }

    @Test
    public void saleDescriptionIsNullTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", "bread");
        boolean test = false;
        try {
            bread.setSaleDescription(null);
        } catch (NullPointerException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }

    @Test
    public void saleDescriptionEmptyStringTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", "bread");
        boolean test = false;
        try {
            bread.setSaleDescription("");
        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }
    @Test
    public void noShelvesToGetTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", "bread");
        boolean test = false;
        try {
            bread.getShelvesWithItem();
        } catch (ArrayStoreException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }

    @Test
    public void setGetShelfTest(){
        Shelf shelf = new Shelf("10");
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", "bread");
        shelf.addItem(bread);
        bread.setShelves(shelf);
        Assertions.assertTrue(bread.getShelvesWithItem()[0].equals(shelf) & shelf.getItemsOnShelf()[0].equals(bread));
    }

}
