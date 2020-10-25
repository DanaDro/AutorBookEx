package com.autorBook.autorBook.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.autorBook.autorBook.Exception.OperationNotAllowedException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor

public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int year;
	
	public Book(String name, int year) {
		this.name = name;
		this.year = year;
	}

	public void setId(int id) throws OperationNotAllowedException {
		throw new OperationNotAllowedException("Change id");
	}
	
	

}
