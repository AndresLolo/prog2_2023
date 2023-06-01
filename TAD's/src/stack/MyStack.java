package stack;

import queue.QueueVacia;

public interface MyStack<T> {
    void push(T value);

    T pop();

    T peek();

    int size();

}
