package BinaryHeap;

import MyLinkedList.LinkedList;
import MyLinkedList.MyList;

public class BinaryHeap<T extends Comparable<T>> implements MyHeap<T>{
    private MyList<T> heap;
    private int size;

    public BinaryHeap() {
        heap = new LinkedList<>();
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(T value) {
        heap.add(value);
        size++;
        heapifyUp(size - 1);
    }
    @Override
    public T deleteMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        T min = heap.get(0);
        T lastElement = heap.get(size - 1);
        heap.set(0, lastElement);
        heap.remove(size - 1);
        size--;
        heapifyDown(0);

        return min;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        return heap.get(0);
    }
    //funcion que elimina el maximo



    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap.get(index).compareTo(heap.get(parent)) < 0) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;

        if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }

        if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }





}

