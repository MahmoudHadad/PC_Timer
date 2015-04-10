package Commands;

import java.io.IOException;

public class Restart extends Command{

	public Restart(String message) {
		super(message);
		
	}

	@Override
	public void execute() {
		try {
			Process process = Runtime.getRuntime().exec ("shutdown -r -t 0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
