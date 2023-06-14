package Entities;


import uy.edu.um.prog2.adt.MyLinkedList.LinkedList;
import uy.edu.um.prog2.adt.MyLinkedList.MyList;
import uy.edu.um.prog2.adt.Hash.*;

public class User {
    private long id;

    private String name;

    private MyList<Tweet> tweets;;

    public User(long id, String name) {
        this.tweets = new LinkedList<>();
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

    public MyList<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(MyList<Tweet> tweets) {
        this.tweets = tweets;
    }

    public void puttweet(Tweet tweet) {
        this.tweets.add(tweet);
    }
}
