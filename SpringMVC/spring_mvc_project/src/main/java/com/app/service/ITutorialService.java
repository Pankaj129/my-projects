package com.app.service;

import java.util.List;

import com.app.pojos.Tutorial;

public interface ITutorialService {

	Tutorial getTutorialDetails(String tut);

	List<String> getTutorialNamesByTopic(long topicld);
	
	String validateNAddTutotrial(Tutorial transientTut);

}
