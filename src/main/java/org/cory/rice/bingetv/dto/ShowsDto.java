package org.cory.rice.bingetv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cory.rice.bingetv.models.Users;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowsDto implements Serializable {
//	handles data mapping for Shows
	private Long id;
	private Long showId;
	private String showName;
	private Users users;
	
	
}
