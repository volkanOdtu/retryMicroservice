package com.example.springretry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface BackEndAdapter {
	
	@Retryable(value = {RemoteServiceNotAvailableException.class} ,maxAttempts = 3 ,backoff = @Backoff(delay = 1000))
	public String getBackendResponse(boolean simulateRetry ,boolean simulateRetryFallback);
	
	@Recover
	public String getBackendResponseFallback(RuntimeException e);
}
