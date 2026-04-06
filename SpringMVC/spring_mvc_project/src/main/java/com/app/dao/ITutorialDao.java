package com.app.dao;

import java.util.List;

import com.app.pojos.Tutorial;

public interface ITutorialDao {
	
	public List<String> getTutorialNamesByTopic(Long topicId);
	
	public Tutorial getTutorialDetails(String tutName);
	
	public String addTutorial(Tutorial transientTutorial);

}
