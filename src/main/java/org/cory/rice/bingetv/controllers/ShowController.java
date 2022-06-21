package org.cory.rice.bingetv.controllers;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.cory.rice.bingetv.dto.ShowsDto;
import org.cory.rice.bingetv.dto.UserDto;
import org.cory.rice.bingetv.mappers.BingeListMapper;
import org.cory.rice.bingetv.models.Shows;
import org.cory.rice.bingetv.repository.ShowRepository;
import org.cory.rice.bingetv.services.ApiService;
import org.cory.rice.bingetv.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
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

	private BingeListMapper bingeListMapper;
	
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
	public ResponseEntity<Void> createShow(@RequestBody ShowsDto showsDto) {
		showService.saveShow(showsDto);
		
		return new ResponseEntity<>(CREATED);
	}
	
	@GetMapping("/add/{showId}")
	public ResponseEntity<ShowsDto> getSavedShowById(@PathVariable Long showId) {
		return status(OK).body(showService.getShowById(showId));
	}
	
	
	
	
	
}
