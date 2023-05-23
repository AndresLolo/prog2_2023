package MyLinkedList;

public interface MyList {
    void add(Object value);
    void remove(int position);
    Object get(int position);
    boolean contains(Object nodo);
    void addFirst(Object value);
    void addLast(Object value);
    int size();
}
