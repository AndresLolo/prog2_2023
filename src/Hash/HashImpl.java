package Hash;

import BinaryTree.BinaryTree.MyTree;

import java.util.Arrays;

public class HashImpl<K,T> implements MyHash<K,T> {
    private int capacity;
    private Node[] table;

    public HashImpl(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
        Arrays.fill(table, null);
    }

    @Override
    public void put(K key, T value) {
        int lugar = key.hashCode() % capacity;
        Node<K, T> node = new Node<>(key, value);
        if (table[lugar] == null || table[lugar].isDeleted()) {
            table[lugar] = node;
        } else {
            int i = 1;
            int newPosition = (key.hashCode() + linearColision(i) % capacity);
            while (table[newPosition] != null && !table[newPosition].isDeleted() && i <= capacity) {
                i++;
                newPosition = (key.hashCode() + linearColision(i) % capacity);

            }
            if (i > capacity) {
                throw new RuntimeException("No hay lugar");
            }
            table[newPosition] = node;
        }

    }

    private int linearColision(int i) {
        return i;
    }


    @Override
    public boolean contains(K key) {
        int lugar = key.hashCode() % capacity;
        if (table[lugar] != null && !table[lugar].isDeleted()) {
            return true;
        }
        return false;
    }

    @Override
    public void remove(K clave) {
        int lugar = clave.hashCode() % capacity;
        if (table[lugar] != null) {
            table[lugar].setDeleted(true);

        }
        else {
            throw new RuntimeException("No existe");
        }

    }

    @Override
    public int size() {
        int contador = 0;
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null && !table[i].isDeleted()) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public T get(K key) {
        int lugar = key.hashCode() % capacity;
        if (table[lugar] != null && !table[lugar].isDeleted()) {
            return (T) table[lugar].getValue();
        }
        return null;
    }
}



