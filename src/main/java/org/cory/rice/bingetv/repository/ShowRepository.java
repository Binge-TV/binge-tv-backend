package org.cory.rice.bingetv.repository;

import org.cory.rice.bingetv.models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Shows,  Long>{
//	Optional<Shows> findByName(String showName);
}
