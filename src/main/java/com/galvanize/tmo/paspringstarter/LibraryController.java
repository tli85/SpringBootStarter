package com.galvanize.tmo.paspringstarter;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Comparator;
import java.util.List;


@RestController
public class LibraryController {

    //Library Repo
    private LibraryRepo repo = new LibraryRepo();
    private int id = 1;

    @GetMapping("/health")
    public void health() {

    }

    @GetMapping(value="/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String index() {
        return "This is Home page";
    }

    @PostMapping(value = "/api/books")
    public ResponseEntity<Book> addNewBook(@RequestBody Book newBook) {
        Book newAddedBook = new Book(id++, newBook.getAuthor(), newBook.getTitle(), newBook.getPublishingYear());
        repo.save(newAddedBook);
        return new ResponseEntity<>(newAddedBook, HttpStatus.CREATED);
    }

    @GetMapping("/api/books")
    public List<Book> retrieveAll()
    {
        List<Book> books = repo.retrieveAll();
        books.sort(Comparator.comparing(Book::getTitle));
        return books;
    }

    @DeleteMapping(value = "/api/books")
    public ResponseEntity<HttpStatus> deleteAll()
    {
        repo.deleteAll();
        id = 1;
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
