package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "address_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address extends BaseEntity {

	@Column(name = "address_line1", length = 50)
	private String addressLine1;

	@Column(name = "address_line2", length = 50)
	private String addressLine2;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String country;
	@Column
	private String zipCode;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@MapsId
	private User owner;

}
