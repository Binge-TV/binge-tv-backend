package org.cory.rice.bingetv.models;

import jakarta.persistence.*;
import lombok.*;


import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "Shows")
public class Shows {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private Long showId;
	@Column
	private String showName;
	@Column
	private String imageUrl;
	@Column
	private Instant dateAdded;
	@Column
	private Instant dateUpdated;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Shows shows = (Shows) o;
		return Objects.equals(id, shows.id) && Objects.equals(showId, shows.showId) && Objects.equals(showName, shows.showName) && Objects.equals(imageUrl, shows.imageUrl) && Objects.equals(dateAdded, shows.dateAdded) && Objects.equals(dateUpdated, shows.dateUpdated);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, showId, showName, imageUrl, dateAdded, dateUpdated);
	}
}
