import org.junit.Test;
import uy.edu.um.prog2.adt.Hash.*;
import uy.edu.um.prog2.adt.Hash.HashImpl;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class HashTest {
    @Test
    public void testFlujoNormal() {
        HashImpl hash = new HashImpl(2);

        hash.put(1, "Daniel");
        hash.put(3, "pedro");
        hash.put(3, "Toby");
        hash.put(2, "Lola");
        hash.put(11, "Siny");

        assertEquals(4, hash.size());

        assertTrue(hash.contains(3));
        assertEquals("Toby", hash.get(3));
        hash.remove(3);

        assertEquals(3, hash.size());

        assertFalse(hash.contains(3));
        assertNull(hash.get(3));

        assertTrue(hash.contains(11));
        assertEquals("Siny", hash.get(11));

    }
}
