package com.galvanize.tmo.paspringstarter;

import java.util.ArrayList;
import java.util.List;

public class BooksRepo {
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void clear() {
        books.clear();
    }
}