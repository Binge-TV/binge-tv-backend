package org.cory.rice.bingetv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cory.rice.bingetv.models.BingedList;

import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowsDto {
	
	private Long showId;
	private String showName;
	private Set<BingedList> bingedList;
}
