package service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import comparator.BookAuthorComparator;
import exception.BookNotAvailableException;
import exception.MemberLimitExceededException;
import model.Book;
import model.Member;
import utilities.FileUtil;
import utilities.IdGenerator;

public class Library {

	private static volatile Library library;

	private static final String BOOK_FILE = "books.dat";
	private static final String MEMBER_FILE = "members.dat";

	private Map<String, Book> books;
	private Map<String, Member> members;

	private Library() {
		loadData();
	}

	public static Library getInstance() {
		if (library == null) {
			synchronized (Library.class) {
				if (library == null) {
					library = new Library();
				}
			}
		}
		return library;
	}

	private void loadData() {
		books = FileUtil.<HashMap<String, Book>>load(BOOK_FILE);

		members = FileUtil.<HashMap<String, Member>>load(MEMBER_FILE);

		updateIdCounters();

		System.out.println("Library data loaded.");
		System.out.println("Books   : " + books.size());
		System.out.println("Members : " + members.size());
	}

	public void saveData() {
		FileUtil.save(BOOK_FILE, (HashMap<String, Book>) books);
		FileUtil.save(MEMBER_FILE, (HashMap<String, Member>) members);
	}

	private void updateIdCounters() {

		if (!books.isEmpty()) {
			long maxIsbn = books.values().stream().map(Book::getIsbn).mapToLong(Long::parseLong).max()
					.orElse(9780000000000L);

			IdGenerator.setNextIsbn(maxIsbn + 1);
		}

		if (!members.isEmpty()) {
			int maxMemberId = members.values().stream().map(Member::getMemberId).map(id -> id.substring(1))
					.mapToInt(Integer::parseInt).max().orElse(1000);

			IdGenerator.setNextMemberId(maxMemberId + 1);
		}
	}

	public void addBook(Book book) {

		boolean exists = books.values().stream().anyMatch(b -> b.getTitle().equalsIgnoreCase(book.getTitle())
				&& b.getAuthor().equalsIgnoreCase(book.getAuthor()));

		if (exists) {
			System.out.println("Book already exists.");
			return;
		}

		books.put(book.getIsbn(), book);

		System.out.println("--------------------------------");

		System.out.println("Book Added Successfully");

		System.out.println("Generated ISBN : " + book.getIsbn());

		System.out.println("--------------------------------");

	}

	public void addMember(Member member) {
		members.put(member.getMemberId(), member);
		System.out.println("--------------------------------");

		System.out.println("Member Added Successfully");

		System.out.println("Member Id : " + member.getMemberId());

		System.out.println("--------------------------------");
	}

	public void borrowBooks(String isbn, String memberId) throws Exception {

		Book book = books.get(isbn);
		Member member = members.get(memberId);

		if (book == null)
			throw new BookNotAvailableException("Book not found.!!");
		if (member == null)
			throw new MemberLimitExceededException("Member not found.!!");

		book.borrow();
		member.borrowBook(book);
	}

	public void returnBook(String isbn, String memberId) throws Exception {
		Book book = books.get(isbn);
		Member member = members.get(memberId);

		if (book == null)
			throw new BookNotAvailableException("Book not found.!!");
		if (member == null)
			throw new MemberLimitExceededException("Member not found.!!");

		book.returnItem();
		member.returnBook(book);

	}

	public List<Book> searchBooks(Predicate<Book> condition) {

		return books.values().stream().filter(condition).toList();
	}

	public List<Book> searchBookSortedbyTitle() {
		List<Book> sortedBookList = new ArrayList<>(books.values());
		Collections.sort(sortedBookList);
		return sortedBookList;
	}

	public List<Book> searchBookSortedbyAuthor() {
		List<Book> sortedBookList = new ArrayList<>(books.values());
		sortedBookList.sort(new BookAuthorComparator());
		return sortedBookList;
	}

	public List<Member> getAllMembers() {
		List<Member> memberList = new ArrayList<>(members.values());
		return memberList;
	}

	public void displayBorrowedBooks(String memberId) {

		Member member = members.get(memberId);

		if (member == null) {
			System.out.println("Member not found.");
			return;
		}

		member.displayBorrowedBooks();
	}

	public void printBooks(List<Book> books) {

		if (books.isEmpty()) {
			System.out.println("No books found.");
			return;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

		System.out.println(
				"====================================================================================================================================");

		System.out.printf("%-15s %-25s %-20s %-12s %-15s %-15s%n", "ISBN", "Title", "Author", "Status", "Borrow Date",
				"Due Date");

		System.out.println(
				"====================================================================================================================================");

		for (Book book : books) {

			String borrowDate = book.getBorrowedDate() == null ? "-" : book.getBorrowedDate().format(formatter);

			String dueDate = book.getDueDate() == null ? "-" : book.getDueDate().format(formatter);

			System.out.printf("%-15s %-25s %-20s %-12s %-15s %-15s%n", book.getIsbn(), book.getTitle(),
					book.getAuthor(), book.isAvailable() ? "Available" : "Borrowed", borrowDate, dueDate);
		}

		System.out.println(
				"====================================================================================================================================");
	}

	public void getAllBooks() {
		printBooks(new ArrayList<>(books.values()));

	}

	public void removeMember(String memberId) {

		Member member = members.get(memberId);

		if (member == null) {
			System.out.println("Member not found.");
			return;
		}

		if (!member.getBorrowedBooks().isEmpty()) {
			System.out.println("Member cannot be deleted.");
			System.out.println("Reason : Member has borrowed books.");
			return;
		}

		members.remove(memberId);

		System.out.println("Member deleted successfully.");
	}

	public void displayMembers(List<Member> members) {

		if (members == null || members.isEmpty()) {
			System.out.println("\nNo members registered.");
			return;
		}

		System.out.println("\n====================================================================================");
		System.out.printf("%-15s %-25s %-20s %-15s%n", "MEMBER ID", "NAME", "BORROWED", "LIMIT");
		System.out.println("====================================================================================");

		for (Member member : members) {

			System.out.printf("%-15s %-25s %-20d %-15d%n", member.getMemberId(), member.getName(),
					member.getBorrowedBooks().size(), member.getMaxBorrowLimit());
		}

		System.out.println("====================================================================================");
	}

	public void displayLibraryStatistics() {

		long totalBooks = books.size();
		long availableBooks = books.values().stream().filter(Book::isAvailable).count();

		long borrowedBooks = totalBooks - availableBooks;
		long totalMembers = members.size();

		long activeMembers = members.values().stream().filter(member -> !member.getBorrowedBooks().isEmpty()).count();

		long inactiveMembers = totalMembers - activeMembers;

		System.out.println("\n==========================================");
		System.out.println("          LIBRARY STATISTICS");
		System.out.println("==========================================");
		System.out.printf("%-30s : %d%n", "Total Books", totalBooks);
		System.out.printf("%-30s : %d%n", "Available Books", availableBooks);
		System.out.printf("%-30s : %d%n", "Borrowed Books", borrowedBooks);
		System.out.printf("%-30s : %d%n", "Registered Members", totalMembers);
		System.out.printf("%-30s : %d%n", "Active Members", activeMembers);
		System.out.printf("%-30s : %d%n", "Inactive Members", inactiveMembers);
		System.out.println("==========================================");
	}

}
