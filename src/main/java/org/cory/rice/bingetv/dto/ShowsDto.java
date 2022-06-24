package org.cory.rice.bingetv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cory.rice.bingetv.models.User;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowsDto {
	
	private Long showId;
	private String showName;
	private User users;
	
	

}
