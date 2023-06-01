package uy.edu.um.prog2.adt.BinaryTree;

import uy.edu.um.prog2.adt.MyLinkedList.LinkedList;


public class Tree<K extends Comparable<K>,T> implements MyTree<K,T> {

    private Node<K,T> root;

    //FUNCION QUE HAGA UN FIND DE UN BINARY TREE
    @Override
    public T find(K key) { //key es el numero que busco
        Node<K,T> currentNode = this.root; //root es el nodo raiz
        while (currentNode != null){
            if (currentNode.key.equals(key)){ //equals es para comparar objetos
                return currentNode.data;
            }else if (currentNode.key.compareTo(key) > 0){ //si es mayor a 0, entonces es mayor
                currentNode = currentNode.leftChild;
            }else{
                currentNode = currentNode.rightChild;
            }
        }
        if (currentNode == null){
            return null;
        }
        return currentNode.data;
    }
    //funcion que inserte y ordene los nodos
    @Override
    public void insert(K key, T data) {
        Node<K,T> newNode = new Node<>(key, data);
        if (this.root == null){
            this.root = newNode;
        }else{
            Node<K,T> currentNode = this.root;
            Node<K,T> parentNode = null;
            while (currentNode != null){
                parentNode = currentNode;
                if (currentNode.key.compareTo(key) > 0){
                    currentNode = currentNode.leftChild;
                }else{
                    currentNode = currentNode.rightChild;
                }
            }
            if (parentNode.key.compareTo(key) > 0){
                parentNode.leftChild = newNode;
            }else{
                parentNode.rightChild = newNode;
            }
        }


    }


    //funcion que elimine un nodo
    @Override
    public void delete(K key) {
        Node<K,T> currentNode = this.root;
        Node<K,T> parentNode = null;
        while (currentNode != null){
            if (currentNode.key.equals(key)){
                if (currentNode.leftChild == null && currentNode.rightChild == null){
                    if (parentNode == null){
                        this.root = null;
                    }else if (parentNode.leftChild == currentNode){
                        parentNode.leftChild = null;
                    }else{
                        parentNode.rightChild = null;
                    }
                }else if (currentNode.leftChild == null){
                    if (parentNode == null){
                        this.root = currentNode.rightChild;
                    }else if (parentNode.leftChild == currentNode){
                        parentNode.leftChild = currentNode.rightChild;
                    }else{
                        parentNode.rightChild = currentNode.rightChild;
                    }
                }else if (currentNode.rightChild == null){
                    if (parentNode == null){
                        this.root = currentNode.leftChild;
                    }else if (parentNode.leftChild == currentNode){
                        parentNode.leftChild = currentNode.leftChild;
                    }else{
                        parentNode.rightChild = currentNode.leftChild;
                    }
                }else{
                    Node<K,T> minNode = currentNode.rightChild;
                    Node<K,T> minNodeParent = currentNode;
                    while (minNode.leftChild != null){
                        minNodeParent = minNode;
                        minNode = minNode.leftChild;
                    }
                    currentNode.key = minNode.key;
                    currentNode.data = minNode.data;
                    if (minNodeParent.leftChild == minNode){
                        minNodeParent.leftChild = minNode.rightChild;
                    }else{
                        minNodeParent.rightChild = minNode.rightChild;
                    }
                }
                return;
            }else if (currentNode.key.compareTo(key) > 0){
                parentNode = currentNode;
                currentNode = currentNode.leftChild;
            }else{
                parentNode = currentNode;
                currentNode = currentNode.rightChild;
            }
        }

    }

//funcion que cuente el numero de nodos
    @Override
    public int size() {
        return contador(this.root);

    }


    public int contador(Node<K,T> currentNode){
        if(currentNode == null) {
            return 0;
        }else{
            int leftSize = contador(currentNode.leftChild);
            int rightSize = contador(currentNode.rightChild);
            return leftSize + rightSize + 1;
        }
    }





    //funcion que realice el recorrido del arbol en orden (izquierda, raiz, derecha)
    @Override
    public LinkedList inOrder() {
        LinkedList<K> list = new LinkedList<>();
        Node<K,T> currentNode = this.root;
        while (currentNode != null){
            if (currentNode.leftChild == null){
                list.add(currentNode.key);
                currentNode = currentNode.rightChild;
            }else{
                Node<K,T> predecesor = currentNode.leftChild;
                while (predecesor.rightChild != null && predecesor.rightChild != currentNode){
                    predecesor = predecesor.rightChild;
                }
                if (predecesor.rightChild == null){
                    predecesor.rightChild = currentNode;
                    currentNode = currentNode.leftChild;
                }else{
                    predecesor.rightChild = null;
                    list.add(currentNode.key);
                    currentNode = currentNode.rightChild;
                }
            }
        }

        return list;

    }

    @Override
    public boolean contains(K key) {
        return contains(this.root, key);

    }

    private boolean contains(Node<K,T> currentNode, K key){
        if (currentNode == null){
            return false;
        }else if (currentNode.key.equals(key)){
            return true;
        }else if (currentNode.key.compareTo(key) > 0){
            return contains(currentNode.leftChild, key);
        }else{
            return contains(currentNode.rightChild, key);
        }
    }

}

