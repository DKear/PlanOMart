import org.junit.Test;
import org.junit.jupiter.api.Assertions;

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
        String name = null;
        Store store;
        try {
            store = new Store(name);

        } catch (NullPointerException e) {
            Assertions.assertTrue(true);
        }

    }


}