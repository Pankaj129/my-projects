package model;

import java.io.Serializable;
import java.time.LocalDate;

import exception.BookNotAvailableException;
import utilities.IdGenerator;

public class Book implements Serializable, Borrowable, Comparable<Book> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;
	private String author;
	private String isbn;
	private BookStatus availabilityStatus;
	private LocalDate borrowedDate;
	private LocalDate dueDate;

	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = IdGenerator.generateIsbn();
		this.availabilityStatus = BookStatus.AVAILABLE;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public BookStatus getAvailabilityStatus() {
		return availabilityStatus;
	}

	@Override
	public void borrow() throws BookNotAvailableException {
		if (availabilityStatus == BookStatus.BORROWED)
			throw new BookNotAvailableException("Book already borrowed.!!");

		availabilityStatus = BookStatus.BORROWED;

		borrowedDate = LocalDate.now();

		// Due after 15 days
		dueDate = borrowedDate.plusDays(15);

	}

	@Override
	public void returnItem() {
		availabilityStatus = BookStatus.AVAILABLE;
		borrowedDate = null;
		dueDate = null;

	}

	@Override
	public boolean isAvailable() {

		return availabilityStatus == BookStatus.AVAILABLE;
	}

	@Override
	public String toString() {
		return String.format("%-15s %-25s %-20s %-10s", isbn, title, author, availabilityStatus);
	}

	@Override
	public int compareTo(Book other) {

		return this.title.compareToIgnoreCase(other.title);
	}

	public LocalDate getBorrowedDate() {
		return borrowedDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

}
