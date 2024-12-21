package com.__crudDemo_example.crudDemo.controllers;

import com.__crudDemo_example.crudDemo.entity.Book;
import com.__crudDemo_example.crudDemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService theBookService) {
        bookService = theBookService;
    }

    // Retrieve all books
    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    // Retrieve a book by ID
    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable int bookId) {
        Book theBook = bookService.findById(bookId);
        if (theBook == null) {
            throw new RuntimeException("Book not found for ID - " + bookId);
        }
        return theBook;
    }

    // Add a new book
    @PostMapping("/books")
    public Book addBook(@RequestBody Book theBook) {
        theBook.setId(0); // Force creation of a new book
        Book thebook = bookService.save(theBook);
        return thebook;
    }

    // Update an existing book
    @PutMapping("/books")
    public Book updateBook(@RequestBody Book theBook) {
        Book thebook = bookService.save(theBook);
        return thebook;
    }

    // Delete a book by ID
    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable int bookId) {
        Book thebook = bookService.findById(bookId);

        if (thebook == null) {
            throw new RuntimeException("Book id not found - " + bookId);
        }
        bookService.deleteById(bookId);
        return "Deleted book with ID - " + bookId;
    }

    // Retrieve books by last name
    @GetMapping("/books/last_name/{lastName}")
    public List<Book> findByLastName(@PathVariable String lastName) {
        return bookService.findBy_LastName(lastName);
    }

    // Retrieve books by release year
    @GetMapping("/books/released_year/{releasedYear}")
    public List<Book> findByReleasedYear(@PathVariable int releasedYear) {
        return bookService.findByReleased_Year(releasedYear);
    }
}
