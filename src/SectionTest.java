import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Created by Jamie on 2/24/2017.
 */
class SectionTest {
    @Test
    public void sectionNameTest() {
        String name = "section";
        Section section = new Section(name);
        Assertions.assertTrue(section.getSectionName().equals(name));
    }

    @Test
    public void sectionInvalidNameTest() {
        String name = "";
        Section section;
        try {
            section = new Section(name);
            section.getSectionName();
            Assertions.assertFalse(!section.getSectionName().equals(""));

        } catch (NullPointerException e) {
            Assertions.assertTrue(true);
        }

    }

    @Test
    public void sectionHasNoAisleTest(){
        Section section = new Section("Section 1");
        Assertions.assertFalse(section.hasAisle());
    }

    @Test
    public void sectionReturnArrayTest(){
        Section section = new Section("Section 1");
        Assertions.assertTrue(section.getAisles().length == 0);
    }

    @Test
    public void sectionAddAisleTest(){
        Section section = new Section("Section");
        Aisle aisle = new Aisle("Aisle 1");
        section.addAisle(aisle);
        Assertions.assertTrue(section.getAisles().length == 1 & section.getAisles()[0].equals(aisle));
    }

    @Test
    public void sectionHasAisle(){
        Section section = new Section("Section");
        Aisle aisle = new Aisle("Aisle 1");
        section.addAisle(aisle);
        Assertions.assertTrue(section.hasAisle());
    }

    @Test
    public void sectionRemoveAisleTest(){
        Section section = new Section("Section");
        Aisle aisle0 = new Aisle("Aisle 1");
        Aisle aisle1 = new Aisle("Aisle 2");
        section.addAisle(aisle0);
        section.addAisle(aisle1);
        section.removeAisle(aisle0);
        Assertions.assertTrue(section.getAisles().length == 1 & section.getAisles()[0].equals(aisle1));
    }

    @Test
    public void sectionSetStore(){
        Store store = new Store("Store");
        Section section0 = new Section("Section 1");
        Section section1 = new Section ("Section 1");
        store.addSection(section0);
        store.addSection(section1);
        section0.setStore(store);
        section1.setStore(store);
        Assertions.assertTrue(section1.getStore().equals(store) & store.getSections()[1].equals(section1));
    }
}