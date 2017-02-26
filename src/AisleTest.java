import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AisleTest {

    @Test
    public void aisleNameTest() {
        String aisleName = "3B";
        Aisle aisle = new Aisle(aisleName);
        Assertions.assertTrue(aisle.getAisleName().equals(aisleName));
    }

    @Test
    public void wrongAisleNameTest() {
        String aisleName = "";
        Aisle aisle;

        try {
            aisle = new Aisle(aisleName);
            aisle.getAisleName();
            Assertions.assertFalse(!aisle.getAisleName().equals(""));
        } catch (NullPointerException e) {
            Assertions.assertTrue(true);
        }

    }

    @Test
    public void aisleHasNoRacksTest() {
        Aisle aisle = new Aisle("Aisle");
        Assertions.assertFalse(aisle.hasRacks());

    }

    @Test
    public void aisleReturnArrayTest() {
        Aisle aisle = new Aisle("Aisle");
        Assertions.assertTrue(aisle.getRack().length == 0);
    }

    @Test
    public void aisleAddRacksTest() {
        Aisle aisle = new Aisle("Aisle");
        Rack rack = new Rack("Rack 1");
        aisle.addRack(rack);
        Assertions.assertTrue(aisle.getRack().length == 1);
    }

    @Test
    public void aisleRemoveRackTest() {
        Aisle aisle = new Aisle("Aisle");
        Rack rack0 = new Rack("Rack 1");
        Rack rack1 = new Rack("Rack 2");
        aisle.addRack(rack0);
        aisle.addRack(rack1);
        aisle.removeRack(rack0);
        Assertions.assertTrue(aisle.getRack().length == 1);
    }

    @Test
    public void aisleHasRacks() {
        Aisle aisle = new Aisle("Aisle");
        Rack rack = new Rack("Rack 1");
        aisle.addRack(rack);
        Assertions.assertTrue(aisle.hasRacks());
    }
    @Test
    public void aisleSetSection(){
        Section section = new Section("Section1");
        Aisle aisle = new Aisle("Aisle 1");
        Aisle aisle1 = new Aisle("Aisle 2");
        section.addAisle(aisle);
        section.addAisle(aisle1);
        aisle.setSection(section);
        aisle1.setSection(section);
        Assertions.assertTrue(aisle1.getSection().equals(section) & section.getAisles()[1].equals(aisle1));
    }
}