import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;

import com.sun.javafx.binding.StringFormatter;

import java.awt.Font;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Timer extends JFrame implements Runnable{
	private JLabel timerLabel;
	private JButton cancelButton;
	private JPanel contentPane;
	private int timer = 0;
	private Command command;
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
		setBounds(400, 200, 541, 237);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		timerLabel = new JLabel("00 : 00 : 00");
		timerLabel.setFont(new Font("Tahoma", Font.BOLD, 62));
		timerLabel.setBounds(71, 0, 454, 144);
		contentPane.add(timerLabel);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		cancelButton.setBounds(186, 142, 128, 30);
		contentPane.add(cancelButton);
	}

	public void run() {
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
		
		if (command == Command.SHUTDOWN)
			com = "shutdown -s -t 0";
		else if(command == Command.RESTART)
			com = "shutdown -r -t 0";
		else if(command == Command.LOGOFF)
			com = "";
		else if(command == Command.SLEEP)
			com = "";
		
		try {
			Process process = Runtime.getRuntime().exec (com);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
