package pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Tutorial extends BaseEntity {

	@Column(name = "tut_name", length = 30, unique = true)
	private String tutName;

	@Column(name = "publish_date", nullable = false)
	private LocalDate pubDate;

	@Column(length = 500)
	private String content;

	@Column(name = "no_of_visit")
	private int visits;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topic_id", nullable = false)
	private Topic selectedTopic;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", nullable = false)
	private User author;

	public Tutorial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tutorial(String tutName, LocalDate pubDate, String content, int visits) {
		super();
		this.tutName = tutName;
		this.pubDate = pubDate;
		this.content = content;
		this.visits = visits;
	}

	public String getTutName() {
		return tutName;
	}

	public void setTutName(String tutName) {
		this.tutName = tutName;
	}

	public LocalDate getPubDate() {
		return pubDate;
	}

	public void setPubDate(LocalDate pubDate) {
		this.pubDate = pubDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public Topic getSelectedTopic() {
		return selectedTopic;
	}

	public void setSelectedTopic(Topic selectedTopic) {
		this.selectedTopic = selectedTopic;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Tutorial Id : " + getId() + " [tutName=" + tutName + ", pubDate=" + pubDate + ", content=" + content
				+ ", visits=" + visits + "]";
	}

}
