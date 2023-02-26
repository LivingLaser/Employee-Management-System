package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home {
	
	private JFrame frame;
	private ImageIcon icon_1_1, image_1_1, image_1_3;
	private Image icon_1_2, image_1_2;
	private JLabel heading, image;
	private JButton button;
	
	Home() {
		
		frame = new JFrame("EMS - Home");
		icon_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/EMS Logo.png"));
		icon_1_2 = icon_1_1.getImage();
		heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
		image_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/Home Page.png"));
		image_1_2 = image_1_1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
		image_1_3 = new ImageIcon(image_1_2);
		image = new JLabel(image_1_3);
		button = new JButton("Login");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Login();
			}
		});
		
		frame.setIconImage(icon_1_2);
		frame.setSize(1200, 700);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocation(80, 20);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.add(heading);
		heading.setBounds(170, 15, 1000, 60);
		heading.setFont(new Font("serif", Font.PLAIN, 50));
		heading.setForeground(Color.YELLOW);
		frame.add(button);
		button.setBounds(500, 350, 200, 70);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.YELLOW);
		button.setFont(new Font("serif", Font.BOLD, 20));
		frame.add(image);
		image.setBounds(0, 100, 1200, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true) {
			heading.setVisible(false);
			
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
			}
			
			heading.setVisible(true);
			
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
			}
		}
	}

	public static void main(String[] args) {
		
		new Home();
	}

}
