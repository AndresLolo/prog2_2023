package uy.edu.um.prog2.adt.queue;

public interface MyPrioridadQueue <T> extends MyQueue<T> {

    void enqueueConPrioridad(T element, int priority);
}
