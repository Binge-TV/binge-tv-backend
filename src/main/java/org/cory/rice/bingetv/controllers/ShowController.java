package org.cory.rice.bingetv.controllers;


import lombok.AllArgsConstructor;

import lombok.RequiredArgsConstructor;
import org.cory.rice.bingetv.dto.ShowsDto;

import org.cory.rice.bingetv.exceptions.BingeTvException;
import org.cory.rice.bingetv.models.Shows;
import org.cory.rice.bingetv.models.User;
import org.cory.rice.bingetv.repository.ShowRepository;

import org.cory.rice.bingetv.services.ApiService;
import org.cory.rice.bingetv.services.ShowService;


import org.cory.rice.bingetv.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RequiredArgsConstructor
@AllArgsConstructor
//@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
@RequestMapping("api/v1/shows")
public class ShowController {
	
	@Autowired
	private ShowRepository showRepository;

	@Autowired
	private ShowService showService;
	private ApiService apiService;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	
//	public ShowController(ApiService apiService, ShowService showService) {
//		this.apiService = apiService;
//		this.showService = showService;
//	}
//	@Autowired
//	private ShowService showService;
//	private ApiService apiService;
//

	
	public ShowController(ApiService apiService, ShowService showService) {
		this.apiService = apiService;
		this.showService = showService;

	}
	
	@PostMapping
	public String searchShowByName(@RequestBody  String query) throws IOException {
		return  apiService.ApiCallByName(query);
	}
	
	@GetMapping("{showId}")
	public String getShowDetails(@PathVariable String showId) throws IOException {
		return apiService.ApiCallById(showId);
	}
	
	@GetMapping("/index")
	public ResponseEntity<List<ShowsDto>>getAllShows() {
		return status(OK).body(showService.getAllShows());
	}
	
	@PostMapping("{showId}/add")
	public ResponseEntity<Void> createShow(@RequestBody Shows shows) {
//		Shows checkUser = showRepository.findByShowId(shows.getShowId()).get();
//		String username = shows.getUsers().getUsername();
//		System.out.println("CHECKUSER " + checkUser + " USERNAME " + username);
//		if (!checkUser.getUsers().getUsername().contains(username)) {
			
			
			showService.saveShow(shows);
			return new ResponseEntity<>(CREATED);
//		}
//		return new ResponseEntity<>(HttpStatus.IM_USED);
	}
	
	@GetMapping("/add/{showId}")
	public ResponseEntity<ShowsDto> getSavedShowById(@PathVariable Long showId) {
		return status(OK).body(showService.getShowById(showId));
	}
	
}
