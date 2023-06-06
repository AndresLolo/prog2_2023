package uy.edu.um.prog2.adt.queue;

public interface MyQueue<T> {

    void enqueue(T value);

    T dequeue() throws QueueVacia;

    boolean contains(T value);

    int size();
}
