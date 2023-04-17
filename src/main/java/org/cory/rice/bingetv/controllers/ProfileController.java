package org.cory.rice.bingetv.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.cory.rice.bingetv.dto.UserDto;
import org.cory.rice.bingetv.models.Users;
import org.cory.rice.bingetv.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//	endpoints for all Profile related
	@Autowired
	private ProfileService profileService;
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUserProfiles() {
		return status(OK).body(profileService.getAllUsers());
	}
	
	@GetMapping("{userId}")
	public UserDto getProfileDetails(@PathVariable Long userId) {
		return profileService.getUserById(userId);
	}
	
	@PatchMapping("{userId}")
	public ResponseEntity<Users> updateUserProfile(@PathVariable Long userId, @RequestBody Users usersDetails) {
		profileService.updateUser(userId, usersDetails);
		return ResponseEntity.ok(usersDetails);
	}
	
	@DeleteMapping("{userId}")
	public ResponseEntity<HttpStatus> deleteUserProfile(@PathVariable Long userId) {
		profileService.deleteUser(userId);
		return new ResponseEntity<>(NO_CONTENT);
	}
	
}