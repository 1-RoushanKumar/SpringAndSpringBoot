package com.__crudDemo_example.crudDemo.controllers;

import com.__crudDemo_example.crudDemo.entity.Book;
import com.__crudDemo_example.crudDemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is a REST controller that handles HTTP requests related to books.
 * It uses Spring's @RestController annotation, which combines @Controller and @ResponseBody,
 * making it suitable for creating RESTful web services.
 */
@RestController
@RequestMapping("/api") // Base URL for all endpoints in this controller
public class BookController {

    private BookService bookService;

    /**
     * Constructor-based dependency injection of BookService.
     * @Autowired is used to automatically inject the required dependency.
     */
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Handle GET requests to retrieve all books.
     * @return a list of all books in the database.
     */
    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    /**
     * Handle GET requests to retrieve a book by its ID.
     * @param bookId The ID of the book to retrieve.
     * @return the book with the specified ID.
     */
    @GetMapping("/books/book_id/{bookId}")
    public Book findById(@PathVariable int bookId) {
        return bookService.findById(bookId);
    }

    /**
     * Handle POST requests to add a new book.
     * The ID is set to 0 to ensure the book is treated as a new entity and not an update.
     * @param book The book object to save.
     * @return the saved book object.
     */
    @PostMapping("/books")
    public Book add(@RequestBody Book book) {
        // Set ID to 0 to enforce a new record creation
        book.setId(0);
        bookService.save(book);
        return book;
    }

    /**
     * Handle PUT requests to update an existing book.
     * The updated book object is passed in the request body.
     * @param updatedBook The book object with updated information.
     * @return the updated book object.
     */
    @PutMapping("/books")
    public Book update(@RequestBody Book updatedBook) {
        bookService.update(updatedBook);
        return updatedBook;
    }

    /**
     * Handle DELETE requests to remove a book by its ID.
     * @param bookId The ID of the book to delete.
     */
    @DeleteMapping("/books/{bookId}")
    public String delete(@PathVariable int bookId) {
        bookService.delete(bookId);
        // Print a message indicating successful deletion
        // This will printed in console.
        // For printing in Postman and webBrowser make it return type string.
        return "Book with ID " + bookId + " has been successfully deleted.";
    }

    /**
     * Handle GET requests to retrieve books by last name.
     * A unique path prefix "last_name" is added to avoid conflicts with other endpoints.
     * @param lastName The last name of the author whose books to retrieve.
     * @return a list of books written by the specified author.
     */
    @GetMapping("/books/last_name/{lastName}")
    public List<Book> findByLastName(@PathVariable String lastName) {
        return bookService.findByLastName(lastName);
    }

    /**
     * Handle GET requests to retrieve books by their release year.
     * A unique path prefix "released_year" is added to avoid conflicts with other endpoints.
     * @param releasedYear The release year of the books to retrieve.
     * @return a list of books released in the specified year.
     */
    @GetMapping("/books/released_year/{releasedYear}")
    public List<Book> findByReleasedYear(@PathVariable int releasedYear) {
        return bookService.findByReleased_Year(releasedYear);
    }
}
