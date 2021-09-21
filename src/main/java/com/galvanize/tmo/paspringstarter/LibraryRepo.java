package com.galvanize.tmo.paspringstarter;

import java.util.ArrayList;
import java.util.List;


public class LibraryRepo {

    private List<Book> repository = new ArrayList<>();

    public void save(Book book)
    {
        repository.add(book);
    }

    public List<Book> retrieveAll()
    {
        return repository;
    }

    public void deleteAll()
    {
        repository.clear();
    }
}
