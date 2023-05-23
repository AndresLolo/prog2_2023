package BinaryTree.BinaryTree;

import MyList.MyList;


public interface MyTree <K extends Comparable<K>,T>{
    T find(K key);
    void insert (K key, T data);
    void delete (K key);
    int size ();
    MyList<K> inOrder();
    boolean contains(K key);
}
