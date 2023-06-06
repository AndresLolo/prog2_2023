package Entities;


import uy.edu.um.prog2.adt.MyLinkedList.LinkedList;
import uy.edu.um.prog2.adt.MyLinkedList.MyList;

public class User {
    private long id;

    private String name;

    private MyList<Tweet> tweets = new LinkedList<>();

    public User(String name, long id) {

        this.name = name;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
