package com.__crudDemo_example.crudDemo.DAO;

import com.__crudDemo_example.crudDemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    // We don't need to implement standard methods like save, findAll, and findById,
    // because they are already provided by JpaRepository.
    // However, when we need to add custom methods that are not present in JpaRepository,
    // we need to define custom queries using @Query.

    // Custom query to find books by author's last name.
    // This query retrieves a list of books where the author's last name matches the provided parameter.
    @Query("SELECT b FROM Book b WHERE b.authorLastName = :lastName")
    List<Book> findByLastName(@Param("lastName") String lastName);

    // Custom query to find books by release year.
    // This query retrieves books that were released on or after the provided year.
    @Query("SELECT b FROM Book b WHERE b.releasedYear >= :year")
    List<Book> findByReleasedYear(@Param("year") int year);
}
