package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;
import pojos.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public String RegisterUser(User user) {
		String mesg = "User Registration FAILED....";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(user);
			mesg = user.getFirstName()+" with user id  (" + user.getId() + ")  Registered successfully..!!!!!";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
