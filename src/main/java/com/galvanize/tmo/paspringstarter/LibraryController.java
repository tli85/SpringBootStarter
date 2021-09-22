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
    private BooksRepo repo = new BooksRepo();
    private int id = 1;

    @GetMapping("/health")
    public void health() {

    }

    @GetMapping(value="/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String index() {
        return "This is Home page";
    }

    @PostMapping("/api/books")
    public ResponseEntity<Book> addNewBook(@RequestBody Book newBook) {
        Book newAddedBook = new Book(id++, newBook.getAuthor(), newBook.getTitle(), newBook.getYearPublished());
        repo.addBook(newAddedBook);
        return new ResponseEntity<>(newAddedBook, HttpStatus.CREATED);
    }

    @GetMapping("/api/books")
    public BooksRepo getBooks()
    {
        List<Book> books = repo.getBooks();
        books.sort(Comparator.comparing(Book::getTitle));
        return repo;
    }

    @DeleteMapping("/api/books")
    public ResponseEntity<HttpStatus> removeBooks()
    {
        repo.clear();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
