package org.cory.rice.bingetv.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cory.rice.bingetv.models.BingedList;
import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private Long userId;
	private String username;
	private String email;
	private BingedList bingedList;
	private Instant created;
	private String password;
}
