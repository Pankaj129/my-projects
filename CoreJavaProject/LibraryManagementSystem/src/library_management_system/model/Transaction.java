package library_management_system.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Book book;
	private final Member member;
	private final TransactionType type;
	private final LocalDateTime transactionTime;

	public Transaction(Book book, Member member, TransactionType type) {

		this.book = book;
		this.member = member;
		this.type = type;
		this.transactionTime = LocalDateTime.now();
	}

	public Book getBook() {
		return book;
	}

	public Member getMember() {
		return member;
	}

	public TransactionType getType() {
		return type;
	}

	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}

	@Override
	public String toString() {

		return String.format("%-10s %-20s %-20s %-15s %s", member.getMemberId(), member.getName(), book.getTitle(),
				type, transactionTime);
	}
}