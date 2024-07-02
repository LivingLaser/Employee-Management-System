package main;
import ops.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee implements Insert {
	
	private JFrame frame;
	private ImageIcon icon_1_1, image_1_1, image_1_3;
	private Image icon_1_2, image_1_2;
	private JLabel image, heading;
	private JLabel label_1, label_2, label_3, label_4, label_5, label_6, label_7, label_8, label_9, label_10, label_11;
	private JTextField text_1, text_2, text_3, text_4, text_5, text_6, text_7, text_8, text_9, text_10, text_11;
	private Font font_1, font_2;
	private JButton button_1, button_2;
	private String name, f_name, age, dob, add, phone, email, education, post, aadhar, e_id_1, e_id_2;
	
	AddEmployee() {
		
		frame = new JFrame("EMS - Add Employee");
		icon_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/EMS Logo.png"));
		icon_1_2 = icon_1_1.getImage();
		image_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/Profile.png"));
		image_1_2 = image_1_1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
		image_1_3 = new ImageIcon(image_1_2);
		image = new JLabel(image_1_3);
		heading = new JLabel("New Employee Details");
		font_1 = new Font("arial black", Font.PLAIN, 16);
		font_2 = new Font("serif", Font.BOLD, 18);
		label_1 = new JLabel("Name");
		label_2 = new JLabel("Father's Name");
		label_3 = new JLabel("Age");
		label_4 = new JLabel("Date Of Birth");
		label_5 = new JLabel("Address");
		label_6 = new JLabel("Phone");
		label_7 = new JLabel("Email Id");
		label_8 = new JLabel("Education");
		label_9 = new JLabel("Job Post");
		label_10 = new JLabel("Aadhar No");
		label_11 = new JLabel("Employee Id");
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
		button_1 = new JButton("Submit");
		button_2 = new JButton("Cancel");
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getInsert();
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		frame.setIconImage(icon_1_2);
		frame.setSize(1000, 600);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocation(180, 100);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true);
		frame.add(heading);
		heading.setBounds(360, 10, 300, 50);
		heading.setFont(new Font("serif", Font.BOLD, 30));
		frame.add(label_1);
		label_1.setBounds(60, 50, 100, 100);
		label_1.setFont(font_1);
		frame.add(text_1);
		text_1.setBounds(170, 90, 250, 25);
		text_1.setFont(font_2);
		frame.add(label_2);
		label_2.setBounds(500, 50, 200, 100);
		label_2.setFont(font_1);
		frame.add(text_2);
		text_2.setBounds(650, 90, 250, 25);
		text_2.setFont(font_2);
		frame.add(label_3);
		label_3.setBounds(60, 100, 100, 100);
		label_3.setFont(font_1);
		frame.add(text_3);
		text_3.setBounds(170, 139, 250, 25);
		text_3.setFont(font_2);
		frame.add(label_4);
		label_4.setBounds(500, 100, 200, 100);
		label_4.setFont(font_1);
		frame.add(text_4);
		text_4.setBounds(650, 139, 250, 25);
		text_4.setFont(font_2);
		frame.add(label_5);
		label_5.setBounds(60, 150, 100, 100);
		label_5.setFont(font_1);
		frame.add(text_5);
		text_5.setBounds(170, 190, 500, 25);
		text_5.setFont(font_2);
		frame.add(label_6);
		label_6.setBounds(60, 200, 100, 100);
		label_6.setFont(font_1);
		frame.add(text_6);
		text_6.setBounds(170, 239, 250, 25);
		text_6.setFont(font_2);
		frame.add(label_7);
		label_7.setBounds(500, 200, 200, 100);
		label_7.setFont(font_1);
		frame.add(text_7);
		text_7.setBounds(650, 238, 250, 25);
		text_7.setFont(font_2);
		frame.add(label_8);
		label_8.setBounds(60, 250, 100, 100);
		label_8.setFont(font_1);
		frame.add(text_8);
		text_8.setBounds(170, 290, 250, 25);
		text_8.setFont(font_2);
		frame.add(label_9);
		label_9.setBounds(500, 250, 200, 100);
		label_9.setFont(font_1);
		frame.add(text_9);
		text_9.setBounds(650, 289, 250, 25);
		text_9.setFont(font_2);
		frame.add(label_10);
		label_10.setBounds(60, 300, 100, 100);
		label_10.setFont(font_1);
		frame.add(text_10);
		text_10.setBounds(170, 340, 250, 25);
		text_10.setFont(font_2);
		frame.add(label_11);
		label_11.setBounds(500, 300, 200, 100);
		label_11.setFont(font_1);
		frame.add(text_11);
		text_11.setBounds(650, 339, 250, 25);
		text_11.setFont(font_2);
		frame.add(button_1);
		button_1.setBounds(270, 420, 140, 50);
		button_1.setBackground(Color.BLACK);
		button_1.setForeground(Color.WHITE);
		frame.add(button_2);
		button_2.setBounds(600, 420, 140, 50);
		button_2.setBackground(Color.RED);
		button_2.setForeground(Color.WHITE);
		frame.add(image);
		image.setBounds(0, 0, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void getInsert() {
		
		name = text_1.getText();
		f_name = text_2.getText();
		age = text_3.getText();
		dob = text_4.getText();
		add = text_5.getText();
		phone = text_6.getText();
		email = text_7.getText();
		education = text_8.getText();
		post = text_9.getText();
		aadhar = text_10.getText();
		e_id_1 = text_11.getText();
		e_id_2 = text_11.getText();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "DBMS");
			PreparedStatement pstm_1 = con.prepareStatement("select e_id from employee where e_id=?");
			pstm_1.setString(1, e_id_1);
			ResultSet rs = pstm_1.executeQuery();
			PreparedStatement pstm_2 = con.prepareStatement("insert into employee values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			try {
				if(rs.next()) {
					JOptionPane.showMessageDialog(frame, "Employee Id already exist", "Warning", JOptionPane.WARNING_MESSAGE);
					text_11.setText(null);
				}
				else {
					if(name.isBlank() || f_name.isBlank() || age.isBlank() || dob.isBlank() || add.isBlank() || phone.isBlank() || email.isBlank() || education.isBlank() || post.isBlank() || aadhar.isBlank() || e_id_2.isBlank()) {
						JOptionPane.showMessageDialog(frame, "One or more fields are empty", "Warning", JOptionPane.WARNING_MESSAGE);
					}
					else {
						pstm_2.setString(1, name);
						pstm_2.setString(2, f_name);
						pstm_2.setString(3, age);
						pstm_2.setString(4, dob);
						pstm_2.setString(5, add);
						pstm_2.setString(6, phone);
						pstm_2.setString(7, email);
						pstm_2.setString(8, education);
						pstm_2.setString(9, post);
						pstm_2.setString(10, aadhar);
						pstm_2.setString(11, e_id_2);
						pstm_2.executeUpdate();
						
						JOptionPane.showMessageDialog(frame, "Record inserted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
					}
				}
			}
			finally {
				con.close();
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(frame, "Failed to insert data", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
