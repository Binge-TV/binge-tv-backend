package org.cory.rice.bingetv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cory.rice.bingetv.models.Shows;
import org.cory.rice.bingetv.models.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BingedListDto {
	
	private Long id;
	private User owner;
	List<Shows> bingedShows;
}
