package uy.edu.um.prog2.adt.Hash;



public class HashImpl<K,T> implements MyHash<K,T> {
    private int capacity;
    private Node[] table;



    public HashImpl(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
        arrayfill();
    }
    //llenar el array con nulls pero son usar la bilbioteca de java
    private void arrayfill(){
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }

    }

    @Override
    public void put(K key, T value) {
        int lugar = key.hashCode() % capacity;
        Node<K, T> node = new Node<>(key, value);
        if (table[lugar] == null || table[lugar].isDeleted()) {
            table[lugar] = node;
        } else {
            int i = 1;
            int newPosition = ((key.hashCode() + linearColision(i)) % capacity);
            while (table[newPosition] != null && !table[newPosition].isDeleted() && i <= capacity) {
                if (table[newPosition].getKey().equals(key)) {
                    table[newPosition].setValue(value);
                    return;
                }
                i++;
                newPosition = ((key.hashCode() + linearColision(i)) % capacity);

            }
            if (i > capacity) {
                doubleSize();
            }
            if(table[newPosition] == null || table[newPosition].isDeleted()) {
                table[newPosition] = node;
            } else{
                this.put(key, value);
            }
        }

    }
    //double the size of the table and rehash all the elements
    private void doubleSize() {
        capacity *= 2;
        Node[] oldTable = table;
        table = new Node[capacity];
        arrayfill();
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                put((K) oldTable[i].getKey(), (T) oldTable[i].getValue());
            }
        }
    }
    private int linearColision(int i) {
        return i;
    }


    @Override
    public boolean contains(K key) {
        int lugar = key.hashCode() % capacity;
        int i = 1;
        if(table[lugar] == null){
            return false;
        }
        else
        if(table[lugar].getKey().equals(key)){
            if(table[lugar].isDeleted()){
                return false;
            }
            else {
                return true;
            }
        }
        else{
            int newPosition = ((key.hashCode() + linearColision(i)) % capacity);
            while (i <= capacity && table[newPosition] != null && !table[newPosition].isDeleted() && !table[newPosition].getKey().equals(key)) {
                i++;
                newPosition = ((key.hashCode() + linearColision(i)) % capacity);
            }
            if (i <= capacity && table[newPosition].getKey().equals(key) && !table[newPosition].isDeleted()) {
                return true;
            }
            else{
                return false;
            }
        }
    }
// funcion que elimina un elemento de la tabla segun la key que tiene
    @Override
    public void remove(K clave) {
        int lugar = clave.hashCode() % capacity;
        if (table[lugar] != null && table[lugar].getKey().equals(clave)) {
            table[lugar].setDeleted(true);
        } else {
            int i = 1;
            int newPosition = ((clave.hashCode() + linearColision(i)) % capacity);
            while (table[newPosition] != null && !table[newPosition].isDeleted() && !table[newPosition].getKey().equals(clave) && i <= capacity) {
                i++;
                newPosition = ((clave.hashCode() + linearColision(i)) % capacity);
            }
            if (i <= capacity) {
                table[newPosition].setDeleted(true);
            }
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
        int i = 1;
        if(table[lugar] == null){
            return null;
        }
        else
        if(table[lugar].getKey().equals(key)){
            if(table[lugar].isDeleted()){
                return null;
            }
            else {
                return (T) table[lugar].getValue();
            }
        }
        else {
            int newPosition = ((key.hashCode() + linearColision(i)) % capacity);
            while (i <= capacity && table[newPosition] != null && !table[newPosition].isDeleted() && !table[newPosition].getKey().equals(key)) {
                i++;
                newPosition = ((key.hashCode() + linearColision(i)) % capacity);
            }
            if (table[newPosition] == null || table[newPosition].isDeleted()) {
                return null;
            }

            return (T) table[newPosition].getValue();
        }
    }



}



