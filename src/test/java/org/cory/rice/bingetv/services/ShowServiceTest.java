//package org.cory.rice.bingetv.services;
//
//import org.cory.rice.bingetv.dto.ShowsDto;
//import org.cory.rice.bingetv.mappers.ShowMapper;
//import org.cory.rice.bingetv.models.Shows;
//import org.cory.rice.bingetv.models.User;
//import org.cory.rice.bingetv.repository.ShowRepository;
//import org.cory.rice.bingetv.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.Instant;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//@Transactional
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class ShowServiceTest {
//	@Autowired
//	private ShowRepository showRepository;
//	@Autowired
//	UserDetailsServiceImpl userDetailsService;
//	@Autowired
//	private ShowService showService;
//	@Autowired
//	private UserRepository userRepo;
//
//	@Test
//	void testGetShowById() {
//		User user1 = new User(null, "User1", "User2",
//				"User1@user.com", Instant.now(), true, "bio", null);
//		userRepo.save(user1);
//		Shows show1 = new Shows(null, 1981l, "Charmed", user1);
//		Shows savedShow = showRepository.save(show1);
//		ShowsDto testShow = showService.getShowById(1981l);
//		assertEquals(savedShow.getShowId(), testShow.getShowId());
//
//	}
//}