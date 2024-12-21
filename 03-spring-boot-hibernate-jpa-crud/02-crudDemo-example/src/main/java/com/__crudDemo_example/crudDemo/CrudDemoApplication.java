package com.__crudDemo_example.crudDemo;

import com.__crudDemo_example.crudDemo.DAO.BookDAO;
import com.__crudDemo_example.crudDemo.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(BookDAO bookDAO) {
		return runner -> {

//			createBook(bookDAO);

//			readBook(bookDAO,20);

//			getAllBooks(bookDAO);

//			updateBook(bookDAO);

//			deleteBook(bookDAO);

//			bookByLastName(bookDAO);

			bookByReleasedYear(bookDAO);

		};
	}

	private void bookByReleasedYear(BookDAO bookDAO) {
		List<Book> booksByReleasedYear = bookDAO.findByReleased_Year(2000);
        System.out.println("Books released after 1999: ");
        for (Book book : booksByReleasedYear) {
            System.out.println(book);
        }
	}

	private void bookByLastName(BookDAO bookDAO) {
		List<Book> booksByLastName = bookDAO.findByLastName("Harris");
		System.out.println("Books by Harris: ");
		for (Book book : booksByLastName) {
			System.out.println(book);
		}
	}


	private void deleteBook(BookDAO bookDAO) {
		int bookId = 20;
		System.out.println("Deleting book with id " + bookId);
		bookDAO.delete(bookId);
		System.out.println("Book deleted!!!");

	}

	private void updateBook(BookDAO bookDAO) {
		int bookId = 20;
		System.out.println("Getting book with id " + bookId);
		Book myBook = bookDAO.findById(bookId);

		System.out.println("Updating book with id " + bookId);
		myBook.setStockQuantity(50);
		bookDAO.update(myBook);

		System.out.println("Updated Book: "+myBook);
	}

	private void getAllBooks(BookDAO bookDAO) {
		List<Book> theBooks = bookDAO.findAll();
		for (Book book : theBooks) {
			System.out.println(book);
		}
	}

	private void readBook(BookDAO bookDAO ,int theId) {
		System.out.println("Fetching book by id: "+theId);
		Book book = bookDAO.findById(theId);
		System.out.println("Found the book: "+book);
	}

	private void createBook(BookDAO bookDAO) {
		System.out.println("Adding new book object...");
		Book book = new Book("The Great Gatsby","F. Scott","Fitzgerald",1925,25,180);

		System.out.println("Saving the book...");
		bookDAO.save(book);

		System.out.println("Saved book Generated id: "+book.getId());
	}

}
