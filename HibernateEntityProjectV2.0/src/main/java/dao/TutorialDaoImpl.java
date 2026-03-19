package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Topic;
import pojos.Tutorial;
import pojos.User;

public class TutorialDaoImpl implements ITutorialDao {

	@Override
	public String addTutorialByAuthorAndTopic(Tutorial tut, long authorId, long topicId) {
		String mesg = "Tutorial addition failed....";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			User author = session.find(User.class, authorId);
			Topic topic = session.find(Topic.class, topicId);
			if (author != null && topic != null) {
				tut.setAuthor(author);
				tut.setSelectedTopic(topic);
				session.persist(tut);
				mesg = "Added a new tut for Author Name : " + author.getLastName() + " under topic "
						+ topic.getTopicName();

			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public List<Tutorial> getAllTutorials() {
		List<Tutorial> tutorials = null;
		String jpql = "select t from Tutorial t";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			tutorials = session.createQuery(jpql, Tutorial.class).getResultList();
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return tutorials;
	}

	@Override
	public List<Tutorial> getTutorialsAndTopicDetails() {
		List<Tutorial> tutorials = null;
		String jpql = "select t from Tutorial t join fetch t.selectedTopic";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			tutorials = session.createQuery(jpql, Tutorial.class).getResultList();
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return tutorials;
	}

	@Override
	public List<Tutorial> findByTopicName(String topicName) {
		List<Tutorial> tutorials = null;
		String jpql = "select t from Tutorial t where t.selectedTopic:topic";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			tutorials = session.createQuery(jpql, Tutorial.class).setParameter("topic", topicName).getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return tutorials;
	}

}
