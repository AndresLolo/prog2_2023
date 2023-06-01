package uy.edu.um.prog2.adt.BinaryHeap;

public interface MyHeap<T extends Comparable<T>> {
    void insert(T data);
    T deleteMin();
    int size();
    T get();


}
