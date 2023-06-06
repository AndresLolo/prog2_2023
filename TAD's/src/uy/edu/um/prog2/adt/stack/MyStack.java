package uy.edu.um.prog2.adt.stack;

import uy.edu.um.prog2.adt.queue.QueueVacia;

public interface MyStack<T> {
    void push(T value);

    T pop() throws  QueueVacia;

    T peek();

    int size();

}
