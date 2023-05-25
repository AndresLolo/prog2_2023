import BinaryHeap.BinaryHeap;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeapImplTest {

    @Test
    public void testHeapMin() {
        BinaryHeap heapMax = new BinaryHeap();

        heapMax.insert(150);
        heapMax.insert(15);
        heapMax.insert(2);
        heapMax.insert(200);
        heapMax.insert(17);

        assertEquals(5, heapMax.size());

        assertEquals(new Integer(2), heapMax.get());
        assertEquals(new Integer(2), heapMax.deleteMin());

        assertEquals(new Integer(15), heapMax.get());
        assertEquals(new Integer(15), heapMax.deleteMin());

        assertEquals(new Integer(17), heapMax.get());
        assertEquals(new Integer(17), heapMax.deleteMin());

        assertEquals(new Integer(150), heapMax.get());
        assertEquals(new Integer(150), heapMax.deleteMin());

        assertEquals(new Integer(200), heapMax.get());
        assertEquals(new Integer(200), heapMax.deleteMin());

        assertEquals(0, heapMax.size());
    }





        @Test
        public void testInsertAndDeleteMin() {
            BinaryHeap heap = new BinaryHeap();

            assertTrue(heap.isEmpty());

            heap.insert(5);
            heap.insert(3);
            heap.insert(8);
            heap.insert(1);
            heap.insert(6);
            assertFalse(heap.isEmpty());

            assertEquals(1, heap.deleteMin());
            assertEquals(3, heap.deleteMin());
            assertEquals(5, heap.deleteMin());
            assertEquals(6, heap.deleteMin());
            assertEquals(8, heap.deleteMin());

            assertTrue(heap.isEmpty());
        }

    }




