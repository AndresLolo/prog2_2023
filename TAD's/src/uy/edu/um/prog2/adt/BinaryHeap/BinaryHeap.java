package uy.edu.um.prog2.adt.BinaryHeap;


public class BinaryHeap<T extends Comparable<T>> implements MyHeap<T> {
    private T[] heap;
    private int size;
    private static final int CAPACITY = 2;
    private boolean isHeapMin = true;


    public BinaryHeap(boolean isHeapMin) {

        heap = (T[]) new Comparable[CAPACITY];
        size = 0;
        this.isHeapMin = isHeapMin;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(T value) {
        if (size == heap.length-1) {
            doubleSize();
        }

        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    public T delete() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        T min = (T) heap[0];
        heap[0] = heap[size - 1];
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

        return (T) heap[0];
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && comparar((T) heap[index],(T) heap[parent]) < 0) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;

        if (left < size && comparar((T)heap[left],(T) heap[smallest]) < 0) {
            smallest = left;
        }

        if (right < size &&  comparar((T)heap[right],(T) heap[smallest]) < 0) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }
    private void doubleSize() {
        T[] old = heap;
        heap = (T[]) new Comparable[heap.length * 2];
        System.arraycopy(old, 0, heap, 0, size);
    }

    private void swap(int i, int j) {
        Object temp = heap[i];
        heap[i] = heap[j];
        heap[j] = (T) temp;
    }
    private int comparar(T a, T b){
        if(isHeapMin){
            return a.compareTo(b);
        }else{
            return (a.compareTo(b))*(-1);
        }
    }


}