package com.autorBook.autorBook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autorBook.autorBook.Bean.Book;
import com.autorBook.autorBook.Exception.AlreadyExistException;
import com.autorBook.autorBook.Repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public void addBook(Book book) throws AlreadyExistException {
		List<Book> books = getAllBooks();
		for (Book b : books) {
			if(b.getId() == book.getId() || b.getName().equalsIgnoreCase(book.getName())) {
				throw new AlreadyExistException("Name or Id");
			}
		}
		bookRepository.save(book);
	}
	
	public void updateBook(Book book) {
		bookRepository.saveAndFlush(book);
	}
	
	public void deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
	}
	
	public Book getOneBook(int bookId) {
		return bookRepository.getOne(bookId);
	}
	
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	public List<Book> findBooksByYear(int year){
		return bookRepository.findByYear(year);
	}
	
	public List<Book> findBooksByYearLessThan(int year){
		return bookRepository.findByYearLessThan(year);
	}
}
