package test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import library_management_system.model.Book;
import library_management_system.model.Member;
import library_management_system.service.Library;

public class LibraryTest {

    private Library library;

    @BeforeEach
    void setup() {
        library = Library.getInstance();
        library.clearData();
    }

    @Test
    void testBorrowBook() throws Exception {

        Book book = new Book("Java", "James");
        Member member = new Member("Pankaj");

        library.addBook(book);
        library.addMember(member);

        library.borrowBooks(book.getIsbn(), member.getMemberId());

        assertFalse(book.isAvailable());
    }
}
