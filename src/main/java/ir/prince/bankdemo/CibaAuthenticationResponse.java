package ir.prince.bankdemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CibaAuthenticationResponse {

	
	@JsonProperty(value = "auth_req_id")
	private String auth_req_id;
	
	@JsonProperty(value = "expires_in")
	private int expires_in;
	
	@JsonProperty(value = "interval")
	private int interval;
	
	@JsonProperty(value = "error")
	private String error;
	
	@JsonProperty(value = "error_description")
	private String error_description;

	public String getAuth_req_id() {
		return auth_req_id;
	}

	public void setAuth_req_id(String auth_req_id) {
		this.auth_req_id = auth_req_id;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError_description() {
		return error_description;
	}

	public void setError_description(String error_description) {
		this.error_description = error_description;
	}

	public CibaAuthenticationResponse(String auth_req_id, int expires_in, int interval) {
		super();
		this.auth_req_id = auth_req_id;
		this.expires_in = expires_in;
		this.interval = interval;
	}

	public CibaAuthenticationResponse(String error, String error_description) {
		super();
		this.error = error;
		this.error_description = error_description;
	}

	public CibaAuthenticationResponse() {
		super();
	}
	
	
	
}
