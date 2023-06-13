package Entities;

import uy.edu.um.prog2.adt.MyLinkedList.LinkedList;
import uy.edu.um.prog2.adt.MyLinkedList.MyList;

import java.util.Arrays;
import java.util.Objects;

public class HashTag {
    private String fecha;
    private String text;


    private MyList<Tweet> tweets = new LinkedList<>();

    public HashTag(String fecha, String text) {
        this.fecha = fecha;
        this.text = text;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashTag hashTag = (HashTag) o;
        return Objects.equals(text, hashTag.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
