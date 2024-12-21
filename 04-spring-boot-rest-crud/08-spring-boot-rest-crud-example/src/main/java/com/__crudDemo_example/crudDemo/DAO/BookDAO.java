package com.__crudDemo_example.crudDemo.DAO;

import com.__crudDemo_example.crudDemo.entity.Book;

import java.util.List;

public interface BookDAO {

    Book save(Book book);

    Book findById(Integer id);

    List<Book> findAll();

    Book update(Book book);

    void delete(Integer id);

    List<Book> findByLastName(String lastName);

    List<Book> findByReleased_Year(int year);
}
