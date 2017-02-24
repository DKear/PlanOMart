import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jamie on 2/23/2017.
 */
class StoreTest {

    @Test
    public void storeNameTest(){
        String name = "store";
        Store store = new Store(name);
        Assertions.assertTrue(store.getStoreName().equals(name));
    }

    @Test
    public void storeInvalidNameTest(){
        String name = null;
        Store store;
        try {
            store = new Store(name);

        }catch (NullPointerException e){
            Assertions.assertTrue(true);
        }


    }



}