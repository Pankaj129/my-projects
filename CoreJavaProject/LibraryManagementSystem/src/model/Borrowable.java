package model;

import exception.BookNotAvailableException;

public interface Borrowable {

	void borrow() throws BookNotAvailableException;

	void returnItem();

	boolean isAvailable();

}
