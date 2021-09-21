package com.galvanize.tmo.paspringstarter;

public class Book {

    private int id;
    String author;
    String title;
    int yearPublished;

    Book(int id, String author, String title, int yearPublished) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.yearPublished = yearPublished;
    }

    public int getId() {return id; }

    public String getAuthor() {return author; }

    public String getTitle() {return title; }

    public int getYearPublished() {return yearPublished; }
}
