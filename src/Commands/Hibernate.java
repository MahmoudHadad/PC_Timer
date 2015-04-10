package Commands;

import java.io.IOException;

public class Hibernate extends Command{

	public Hibernate(String message) {
		super(message);
		
	}

	@Override
	public void execute() {
		try {
			Process process = Runtime.getRuntime().exec ("shutdown -h");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
