package com.autorBook.autorBook.Exception;

public class AlreadyExistException extends Exception {

	public AlreadyExistException(String massege) {
		super(massege + " is Already exist Exception.");
	}
}
