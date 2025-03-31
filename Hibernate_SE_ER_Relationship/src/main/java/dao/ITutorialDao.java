package dao;

import pojos.Tutorial;

public interface ITutorialDao {

	String addNewTutorialByAuthorAndByTopic(Tutorial newTutorial, long author, long topic);
}
