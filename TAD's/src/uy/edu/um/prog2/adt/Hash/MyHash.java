package uy.edu.um.prog2.adt.Hash;

import Entities.Tweet;

public interface MyHash<K,T> {
    public void put(K key, T value);
    public boolean contains(K key);
    public void remove(K clave);
    public int size();
    public T get(K key);
    public boolean containsValue(T value);



}
