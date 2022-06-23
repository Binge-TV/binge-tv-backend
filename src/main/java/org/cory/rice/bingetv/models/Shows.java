package org.cory.rice.bingetv.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Shows")
public class Shows {
	

	@Id
	private Long showId;
	@Column
	private String showName;
	public Shows(Long showId) {
		this.showId = showId;
	}
}
