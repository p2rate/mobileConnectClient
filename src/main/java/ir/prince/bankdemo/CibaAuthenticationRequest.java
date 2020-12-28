package ir.prince.bankdemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CibaAuthenticationRequest {

	
	@JsonProperty(value = "client_name")
	private String client_name;
	@JsonProperty(value = "client_secret")
	private String client_secret;
	
	@JsonProperty(value = "scope")
	private String scope;
	@JsonProperty(value = "client_notification_token")
	private String client_notification_token;
	@JsonProperty(value = "acr_values")
	private String acr_values;
	@JsonProperty(value = "login_hint_token")
	private String login_hint_token;
	@JsonProperty(value = "id_token_hint")
	private String id_token_hint;
	@JsonProperty(value = "login_hint")
	private String login_hint;
	@JsonProperty(value = "binding_message")
	private String binding_message;
	@JsonProperty(value = "user_code")
	private String user_code;
	@JsonProperty(value = "requested_expiry")
	private String requested_expiry;
	
	
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getClient_notification_token() {
		return client_notification_token;
	}
	public void setClient_notification_token(String client_notification_token) {
		this.client_notification_token = client_notification_token;
	}
	public String getAcr_values() {
		return acr_values;
	}
	public void setAcr_values(String acr_values) {
		this.acr_values = acr_values;
	}
	public String getLogin_hint_token() {
		return login_hint_token;
	}
	public void setLogin_hint_token(String login_hint_token) {
		this.login_hint_token = login_hint_token;
	}
	public String getId_token_hint() {
		return id_token_hint;
	}
	public void setId_token_hint(String id_token_hint) {
		this.id_token_hint = id_token_hint;
	}
	public String getLogin_hint() {
		return login_hint;
	}
	public void setLogin_hint(String login_hint) {
		this.login_hint = login_hint;
	}
	public String getBinding_message() {
		return binding_message;
	}
	public void setBinding_message(String binding_message) {
		this.binding_message = binding_message;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getRequested_expiry() {
		return requested_expiry;
	}
	public void setRequested_expiry(String requested_expiry) {
		this.requested_expiry = requested_expiry;
	}
	
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getClient_secret() {
		return client_secret;
	}
	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}
	
	
	public CibaAuthenticationRequest(String client_name, String client_secret, String scope,
			String client_notification_token, String acr_values,
			String login_hint, String binding_message, String user_code, String requested_expiry) {
		super();
		this.client_name = client_name;
		this.client_secret = client_secret;
		this.scope = scope;
		this.client_notification_token = client_notification_token;
		this.acr_values = acr_values;
		this.login_hint = login_hint;
		this.binding_message = binding_message;
		this.user_code = user_code;
		this.requested_expiry = requested_expiry;
	}
	public CibaAuthenticationRequest() {
		super();
	}
	
	
	
	

		
		
		
		
		
		
		


}
