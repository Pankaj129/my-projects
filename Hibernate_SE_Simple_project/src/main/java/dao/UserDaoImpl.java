package dao;

import static utils.HibernateUtils.getFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Role;
import pojos.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public String registerUser(User transientUser) {
		Session session = getFactory().openSession();
		Transaction tx = session.beginTransaction();
		String mesg = "User Registration Failed.......!!";
		try {
			session.save(transientUser);
			tx.commit();
			mesg = "User " + transientUser.getUserId() + ", registered successfully..!!!!";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return mesg;
	}

	@Override
	public User getUserByUserId(long userId) {
		User user = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			user = session.get(User.class, userId);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpqlQuery = "select u from User u";
		try {
			users = session.createQuery(jpqlQuery, User.class).getResultList();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
		}
		return users;
	}

	@Override
	public List<User> getUsersByDateAndRole(LocalDate startDate, LocalDate endDate, Role userRole) {
		List<User> users = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpqlQuery = "select u from User u where u.regDate between :start and :end and u.userRole=:role";
		try {
			users = session.createQuery(jpqlQuery, User.class).setParameter("start", startDate)
					.setParameter("end", endDate).setParameter("role", userRole).getResultList();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
		}
		return users;
	}

	@Override
	public List<String> getSelectedUserByDate(LocalDate date) {
		List<String> names = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpqlQuery = "select u .name from User u where u.regDate > :date";
		try {
			names = session.createQuery(jpqlQuery, String.class).setParameter("date", date).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
		}
		return names;
	}

	@Override
	public List<User> getUsersDetailsByRegDate(LocalDate startDate, LocalDate endDate) {
		List<User> users = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpqlQuery = "select new pojos.User(name, userRole, regAmount) from User u where u.regDate between :strt and :end";
		try {
			users = session.createQuery(jpqlQuery, User.class).setParameter("strt", startDate)
					.setParameter("end", endDate).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
		}
		return users;
	}

	@Override
	public String changePassword(long userId, String newPassword) {
		String mesg = "Password change FAILED........";
		User user = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		// String jpqlQuery = "select new pojos.User(name, userRole, regAmount) from
		// User u where u.regDate between :strt and :end";
		try {
			user = session.get(User.class, userId);
			if (user != null) {
				user.setPassword(newPassword);
				mesg = "Password has been changed successfully...!!!!!!!!";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
		}
		return mesg;
	}

	@Override
	public String applyBulkDiscount(LocalDate date, double discount) {
		String mesg = "bulk update failed.....";
		String jpqlQuery = "update User u set u.regAmount=u.regAmount-:disc where u.regDate < :dt";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			int rowCount = session.createQuery(jpqlQuery).setParameter("disc", discount).setParameter("dt", date)
					.executeUpdate();
			mesg = "Bulk discount applied to " + rowCount + " users successfully....!!!!!!!!!!";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		}

		return mesg;
	}

	@Override
	public String deleteUserByEmail(String email) {
		String jpqlQuery = "select u from User u where u.email=:em";
		String mesg = "User deletion FAILED............";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			User user = (User) session.createQuery(jpqlQuery, User.class).setParameter("em", email).getSingleResult();
			session.delete(user);
			mesg = "User with email " + email + " deleted successfully...!!!!!";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
		}

		return mesg;
	}

	@Override
	public String updateImageByUserId(long userId, String imagePath) throws IOException {
		String mesg = "Image Updation FAILED...........";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			User user = session.get(User.class, userId);
			if (user != null) {
				File file = new File(imagePath);
				if (file.isFile() && file.canRead()) {
					user.setImage(FileUtils.readFileToByteArray(file));
					mesg = "Image updation for user with userId = " + userId + " done successfully...!!!!!";
				} else
					mesg = "Image updation Failed : Invalid file path";
			} else
				mesg = "Image updation Failed : Invalid user";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
		}

		return mesg;
	}

	@Override
	public String restoreImageByUserId(long userId, String imagePath) throws IOException {
		String mesg = "Image restoration FAILED...........";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			User user = session.get(User.class, userId);
			if (user != null) { 
				if (user.getImage()!=null) {
					FileUtils.writeByteArrayToFile(new File(imagePath), user.getImage());
					mesg = "Image restoration for user " + user.getname() + " done successfully...!!!!!";
				} else
					mesg = "Image restoration Failed : image not assigned.";
			} else
				mesg = "Image restoration Failed : Invalid user";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
		}

		return mesg;
	}

}
