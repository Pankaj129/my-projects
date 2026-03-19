package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.*;

import pojos.Topic;

public class TopicDaoImpl implements ITopicDao {

	@Override
	public String addNewTopic(Topic topic) {
		String mesg = "Topic adddition Failed....";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(topic);
			tx.commit();
			mesg = "New Topic with " + topic.getId() + " added successfully..!!!";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public List<Topic> getAllTopics() {
		List<Topic> topics = null;
		String jpql = "select t from Topic t";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			topics = session.createQuery(jpql, Topic.class).getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return topics;
	}

}
