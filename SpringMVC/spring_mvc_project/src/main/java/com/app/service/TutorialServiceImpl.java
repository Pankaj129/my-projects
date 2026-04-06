package com.app.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITutorialDao;
import com.app.pojos.Tutorial;

@Service
@Transactional
public class TutorialServiceImpl implements ITutorialService {

	@Autowired
	private ITutorialDao tutDao;

	@Override
	public Tutorial getTutorialDetails(String tut) {

		return tutDao.getTutorialDetails(tut);
	}

	@Override
	public List<String> getTutorialNamesByTopic(long topicld) {

		return tutDao.getTutorialNamesByTopic(topicld);
	}

	@Override
	public String validateNAddTutotrial(Tutorial transientTut) {

		long period = Period.between(transientTut.getPublishDate(), LocalDate.now()).toTotalMonths();
		System.out.println("period : "+period);
		if (period < 6 && transientTut.getContent().length() < 255) {

			String persistentTut = tutDao.addTutorial(transientTut);
			return "Added new tut with ID=" + persistentTut;

		}
		throw new RuntimeException("Invalid Inputs.....");
	}

}
