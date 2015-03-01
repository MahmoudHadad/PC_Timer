import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;

import com.sun.javafx.binding.StringFormatter;
import com.sun.prism.Mesh;

import java.awt.Font;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class Timer extends JFrame implements Runnable{
	private JLabel timerLabel;
	private JButton cancelButton;
	private JPanel contentPane;
	private int timer = 0;
	private Command command;
	private JLabel messageLabel;
	private JLabel imageLabel;
	/**
	 * Create the frame.
	 */
	public Timer(int time, Command c) {
		setTitle("Timer");
		setResizable(false);
		timer = time ;
		command = c;
		////
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 541, 331);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		timerLabel = new JLabel("00 : 00 : 00");
		timerLabel.setForeground(new Color(165, 42, 42));
		timerLabel.setFont(new Font("IrisUPC", Font.BOLD, 90));
		timerLabel.setBounds(81, -28, 410, 352);
		contentPane.add(timerLabel);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		cancelButton.setBounds(197, 251, 128, 30);
		contentPane.add(cancelButton);
		
		messageLabel = new JLabel("");
		messageLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 38));
		messageLabel.setBounds(115, 0, 410, 69);
		contentPane.add(messageLabel);
		
		imageLabel = new JLabel("");
		imageLabel.setIcon(new ImageIcon(getClass().getResource("alarm.jpg")));
		imageLabel.setForeground(new Color(139, 0, 0));
		imageLabel.setFont(new Font("Tahoma", Font.BOLD, 62));
		imageLabel.setBounds(10, 59, 515, 168);
		contentPane.add(imageLabel);
	}

	public void run() {
		
		if (command == Command.SHUTDOWN)
			messageLabel.setText("SHUTDOWN IN");
		else if(command == Command.RESTART)
			messageLabel.setText("RESTART IN");
		else if(command == Command.LOGOFF)
			messageLabel.setText("LOGOFF IN");
		else if(command == Command.SLEEP)
			messageLabel.setText("SLEEP IN");
		else if(command == Command.HIBERNATE)
			messageLabel.setText("HIBERNATE IN");
		else if(command == Command.ALARM)
			messageLabel.setText("ALARM IN");
		
		
		int h,m,s;
		
		while (timer > -1)
		{
			h = timer /3600;
			m = timer % 3600 /60;
			s = timer%3600 %60;
			
			timerLabel.setText(String.format("%02d : %02d : %02d ",h,m,s ) );
			timer --;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String com = "";
		if(command == Command.ALARM)
		{
			new PlaySong(getClass().getResource("Loud_Alarm.wav"),21).start();
		}
		else
		{
			if (command == Command.SHUTDOWN)
				com = "shutdown -s -t 0";
			else if(command == Command.RESTART)
				com = "shutdown -r -t 0";
			else if(command == Command.LOGOFF)
				com = "shutdown/l";
			else if(command == Command.SLEEP)
				com = "";
			else if(command == Command.HIBERNATE)
				com = "shutdown -h";
			try {
				Process process = Runtime.getRuntime().exec (com);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
