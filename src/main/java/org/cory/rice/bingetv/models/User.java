package org.cory.rice.bingetv.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
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
	@JsonManagedReference
	@OneToMany(targetEntity = Shows.class, cascade = ALL, fetch = LAZY,
	mappedBy = "users")
	private Set<Shows> bingedList = new LinkedHashSet<Shows>();
	
	
	public User(String username) {
		this.username = username;
		this.userId = getUserId();
	}
}
