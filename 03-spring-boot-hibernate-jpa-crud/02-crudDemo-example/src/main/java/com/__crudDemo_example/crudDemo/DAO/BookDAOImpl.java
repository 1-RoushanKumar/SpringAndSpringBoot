package com.__crudDemo_example.crudDemo.DAO;

import com.__crudDemo_example.crudDemo.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO{

    private EntityManager entityManager;

    @Autowired
    public BookDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Book book) {
        entityManager.persist(book);
    }

    @Override
    public Book findById(Integer id) {
        return entityManager.find(Book.class,id);
    }

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> query = entityManager.createQuery("From Book",Book.class);
        List<Book> result = query.getResultList();
        return result;
    }

    @Override
    @Transactional
    public void update(Book book) {
        entityManager.merge(book);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Book theBook = entityManager.find(Book.class,id);
        entityManager.remove(theBook);
    }


    //Using TypedQuery(JPQL), which is different from SqlQuery
    @Override
    public List<Book> findByLastName(String theLastName) {
        TypedQuery<Book> query = entityManager.createQuery(
                "SELECT b FROM Book b WHERE b.authorLastName = :lastName", Book.class);
        query.setParameter("lastName", theLastName);
        return query.getResultList();
    }

    @Override
    public List<Book> findByReleased_Year(int year) {
        TypedQuery<Book> query = entityManager.createQuery(
                "SELECT b FROM Book b WHERE b.releasedYear >= :year", Book.class);
        query.setParameter("year", year);
        return query.getResultList();
    }
}
