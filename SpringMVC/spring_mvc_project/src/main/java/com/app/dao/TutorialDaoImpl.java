package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Tutorial;

@Repository
public class TutorialDaoImpl implements ITutorialDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<String> getTutorialNamesByTopic(Long topicId) {
		String jpql = "select t.tutorialName from Tutorial t where t.selectedTopic.id =:topic";
		return sessionFactory.getCurrentSession().createQuery(jpql, String.class).setParameter("topic", topicId)
				.getResultList();
	}

	@Override
	public Tutorial getTutorialDetails(String tutName) {
		String jpql = "select t from Tutorial t where t.tutorialName=:tutorial";
		return sessionFactory.getCurrentSession().createQuery(jpql, Tutorial.class).setParameter("tutorial", tutName)
				.getSingleResult();
	}

	@Override
	public String addTutorial(Tutorial transientTutorial) {
		String id = "" + sessionFactory.getCurrentSession().save(transientTutorial);
		return id;
	}

}
