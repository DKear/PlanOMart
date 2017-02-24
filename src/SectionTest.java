import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jamie on 2/24/2017.
 */
class SectionTest {
    @Test
    public void sectionNameTest(){
        String name = "store";
        Store store = new Store(name);
        Assertions.assertTrue(store.getStoreName().equals(name));
    }
}