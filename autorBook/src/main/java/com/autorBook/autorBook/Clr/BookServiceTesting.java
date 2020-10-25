package com.autorBook.autorBook.Clr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.autorBook.autorBook.Bean.Book;
import com.autorBook.autorBook.Service.BookService;
import com.autorBook.autorBook.util.SpringTable;

@Component
@Order(2)
public class BookServiceTesting implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	@Override
	public void run(String... args) throws Exception {

		Book bb1 = new Book("Java Script", 2020);
		Book bb2 = new Book("Python", 2018);
		Book bb3 = new Book("C++", 2003);
		Book bb4 = new Book("Web", 2019);

		System.out.println("----------- add book -----------");
		try {
			bookService.addBook(bb1);
			bookService.addBook(bb2);
			bookService.addBook(bb3);
			bookService.addBook(bb4);
			SpringTable.print(bookService.getAllBooks());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("----------- add book not work -----------");
		try {
			bookService.addBook(bb1);
			SpringTable.print(bookService.getAllBooks());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("----------- update book -----------");
		try {
			bb2.setYear(2017);
			bookService.updateBook(bb2);
			SpringTable.print(bookService.getOneBook(2));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("----------- update book not work -----------");
		try {
			bb3.setId(33);;
			bookService.updateBook(bb3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("----------- delete book -----------");
		bookService.deleteBook(4);
		System.out.println("----------- get one book -----------");
		SpringTable.print(bookService.getOneBook(2));
		System.out.println("----------- get all books -----------");
		SpringTable.print(bookService.getAllBooks());
		System.out.println("----------- get all books by year -----------");
		SpringTable.print(bookService.findBooksByYear(2020));
		System.out.println("----------- get all books by year less than -----------");
		SpringTable.print(bookService.findBooksByYearLessThan(2019));
	}

}
