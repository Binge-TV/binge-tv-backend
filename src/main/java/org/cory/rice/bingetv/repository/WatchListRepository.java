package org.cory.rice.bingetv.repository;

import org.cory.rice.bingetv.models.Profile;

import org.cory.rice.bingetv.models.WatchList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchListRepository extends JpaRepository<WatchList, Profile> {
}
