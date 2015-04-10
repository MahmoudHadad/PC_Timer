package Commands;

import java.io.IOException;

public class Logout extends Command{

	public Logout(String message) {
		super(message);
		
	}

	@Override
	public void execute() {
		try {
			Process process = Runtime.getRuntime().exec ("shutdown/l");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
