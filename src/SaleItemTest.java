import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Created by joshu on 2/24/2017.
 */
public class SaleItemTest {
    @Test
    public void getPriceTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 1, "bread", 56, 4);
        Assertions.assertEquals(1.39, bread.getPrice());
    }

    @Test
    public void tooLowOfPriceTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(0, "White Classic", "Wonder Bread", 832756, 1, "bread", 56, 4);
        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }

    @Test
    public void getNameTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 1, "bread", 56, 4);
        Assertions.assertTrue(bread.getName().equals("White Classic"));
    }

    @Test
    public void nullNameTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, null, "Wonder Bread", 832756, 1, "bread", 56, 4);
        } catch (NullPointerException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }

    @Test
    public void emptyStringNameTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, "", "Wonder Bread", 832756, 1, "bread", 56, 4);
        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }

    @Test
    public void getBrandTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 1, "bread", 56, 4);
        Assertions.assertTrue(bread.getBrand().equals("Wonder Bread"));
    }

    @Test
    public void nullBrandTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, "White Classic", null, 832756, 1, "bread", 56, 4);
        } catch (NullPointerException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }

    @Test
    public void emptyStringBrandTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, "White Classic", "", 832756, 1, "bread", 56, 4);
        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }

    @Test
    public void getUPCTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 1, "bread", 56, 4);
        Assertions.assertEquals(832756, bread.getUPC());
    }

    @Test
    public void upcTooSmallTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 0, 1, "bread", 56, 4);
        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }

    @Test
    public void getQuantityTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 1, "bread", 56, 4);
        Assertions.assertEquals(1, bread.getQuantity());
    }

    @Test
    public void quantityTooLowTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, -1, "bread", 56, 4);
        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }

    @Test
    public void getCategoryTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 1, "Bread", 56, 4);
        Assertions.assertTrue(bread.getCategory().equals("Bread"));
    }

    @Test
    public void categoryIsNullTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 1, null, 56, 4);
        } catch (NullPointerException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }

    @Test
    public void categoryEmptyStringTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 1, "", 56, 4);
        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }

    @Test
    public void getItemBaseTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 1, "Bread", 56, 4);
        Assertions.assertEquals(56, bread.getItemBase());
    }

    @Test
    public void itemBaseTooLowTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 1, "bread", 0, 4);
        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }

    @Test
    public void getItemHeightTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 1, "Bread", 56, 4);
        Assertions.assertEquals(4, bread.getItemHeight());
    }

    @Test
    public void itemHeightTooLowTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 1, "bread", 56, 0);
        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }

    @Test
    public void getItemAreaTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 1, "Bread", 56, 4);
        Assertions.assertEquals(224, bread.getItemArea());
    }

    @Test
    public void getTotalAreaConsumedTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 2, "Bread", 56, 4);
        Assertions.assertEquals(448, bread.getTotalAreaConsumed());
    }

    @Test
    public void doesNotHaveTagTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 2, "Bread", 56, 4);
        Assertions.assertFalse(bread.hasTags());
    }

    @Test
    public void hasTagsTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 2, "Bread", 56, 4);
        String tag = "sliced";
        bread.addTag(tag);
        Assertions.assertTrue(bread.hasTags());
    }

    @Test
    public void getTagsTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 2, "Bread", 56, 4);
        String tag = "sliced";
        bread.addTag(tag);
        Assertions.assertTrue(bread.getTags()[0].equals("sliced"));
    }

    @Test
    public void noTagsToGetTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 2, "Bread", 56, 4);
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
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 2, "Bread", 56, 4);
        String tag = "sliced";
        bread.addTag(tag);
        Assertions.assertTrue(bread.removeTag(tag));
    }

    @Test
    public void productRemovedFromShelfNegativeTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 2, "Bread", 56, 4);
        String tag = "sliced";
        Assertions.assertFalse(bread.removeTag(tag));
    }

    @Test
    public void getSalePriceTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 2, "Bread", 56, 4,
                0, "Buy One Get One");
        Assertions.assertEquals(0, bread.getSalePrice());
    }
    @Test
    public void itemSalePriceTooLowTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 1, "bread", 56, 4,
                    -.50, "$.50 off");
        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }
    @Test
    public void itemSalePriceTooHighTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 1, "bread", 56, 4,
                    1.89, "$.50 off");
        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }
    @Test
    public void getSaleDescriptionTest() {
        SaleItem bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 2, "Bread", 56, 4,
                0, "Buy One Get One");
        Assertions.assertTrue(bread.getSaleDescription().equals("Buy One Get One"));
    }

    @Test
    public void saleDescriptionIsNullTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 2, "Bread", 56, 4,
                    0, null);
        } catch (NullPointerException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }

    @Test
    public void saleDescriptionEmptyStringTest() {
        SaleItem bread;
        boolean test = false;
        try {
            bread = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 2, "Bread", 56, 4,
                    0, "");
        } catch (IllegalArgumentException e) {
            test = true;
            Assertions.assertTrue(test);
        }
        Assertions.assertTrue(test);
    }
    @Test
    public void setgetShelfTest(){
        Shelf shelf = new Shelf(10, 10);
        SaleItem item = new SaleItem(1.39, "White Classic", "Wonder Bread", 832756, 2, "Bread", 56, 4,
                0, "Buy One Get One");
        shelf.addItem(item);
        item.setShelf(shelf);
        Assertions.assertTrue(item.getShelf().equals(shelf) & shelf.getItemsOnShelf()[0].equals(item));
    }
}
