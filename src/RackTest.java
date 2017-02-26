import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RackTest {

    @Test
    public void getRackNameTest(){
        Rack rack1 = new Rack("rack1");
        Assertions.assertTrue(rack1.getRackName().equals("rack1"));
    }

    @Test
    public void emptyRackNameTest(){
        Rack rack;
        boolean testRack = false;
        try {
            rack = new Rack("");
        } catch (IllegalArgumentException e) {
            testRack = true;
            Assertions.assertTrue(testRack);
        }
        Assertions.assertTrue(testRack);
    }

    @Test
    public void nullRackNameTest(){
        String name = "";
        Rack rack;
        try{
            rack = new Rack(name);
            rack.getRackName();
            Assertions.assertFalse(!rack.getRackName().equals(""));

        }catch(NullPointerException e){
            Assertions.assertTrue(true);


        }
    }

}