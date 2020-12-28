package ir.prince.bankdemo;

public class CibaClientAuthExcption extends Exception{

	private String description;
	
	public CibaClientAuthExcption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CibaClientAuthExcption(String message,String des) {
		super(message);
		this.description= des;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
