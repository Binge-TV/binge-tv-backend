package org.cory.rice.bingetv.controllers;

import org.cory.rice.bingetv.BingeTvConfigProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/binge")
public class BingeController {
	
	private final BingeTvConfigProperties bingConfig;
	
	public  BingeController(BingeTvConfigProperties bingeConfig) {
		this.bingConfig = bingeConfig;
	}
	
	@GetMapping
	public Map<String, String> printAllProps(){
		return Map.of("apiKey", bingConfig.apiKey());
		
	}
}
