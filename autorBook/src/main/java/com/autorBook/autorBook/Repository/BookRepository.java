package com.autorBook.autorBook.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autorBook.autorBook.Bean.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	public List<Book> findByYear(int year);
	
	public List<Book> findByYearLessThan(int year);
}
