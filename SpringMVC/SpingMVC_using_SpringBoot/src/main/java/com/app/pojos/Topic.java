package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "topic_tbl")
public class Topic extends BaseEntity {

	@Column(name = "topic_name", length = 50)
	private String topicName;
	@Column(name = "topic_desc", length = 150)
	private String description;

}
