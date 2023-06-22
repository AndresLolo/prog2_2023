package Entities;


import uy.edu.um.prog2.adt.MyLinkedList.LinkedList;
import uy.edu.um.prog2.adt.MyLinkedList.MyList;
import uy.edu.um.prog2.adt.Hash.*;

public class User implements Comparable<User>{
    private long id;

    private String name;

    private boolean verificado;
    private int cantidadTweets;
    private int favorito;

    private int lugar;
    private MyList<Tweet> tweets;;

    public User(long id, String name, boolean verificado, int cantidadTweets, int lugar) {
        this.tweets = new LinkedList<>();
        this.name = name;
        this.id = id;
        this.verificado = verificado;
        this.cantidadTweets = cantidadTweets;
        this.favorito = 0;
        this.lugar = lugar;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
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
        this.cantidadTweets++;
        this.favorito += tweet.getFavoritos();
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public int getCantidadTweets() {
        return cantidadTweets;
    }

    public void setCantidadTweets(int cantidadTweets) {
        this.cantidadTweets = cantidadTweets;
    }

    @Override
    public int compareTo(User o) {
        Integer a = this.cantidadTweets;
        Integer b = o.getCantidadTweets();
        return a.compareTo(b);
    }
}