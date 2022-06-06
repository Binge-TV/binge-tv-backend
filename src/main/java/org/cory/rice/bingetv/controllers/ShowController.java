package org.cory.rice.bingetv.controllers;


import org.cory.rice.bingetv.models.TvShow;
import org.cory.rice.bingetv.repository.ShowRepository;
import org.cory.rice.bingetv.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
@RequestMapping("api/v1/shows")
public class ShowController {
	
	@Autowired
	private ShowRepository showRepository;
	
	@GetMapping
	public String searchShowByName(String query) throws IOException {
		return ApiService.ApiCallByName(query);
	}
	
	@GetMapping("{showId}")
	public String getShowDetails(@PathVariable Integer showId) throws IOException {
		return ApiService.ApiCallById(showId);
	}
	
	
	
	
	
}
