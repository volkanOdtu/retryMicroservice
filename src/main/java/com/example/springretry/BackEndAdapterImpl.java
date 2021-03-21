package com.example.springretry;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class BackEndAdapterImpl implements BackEndAdapter {

	@Override
	public String getBackendResponse(boolean simulateRetry, boolean simulateRetryFallback) {
		if(simulateRetry) {
			System.out.println("Simulate retry is true ,so lets simulate exception scenario");
			
			if(simulateRetryFallback) {
				throw new RemoteServiceNotAvailableException("Dont worry! Just simulated Spring-retry");
			}
			int random = new Random().nextInt(4);
			System.out.println("Random Number: " + random);
			
			if(random % 2 ==0 )
				throw new RemoteServiceNotAvailableException("Dont worry! Just simulated Spring-retry");
			
		}
		return "Hello from Remote Backend";
	}

	@Override
	public String getBackendResponseFallback(RuntimeException e) {
		System.out.println("All retries completed ,so Fallback method called");
		return "All retries completed ,so Fallback method called";
	}

}
