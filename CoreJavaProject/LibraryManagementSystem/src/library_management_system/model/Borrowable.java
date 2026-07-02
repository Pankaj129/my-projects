package library_management_system.model;

import library_management_system.exception.BookNotAvailableException;

public interface Borrowable {

	void borrow() throws BookNotAvailableException;

	void returnItem();

	boolean isAvailable();

}
