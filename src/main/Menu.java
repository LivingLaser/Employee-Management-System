package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu {
	
	private JFrame frame;
	private ImageIcon icon_1_1, image_1_1, image_1_3;
	private Image icon_1_2, image_1_2;
	private JLabel image;
	private JMenuBar menu_bar;
	private JMenu menu_1, menu_2, menu_3, menu_4, menu_5;
	private JMenuItem menu_item_1, menu_item_2, menu_item_3, menu_item_4, menu_item_5, menu_item_6, menu_item_7, menu_item_8, menu_item_9;
	private Font font_1, font_2;
	
	Menu() {
		
		frame = new JFrame("EMS - Menu");
		icon_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/EMS Logo.png"));
		icon_1_2 = icon_1_1.getImage();
		image_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/Menu Page.png"));
		image_1_2 = image_1_1.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
		image_1_3 = new ImageIcon(image_1_2);
		image = new JLabel(image_1_3);
		menu_bar = new JMenuBar();
		menu_1 = new JMenu("Profile");
		menu_item_1 = new JMenuItem("Create Profile");
		menu_item_2 = new JMenuItem("View Profile");
		menu_2 = new JMenu("Manage");
		menu_item_3 = new JMenuItem("Update Details");
		menu_3 = new JMenu("Salary");
		menu_item_4 = new JMenuItem("Add Salary");
		menu_item_5 = new JMenuItem("Update Salary");
		menu_item_6 = new JMenuItem("Generate Salary Slip");
		menu_4 = new JMenu("Delete");
		menu_item_7 = new JMenuItem("Delete Employee");
		menu_5 = new JMenu("Exit");
		menu_item_8 = new JMenuItem("Logout");
		menu_item_9 = new JMenuItem("Close");
		font_1 = new Font("arial black", Font.BOLD, 20);
		font_2 = new Font("arial black", Font.BOLD, 18);
		
		menu_item_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddEmployee();
			}
		});
		
		menu_item_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmployeeDetails();
			}
		});
		
		menu_item_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateEmployee();
			}
		});
		
		menu_item_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddSalary();
			}
		});
		
		menu_item_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateSalary();
			}
		});
		
		menu_item_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SalarySlip();
			}
		});
		
		menu_item_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteEmployee();
			}
		});
		
		menu_item_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Login();
			}
		});
		
		menu_item_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		frame.setIconImage(icon_1_2);
		frame.setSize(1200, 700);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocation(80, 20);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		menu_1.add(menu_item_1);
		menu_1.add(menu_item_2);
		menu_2.add(menu_item_3);
		menu_3.add(menu_item_4);
		menu_3.add(menu_item_5);
		menu_3.add(menu_item_6);
		menu_4.add(menu_item_7);
		menu_5.add(menu_item_8);
		menu_5.add(menu_item_9);
		menu_bar.add(menu_1);
		menu_bar.add(menu_2);
		menu_bar.add(menu_3);
		menu_bar.add(menu_4);
		menu_bar.add(menu_5);
		menu_1.setFont(font_1);
		menu_2.setFont(font_1);
		menu_3.setFont(font_1);
		menu_4.setFont(font_1);
		menu_5.setFont(font_1);
		menu_item_1.setFont(font_2);
		menu_item_2.setFont(font_2);
		menu_item_3.setFont(font_2);
		menu_item_4.setFont(font_2);
		menu_item_5.setFont(font_2);
		menu_item_6.setFont(font_2);
		menu_item_7.setFont(font_2);
		menu_item_8.setFont(font_2);
		menu_item_9.setFont(font_2);
		menu_bar.setBackground(Color.BLACK);
		menu_1.setForeground(Color.GRAY);
		menu_2.setForeground(Color.GRAY);
		menu_3.setForeground(Color.GRAY);
		menu_4.setForeground(Color.GRAY);
		menu_5.setForeground(Color.GRAY);
		menu_item_1.setBackground(Color.BLACK);
		menu_item_2.setBackground(Color.BLACK);
		menu_item_3.setBackground(Color.BLACK);
		menu_item_4.setBackground(Color.BLACK);
		menu_item_5.setBackground(Color.BLACK);
		menu_item_6.setBackground(Color.BLACK);
		menu_item_7.setBackground(Color.BLACK);
		menu_item_8.setBackground(Color.BLACK);
		menu_item_9.setBackground(Color.BLACK);
		menu_item_1.setForeground(Color.YELLOW);
		menu_item_2.setForeground(Color.YELLOW);
		menu_item_3.setForeground(Color.YELLOW);
		menu_item_4.setForeground(Color.YELLOW);
		menu_item_5.setForeground(Color.YELLOW);
		menu_item_6.setForeground(Color.YELLOW);
		menu_item_7.setForeground(Color.YELLOW);
		menu_item_8.setForeground(Color.RED);
		menu_item_9.setForeground(Color.YELLOW);
		frame.setJMenuBar(menu_bar);
		frame.add(image);
		image.setBounds(0, 0, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
