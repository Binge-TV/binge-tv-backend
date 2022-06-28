package org.cory.rice.bingetv.services;

import org.cory.rice.bingetv.dto.UserDto;
import org.cory.rice.bingetv.models.User;
import org.cory.rice.bingetv.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProfileServiceTest {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ProfileService profileService;
	
	@Test
	void testGetUserById() {
		User user1 = new User(null, "User1", "User2",
				"User1@user.com", Instant.now(), true, "bio", null);
		
		userRepo.save(user1);
		
		UserDto expectedUser = profileService.getUserById(user1.getUserId());
		
		assertEquals(user1.getUserId(), expectedUser.getUserId());
	}
}