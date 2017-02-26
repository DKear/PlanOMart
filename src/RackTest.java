import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RackTest {

    @Test
    public void getRackNameTest() {
        Rack rack1 = new Rack("rack1");
        Assertions.assertTrue(rack1.getRackName().equals("rack1"));
    }

    @Test
    public void emptyRackNameTest() {
        Rack rack;
        try {
            rack = new Rack("");
            rack.getRackName();
            Assertions.assertFalse(!rack.getRackName().equals(""));

        } catch (IllegalArgumentException e) {
            Assertions.assertTrue(true);

        }
    }

    @Test
    public void hasNoShelfTest() {
        Rack rack = new Rack("testRack");
        Assertions.assertFalse(rack.hasShelves());
    }

    @Test
    public void addShelfTest() {
        Rack rack = new Rack("Rack");
        Shelf shelf = new Shelf(3, 4);
        rack.addShelf(shelf);
        Assertions.assertTrue(rack.getShelf().length == 1);
    }

    @Test
    public void hasShelfTest() {
        Rack rack = new Rack("testRack");
        Shelf shelf = new Shelf(4, 2);
        rack.addShelf(shelf);
        Assertions.assertTrue(rack.hasShelves());
    }

    @Test
    public void removeShelfTest() {
        Rack rack = new Rack("TestRack");
        Shelf shelf = new Shelf(4, 2);
        Shelf shelf_2 = new Shelf(4, 2);
        rack.addShelf(shelf);
        rack.addShelf(shelf_2);
        rack.removeShelf(shelf);
        Assertions.assertTrue(rack.getShelf().length == 1);
    }

    @Test
    public void rackSetAisle(){
    Aisle aisle = new Aisle("Aisle 1");
    Rack rack0 = new Rack("Rack 1");
    Rack rack1 = new Rack ("Rack 2");
        aisle.addRack(rack0);
        aisle.addRack(rack1);
        rack0.setRackToAisle(aisle);
        rack1.setRackToAisle(aisle);
        Assertions.assertTrue(rack1.getRackAisle().equals(aisle) & aisle.getRack()[1].equals(rack1));
}
}