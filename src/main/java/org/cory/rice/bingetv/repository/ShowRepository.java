package org.cory.rice.bingetv.repository;

import org.cory.rice.bingetv.models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Shows,  Long>{
}
