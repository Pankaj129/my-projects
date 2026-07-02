package library_management_system.service;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Predicate;

import library_management_system.comparator.BookAuthorComparator;
import library_management_system.exception.BookNotAvailableException;
import library_management_system.exception.MemberLimitExceededException;
import library_management_system.model.Book;
import library_management_system.model.Member;
import library_management_system.model.Transaction;
import library_management_system.model.TransactionType;
import library_management_system.utilities.FileUtil;
import library_management_system.utilities.IdGenerator;

public class Library {

	private static volatile Library library;

	private static final String BOOK_FILE = "books.dat";
	private static final String MEMBER_FILE = "members.dat";

	private Map<String, Book> books;
	private Map<String, Member> members;
	private Stack<Transaction> undoStack = new Stack<>();

	private List<Transaction> transactionHistory = new ArrayList<>();

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

		Transaction transaction = new Transaction(book, member, TransactionType.BORROW);

		undoStack.push(transaction);
		transactionHistory.add(transaction);

		saveData();
	}

	public void returnBook(String isbn, String memberId) throws Exception {
		Book book = books.get(isbn);
		Member member = members.get(memberId);

		if (book == null)
			throw new BookNotAvailableException("Book not found.!!");
		if (member == null)
			throw new MemberLimitExceededException("Member not found.!!");

		long fine = book.calculateFine();

		if (fine > 0) {
		    System.out.println("Late return. Fine to be collected: ₹" + fine);
		}

		book.returnItem();
		member.returnBook(book);

		Transaction transaction = new Transaction(book, member, TransactionType.RETURN);

		undoStack.push(transaction);
		transactionHistory.add(transaction);

		saveData();

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

	public void displayTransactions() {

		if (transactionHistory.isEmpty()) {

			System.out.println("No transaction history.");
			return;
		}

		System.out.println("\n==============================================================");
		System.out.printf("%-10s %-20s %-20s %-10s %-20s%n", "Member", "Name", "Book", "Action", "Time");
		System.out.println("==============================================================");

		transactionHistory.forEach(System.out::println);

		System.out.println("==============================================================");
	}

	public void exportBooks() {

		try (PrintWriter pw = new PrintWriter("books.csv")) {

			pw.println("ISBN,Title,Author,Status");

			for (Book book : books.values()) {

				pw.printf("%s,%s,%s,%s%n", book.getIsbn(), book.getTitle(), book.getAuthor(), book.isAvailable());

			}

			System.out.println("CSV Exported.");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void calculateFine(String isbn) {

		Book book = books.get(isbn);

		if (book == null) {
			System.out.println("Book not found.");
			return;
		}

		System.out.println("\n==========================================");
		System.out.println("           FINE DETAILS");
		System.out.println("==========================================");

		System.out.println("ISBN          : " + book.getIsbn());
		System.out.println("Title         : " + book.getTitle());
		System.out.println("Author        : " + book.getAuthor());

		if (book.isAvailable()) {

			System.out.println("Status        : Available");
			System.out.println("Fine          : ₹0");

		} else {

			LocalDate today = LocalDate.now();

			long overdueDays = today.isAfter(book.getDueDate()) ? ChronoUnit.DAYS.between(book.getDueDate(), today) : 0;

			System.out.println("Status        : Borrowed");
			System.out.println("Borrow Date   : " + book.getBorrowedDate());
			System.out.println("Due Date      : " + book.getDueDate());
			System.out.println("Overdue Days  : " + overdueDays);
			System.out.println("Fine          : ₹" + book.calculateFine());

		}

		System.out.println("==========================================");
	}

	public void clearData() {

		books.clear();
		members.clear();

		saveData();
	}

	private static final String[] BOOK_TITLES = { "Effective Java", "Clean Code", "Head First Java", "Spring in Action",
			"Thinking in Java", "Java Concurrency in Practice", "Design Patterns", "Refactoring", "Algorithms",
			"Microservices", "The Pragmatic Programmer", "Domain Driven Design", "Java Puzzlers", "Clean Architecture",
			"JUnit in Action" };

	private static final String[] BOOK_AUTHORS = { "Joshua Bloch", "Robert C. Martin", "Kathy Sierra", "Craig Walls",
			"Bruce Eckel", "Brian Goetz", "Gang of Four", "Martin Fowler", "Robert Sedgewick", "Sam Newman",
			"Andrew Hunt", "Eric Evans", "Joshua Bloch", "Robert C. Martin", "Petar Tahchiev" };

	private static final String[] MEMBER_NAMES = { "Pankaj", "Rahul", "Amit", "Sneha", "Priya", "Neha", "Ankit",
			"Rohit", "Karan", "Vivek" };

	public void generateSampleData() {

		if (!books.isEmpty() || !members.isEmpty()) {

			System.out.println("--------------------------------");
			System.out.println("Sample data already exists.");
			System.out.println("--------------------------------");
			return;
		}

		// Add Books
		for (int i = 0; i < BOOK_TITLES.length; i++) {
			addBook(new Book(BOOK_TITLES[i], BOOK_AUTHORS[i]));
		}

		// Add Members
		for (String name : MEMBER_NAMES) {
			addMember(new Member(name));
		}

		List<Book> availableBooks = new ArrayList<>(books.values());
		List<Member> memberList = new ArrayList<>(members.values());

		Collections.shuffle(availableBooks);
		Collections.shuffle(memberList);

		int borrowCount = Math.min(5, Math.min(availableBooks.size(), memberList.size()));

		for (int i = 0; i < borrowCount; i++) {

			try {

				borrowBooks(availableBooks.get(i).getIsbn(), memberList.get(i).getMemberId());

			} catch (Exception e) {

				System.out.println("Unable to borrow " + availableBooks.get(i).getTitle() + " : " + e.getMessage());
			}
		}

		saveData();

		System.out.println("--------------------------------");
		System.out.println("Sample data generated successfully.");
		System.out.println("--------------------------------");
	}

	public void undoLastTransaction() {

		if (undoStack.isEmpty()) {

			System.out.println("No transaction available to undo.");
			return;
		}

		Transaction transaction = undoStack.pop();

		Book book = transaction.getBook();
		Member member = transaction.getMember();

		try {

			if (transaction.getType() == TransactionType.BORROW) {

				// Undo Borrow

				book.returnItem();
				member.returnBook(book);

				System.out.println("--------------------------------");
				System.out.println("Undo Successful");
				System.out.println("Borrow operation reversed.");
				System.out.println("--------------------------------");

			} else {

				// Undo Return

				book.borrow();
				member.borrowBook(book);

				System.out.println("--------------------------------");
				System.out.println("Undo Successful");
				System.out.println("Return operation reversed.");
				System.out.println("--------------------------------");
			}

			saveData();

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

}
