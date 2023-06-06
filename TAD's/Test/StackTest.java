import static org.junit.Assert.*;

import org.junit.Test;
import uy.edu.um.prog2.adt.MyLinkedList.LinkedList;
import uy.edu.um.prog2.adt.queue.QueueVacia;

public class StackTest {

    @Test
    public void testFlujoCompleto() throws QueueVacia {

        LinkedList<Integer> colStack = new LinkedList<>();

        colStack.push(2);
        colStack.push(4);
        colStack.push(7);

        assertEquals(new Integer(7), colStack.peek());


        assertEquals(new Integer(7), colStack.pop());

        assertEquals(new Integer(4), colStack.peek());



        assertEquals(new Integer(4), colStack.pop());



        assertEquals(new Integer(2), colStack.pop());



    }

}
