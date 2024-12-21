package com.__crudDemo_example.crudDemo.service;

import com.__crudDemo_example.crudDemo.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(int theId);

    Book save(Book theBook);

    void deleteById(int theId);

}
