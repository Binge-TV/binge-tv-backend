package org.cory.rice.bingetv.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cory.rice.bingetv.dto.AuthenticationResponse;
import org.cory.rice.bingetv.dto.LoginRequest;
import org.cory.rice.bingetv.dto.RefreshTokenRequest;
import org.cory.rice.bingetv.dto.RegisterRequest;
import org.cory.rice.bingetv.exceptions.BingeTvException;
import org.cory.rice.bingetv.models.NotificationEmail;
import org.cory.rice.bingetv.models.User;
import org.cory.rice.bingetv.models.VerificationToken;
import org.cory.rice.bingetv.repository.UserRepository;
import org.cory.rice.bingetv.repository.VerificationTokenRepository;
import org.cory.rice.bingetv.security.JwtProvider;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class AuthService {
	
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	private final VerificationTokenRepository verificationTokenRepository;
	private final MailService mailService;
	private final AuthenticationManager authenticationManager;
	private final JwtProvider jwtProvider;
	private final RefreshTokenService refreshTokenService;
	
	
	public void signup(RegisterRequest registerRequest) {
		User user = new User();//creates new user from RegisterRequest DTO
		user.setUsername(registerRequest.getUsername());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		user.setCreated(Instant.now());//current time at creation
		user.setEnabled(false);//used for email verification
		
		userRepository.save(user);
		
		String token = generateVerificationToken(user);//creates JWT token from user
		mailService.sendMail(new NotificationEmail("Please Activate your Account",
				user.getEmail(), "Thank you for signing up to Binge[TV], " +
				"please click on the below url to activate your account : " +
				"http://localhost:8080/api/v1/auth/accountVerification/" + token));//send account verification endpoint
		// for user to verify email and setEnabled to true to allow login
	}
	
	@Transactional(readOnly = true)
	public User getCurrentUser() {
		Jwt principal = (Jwt) SecurityContextHolder.
				getContext().getAuthentication().getPrincipal();
		
		return userRepository.findByUsername(principal.getSubject())
				.orElseThrow(() -> new UsernameNotFoundException("User name not found - "));
	}
	
	private void fetchUserAndEnable(VerificationToken verificationToken) {
		String username = verificationToken.getUser().getUsername();
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new BingeTvException("User not found with name - " + username));
		user.setEnabled(true);
		userRepository.save(user);//after user click email verification link this sets the user to enabled
	}
	
	private String generateVerificationToken(User user) {
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setUser(user);//creates verification token for user on signup
		
		verificationTokenRepository.save(verificationToken);
		return token;
	}
	
	public void verifyAccount(String token) {
		Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
		verificationToken.orElseThrow(() -> new BingeTvException("Invalid Token"));
		fetchUserAndEnable(verificationToken.get());//uses verification token for authorization
	}
	
	//login method called in auth controller
	public AuthenticationResponse login(LoginRequest loginRequest) {
		Authentication authenticate = authenticationManager.authenticate
				(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
						loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		String token = jwtProvider.generateToken(authenticate);
		return AuthenticationResponse.builder()
				.authenticationToken(token)
				.refreshToken(refreshTokenService.generateRefreshToken().getToken())
				.expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
				.username(loginRequest.getUsername())
				.build();
	}
	//creates refresh token and set the exp date
	public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
		refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
		String token = jwtProvider.generateTokenWithUserName(refreshTokenRequest.getUsername());
		return AuthenticationResponse.builder()
				.authenticationToken(token)
				.refreshToken(refreshTokenRequest.getRefreshToken())
				.expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
				.username(refreshTokenRequest.getUsername())
				.build();
	}
	
	public boolean isLoggedIn() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
	}
	
}
