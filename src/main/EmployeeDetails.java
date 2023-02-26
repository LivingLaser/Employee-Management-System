package main;
import ops.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EmployeeDetails implements View {
	
	private JFrame frame_1, frame_2;
	private JPanel panel;
	private ImageIcon icon_1_1, image_1_1, image_1_3;
	private Image icon_1_2, image_1_2;
	private JLabel image, heading;
	private JLabel label_1, label_2, label_3, label_4, label_5, label_6, label_7, label_8, label_9, label_10;
	private JLabel label_text_1, label_text_2, label_text_3, label_text_4, label_text_5, label_text_6, label_text_7, label_text_8, label_text_9;
	private JTextField text;
	private Font font;
	private JButton button_1, button_2, button_3, button_4;
	private String e_id_1, e_id_2;
	
	EmployeeDetails() {
		
		frame_1 = new JFrame("EMS - Employee Details");
		frame_2 = new JFrame("EMS - Employee Details");
		panel = new JPanel();
		icon_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/EMS Logo.png"));
		icon_1_2 = icon_1_1.getImage();
		image_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/Profile.png"));
		image_1_2 = image_1_1.getImage().getScaledInstance(600, 340, Image.SCALE_DEFAULT);
		image_1_3 = new ImageIcon(image_1_2);
		image = new JLabel(image_1_3);
		heading = new JLabel("Employee Details");
		label_1 = new JLabel("Employee Id");
		label_2 = new JLabel("Employee Id:");
		label_3 = new JLabel("Name:");
		label_4 = new JLabel("Father's Name:");
		label_5 = new JLabel("DOB:");
		label_6 = new JLabel("Address:");
		label_7 = new JLabel("Phone:");
		label_8 = new JLabel("Email Id:");
		label_9 = new JLabel("Education:");
		label_10 = new JLabel("Job Post:");
		label_text_1 = new JLabel();
		label_text_2 = new JLabel();
		label_text_3 = new JLabel();
		label_text_4 = new JLabel();
		label_text_5 = new JLabel();
		label_text_6 = new JLabel();
		label_text_7 = new JLabel();
		label_text_8 = new JLabel();
		label_text_9 = new JLabel();
		text = new JTextField();
		font = new Font("serif", Font.BOLD, 25);
		button_1 = new JButton("Search");
		button_2 = new JButton("Cancel");
		button_3 = new JButton("Print");
		button_4 = new JButton("Cancel");
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getView();
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_1.dispose();
			}
		});
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Printer().getPrint(panel);
			}
		});
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_2.dispose();
			}
		});
		
		frame_1.setIconImage(icon_1_2);
		frame_1.setSize(600, 340);
		frame_1.setResizable(false);
		frame_1.setLayout(null);
		frame_1.setLocation(400, 200);
		frame_1.getContentPane().setBackground(Color.WHITE);
		frame_1.setVisible(true);
		frame_1.add(label_1);
		label_1.setBounds(90, 40, 200, 100);
		label_1.setFont(new Font("arial black", Font.BOLD, 25));
		frame_1.add(text);
		text.setBounds(280, 75, 200, 35);
		text.setFont(new Font("serif", Font.BOLD, 20));
		frame_1.add(button_1);
		button_1.setBounds(150, 180, 100, 40);
		button_1.setBackground(Color.BLACK);
		button_1.setForeground(Color.WHITE);
		frame_1.add(button_2);
		button_2.setBounds(350, 180, 100, 40);
		button_2.setBackground(Color.RED);
		button_2.setForeground(Color.WHITE);
		frame_1.add(image);
		image.setBounds(0, 0, 600, 340);
		frame_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame_2.setIconImage(icon_1_2);
		frame_2.setSize(1000, 600);
		frame_2.setResizable(false);
		frame_2.setLayout(null);
		frame_2.setLocation(180, 100);
		frame_2.getContentPane().setBackground(Color.WHITE);
		frame_2.add(panel);
		panel.setLayout(null);
		panel.setBounds(0, 0, 1000, 420);
		panel.setBackground(Color.YELLOW);
		panel.add(heading);
		heading.setBounds(310, 0, 500, 100);
		heading.setFont(new Font("arial black", Font.PLAIN, 40));
		panel.add(label_2);
		label_2.setBounds(100, 80, 200, 100);
		label_2.setFont(font);
		panel.add(label_text_1);
		label_text_1.setBounds(280, 80, 500, 100);
		label_text_1.setFont(font);
		panel.add(label_3);
		label_3.setBounds(530, 80, 200, 100);
		label_3.setFont(font);
		panel.add(label_text_2);
		label_text_2.setBounds(645, 80, 500, 100);
		label_text_2.setFont(font);
		panel.add(label_4);
		label_4.setBounds(100, 140, 200, 100);
		label_4.setFont(font);
		panel.add(label_text_3);
		label_text_3.setBounds(280, 140, 500, 100);
		label_text_3.setFont(font);
		panel.add(label_5);
		label_5.setBounds(530, 140, 200, 100);
		label_5.setFont(font);
		panel.add(label_text_4);
		label_text_4.setBounds(645, 140, 500, 100);
		label_text_4.setFont(font);
		panel.add(label_6);
		label_6.setBounds(100, 197, 200, 100);
		label_6.setFont(font);
		panel.add(label_text_5);
		label_text_5.setBounds(280, 197, 700, 100);
		label_text_5.setFont(font);
		panel.add(label_7);
		label_7.setBounds(100, 255, 200, 100);
		label_7.setFont(font);
		panel.add(label_text_6);
		label_text_6.setBounds(280, 255, 500, 100);
		label_text_6.setFont(font);
		panel.add(label_8);
		label_8.setBounds(530, 255, 200, 100);
		label_8.setFont(font);
		panel.add(label_text_7);
		label_text_7.setBounds(645, 255, 500, 100);
		label_text_7.setFont(font);
		panel.add(label_9);
		label_9.setBounds(100, 315, 200, 100);
		label_9.setFont(font);
		panel.add(label_text_8);
		label_text_8.setBounds(280, 315, 500, 100);
		label_text_8.setFont(font);
		panel.add(label_10);
		label_10.setBounds(530, 315, 200, 100);
		label_10.setFont(font);
		panel.add(label_text_9);
		label_text_9.setBounds(645, 315, 200, 100);
		label_text_9.setFont(font);
		frame_2.add(button_3);
		button_3.setBounds(270, 460, 140, 50);
		button_3.setBackground(Color.BLACK);
		button_3.setForeground(Color.WHITE);
		frame_2.add(button_4);
		button_4.setBounds(600, 460, 140, 50);
		button_4.setBackground(Color.RED);
		button_4.setForeground(Color.WHITE);
		frame_2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void getView() {
		
		e_id_1 = text.getText();
		e_id_2 = text.getText();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ems", "root", "DBMS");
			PreparedStatement pstm_1 = con.prepareStatement("select e_id from employee where e_id=?");
			pstm_1.setString(1, e_id_1);
			ResultSet rs_1 = pstm_1.executeQuery();
			PreparedStatement pstm_2 = con.prepareStatement("select e_id, name, fathers_name, date_of_birth, address, phone, email_id, education, job_post from employee where e_id=?");
			pstm_2.setString(1, e_id_2);
			ResultSet rs_2;
			
			try {
				if(rs_1.next()) {
					frame_1.dispose();
					rs_2 = pstm_2.executeQuery();
					
					if(rs_2.next()) {
						label_text_1.setText(rs_2.getString(1));
						label_text_2.setText(rs_2.getString(2));
						label_text_3.setText(rs_2.getString(3));
						label_text_4.setText(rs_2.getString(4));
						label_text_5.setText(rs_2.getString(5));
						label_text_6.setText(rs_2.getString(6));
						label_text_7.setText(rs_2.getString(7));
						label_text_8.setText(rs_2.getString(8));
						label_text_9.setText(rs_2.getString(9));
					}
					
					frame_2.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(frame_1, "No record found", "Warning", JOptionPane.WARNING_MESSAGE);
					text.setText(null);
				}
			}
			finally {
				con.close();
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(frame_1, "Failed to connect", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
