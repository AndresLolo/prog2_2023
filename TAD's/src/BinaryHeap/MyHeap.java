package BinaryHeap;

public interface MyHeap<T extends Comparable<T>> {
    void insert(T data);
    T deleteMin();
    int size();
    T get();


}
