package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tutorial_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "selectedTopic", "author" })
public class Tutorial extends BaseEntity {

	@Column(name = "tutorial_name")
	private String tutorialName;
	@Column(name = "publish_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate publishDate;
	@Column(name = "total_visits")
	private int visits;
	@Column(length = 400)
	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topic_id", nullable = false)
	private Topic selectedTopic;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User author;

}
