package org.cory.rice.bingetv.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TV Shows")
public class TvShow {
	
	@Id
	private Integer showId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Likes")
	private Integer likes;
}
