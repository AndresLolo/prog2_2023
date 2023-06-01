import uy.edu.um.prog2.adt.BinaryTree.Tree;
import uy.edu.um.prog2.adt.MyLinkedList.LinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {


    @Test
    public void testTree() {
        Tree binaryTreeList = new Tree();
        binaryTreeList.insert(8, "A");
        binaryTreeList.insert(15, "B");
        binaryTreeList.insert(40, "C");
        binaryTreeList.insert(3, "D");
        binaryTreeList.insert(6, "E");
        binaryTreeList.insert(11, "F");

        assertEquals(6,binaryTreeList.size());

        assertEquals("A",binaryTreeList.find(8));
        assertEquals("B",binaryTreeList.find(15));

        LinkedList list = binaryTreeList.inOrder();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        int elementToRemove = 11;
        binaryTreeList.delete(elementToRemove);

        assertEquals(true,binaryTreeList.contains(8));

    }

    @Test
    public void testAddFlujoNormal() {
        Tree<Integer, Integer> oTree = new Tree<>();

        oTree.insert(3, 3);
        oTree.insert(21, 21);
        oTree.insert(11, 11);
        oTree.insert(-1, -1);
        oTree.insert(4, 4);
        oTree.insert(18, 18);

        LinkedList colValues = oTree.inOrder();

        assertEquals(-1, colValues.get(0));
        assertEquals(3, colValues.get(1));
        assertEquals(4, colValues.get(2));
        assertEquals(11, colValues.get(3));
        assertEquals(18, colValues.get(4));
        assertEquals(21, colValues.get(5));
    }

    @Test
    public void testRemoveFlujoNormal() {
        Tree<Integer, Integer> oTree = new Tree<>();

        oTree.insert(3, 3);
        oTree.insert(21, 21);
        oTree.insert(11, 11);
        oTree.insert(-1, -1);
        oTree.insert(4, 4);
        oTree.insert(18, 18);

        oTree.delete(3);
        oTree.delete(-1);
        oTree.delete(18);

        LinkedList colValues = oTree.inOrder();

        assertEquals(4, colValues.get(0));
        assertEquals(11, colValues.get(1));
        assertEquals(21, colValues.get(2));
    }

    @Test
    public void testRemoveFlujoParticular() {
        Tree<Integer, Integer> oTree = new Tree<>();

        oTree.insert(3, 3);
        oTree.insert(-1, -1);
        oTree.insert(4, 4);
        oTree.insert(18, 18);

        oTree.delete(3);
        oTree.delete(-1);
        oTree.delete(18);
        oTree.delete(4);

        LinkedList colValues = oTree.inOrder();

        assertEquals(0, colValues.size());
    }

    @Test
    public void testFindFlujoNormal() {
        Tree<Integer, Integer> oTree = new Tree<>();

        oTree.insert(3, 3);
        oTree.insert(21, 21);
        oTree.insert(11, 11);
        oTree.insert(-1, -1);
        oTree.insert(4, 4);
        oTree.insert(18, 18);

        oTree.delete(3);
        oTree.delete(-1);
        oTree.delete(18);

        Integer oTemp = oTree.find(3);

        assertNull(oTemp);

        oTemp = oTree.find(21);

        assertEquals(21, oTemp.intValue());

    }

    @Test
    public void testContainFlujoNormal() {
        Tree<Integer, Integer> oTree = new Tree<>();

        oTree.insert(3, 3);
        oTree.insert(21, 21);
        oTree.insert(11, 11);
        oTree.insert(-1, -1);
        oTree.insert(4, 4);
        oTree.insert(18, 18);

        assertFalse(oTree.contains(33));
        assertTrue(oTree.contains(-1));
    }

}
