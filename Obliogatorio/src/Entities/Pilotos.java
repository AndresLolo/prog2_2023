package Entities;

import uy.edu.um.prog2.adt.MyLinkedList.LinkedList;

public class Pilotos {
    private String name;

    private int cantidad;

    public Pilotos(String name, int cantidad) {
        this.name = name;
        this.cantidad = cantidad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void addCantidad(){
        this.cantidad++;
    }
}