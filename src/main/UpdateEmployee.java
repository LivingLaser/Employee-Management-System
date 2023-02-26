package main;
import ops.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee implements Update {
	
	private JFrame frame_1, frame_2;
	private ImageIcon icon_1_1, image_1_1, image_1_4, image_1_5;
	private Image icon_1_2, image_1_2, image_1_3;
	private JLabel image_1, image_2, heading;
	private JLabel label_1, label_2, label_3, label_4, label_5, label_6, label_7, label_8, label_9, label_10, label_11, label_12;
	private JTextField text_1, text_2, text_3, text_4, text_5, text_6, text_7, text_8, text_9, text_10, text_11, text_12;
	private Font font_1, font_2;
	private JButton button_1, button_2, button_3, button_4;
	private String name, f_name, age, dob, add, phone, email, education, post, e_id_1, e_id_2, e_id_3;
	
	UpdateEmployee() {
		
		frame_1 = new JFrame("EMS - Employee Details");
		frame_2 = new JFrame("EMS - Employee Details");
		icon_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/EMS Logo.png"));
		icon_1_2 = icon_1_1.getImage();
		image_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/Manage.png"));
		image_1_2 = image_1_1.getImage().getScaledInstance(600, 340, Image.SCALE_DEFAULT);
		image_1_3 = image_1_1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
		image_1_4 = new ImageIcon(image_1_2);
		image_1_5 = new ImageIcon(image_1_3);
		image_1 = new JLabel(image_1_4);
		image_2 = new JLabel(image_1_5);
		heading = new JLabel("Update Employee Details");
		font_1 = new Font("arial black", Font.PLAIN, 16);
		font_2 = new Font("serif", Font.BOLD, 18);
		label_1 = new JLabel("Employee Id");
		label_2 = new JLabel("Name");
		label_3 = new JLabel("Father's Name");
		label_4 = new JLabel("Age");
		label_5 = new JLabel("Date Of Birth");
		label_6 = new JLabel("Address");
		label_7 = new JLabel("Phone");
		label_8 = new JLabel("Email Id");
		label_9 = new JLabel("Education");
		label_10 = new JLabel("Job Post");
		label_11 = new JLabel("Aadhar No");
		label_12 = new JLabel("Employee Id");
		text_1 = new JTextField();
		text_2 = new JTextField();
		text_3 = new JTextField();
		text_4 = new JTextField();
		text_5 = new JTextField();
		text_6 = new JTextField();
		text_7 = new JTextField();
		text_8 = new JTextField();
		text_9 = new JTextField();
		text_10 = new JTextField();
		text_11 = new JTextField();
		text_12 = new JTextField();
		button_1 = new JButton("Submit");
		button_2 = new JButton("Cancel");
		button_3 = new JButton("Update Data");
		button_4 = new JButton("Cancel");
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setUpdate();
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_1.dispose();
			}
		});
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getUpdate();
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
		frame_1.add(text_1);
		text_1.setBounds(280, 75, 200, 35);
		text_1.setFont(new Font("serif", Font.BOLD, 20));
		frame_1.add(button_1);
		button_1.setBounds(150, 180, 100, 40);
		button_1.setBackground(Color.BLACK);
		button_1.setForeground(Color.WHITE);
		frame_1.add(button_2);
		button_2.setBounds(350, 180, 100, 40);
		button_2.setBackground(Color.RED);
		button_2.setForeground(Color.WHITE);
		frame_1.add(image_1);
		image_1.setBounds(0, 0, 600, 340);
		frame_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame_2.setIconImage(icon_1_2);
		frame_2.setSize(1000, 600);
		frame_2.setResizable(false);
		frame_2.setLayout(null);
		frame_2.setLocation(180, 100);
		frame_2.getContentPane().setBackground(Color.WHITE);
		frame_2.add(heading);
		heading.setBounds(340, 10, 330, 50);
		heading.setFont(new Font("serif", Font.BOLD, 30));
		frame_2.add(label_2);
		label_2.setBounds(60, 50, 100, 100);
		label_2.setFont(font_1);
		frame_2.add(text_2);
		text_2.setBounds(170, 90, 250, 25);
		text_2.setFont(font_2);
		frame_2.add(label_3);
		label_3.setBounds(500, 50, 200, 100);
		label_3.setFont(font_1);
		frame_2.add(text_3);
		text_3.setBounds(650, 90, 250, 25);
		text_3.setFont(font_2);
		frame_2.add(label_4);
		label_4.setBounds(60, 100, 100, 100);
		label_4.setFont(font_1);
		frame_2.add(text_4);
		text_4.setBounds(170, 139, 250, 25);
		text_4.setFont(font_2);
		frame_2.add(label_5);
		label_5.setBounds(500, 100, 200, 100);
		label_5.setFont(font_1);
		frame_2.add(text_5);
		text_5.setBounds(650, 139, 250, 25);
		text_5.setFont(font_2);
		frame_2.add(label_6);
		label_6.setBounds(60, 150, 100, 100);
		label_6.setFont(font_1);
		frame_2.add(text_6);
		text_6.setBounds(170, 190, 500, 25);
		text_6.setFont(font_2);
		frame_2.add(label_7);
		label_7.setBounds(60, 200, 100, 100);
		label_7.setFont(font_1);
		frame_2.add(text_7);
		text_7.setBounds(170, 239, 250, 25);
		text_7.setFont(font_2);
		frame_2.add(label_8);
		label_8.setBounds(500, 200, 200, 100);
		label_8.setFont(font_1);
		frame_2.add(text_8);
		text_8.setBounds(650, 238, 250, 25);
		text_8.setFont(font_2);
		frame_2.add(label_9);
		label_9.setBounds(60, 250, 100, 100);
		label_9.setFont(font_1);
		frame_2.add(text_9);
		text_9.setBounds(170, 290, 250, 25);
		text_9.setFont(font_2);
		frame_2.add(label_10);
		label_10.setBounds(500, 250, 200, 100);
		label_10.setFont(font_1);
		frame_2.add(text_10);
		text_10.setBounds(650, 289, 250, 25);
		text_10.setFont(font_2);
		frame_2.add(label_11);
		label_11.setBounds(60, 300, 100, 100);
		label_11.setFont(font_1);
		frame_2.add(text_11);
		text_11.setBounds(170, 340, 250, 25);
		text_11.setFont(font_2);
		text_11.setEditable(false);
		frame_2.add(label_12);
		label_12.setBounds(500, 300, 200, 100);
		label_12.setFont(font_1);
		frame_2.add(text_12);
		text_12.setBounds(650, 339, 250, 25);
		text_12.setFont(font_2);
		text_12.setEditable(false);
		frame_2.add(button_3);
		button_3.setBounds(270, 420, 140, 50);
		button_3.setBackground(Color.BLACK);
		button_3.setForeground(Color.WHITE);
		frame_2.add(button_4);
		button_4.setBounds(600, 420, 140, 50);
		button_4.setBackground(Color.RED);
		button_4.setForeground(Color.WHITE);
		frame_2.add(image_2);
		image_2.setBounds(0, 0, 1000, 600);
		frame_2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void setUpdate() {
		
		e_id_1 = text_1.getText();
		e_id_2 = text_1.getText();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ems", "root", "DBMS");
			PreparedStatement pstm_1 = con.prepareStatement("select e_id from employee where e_id=?");
			pstm_1.setString(1, e_id_1);
			ResultSet rs_1 = pstm_1.executeQuery();
			PreparedStatement pstm_2 = con.prepareStatement("select * from employee where e_id=?");
			pstm_2.setString(1, e_id_2);
			ResultSet rs_2;
			
			try {
				if(rs_1.next()) {
					frame_1.dispose();
					rs_2 = pstm_2.executeQuery();
					
					if(rs_2.next()) {
						text_2.setText(rs_2.getString(1));
						text_3.setText(rs_2.getString(2));
						text_4.setText(rs_2.getString(3));
						text_5.setText(rs_2.getString(4));
						text_6.setText(rs_2.getString(5));
						text_7.setText(rs_2.getString(6));
						text_8.setText(rs_2.getString(7));
						text_9.setText(rs_2.getString(8));
						text_10.setText(rs_2.getString(9));
						text_11.setText(rs_2.getString(10));
						text_12.setText(rs_2.getString(11));
					}
					
					frame_2.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(frame_1, "No record found", "Warning", JOptionPane.WARNING_MESSAGE);
					text_1.setText(null);
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

	@Override
	public void getUpdate() {
		
		e_id_3 = text_1.getText();
		name = text_2.getText();
		f_name = text_3.getText();
		age = text_4.getText();
		dob = text_5.getText();
		add = text_6.getText();
		phone = text_7.getText();
		email = text_8.getText();
		education = text_9.getText();
		post = text_10.getText();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ems", "root", "DBMS");
			PreparedStatement pstm = con.prepareStatement("update employee set name=?, fathers_name=?, age=?, date_of_birth=?, address=?, phone=?, email_id=?, education=?, job_post=? where e_id=?");
			
			try {
				if(name.isBlank() || f_name.isBlank() || age.isBlank() || dob.isBlank() || add.isBlank() || phone.isBlank() || email.isBlank() || education.isBlank() || post.isBlank()) {
					JOptionPane.showMessageDialog(frame_2, "One or more fields are empty", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else {
					pstm.setString(1, name);
					pstm.setString(2, f_name);
					pstm.setString(3, age);
					pstm.setString(4, dob);
					pstm.setString(5, add);
					pstm.setString(6, phone);
					pstm.setString(7, email);
					pstm.setString(8, education);
					pstm.setString(9, post);
					pstm.setString(10, e_id_3);
					pstm.executeUpdate();
					
					JOptionPane.showMessageDialog(frame_2, "Record updated successfully", "Update Complete", JOptionPane.INFORMATION_MESSAGE);
					frame_2.dispose();
				}
			}
			finally {
				con.close();
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(frame_2, "Failed to connect", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
