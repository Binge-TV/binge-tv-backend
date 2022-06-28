package org.cory.rice.bingetv.services;

import lombok.AllArgsConstructor;
import org.cory.rice.bingetv.exceptions.BingeTvException;
import org.cory.rice.bingetv.models.RefreshToken;
import org.cory.rice.bingetv.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenService {
	
	private final RefreshTokenRepository refreshTokenRepository;
	
	public RefreshToken generateRefreshToken() {
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setToken(UUID.randomUUID().toString());
		refreshToken.setCreatedDate(Instant.now());
		return refreshTokenRepository.save(refreshToken);//creates and saves refresh token
	}
	
	void validateRefreshToken(String token) {//checks if token exists
		refreshTokenRepository.findByToken(token)
				.orElseThrow(() -> new BingeTvException("Invalid refresh Token"));
	}
	
	public void deleteRefreshToken(String token) {
		refreshTokenRepository.deleteByToken(token);
	}
}