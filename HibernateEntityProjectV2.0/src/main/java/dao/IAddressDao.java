package dao;

import pojos.Address;

public interface IAddressDao {
	String assignUserAddress(String email, Address address);

	String updateUserAddress(long userId, Address updatedAddress);

}
