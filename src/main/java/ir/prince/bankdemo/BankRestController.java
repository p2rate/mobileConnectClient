package ir.prince.bankdemo;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

@org.springframework.web.bind.annotation.RestController
public class BankRestController implements InitializingBean{

	@Autowired
	private RestTemplate restTemplate;
	
	enum status {pending,confirmed,denied,timedout};
	
	Map<String, String> account2phone = new HashMap<>();
	
	Map<String, status> stat= new HashMap<>();
	Map<String, String> auth2sessionMap = new HashMap<>();
	Map<String, String> session2authMap = new HashMap<>();
	
	private String cibaUri = "http://45.129.36.178/ciba/oauth/bc-authorize";

	@Value("${bank.cookieRedirectAddress}")
	private String cookieRedirectAddress;
	
	
	
	@RequestMapping("/api/username")
	public Map<String, String> username(Principal pr) {
		
		Map<String, String> result = new HashMap<>();
		result.put("username", pr.getName());
		return result;
	}
	
	@PostMapping("/api/transfer")
	public Map<String, String> transfer(@RequestBody TransferRequest transferReq,Principal pr){
		
		Map<String, String> result = new HashMap<>();
//		
//		result.put("source", transferReq.getSource());
		
		CibaAuthenticationResponse cibaRes;
		
		try {
			cibaRes = authenticate_ciba_flow(transferReq,pr.getName());
			if(cibaRes.getError()== null) {

				String clientSessionId= UUID.randomUUID().toString();
				auth2sessionMap.put(cibaRes.getAuth_req_id(), clientSessionId);
				session2authMap.put(clientSessionId, cibaRes.getAuth_req_id());
				stat.put(clientSessionId, status.pending);
				
				result.put("isSuccessful", "true");
				result.put("error", "");
				result.put("id", clientSessionId);
				}
			else {
				result.put("isSuccessful", "false");
				result.put("error", cibaRes.getError());
				result.put("id", null);

			}
		}
		catch(Exception e) {
			result.clear();
			result.put("isSuccessful", "false");
			result.put("error", "network_err");
			result.put("id", null);

		}
		
		
		return result;
	}

	private CibaAuthenticationResponse authenticate_ciba_flow(TransferRequest transferReq,String username) throws Exception {
		// TODO Auto-generated method stub
		
		String token = UUID.randomUUID().toString();
		String phone = "";
//		phone= account2phone.get(transferReq.getSource().substring(0, 1));
		
		CibaAuthenticationRequest cibaReq = new CibaAuthenticationRequest(
				"$clientID",
				"$clientSecret",
				"openid",
				token, 
				"3",
//				phone,
				username,
				"transfer " + transferReq.getAmount() + " to " + transferReq.getDestination(),
				null,
				"10");
				
		HttpHeaders header = new HttpHeaders();
//		header.set("Authorization", "Bearer "+token);
//		header.setBearerAuth(vToken.getClient_notification_token());
		header.setContentType(MediaType.APPLICATION_JSON);
//		OtaSendRequest sms = new OtaSendRequest(username, encypted_data, sessionID);
		HttpEntity<CibaAuthenticationRequest> request = new HttpEntity<CibaAuthenticationRequest>(cibaReq, header);
		CibaAuthenticationResponse response = restTemplate.postForObject(cibaUri , request, CibaAuthenticationResponse.class);
		return response;
		
	}
	
	@GetMapping("/api/status/{id}")
	public Map<String, String> status(@PathVariable("id") String clientSessionId ){
		
		Map<String, String> r = new HashMap<>();
		status s= stat.get(clientSessionId);
		r.put("status", s!=null?s.toString():"");
		return r;
	}
	
	@GetMapping("/api/retry/{id}")
	public retryResponse retry(@PathVariable("id") String clientSessionId ){
		
//		Map<String, String> r = new HashMap<>();
		String auth_id = session2authMap.get(clientSessionId);
		
		retryResponse r;
		try {
			r = send_retry(auth_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			r = new retryResponse("false", "err_sending",null);
		}
		

		return r;
	}
	

	private retryResponse send_retry(String id) throws Exception {
		// TODO Auto-generated method stub
		
		String retryUrl = "/d893ebd9-80b0-4a58-bb4c-aeac616cca01/pa/authenticate/retry/{id}";

				
		HttpHeaders header = new HttpHeaders();
//		header.set("Authorization", "Bearer "+token);
//		header.setBearerAuth(vToken.getClient_notification_token());
		header.setContentType(MediaType.APPLICATION_JSON);
//		OtaSendRequest sms = new OtaSendRequest(username, encypted_data, sessionID);
		HttpEntity<CibaAuthenticationRequest> request = new HttpEntity<CibaAuthenticationRequest>(header);
		retryResponse response = restTemplate.postForObject(retryUrl , request, retryResponse.class);
		return response;
		
	}
	
	
	@Bean
	public RestTemplate RestTemplate() {
		
		return new RestTemplate();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		account2phone.put("1", "09981263013");
		account2phone.put("2", "09981263014");
		account2phone.put("3", "09981163018");

	}
	
	@PostMapping("/ciba/callback")
	public String cibaCallback(@RequestBody CibaTokenResponse token) {
		System.out.println(token.toString());
		if(token.getError() == null) {
			
			stat.put(auth2sessionMap.get(token.getAuth_req_id()), status.confirmed);
		}
		
		else {
			
			stat.put(auth2sessionMap.get(token.getAuth_req_id()), status.denied);

			
		}
		return "";
	}
	
	@GetMapping("/cookie")
	public RedirectView getCookie(@CookieValue(name = "JSESSIONID") String cookie) {
		
		return new RedirectView(cookieRedirectAddress+cookie);
	}
	
}
