package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.RoleEntity;
import pojos.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public String registerUser(User user) {
		String mesg = "User Registration Failed...";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(user);
			tx.commit();
			mesg = "User Registration done successfully..!!!!";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public String assignNewRole(long userId, long roleId) {
		String mesg = "Linking role to user FAILED....";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			User user = session.find(User.class, userId);
			RoleEntity role = session.find(RoleEntity.class, roleId);
			if (user != null && role != null) {
				user.addRole(role);
				mesg = "Role linked to user successfully..!!";
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
