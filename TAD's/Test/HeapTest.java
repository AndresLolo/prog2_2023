import uy.edu.um.prog2.adt.BinaryHeap.BinaryHeap;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {



        @Test
        public void testHeapMin() {
            BinaryHeap heapMin = new BinaryHeap();

            heapMin.insert(150);
            heapMin.insert(15);
            heapMin.insert(2);
            heapMin.insert(200);
            heapMin.insert(17);

            assertEquals(5, heapMin.size());

            assertEquals(new Integer(2), heapMin.get());
            assertEquals(new Integer(2), heapMin.deleteMin());

            assertEquals(new Integer(15), heapMin.get());
            assertEquals(new Integer(15), heapMin.deleteMin());

            assertEquals(new Integer(17), heapMin.get());
            assertEquals(new Integer(17), heapMin.deleteMin());

            assertEquals(new Integer(150), heapMin.get());
            assertEquals(new Integer(150), heapMin.deleteMin());

            assertEquals(new Integer(200), heapMin.get());
            assertEquals(new Integer(200), heapMin.deleteMin());

            assertEquals(0, heapMin.size());
        }

    }




