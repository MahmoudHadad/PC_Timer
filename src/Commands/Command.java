package Commands;

public abstract class Command {
	String message;
	
	
	public Command(String message) {
		super();
		this.message = message;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public abstract void execute();
}
