package store.locations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    @Test
    public void storeNameTest(){
        String name = "store";
        Store store = new Store(name);
        assertTrue(store.getStoreName().equals("store"));
    }



    @Test
    public void storeHasNoSectionsTest(){
        Store store = new Store("Store");
        assertFalse(store.hasSections());

    }

    @Test
    public void storeReturnArrayTest(){
        Store store = new Store("Store");
        Assertions.assertTrue(store.getSections().length == 0);
    }

    @Test
    public void storeAddSectionsTest(){
        Store store = new Store("Store");
        Section section = new Section("Section 1");
        store.addSection(section);
        Assertions.assertTrue(store.getSections().length == 1);
    }

    @Test
    public void storeHasSections(){
        Store store = new Store("Store");
        Section section = new Section("Section 1");
        store.addSection(section);
        assertTrue(store.hasSections());
    }

    @Test
    public void storeRemoveSectionTest(){
        Store store = new Store("Store");
        Section section0 = new Section ("Section 1");
        Section section1 = new Section ("Section 2");
        store.addSection(section0);
        store.addSection(section1);
        store.removeSection(section0);
        Assertions.assertTrue(store.getSections().length == 1);
    }
}