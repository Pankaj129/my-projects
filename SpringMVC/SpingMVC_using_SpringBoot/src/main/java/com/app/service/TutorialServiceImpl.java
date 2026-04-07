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
	private ITutorialRepository tutorialRepo;

	@Override
	public List<Tutorial> findByAuthor(Long authorId) {

		return tutorialRepo.findByAuthorId(authorId);
	}

	@Override
	public void saveTutorial(Tutorial tutorial) {
		tutorialRepo.save(tutorial);
	}

	@Override
	public Tutorial findById(Long id) {

		return tutorialRepo.findById(id).orElseThrow(() -> new RuntimeException("Tutorial not found"));
	}

	@Override
	public void deleteById(Long id) {
		tutorialRepo.deleteById(id);

	}

}
