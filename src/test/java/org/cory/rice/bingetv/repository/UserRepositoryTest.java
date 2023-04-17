//package org.cory.rice.bingetv.repository;
//
//import org.cory.rice.bingetv.models.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.time.Instant;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class UserRepositoryTest {
//
//	@Autowired
//	private UserRepository userRepo;
//
//	@Test
//	void testFindByUsername() {
//
//		User user1 = new User(15l, "User1", "User1",
//				"User1@user.com", Instant.now(), true, "bio", null);
//
//		userRepo.findByUsername("User1");
//
//		assertNotNull(user1);
//	}
//}