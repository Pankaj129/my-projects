package pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Card {
	// CardType type, String issuer, LocalDate expDate, String cvv

	@Enumerated(EnumType.STRING)
	@Column(name = "card_type")
	private CardType type;

	@Column(length = 25)
	private String issuer;

	@Column(name = "exp_date")
	private LocalDate expDate;

	@Column(length = 10)
	private String cvv;

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(CardType type, String issuer, LocalDate expDate, String cvv) {
		super();
		this.type = type;
		this.issuer = issuer;
		this.expDate = expDate;
		this.cvv = cvv;
	}

	public CardType getType() {
		return type;
	}

	public void setType(CardType type) {
		this.type = type;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Card [type=" + type + ", issuer=" + issuer + ", expDate=" + expDate + ", cvv=" + cvv + "]";
	}

}
