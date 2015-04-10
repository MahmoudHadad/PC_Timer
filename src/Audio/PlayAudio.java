package Audio;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class PlayAudio {
	public static double playSound(URL file) {
	    
   	 try {
   		 
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
	        
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        AudioFormat format = audioInputStream.getFormat();
	        long frames = audioInputStream.getFrameLength();
	        double durationInSeconds = (frames+0.0) / format.getFrameRate();  
	        clip.start();
	        return durationInSeconds;
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
   	 return 0;
	}
}
