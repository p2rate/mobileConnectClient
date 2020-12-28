package ir.prince.bankdemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CibaTokenResponse {

	@JsonProperty(value = "auth_req_id")
	private String auth_req_id;
	
	@JsonProperty(value = "access_token")
	private String access_token;
	
	@JsonProperty(value = "token_type")
	private String token_type;
	
	@JsonProperty(value = "refresh_token")
	private String refresh_token;
	
	@JsonProperty(value = "expires_in")
	private int expires_in;
	
	@JsonProperty(value = "error")
	private String error;
	
	@JsonProperty(value = "error_description")
	private String error_description;
	
	
	public CibaTokenResponse(String error, String error_description) {
		super();
		this.error = error;
		this.error_description = error_description;
	}

	public CibaTokenResponse(String auth_req_id, String access_token, String token_type, String refresh_token,
			int expires_in) {
		super();
		this.auth_req_id = auth_req_id;
		this.access_token = access_token;
		this.token_type = token_type;
		this.refresh_token = refresh_token;
		this.expires_in = expires_in;
	}
	
	
	

	public CibaTokenResponse() {
		super();
	}

	public String getAuth_req_id() {
		return auth_req_id;
	}

	public void setAuth_req_id(String auth_req_id) {
		this.auth_req_id = auth_req_id;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
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

	@Override
	public String toString() {
		return "CibaTokenResponse [auth_req_id=" + auth_req_id + ", access_token=" + access_token + ", token_type="
				+ token_type + ", refresh_token=" + refresh_token + ", expires_in=" + expires_in + ", error=" + error
				+ ", error_description=" + error_description + "]";
	}
	
	
	
}
