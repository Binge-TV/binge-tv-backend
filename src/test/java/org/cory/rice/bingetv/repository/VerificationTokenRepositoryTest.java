//package org.cory.rice.bingetv.repository;
//
//import org.cory.rice.bingetv.models.User;
//import org.cory.rice.bingetv.models.VerificationToken;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.time.Instant;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class VerificationTokenRepositoryTest {
//
//	@Autowired
//	private VerificationTokenRepository verifyTokenRepo;
//
//	@Test
//	void testFindByToken() {
//		User user1 = new User(4l, "User1", "User2",
//				"User1@user.com", Instant.now(), true, "bio", null);
//		VerificationToken verifyToken =
//				new VerificationToken(5l, "892342834703487", user1);
//		verifyTokenRepo.findByToken("892342834703487");
//		String checkVerifyToken = "892342834703487";
//		VerificationToken savedToken = verifyTokenRepo.save(verifyToken);
//
//		assertEquals(savedToken, verifyTokenRepo.findByToken(checkVerifyToken).get());
//	}
//
//	@Test
//	void testFindByUser() {
//		User user1 = new User(4l, "User1", "User2",
//				"User1@user.com", Instant.now(), true, "bio", null);
//		VerificationToken verifyToken =
//				new VerificationToken(5l, "892342834703487", user1);
//		VerificationToken savedToken = verifyTokenRepo.save(verifyToken);
//		assertEquals(savedToken, verifyTokenRepo.findByUser(user1).get());
//	}
//}