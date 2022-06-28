package org.cory.rice.bingetv.repository;

import org.cory.rice.bingetv.models.User;
import org.cory.rice.bingetv.models.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
	Optional<VerificationToken> findByToken(String token);
	
	Optional<VerificationToken> findByUser(User user);
}