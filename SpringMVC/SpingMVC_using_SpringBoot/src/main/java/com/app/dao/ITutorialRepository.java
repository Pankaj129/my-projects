package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Tutorial;

public interface ITutorialRepository extends JpaRepository<Tutorial, Long> {

	@Query("select t from Tutorial t join fetch t.selectedTopic where t.author.id = :authorId")
	List<Tutorial> findByAuthorId(Long authorId);

	@Query("select t from Tutorial t join fetch t.selectedTopic where t.selectedTopic.id = :topicId "
			+ "order by t.visits desc, t.publishDate desc")
	List<Tutorial> findByTopicSorted(Long topicId);

	@Query("select t from Tutorial t join fetch t.selectedTopic order by t.visits desc, t.publishDate desc")
	List<Tutorial> findAllSorted();

}
