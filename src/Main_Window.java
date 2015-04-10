import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.smartcardio.CommandAPDU;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.SpinnerModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import Commands.Alarm;
import Commands.Command;

import Commands.Hibernate;
import Commands.Logout;
import Commands.Restart;
import Commands.Shutdown;



import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Main_Window extends JFrame {

	private JPanel contentPane;
	private JSpinner hoursSpinner;
	private JSpinner minutsSpinner;
	private JSpinner secondsSpinner;
	private JButton startButton;
	private ButtonGroup bg;

	
	JRadioButton shutdownRB;
	JRadioButton restartRB;
	JRadioButton hibernateRB;
	JRadioButton alarmRB;
	JRadioButton logoffRB;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Window frame = new Main_Window();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_Window() {
		setTitle("PC_Controller");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 459, 257);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		bg = new ButtonGroup();

		
		hoursSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
		hoursSpinner.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		hoursSpinner.setBounds(116, 85, 54, 28);
		contentPane.add(hoursSpinner);
		
		shutdownRB = new JRadioButton("Shutdown");
		shutdownRB.setFont(new Font("Tahoma", Font.BOLD, 14));
		shutdownRB.setSelected(true);
		shutdownRB.setBounds(158, 22, 109, 23);
		contentPane.add(shutdownRB);
		
		hibernateRB = new JRadioButton("Hibernate");
		hibernateRB.setFont(new Font("Tahoma", Font.BOLD, 14));
		hibernateRB.setBounds(297, 55, 109, 23);
		contentPane.add(hibernateRB);
		
		restartRB = new JRadioButton("Restart");
		restartRB.setFont(new Font("Tahoma", Font.BOLD, 14));
		restartRB.setBounds(26, 55, 109, 23);
		contentPane.add(restartRB);
		
		alarmRB = new JRadioButton("Alarm");
		alarmRB.setFont(new Font("Tahoma", Font.BOLD, 14));
		alarmRB.setBounds(297, 118, 109, 23);
		contentPane.add(alarmRB);
		
		logoffRB = new JRadioButton("Logoff");
		logoffRB.setFont(new Font("Tahoma", Font.BOLD, 14));
		logoffRB.setBounds(26, 118, 82, 23);
		contentPane.add(logoffRB);
		
		minutsSpinner = new JSpinner(new SpinnerNumberModel(1, 0, 60, 1));
		minutsSpinner.setFont(new Font("Tahoma", Font.BOLD, 11));
		minutsSpinner.setBounds(185, 85, 54, 28);
		contentPane.add(minutsSpinner);
		
		secondsSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 60, 1));
		secondsSpinner.setFont(new Font("Tahoma", Font.BOLD, 11));
		secondsSpinner.setBounds(257, 85, 54, 28);
		contentPane.add(secondsSpinner);
		
		startButton = new JButton("Start");
		startButton.setForeground(Color.BLUE);
		startButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int time =(Integer)hoursSpinner.getValue() * 3600 + (Integer)minutsSpinner.getValue() * 60 + (Integer)secondsSpinner.getValue() ;
			 Command c = null ;
			 	if(shutdownRB.isSelected() == true)
			 		c = new Shutdown("Shutdown In");
			 	
			 	else if(restartRB.isSelected() == true)
					c = new Restart("Restart In");
				
			 	else if(alarmRB.isSelected()== true)
					c = new Alarm("Alarm In");
			
				else if(hibernateRB.isSelected()== true)
					c = new Hibernate("Hibernate In");
			 
				else if(logoffRB.isSelected()== true)
					c = new Logout ("Logout In");
				
				Timer t  = new Timer(time, c);
				t.setVisible(true);
				new Thread(t).start();
				dispose();
			}
		});
		startButton.setBounds(158, 158, 102, 23);
		contentPane.add(startButton);
		
		JLabel lblH = new JLabel("H");
		lblH.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblH.setBounds(116, 120, 46, 14);
		contentPane.add(lblH);
		
		JLabel lblM = new JLabel("M");
		lblM.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblM.setBounds(185, 120, 46, 14);
		contentPane.add(lblM);
		
		JLabel lblS = new JLabel("S");
		lblS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblS.setBounds(257, 120, 34, 14);
		contentPane.add(lblS);
		bg.add(shutdownRB);
		bg.add(alarmRB);
		bg.add(restartRB);
		bg.add(hibernateRB);
		bg.add(logoffRB);
	}
}
