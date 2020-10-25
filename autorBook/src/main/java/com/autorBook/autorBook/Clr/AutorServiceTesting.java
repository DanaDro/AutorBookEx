package com.autorBook.autorBook.Clr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.autorBook.autorBook.Bean.Autor;
import com.autorBook.autorBook.Bean.Book;
import com.autorBook.autorBook.Service.AutorService;
import com.autorBook.autorBook.util.SpringTable;

@Component
@Order(1)
public class AutorServiceTesting implements CommandLineRunner {

	@Autowired
	private AutorService autorService;

	@Override
	public void run(String... args) throws Exception {

		Autor a1 = new Autor("Ido", "Shay");
		Autor a2 = new Autor("Dana", "Drosvit");
		Autor a3 = new Autor("Daniel", "Ram");
		Autor a4 = new Autor("Avital", "Amikam");
		
		Book b1 = new Book("Java Script", 2020);
		Book b2 = new Book("Python", 2018);
		Book b3 = new Book("C++", 2003);
		Book b4 = new Book("Web", 2019);

		System.out.println("----------- add autor -----------");
		try {
			autorService.addAutor(a1);
			autorService.addAutor(a2);
			autorService.addAutor(a3);
			autorService.addAutor(a4);
			SpringTable.print(autorService.getAllAutors());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("----------- add autor not allowd -----------");
		try {
			autorService.addAutor(a4);
			SpringTable.print(autorService.getAllAutors());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("----------- add book -----------");
		try {
			a1.addBook(b1);
			a1.addBook(b2);
			a2.addBook(b3);
			a3.addBook(b4);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("----------- update autor ----------");
		try {
			a1.setLastName("Shay Shay");
			autorService.updateAutor(a1);
			autorService.updateAutor(a2);
			autorService.updateAutor(a3);
			SpringTable.print(autorService.getOneAutor(1));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("----------- update autor not allowd------------");
		try {
			a2.setId(3);
			autorService.updateAutor(a2);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("----------- delete autor -----------");
		autorService.deleteAutor(4);
		System.out.println("----------- get one autor -----------");
		SpringTable.print(autorService.getOneAutor(1));
		System.out.println("----------- get all autors -----------");
		SpringTable.print(autorService.getAllAutors());
		System.out.println("----------- get autor by name -----------");
		SpringTable.print(autorService.findByFirstName("Ido"));
		System.out.println("----------- get autor by letter -----------");
		SpringTable.print(autorService.findByFirstFirstNameLetter("d"));
		
	}

}
