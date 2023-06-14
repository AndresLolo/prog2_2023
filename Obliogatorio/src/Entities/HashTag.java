package Entities;

import uy.edu.um.prog2.adt.MyLinkedList.LinkedList;
import uy.edu.um.prog2.adt.MyLinkedList.MyList;

import java.util.Arrays;
import java.util.Objects;

public class HashTag {
    private String id;
    private String text;




    public HashTag(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
