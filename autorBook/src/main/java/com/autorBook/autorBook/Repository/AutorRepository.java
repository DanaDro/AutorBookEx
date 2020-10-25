package com.autorBook.autorBook.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autorBook.autorBook.Bean.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
	
	public List<Autor> findByFirstName(String name);
	
	public List<Autor> findByFirstNameStartingWith(String letter);

}
