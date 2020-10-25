package com.autorBook.autorBook.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.autorBook.autorBook.Exception.AlreadyExistException;
import com.autorBook.autorBook.Exception.OperationNotAllowedException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "autors")
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH} , orphanRemoval = true )
	private List<Book> books = new ArrayList<>();
	
	public Autor(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setId(int id) throws OperationNotAllowedException {
		throw new OperationNotAllowedException("Change Id");
	}
	
	public void addBook(Book book) throws AlreadyExistException {
		for (Book b : books) {
			if(b.getName().equalsIgnoreCase(book.getName())) {
				throw new AlreadyExistException("Book");
			}
		}
		books.add(book);
	}
}
