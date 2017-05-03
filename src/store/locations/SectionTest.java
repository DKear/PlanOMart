package store.locations;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;


import static org.junit.jupiter.api.Assertions.*;

class SectionTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void sectionNameTest() {
        String name = "section";
        Section section = new Section(name);
        assertTrue(section.getSectionName().equals(name));
    }



    @Test
    public void sectionHasNoAisleTest(){
        Section section = new Section("Section 1");
        assertFalse(section.hasAisle());
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
        assertTrue(section.getAisles().length == 1 & section.getAisles()[0].equals(aisle));
    }

    @Test
    public void sectionHasAisle(){
        Section section = new Section("Section");
        Aisle aisle = new Aisle("Aisle 1");
        section.addAisle(aisle);
        assertTrue(section.hasAisle());
    }

    @Test
    public void sectionRemoveAisleTest(){
        Section section = new Section("Section");
        Aisle aisle0 = new Aisle("Aisle 1");
        Aisle aisle1 = new Aisle("Aisle 2");
        section.addAisle(aisle0);
        section.addAisle(aisle1);
        section.removeAisle(aisle0);
        assertTrue(section.getAisles().length == 1 & section.getAisles()[0].equals(aisle1));
    }

    @Test
    public void sectionSetGetStoreTest(){
        Store store = new Store("Store");
        Section section0 = new Section("Section 1");
        Section section1 = new Section ("Section 1");
        store.addSection(section0);
        store.addSection(section1);
        section0.setStore(store);
        section1.setStore(store);
        assertTrue(section1.getStore().equals(store) & store.getSections()[1].equals(section1));
    }

    @Test
    public void sectionReturnTagsArrayTest() {
        Section section = new Section("Section 1");
        Assertions.assertTrue(section.getTags().size() == 0);
    }

    @Test
    public void setSectionNameTest(){
        Section section = new Section("original name");
        section.setSectionName("new name");
        Assertions.assertTrue(section.getSectionName().equals("new name"));
    }
    @Test
    public void validateSectionPositiveTest() {
        Section s = new Section("Name");
        Assertions.assertTrue(s.validateSection());
    }
    @Test
    public void validateSectionNegativeTest() {
        Section s = new Section("");
        Assertions.assertFalse(s.validateSection());
    }
}