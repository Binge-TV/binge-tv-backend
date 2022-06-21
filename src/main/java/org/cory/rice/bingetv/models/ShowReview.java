package org.cory.rice.bingetv.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

import static javax.persistence.CascadeType.ALL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShowReview implements Serializable {
	@Id
	private Long reviewId;
	private String content;
	
	@ManyToOne(optional = false, cascade = ALL)
	@JoinColumn(name = "author_email", nullable = false, unique = true)
	private User author;
	private Instant reviewedTime;
}
