//package org.cory.rice.bingetv.services;
//
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class ApiServiceTest {
//
//	@Autowired
//	private ApiService apiService;
//
//	@ParameterizedTest
//	@ValueSource(strings = {"Our Flag Means Death", "What we do in the shadows", "Charmed", "Stranger Things"})
//	void testApiCallByName(String query) {
//		try {
//			String apiCallTest = apiService.ApiCallByName(query);
//			assertNotNull(apiCallTest);
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//
//	}
//}