package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITopicRepository;
import com.app.pojos.Topic;

@Service
@Transactional
public class TopicServiceImpl implements ITopicService {

	@Autowired
	private ITopicRepository topicRepo;

	@Override
	public List<Topic> getAllTopics() {

		return topicRepo.findAll();
	}

	@Override
	public Topic findById(Long id) {

		return topicRepo.findById(id).orElseThrow(() -> new RuntimeException("Topic not found"));
	}

}
