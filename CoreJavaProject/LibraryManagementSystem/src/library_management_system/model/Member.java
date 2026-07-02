package library_management_system.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import library_management_system.exception.BookAlreadyBorrowedException;
import library_management_system.exception.MemberLimitExceededException;
import library_management_system.utilities.IdGenerator;

public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String memberId;
	List<Book> borrowedBooks;
	private int maxBorrowLimit;

	public Member(String name, int maxBorrowLimit) {
		super();
		this.name = name;
		this.memberId = IdGenerator.generateMemberId();
		this.borrowedBooks = new ArrayList<>();
		this.maxBorrowLimit = maxBorrowLimit;
	}

	public String getName() {
		return name;
	}

	public Member(String name) {
		super();
		this.name = name;
	}

	public String getMemberId() {
		return memberId;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public int getMaxBorrowLimit() {
		return maxBorrowLimit;
	}

	public void setMaxBorrowLimit(int maxBorrowLimit) {
		this.maxBorrowLimit = maxBorrowLimit;
	}

	@Override
	public String toString() {
		return "Member [ name=" + name + ", id=" + memberId + ", borrowedBooks=" + borrowedBooks + " ]";
	}

	public void borrowBook(Book book) throws MemberLimitExceededException, BookAlreadyBorrowedException {

	    if (book == null) {
	        throw new IllegalArgumentException("Book cannot be null.");
	    }

	    if (borrowedBooks.size() >= maxBorrowLimit) {
	        throw new MemberLimitExceededException("Borrow book limit exceeded.");
	    }

	    boolean alreadyBorrowed = borrowedBooks.stream()
	            .anyMatch(b -> b.getIsbn().equals(book.getIsbn()));

	    if (alreadyBorrowed) {
	        throw new BookAlreadyBorrowedException("Book is already borrowed by this member.");
	    }

	    borrowedBooks.add(book);
	}

	public void returnBook(Book book) {

		borrowedBooks.remove(book);

		System.out.println("Book returned successfully.");
	}

	public void displayBorrowedBooks() {

		System.out.println("\n==============================================");
		System.out.println("Borrowed Books of Member : " + name);
		System.out.println("Member ID : " + memberId);
		System.out.println("==============================================");

		if (borrowedBooks.isEmpty()) {
			System.out.println("No books borrowed.");
			return;
		}

		System.out.printf("%-15s %-30s %-20s%n", "ISBN", "Title", "Author");
		System.out.println("---------------------------------------------------------------");

		for (Book book : borrowedBooks) {
			System.out.printf("%-15s %-30s %-20s%n", book.getIsbn(), book.getTitle(), book.getAuthor());
		}

		System.out.println("---------------------------------------------------------------");
	}

}
