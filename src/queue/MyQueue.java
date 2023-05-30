package queue;

public interface MyQueue<T> {

    void enqueue(T value);

    T dequeue();

    boolean contains(T value);

    int size();
}
