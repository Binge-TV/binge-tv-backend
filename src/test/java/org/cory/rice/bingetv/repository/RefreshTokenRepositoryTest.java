package org.cory.rice.bingetv.repository;

import org.cory.rice.bingetv.models.RefreshToken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RefreshTokenRepositoryTest {
	@Autowired
	private RefreshTokenRepository refreshTokenRepo;
	
	@Test
	@DisplayName("Find refresh token by string value of token")
	void testFindByToken() {
		RefreshToken refToken =
				new RefreshToken(7L, "hjdslhaf345435546", Instant.now());
		String testToken = "hjdslhaf345435546";
		RefreshToken savedToken = refreshTokenRepo.save(refToken);
		assertEquals(savedToken, refreshTokenRepo.findByToken(testToken).get());
	}
	
	@Test
	void testDeleteByToken() {
		RefreshToken refToken =
				new RefreshToken(7L, "hjdslhaf345435546", Instant.now());
		String deletedToken = "hjdslhaf345435546";
		RefreshToken savedToken = refreshTokenRepo.save(refToken);
		assertNotNull(savedToken);
		refreshTokenRepo.deleteByToken(deletedToken);
		assertNotSame(savedToken, refreshTokenRepo.findByToken(savedToken.getToken()));
		
	}
}