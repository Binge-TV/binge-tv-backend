package org.cory.rice.bingetv.repository;

import org.cory.rice.bingetv.models.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
	/**
	 * @param token
	 * @return
	 */
	Optional<RefreshToken> findByToken(String token);
	
	/**
	 * @param token
	 */
	void deleteByToken(String token);
}