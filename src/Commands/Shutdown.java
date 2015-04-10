package Commands;

import java.io.IOException;

public class Shutdown extends Command{

	public Shutdown(String message) {
		super(message);
		
	}

	@Override
	public void execute() {
		try {
			Process process = Runtime.getRuntime().exec ("shutdown -s -t 0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	

}
