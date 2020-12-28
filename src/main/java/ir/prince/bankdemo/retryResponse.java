package ir.prince.bankdemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class retryResponse {
	
	@JsonProperty(value = "isSuccessful")
	String isSuccessful;
	@JsonProperty(value = "error")
	String error;
	@JsonProperty(value = "interval")
	String interval;
	
	
	
	
	public retryResponse() {
		super();
	}
	
	
	
	
	public retryResponse(String isSuccessful, String error, String interval) {
		super();
		this.isSuccessful = isSuccessful;
		this.error = error;
		this.interval = interval;
	}




	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public String getIsSuccessful() {
		return isSuccessful;
	}
	public void setIsSuccessful(String isSuccessful) {
		this.isSuccessful = isSuccessful;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
}
