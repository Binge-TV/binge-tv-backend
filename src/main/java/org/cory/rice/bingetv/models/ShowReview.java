package org.cory.rice.bingetv.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShowReview implements Serializable {
	
	private String content;
	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "author_email", nullable = false)
	private User author;
	private Instant reviewed;
	
	
}
