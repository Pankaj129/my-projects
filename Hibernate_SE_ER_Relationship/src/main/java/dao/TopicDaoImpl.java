package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Topic;
import static utils.HibernateUtils.getFactory;

public class TopicDaoImpl implements ITopicDao {

	@Override
	public String addNewTopic(Topic topic) {
		String mesg = "New Topic Insertion FAILED.............";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(topic);
			mesg=topic.getTopicName()+" Topic added successfully...!!!!!!!!!!!!";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
				throw e;
			}
		}
		return mesg;
	}

}
