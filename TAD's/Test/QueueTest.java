import static org.junit.Assert.*;

import org.junit.Test;
import uy.edu.um.prog2.adt.MyLinkedList.LinkedList;
import uy.edu.um.prog2.adt.queue.QueueVacia;

public class QueueTest {

    @Test
    public void testFlujoCompleto() throws QueueVacia {
        LinkedList queue = new LinkedList<>();

        queue.enqueue(21);
        queue.enqueue(34);
        queue.enqueue(3);

        assertTrue(queue.contains(21));
        assertEquals(3, queue.size());
        assertEquals(21, queue.dequeue());
        assertFalse(queue.contains(21));

        assertEquals(2, queue.size());

        assertTrue(queue.contains(34));

        assertFalse(queue.contains(18));


        assertEquals(Integer.valueOf(34), queue.dequeue());



        assertEquals(Integer.valueOf(3), queue.dequeue());


    }

}