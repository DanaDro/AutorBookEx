package com.autorBook.autorBook.Exception;

public class OperationNotAllowedException extends Exception {

	public OperationNotAllowedException(String massege) {
		super(massege + " is not allowed exception.");
	}

	
}
