package dao;

import java.util.List;

import pojos.Tutorial;

public interface ITutorialDao {

	String addTutorialByAuthorAndTopic(Tutorial tut, long authorId, long topicId);

	List<Tutorial> getAllTutorials();

	List<Tutorial> getTutorialsAndTopicDetails();

	List<Tutorial> findByTopicName(String topicName);
}
