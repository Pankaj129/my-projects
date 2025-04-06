package dao;



import java.util.List;

import pojos.Tutorial;

public interface ITutorialDao {

	String addNewTutorialByAuthorAndByTopic(Tutorial newTutorial, long author, long topic);
	
	List<Tutorial> getAllTutorials();
	
	List<Tutorial> getAllTutorialsWithTopic();
	
	List<Tutorial> getAllTutorialsByTopicName(String topicName);
}
