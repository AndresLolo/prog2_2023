package Entities;

import uy.edu.um.prog2.adt.MyLinkedList.LinkedList;
import uy.edu.um.prog2.adt.MyLinkedList.MyList;

import java.util.Objects;


public class Tweet {
    private long id;
    private String content;
    private String source;
    private String fecha;
    private boolean is_retweet;

    private MyList<HashTag> HashTags = new LinkedList<>();

    public Tweet(long id, String content, String source,String fecha,  boolean is_retweet, MyList<HashTag> HashTags) {
        this.id = id;
        this.content = content;
        this.source = source;
        this.fecha = fecha;
        this.is_retweet = is_retweet;
        this.HashTags = HashTags;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isIs_retweet() {
        return is_retweet;
    }

    public void setIs_retweet(boolean is_retweet) {
        this.is_retweet = is_retweet;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public MyList<HashTag> getHashTags() {
        return HashTags;
    }

    public void setHashTags(MyList<HashTag> hashTags) {
        HashTags = hashTags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet = (Tweet) o;
        return Objects.equals(content, tweet.content);
    }


}
