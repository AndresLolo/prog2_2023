package uy.edu.um.prog2.adt.MyLinkedList;

import uy.edu.um.prog2.adt.queue.*;
import uy.edu.um.prog2.adt.stack.*;


public class LinkedList<T> implements MyList<T>, MyQueue<T>, MyStack<T> {
    private Nodo<T> first;
    private Nodo<T> last;
    @Override
    public void add(T value) {
        if (this.first == null){
            this.first = new Nodo<>(value);
            this.last = this.first;
        }else{
            Nodo<T> temp = this.first;
            while(temp.getNext()!= null){

                temp = temp.getNext();

            }
            Nodo<T> newNode = new Nodo<>(value);
            temp.setNext(newNode);
            this.last = newNode;

        }
    }

    @Override
    public T get(int position) {
        int i = 0;
        Nodo<T> temp = this.first;
        while(i < position){
            temp = temp.getNext();
            if (temp == null){
                return null;
            }
            i++;
        }
        return temp.getValue();
    }

    @Override
    public void enqueue(T value) {
        addFirst(value);
    }

    @Override
    public T dequeue() throws QueueVacia {
        if (this.first == null){
            throw new QueueVacia();
        }
        T borrador = this.last.getValue();
        remove(size()-1);
        return borrador;
    }

    @Override
    public boolean contains(T nodo) {
        Nodo<T> temp = this.first;
        int i = 0;
        while(temp != null){
            if(nodo != get(i)){
                temp = temp.getNext();
                i++;
            }else{
                return true;
            }
        }
        return false;
    }

    @Override
    public void addFirst(T value) {
        Nodo<T> temp = this.first;
        Nodo<T> nuevo = new Nodo<>(value);
        if (this.first == null){
            this.first = nuevo;
            this.last = nuevo;
        }else {

            nuevo.setNext(this.first);
            this.first = nuevo;
        }

        this.first.setNext(temp);;
    }


    @Override
    public void addLast(T value) {
        add(value);
    }

    @Override
    public void push(T value) {
        addLast(value);
    }

    @Override
    public T pop() throws QueueVacia {

        return dequeue();
    }

    @Override
    public T peek() {
        return get(size()-1);
    }

    @Override
    public int size() {
        Nodo<T> temp = this.first;
        int tamaño = 1;
        if (temp == null){
            return 0;
        }
        while(temp.getNext()!= null){
            tamaño++;
            temp = temp.getNext();

        }
        return tamaño;
    }

    @Override
    public T set(int position, T value) {
        int i = 0;
        Nodo<T> temp = this.first;
        while(i < position){
            temp = temp.getNext();
            if (temp == null){
                return null;
            }
            i++;
        }
        temp.setValue(value);
        return temp.getValue();
    }

    @Override
    public void remove(int position) {
        int i = 0;
        Nodo<T> temp = this.first;
        if (get(position) != null) {
            if (position != 0) {
                while (i < position - 1) {
                    temp = temp.getNext();
                    i++;
                }
                if (temp.getNext().getNext() != null) {
                    temp.setNext(temp.getNext().getNext());
                } else {
                    temp.setNext(null);
                    this.last = temp;
                }
            } else {

                this.first = temp.getNext();
                temp.setValue(null);
            }
        }


    }

    public LinkedList(){

        this.first = null;
        this.last = null;
    }

}
