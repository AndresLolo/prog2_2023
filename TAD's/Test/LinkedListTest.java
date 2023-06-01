import uy.edu.um.prog2.adt.MyLinkedList.LinkedList;
import uy.edu.um.prog2.adt.MyLinkedList.MyList;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void testFlujoCompleto() {

        MyList list = new LinkedList();

        list.add(4);
        list.add(5);
        list.add(7);
        list.add(2);

        assertEquals(4, list.size());

        assertEquals(4, list.get(0));

        assertEquals(2, list.get(3));

        assertTrue(list.contains(5));

        assertFalse(list.contains(12));

        list.remove(12); // si trata de eliminar un elemento que no existe deja la lista como esta

        assertEquals(4, list.size());

        list.remove(0);
        list.remove(0);
        list.remove(0);

        assertEquals(1, list.size());

        assertNull(list.get(2));

        assertEquals(2, list.get(0));


    }

}
