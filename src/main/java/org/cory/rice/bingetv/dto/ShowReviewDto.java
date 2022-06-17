package org.cory.rice.bingetv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cory.rice.bingetv.models.User;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowReviewDto {
	
	private String content;
	private User author;
	private Instant reviewed;
}
