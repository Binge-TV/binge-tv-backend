package org.cory.rice.bingetv.controllers;


import org.cory.rice.bingetv.repository.ShowRepository;
import org.cory.rice.bingetv.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
@RequestMapping("api/v1/shows")
public class ShowController {
	
	@Autowired
	private ShowRepository showRepository;
	
	private ApiService apiService;
	
	public ShowController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@GetMapping
	public String searchShowByName(@RequestBody  String query) throws IOException {
		System.out.println(query);
		return  apiService.ApiCallByName(query);
	}
	
	@GetMapping("{showId}")
	public String getShowDetails(@PathVariable Integer showId) throws IOException {
		return ApiService.ApiCallById(showId);
	}
	
	
	
	
	
}
