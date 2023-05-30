import static org.junit.Assert.*;

import org.junit.Test;
import MyLinkedList.LinkedList;
import stack.MyStack;

public class StackImplTest {

    @Test
    public void testFlujoCompleto() {

        LinkedList<Integer> colStack = new LinkedList<>();

        colStack.push(new Integer(2));
        colStack.push(new Integer(4));
        colStack.push(new Integer(7));

        assertEquals(new Integer(7), colStack.peek());


            assertEquals(new Integer(7), colStack.pop());

        assertEquals(new Integer(4), colStack.peek());



            assertEquals(new Integer(4), colStack.pop());



            assertEquals(new Integer(2), colStack.pop());



    }

}
