package uy.edu.um.prog2.adt.MyLinkedList;

public interface MyList<T> {
    void add(T value);
    void remove(int position);
    T get(int position);
    boolean contains(T nodo);
    void addFirst(T value);
    void addLast(T value);
    int size();
    T set(int position, T value);
}
