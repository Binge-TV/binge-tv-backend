package org.cory.rice.bingetv.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
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
	private String bio = "User has not set up a profile bio";
	@JsonManagedReference
	@OneToMany(targetEntity = Shows.class, cascade = ALL,
			mappedBy = "users")
	private Set<Shows> bingedList = new LinkedHashSet<Shows>();
	
	
	public User(String username) {
		this.username = username;
		this.userId = getUserId();
	}
}
