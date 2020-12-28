package ir.prince.bankdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@org.springframework.stereotype.Controller
public class Controller {

//	@GetMapping("/")
//	public RedirectView index() {
//		
//		return new RedirectView("/loginpage");
//	}
	
	@GetMapping("/")
	public String index() {
		return "index";
//		return new RedirectView("/loginpage");
	}
	
	@GetMapping("/loginpage")
	public String login() {
		
		return "index";
	}
	
	@GetMapping("/dashboard/banktransfer")
	public String transfer() {
		
		return "index";
	}
	
	@GetMapping("/dashboard/banktransfersuccess")
	public String success() {
		
		return "index";
	}
	
	@GetMapping("/dashboard/banktransferfail")
	public String fail() {
		
		return "index";
	}
	
	@GetMapping("/handler/savetoken")
	public String savetoken() {
		
		return "index";
	}
}
