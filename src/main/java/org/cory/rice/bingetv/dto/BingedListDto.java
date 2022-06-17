package org.cory.rice.bingetv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cory.rice.bingetv.models.Shows;
import org.cory.rice.bingetv.models.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BingedListDto {
	
	private Long id;
	private User owner;
	Set<Shows> bShows = new HashSet<>();
}
