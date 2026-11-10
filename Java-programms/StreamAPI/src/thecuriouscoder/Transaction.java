package thecuriouscoder;

public class Transaction {

	String transactionType;
	int TransactionAmount;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(String transactionType, int transactionAmount) {
		super();
		this.transactionType = transactionType;
		TransactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getTransactionAmount() {
		return TransactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		TransactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionType=" + transactionType + ", TransactionAmount=" + TransactionAmount + "]";
	}

}
