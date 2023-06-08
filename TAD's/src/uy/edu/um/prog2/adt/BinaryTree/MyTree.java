package uy.edu.um.prog2.adt.BinaryTree;

import uy.edu.um.prog2.adt.MyLinkedList.LinkedList;
import uy.edu.um.prog2.adt.Hash.*;



public interface MyTree <K extends Comparable<K>,T>{
    T find(K key);
    void insert (K key, T data);
    void delete (K key);
    int size ();
    LinkedList inOrder();
    LinkedList postorder();
    boolean contains(K key);
}
