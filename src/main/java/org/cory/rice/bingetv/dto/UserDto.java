package org.cory.rice.bingetv.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.cory.rice.bingetv.models.Shows;

import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private Long userId;
	private String username;
	private String email;
	private String bio;
	private Set<Shows> bingedList;
	private Instant created;
	private String password;
}
