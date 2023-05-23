package BinaryTree.BinaryTree;

import MyList.MyList;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeLinkedListTest {


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

        MyList list = binaryTreeList.inOrder();

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

        MyList<Integer> colValues = oTree.inOrder();

        assertEquals(new Integer(-1), colValues.get(0));
        assertEquals(new Integer(3), colValues.get(1));
        assertEquals(new Integer(4), colValues.get(2));
        assertEquals(new Integer(11), colValues.get(3));
        assertEquals(new Integer(18), colValues.get(4));
        assertEquals(new Integer(21), colValues.get(5));
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

        MyList<Integer> colValues = oTree.inOrder();

        assertEquals(new Integer(4), colValues.get(0));
        assertEquals(new Integer(11), colValues.get(1));
        assertEquals(new Integer(21), colValues.get(2));
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

        MyList<Integer> colValues = oTree.inOrder();

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

        assertEquals(new Integer(21), oTemp);

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



    public static void main(String[] args) {
        // Crear una instancia de tu lista enlazada de árbol binario

        Tree binaryTreeList = new Tree();

        // Agregar elementos al árbol binario
        binaryTreeList.insert(8, "A");
        binaryTreeList.insert(15, "B");
        binaryTreeList.insert(40, "C");
        binaryTreeList.insert(3, "D");
        binaryTreeList.insert(6, "E");
        binaryTreeList.insert(11, "F");
        binaryTreeList.insert(18, "G");
        binaryTreeList.insert(2, "H");
        binaryTreeList.insert(4, "I");
        binaryTreeList.insert(7, "J");
        binaryTreeList.insert(10, "K");
        binaryTreeList.insert(12, "L");
        binaryTreeList.insert(13, "M");
        binaryTreeList.insert(17, "N");
        binaryTreeList.insert(19, "O");



        System.out.println("Cantidad de elementos en el árbol: " + binaryTreeList.size());



        System.out.println("La informacion buscada:"+ binaryTreeList.find(10));


        System.out.println("Árbol en inOrder:");
        MyList list = binaryTreeList.inOrder();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Eliminar un elemento del árbol
        int elementToRemove = 11;
        binaryTreeList.delete(elementToRemove);
        System.out.println("\nÁrbol después de eliminar el elemento " + elementToRemove + ":");
        MyList list2 = binaryTreeList.inOrder();

        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }
        System.out.println( binaryTreeList.contains(9));



    }


}
