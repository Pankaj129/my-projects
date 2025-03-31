package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Topic;
import pojos.Tutorial;
import pojos.User;

public class TutorialDaoImpl implements ITutorialDao {

	@Override
	public String addNewTutorialByAuthorAndByTopic(Tutorial newTutorial, long authorId, long topicId) {
		String mesg = "Adding New Tutorial FAILED ...............";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			User author = session.get(User.class, authorId);
			Topic topic = session.get(Topic.class, topicId);
			if (author != null && topic != null) {
				newTutorial.setAuthor(author);
				newTutorial.setSelectedTopic(topic);
				session.persist(newTutorial);
				tx.commit();
				mesg = "New Tutorial Added for Author " + author.getFirstName() + " and Topic : " + topic.getTopicName()
						+ " successfully..!!!!!!";
			} else {
				mesg = "Adding New Tutorial FAILED due to Invalid Topic or Invalid Author...............";
			}
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
				throw e;

			}
		}
		return mesg;
	}

}
