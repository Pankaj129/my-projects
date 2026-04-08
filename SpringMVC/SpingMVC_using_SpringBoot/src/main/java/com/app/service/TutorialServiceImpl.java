package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITutorialRepository;
import com.app.pojos.Tutorial;

@Service
@Transactional
public class TutorialServiceImpl implements ITutorialService {

	@Autowired
	private ITutorialRepository tutorialRepository;

	@Override
	public List<Tutorial> findByAuthor(Long authorId) {

		return tutorialRepository.findByAuthorId(authorId);
	}

	@Override
	public void saveTutorial(Tutorial tutorial) {
		tutorialRepository.save(tutorial);
	}

	@Override
	public Tutorial findById(Long id) {

		return tutorialRepository.findById(id).orElseThrow(() -> new RuntimeException("Tutorial not found"));
	}

	@Override
	public void deleteById(Long id) {
		tutorialRepository.deleteById(id);

	}

	@Override
	public List<Tutorial> getAllTutorials() {

		return tutorialRepository.findAll();
	}

	@Override
	public List<Tutorial> findByTopicSorted(Long topicId) {
		return tutorialRepository.findByTopicSorted(topicId);
	}

	@Override
	public List<Tutorial> getAllSorted() {
		return tutorialRepository.findAllSorted();
	}

	@Override
	public void save(Tutorial tutorial) {
		tutorialRepository.save(tutorial);
	}

	@Override
	public Tutorial getById(Long id) {
	
		return tutorialRepository.findById(id).orElse(null);
	}

}
