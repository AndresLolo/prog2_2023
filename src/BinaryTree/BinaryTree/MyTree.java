package BinaryTree.BinaryTree;

import MyLinkedList.LinkedList;


public interface MyTree <K extends Comparable<K>,T>{
    T find(K key);
    void insert (K key, T data);
    void delete (K key);
    int size ();
    LinkedList inOrder();
    boolean contains(K key);
}
