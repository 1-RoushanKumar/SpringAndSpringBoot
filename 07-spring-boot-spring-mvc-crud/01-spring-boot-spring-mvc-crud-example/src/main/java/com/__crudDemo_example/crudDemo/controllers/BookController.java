package com.__crudDemo_example.crudDemo.controllers;

import com.__crudDemo_example.crudDemo.entity.Book;
import com.__crudDemo_example.crudDemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String listBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "BooksDir/list-books"; // Template path
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "BooksDir/book-form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/books/list"; // Corrected path
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int bookId, Model model) {
        Book book = bookService.findById(bookId);
        model.addAttribute("book", book);
        return "BooksDir/book-form";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId") int bookId) {
        bookService.deleteById(bookId);
        return "redirect:/books/list"; // Corrected path
    }
}

