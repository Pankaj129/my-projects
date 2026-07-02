package library_management_system.comparator;

import java.util.Comparator;

import library_management_system.model.Book;

public class BookTitleComparator implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {

		return book1.getTitle().compareToIgnoreCase(book2.getTitle());
	}

}
