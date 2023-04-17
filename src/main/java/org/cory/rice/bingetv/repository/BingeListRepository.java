package org.cory.rice.bingetv.repository;

import org.cory.rice.bingetv.models.BingeList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BingeListRepository extends JpaRepository<BingeList, Long> {
    Optional<BingeList> findByShowId(Long showId);
}
