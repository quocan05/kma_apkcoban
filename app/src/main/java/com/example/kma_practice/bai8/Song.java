package com.example.kma_practice.bai8;

public class Song {

    private String name;
    private String author;
    private int link;
    public Song() {
    }

    public Song(String name, String author, int link) {
        this.name = name;
        this.author = author;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getLink() {
        return link;
    }

    public void setLink(int link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", link=" + link +
                '}';
    }
}
