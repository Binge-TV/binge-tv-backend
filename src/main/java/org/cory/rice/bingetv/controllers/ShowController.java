package org.cory.rice.bingetv.controllers;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.cory.rice.bingetv.repository.ShowRepository;
import org.cory.rice.bingetv.services.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@Data
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
@RequestMapping("api/v1/shows")
public class ShowController {
	
	@Autowired
	private ShowRepository showRepository;
	
	private ShowsService showsService;
	
	public ShowController(ShowsService showsService) {
		this.showsService = showsService;
	}
	
	@PostMapping
	public String searchShowByName(@RequestBody  String query) throws IOException {
		return  showsService.ApiCallByName(query);
	}
	
	@GetMapping("{showId}")
	public String getShowDetails(@PathVariable String showId) throws IOException {
		return showsService.ApiCallById(showId);
	}
	
	
	
	
	
}
