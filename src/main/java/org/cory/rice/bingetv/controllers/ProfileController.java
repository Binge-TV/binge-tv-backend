package org.cory.rice.bingetv.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.cory.rice.bingetv.dto.UserDto;
import org.cory.rice.bingetv.models.User;
import org.cory.rice.bingetv.repository.UserRepository;
import org.cory.rice.bingetv.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@CrossOrigin("http://localhost:3000")
@RequestMapping("api/v1/profiles")
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUserProfiles() {
		return status(OK).body(profileService.getAllUsers());
	}
	
	@GetMapping("{userId}")
	public UserDto getProfileDetails(@PathVariable Long userId) {
		return profileService.getUserById(userId);
	}
	
	@PatchMapping("{userId}")
	public  ResponseEntity<User> updateUserProfile(@PathVariable Long userId, @RequestBody User userDetails) {
		profileService.updateUser(userId ,userDetails);
		
		return ResponseEntity.ok(userDetails);
	}
	
	@DeleteMapping("{userId}")
	public ResponseEntity<HttpStatus> deleteUserProfile(@PathVariable Long userId) {
		profileService.deleteUser(userId);
		return new ResponseEntity<>(NO_CONTENT);
	}
	
}