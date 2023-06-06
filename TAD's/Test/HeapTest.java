import uy.edu.um.prog2.adt.BinaryHeap.BinaryHeap;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {



        @Test
        public void testHeapMin() {
            BinaryHeap heapMin = new BinaryHeap(true);

            heapMin.insert(150);
            heapMin.insert(15);
            heapMin.insert(2);
            heapMin.insert(200);
            heapMin.insert(17);

            assertEquals(5, heapMin.size());

            assertEquals(2, heapMin.get());
            assertEquals(2, heapMin.delete());

            assertEquals(15, heapMin.get());
            assertEquals(15, heapMin.delete());

            assertEquals(17, heapMin.get());
            assertEquals(17, heapMin.delete());

            assertEquals(150, heapMin.get());
            assertEquals(150, heapMin.delete());

            assertEquals(200, heapMin.get());
            assertEquals(200, heapMin.delete());

            assertEquals(0, heapMin.size());
        }
    @Test
    public void testHeapMax() {
        BinaryHeap heapMax = new BinaryHeap(false);

        heapMax.insert(150);
        heapMax.insert(15);
        heapMax.insert(2);
        heapMax.insert(200);
        heapMax.insert(17);

        assertEquals(5, heapMax.size());

        assertEquals(200, heapMax.get());
        assertEquals(200, heapMax.delete());

        assertEquals(150, heapMax.get());
        assertEquals(150, heapMax.delete());

        assertEquals(17, heapMax.get());
        assertEquals(17, heapMax.delete());

        assertEquals(15, heapMax.get());
        assertEquals(15, heapMax.delete());

        assertEquals(2, heapMax.get());
        assertEquals(2, heapMax.delete());

        assertEquals(0, heapMax.size());



    }


}




