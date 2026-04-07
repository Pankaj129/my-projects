package com.app.service;

import java.util.List;

import com.app.pojos.Tutorial;

public interface ITutorialService {

	List<Tutorial> findByAuthor(Long id);

	void saveTutorial(Tutorial tutorial);

	Tutorial findById(Long id);

	void deleteById(Long id);

}
