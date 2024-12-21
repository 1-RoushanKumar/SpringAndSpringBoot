package com.__crudDemo_example.crudDemo.service;

import com.__crudDemo_example.crudDemo.DAO.BookDAO;
import com.__crudDemo_example.crudDemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDAO bookDao;

    @Autowired
    public BookServiceImpl(BookDAO theEntityManager) {
        bookDao = theEntityManager;
    }


    @Override
    public Book save(Book book) {
        bookDao.save(book);
        return book;
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookDao.findById(id);
    }

    @Override
    public void delete(Integer id) {
        bookDao.delete(id);
    }

    @Override
    public Book update(Book book) {
        bookDao.update(book);
        return book;
    }

    @Override
    public List<Book> findByLastName(String lastName) {
        return bookDao.findByLastName(lastName);
    }

    @Override
    public List<Book> findByReleased_Year(int year) {
        return bookDao.findByReleased_Year(year);
    }
}
