package library_management_system;

import java.util.List;
import java.util.Scanner;

import library_management_system.model.Book;
import library_management_system.model.Member;
import library_management_system.service.Library;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Library library = Library.getInstance();
		List<Book> books;

		while (true) {

			displayMenu();

			int choice = sc.nextInt();
			sc.nextLine();

			try {

				switch (choice) {

				case 1:

					System.out.print("Book Title : ");
					String title = sc.nextLine();

					System.out.print("Author : ");
					String author = sc.nextLine();

					if (title == null || title.isBlank())
						throw new IllegalArgumentException("Title cannot be empty.");

					library.addBook(new Book(title, author));

					System.out.println("Book Added Successfully.");
					break;

				case 2:

					System.out.print("Member Name : ");
					String name = sc.nextLine();

					System.out.print("Borrow Limit : ");
					int limit = sc.nextInt();

					library.addMember(new Member(name, limit));

					System.out.println("Member Added.");
					break;

				case 3:

					System.out.print("ISBN : ");
					String isbn = sc.nextLine();

					System.out.print("Member ID : ");
					String memberId = sc.nextLine();

					library.borrowBooks(isbn, memberId);

					break;

				case 4:

					System.out.print("ISBN : ");
					isbn = sc.nextLine();

					System.out.print("Member ID : ");
					memberId = sc.nextLine();

					library.returnBook(isbn, memberId);

					break;

				case 5:

					System.out.print("Enter Title : ");
					title = sc.nextLine();
					books = library.searchBooks(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()));

					library.printBooks(books);

					break;

				case 6:

					System.out.print("Enter Author : ");
					author = sc.nextLine();
					books = library.searchBooks(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()));

					library.printBooks(books);

					break;

				case 7:

					library.getAllBooks();

					break;

				case 8:

					library.displayMembers(library.getAllMembers());

					break;

				case 9:

					books = library.searchBookSortedbyTitle();

					library.printBooks(books);

					break;

				case 10:

					books = library.searchBookSortedbyAuthor();

					library.printBooks(books);

					break;

				case 11:
					System.out.print("Member ID : ");
					memberId = sc.nextLine();
					library.displayBorrowedBooks(memberId);
					break;

				case 12:

					System.out.print("Enter Member ID : ");
					memberId = sc.nextLine();

					library.removeMember(memberId);

					break;

				case 13:

					library.displayLibraryStatistics();
					break;

				case 14:

					library.generateSampleData();
					break;

				case 15:

					library.displayTransactions();
					break;

				case 16:

					library.undoLastTransaction();
					break;

				case 17:

					library.exportBooks();
					break;

				case 18:

					System.out.print("Enter ISBN : ");
					isbn = sc.nextLine();

					library.calculateFine(isbn);

					break;

				case 19:

					library.saveData();

					System.out.println("Data Saved Successfully.");

					break;

				case 20:

					library.saveData();

					System.out.println("Thank You!");

					sc.close();

					System.exit(0);

				default:

					System.out.println("Invalid Choice.");

				}

			} catch (Exception e) {

				System.out.println(e.getMessage());

			}

		}

	}

	private static void displayMenu() {

		System.out.println("\n======================================");
		System.out.println("      LIBRARY MANAGEMENT SYSTEM");
		System.out.println("======================================");
		System.out.println("01. Add Book");
		System.out.println("02. Add Member");
		System.out.println("03. Borrow Book");
		System.out.println("04. Return Book");
		System.out.println("05. Search Book By Title");
		System.out.println("06. Search Book By Author");
		System.out.println("07. Display All Books");
		System.out.println("08. Display All Members");
		System.out.println("09. Sort Books By Title");
		System.out.println("10. Sort Books By Author");
		System.out.println("11. View Borrowed Books");
		System.out.println("12. Delete Membership");
		System.out.println("13. Library Statistics");
		System.out.println("14. Generate Sample Data");
		System.out.println("15. Transaction History");
		System.out.println("16. Undo Last Transaction");
		System.out.println("17. Export Books to CSV");
		System.out.println("18. Calculate Fine");
		System.out.println("19. Save Data");
		System.out.println("20. Exit");
		System.out.print("\nEnter Choice : ");
	}

}