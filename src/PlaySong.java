import java.net.URL;

class PlaySong extends Thread 
{
	URL file ;
	int durationToWait;
	public PlaySong(URL f, int durationToWait) {
		// TODO Auto-generated constructor stub
		file = f;
		this.durationToWait = durationToWait;
	}
	public void run()
	{
		int duration;
		System.out.println("in");
		int i=0;
		double d = PlayAudio.playSound(file) * 1000;
		duration = (int)d;
		try {
			sleep(duration + durationToWait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		while(true)
		{
			PlayAudio.playSound(file) ;
			System.out.println(i);
			try {
				sleep(duration + durationToWait);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
	}
}