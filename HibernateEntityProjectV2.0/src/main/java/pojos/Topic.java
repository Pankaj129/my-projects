package pojos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Topic extends BaseEntity {

	@Column(name = "topic_name", length = 30, unique = true)
	private String topicName;

	@Column(name = "topic_desc", length = 400)
	private String desciption;

	@OneToMany(mappedBy = "selectedTopic", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tutorial> tutorials = new ArrayList<>();

	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Topic(String topicName, String desciption) {
		super();
		this.topicName = topicName;
		this.desciption = desciption;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + getId() + "topicName=" + topicName + ", desciption=" + desciption + "]";
	}

	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}

	public void addTutorial(Tutorial tutorial) {
		tutorials.add(tutorial);
		tutorial.setSelectedTopic(this);
	}

	public void removeTutorial(Tutorial tutorial) {
		tutorials.remove(tutorial);
		tutorial.setSelectedTopic(this);
	}

}
