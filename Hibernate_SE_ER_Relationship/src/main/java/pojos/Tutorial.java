package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tutorial_tbl")
public class Tutorial extends BaseEntity {
	@Column(name = "tutorial_name", length = 20, unique = true)
	private String tutName;
	@Column(name = "publish_date")
	private LocalDate publishDate;
	private int visits;
	@Column(length = 400)
	private String contents;
	// additional prop. to establish uni-directn relationship from Tutorial *--->1Topic
	@ManyToOne
	@JoinColumn(name = "topic_id", nullable = false)
	private Topic selectedTopic;
	@ManyToOne
	@JoinColumn(nullable = false)
	private User author;

	public Tutorial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tutorial(String tutName, LocalDate publishDate, int visits, String contents) {
		super();
		this.tutName = tutName;
		this.publishDate = publishDate;
		this.visits = visits;
		this.contents = contents;
	}

	public String getTutName() {
		return tutName;
	}

	public void setTutName(String tutName) {
		this.tutName = tutName;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Topic getSelectedTopic() {
		return selectedTopic;
	}

	public void setSelectedTopic(Topic selectedTopic) {
		this.selectedTopic = selectedTopic;
	}

	@Override
	public String toString() {
		return "Tutorial ID  " + getId() + "[tutName=" + tutName + ", publishDate=" + publishDate + ", visits=" + visits
				+ ", contents=" + contents + "]";
	}

}
