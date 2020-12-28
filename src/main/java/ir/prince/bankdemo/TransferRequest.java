package ir.prince.bankdemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferRequest {

	
	@JsonProperty(value = "source")
	private String source;
	
	@JsonProperty(value = "destination")
	private String destination;
	
	@JsonProperty(value = "amount")
	private double amount;
	
	@JsonProperty(value = "method")
	private String method;
	
	@JsonProperty(value = "description")
	private String description;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TransferRequest(String source, String destination, double amount, String method, String description) {
		super();
		this.source = source;
		this.destination = destination;
		this.amount = amount;
		this.method = method;
		this.description = description;
	}

	public TransferRequest() {
		super();
	}
	
	
	
	
	
}
