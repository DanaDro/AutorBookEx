package com.autorBook.autorBook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autorBook.autorBook.Bean.Autor;
import com.autorBook.autorBook.Exception.AlreadyExistException;
import com.autorBook.autorBook.Repository.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;
	
	public void addAutor(Autor autor) throws AlreadyExistException {
		List<Autor> autors = getAllAutors();
		for (Autor aut : autors) {
			if(aut.getId() == autor.getId()) {
				throw new AlreadyExistException("This autor");
			}
		}
		autorRepository.save(autor);
	}
	
	public void updateAutor(Autor autor) {
		autorRepository.saveAndFlush(autor);
	}
	
	public void deleteAutor(int autorId) {
		autorRepository.deleteById(autorId);
	}
	public Autor getOneAutor(int autorId) {
		return autorRepository.getOne(autorId);
	}
	
	public List<Autor> getAllAutors() {
		return autorRepository.findAll();
	}
	
	public List<Autor> findByFirstName(String name){
		return autorRepository.findByFirstName(name);
	}
	
	public List<Autor> findByFirstFirstNameLetter(String letter){
		return autorRepository.findByFirstNameStartingWith(letter);
	}
}
