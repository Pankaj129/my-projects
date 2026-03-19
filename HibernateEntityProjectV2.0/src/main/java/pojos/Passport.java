package pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Passport {

	// String passportNumber, LocalDate creationDate, LocalDate expiryDate, String
	// location,
	// String country

	@Column(name = "passport_number", length = 25)
	private String passortNumber;
	@Column(name = "create_date")
	private LocalDate creationDate;
	@Column(name = "expiry_date")
	private LocalDate expiryDate;
	@Column(length = 25)
	private String location;
	@Column(length = 25)
	private String country;

	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passport(String passortNumber, LocalDate creationDate, LocalDate expiryDate, String location,
			String country) {
		super();
		this.passortNumber = passortNumber;
		this.creationDate = creationDate;
		this.expiryDate = expiryDate;
		this.location = location;
		this.country = country;
	}

	public String getPassortNumber() {
		return passortNumber;
	}

	public void setPassortNumber(String passortNumber) {
		this.passortNumber = passortNumber;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Passport [passortNumber=" + passortNumber + ", creationDate=" + creationDate + ", expiryDate="
				+ expiryDate + ", location=" + location + ", country=" + country + "]";
	}

}
