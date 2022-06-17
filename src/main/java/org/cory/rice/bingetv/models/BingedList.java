package org.cory.rice.bingetv.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="BingedList")
public class BingedList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;


	@OneToOne(fetch = LAZY)
	private User owner;
	@ManyToMany(targetEntity = Shows.class)
	 Set<Shows> bShows = new HashSet<>();




}
