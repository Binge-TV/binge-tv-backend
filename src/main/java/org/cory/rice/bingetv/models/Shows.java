package org.cory.rice.bingetv.models;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Shows")
public class Shows {
	

	@Id
	private Long showId;
	
	@Column
	private String showName;
	
	
	@ManyToMany(mappedBy = "bingedShows")
	private Collection<BingedList> bingedLists;
}
