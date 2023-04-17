package org.cory.rice.bingetv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
//	handles data mapping for User in junction with MapStruct library
	private Long userId;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String bio;
	private BingeListDto bingeList;
	private Instant created;
	private Instant updated;
	private boolean enabled;
}
