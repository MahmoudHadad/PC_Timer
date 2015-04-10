package Commands;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import Audio.PlaySong;

public class Alarm extends Command{

	public Alarm(String message) {
		super(message);
		
	}

	@Override
	public void execute() {
		File f;
//		f = new File(getClass().getResource("Loud_Alarm.wav").toString());
		System.out.println(getClass().getResource(""));
		new PlaySong(getClass().getResource("Loud_Alarm.wav"),21).start();
		
		
	}
	
}
