package stack;

import queue.QueueVacia;

public interface MyStack<T> {
    void push(T value);

    T pop() throws QueueVacia;

    T peek();

    int size();

}
