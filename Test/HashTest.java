import BinaryHeap.BinaryHeap;
import MyLinkedList.MyList;
import org.junit.Test;
import Hash.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class HashTest {
    @Test
    public void testFlujoNormal() {
        HashImpl hash = new HashImpl(7);

        hash.put(1, "Daniel");
        hash.put(3, "Lola");
        hash.put(4, "Toby");
        hash.put(5, "Siny");


        assertEquals(4, hash.size());

        assertTrue(hash.contains(3));
        assertEquals("Lola", hash.get(3));
        hash.remove(3);

        assertEquals(3, hash.size());

        assertFalse(hash.contains(3));
        assertNull(hash.get(3));




    }
}
