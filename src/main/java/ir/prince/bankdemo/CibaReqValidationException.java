package ir.prince.bankdemo;

public class CibaReqValidationException extends Exception {

	private String description;
	public CibaReqValidationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CibaReqValidationException(String message,String des) {
		super(message);
		this.description=des;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}
