package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "topic_tbl")
public class Topic extends BaseEntity {
	@Column(name = "topic_name", length = 30, unique = true)
	private String topicName;
	@Column(name = "topic_desc", length = 100)
	private String desciption;

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
		return "Topic ID " + getId() + " [topicName=" + topicName + ", desciption=" + desciption + "]";
	}

}
