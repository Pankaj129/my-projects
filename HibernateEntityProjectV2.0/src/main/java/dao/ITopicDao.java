package dao;

import java.util.List;

import pojos.Topic;

public interface ITopicDao {
	String addNewTopic(Topic topic);
	
	List<Topic> getAllTopics();
}
