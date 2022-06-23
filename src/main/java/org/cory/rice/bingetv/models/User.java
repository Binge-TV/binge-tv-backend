package org.cory.rice.bingetv.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long userId;
	
	@Column(unique = true)
	@NotBlank(message = "Username is required")
	private String username;
	
	@NotBlank(message = "Password is required")
	private String password;

	@Email
	@Column(unique = true)
	@NotEmpty(message = "Email is required")
	private String email;
	private Instant created;
	private boolean enabled;
	private String bio;
	@OneToMany(targetEntity = Shows.class)
	private Set<Shows> bingedList;
	@OneToOne(mappedBy = "user", optional = false, cascade = ALL)
	private VerificationToken verificationToken;
	public VerificationToken getVerificationToken() {
		return verificationToken;
	}
	
	public void setVerificationToken(VerificationToken verificationToken) {
		this.verificationToken = verificationToken;
	}
}
