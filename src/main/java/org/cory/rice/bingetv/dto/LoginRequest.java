package org.cory.rice.bingetv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
//	handles Request params for Login
	private String username;
	private String password;
}
