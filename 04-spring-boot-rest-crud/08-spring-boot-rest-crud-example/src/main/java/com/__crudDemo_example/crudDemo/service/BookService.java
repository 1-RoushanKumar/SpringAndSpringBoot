package com.__crudDemo_example.crudDemo.service;

import com.__crudDemo_example.crudDemo.entity.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);

    Book findById(Integer id);

    List<Book> findAll();

    Book update(Book book);

    void delete(Integer id);

    List<Book> findByLastName(String lastName);

    List<Book> findByReleased_Year(int year);
}
