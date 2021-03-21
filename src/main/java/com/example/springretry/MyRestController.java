package com.example.springretry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@Autowired
	BackEndAdapter backEndAdapter;
	
	@GetMapping("/retry")
	@ExceptionHandler({Exception.class})
	public String validateSpringRetryCapability(@RequestParam(required = false) boolean simulateRetry ,
				@RequestParam(required = false) boolean simulateRetryFallback) {
		
		System.out.println("inside RestController");
		
		return backEndAdapter.getBackendResponse(simulateRetry, simulateRetryFallback);
	}
}
