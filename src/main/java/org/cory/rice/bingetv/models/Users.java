package org.cory.rice.bingetv.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity(name = "Users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long userId;
	
	@Column(unique = true)
	@NotBlank(message = "Username is required")
	private String username;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Email
	@Column(unique = true)
	@NotEmpty(message = "Email is required")
	private String email;
	@Column
	private String bio = "User has not set up a profile bio";
	@Column
	private Instant created;
	@Column
	private Instant updated;
	@Column
	private boolean enabled;

	@JsonManagedReference
	@OneToMany(targetEntity = BingeList.class, cascade = ALL,
			mappedBy = "users")
	@ToString.Exclude
	private Set<BingeList> bingedList = new LinkedHashSet<BingeList>();

	public Users(String username) {
		this.username = username;
		this.userId = getUserId();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Users users = (Users) o;
		return enabled == users.enabled && Objects.equals(userId, users.userId) && Objects.equals(username, users.username) && Objects.equals(firstName, users.firstName) && Objects.equals(lastName, users.lastName) && Objects.equals(email, users.email) && Objects.equals(bio, users.bio) && Objects.equals(created, users.created) && Objects.equals(updated, users.updated) && Objects.equals(bingedList, users.bingedList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, username, firstName, lastName, email, bio, created, updated, enabled, bingedList);
	}
}
