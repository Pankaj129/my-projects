package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.User;

public class AddressDaoImpl implements IAddressDao {

	@Override
	public String assignUserAddress(String email, Address address) {
		String mesg = "Address asigning to user FAILED....";
		String jpql = "select u from User u where u.email=:em";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			User user = session.createQuery(jpql, User.class).setParameter("em", email).getSingleResult();
			System.out.println(user);
			address.setOwner(user);
			session.persist(address);
			tx.commit();
			System.out.println(address);
			mesg = "User address successfully assigned for user : "+user.getFirstName()+" !!!!";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public String updateUserAddress(long userId, Address updatedAddress) {
		String mesg = "address updation FAILED....";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Address address = session.find(Address.class, userId);
			if(address!=null) {
				updatedAddress.setId(userId);
				session.merge(updatedAddress);
				mesg = "Address updation success for User : "+userId;
			}
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
