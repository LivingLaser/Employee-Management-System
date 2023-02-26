package main;
import ops.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login implements Log {
	
	private JFrame frame_1, frame_2;
	private ImageIcon icon_1_1, image_1_1, image_1_3;
	private Image icon_1_2, image_1_2;
	private JLabel image_1, image_2;
	private JLabel label_1, label_2, label_3;
	private JPasswordField text_1, text_3;
	private JTextField text_2;
	private Font font_1, font_2;
	private JButton button_1, button_2;
	private String username, id, password, name;
	
	Login() {
		
		frame_1 = new JFrame("EMS - Login(1/2)");
		frame_2 = new JFrame("EMS - Login(2/2)");
		icon_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/EMS Logo.png"));
		icon_1_2 = icon_1_1.getImage();
		image_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/Login.png"));
		image_1_2 = image_1_1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
		image_1_3 = new ImageIcon(image_1_2);
		image_1 = new JLabel(image_1_3);
		image_2 = new JLabel(image_1_3);
		label_1 = new JLabel("Username");
		label_2 = new JLabel("Id");
		label_3 = new JLabel("Password");
		text_1 = new JPasswordField();
		text_2 = new JTextField();
		text_3 = new JPasswordField();
		font_1 = new Font("arial black", Font.BOLD, 20);
		font_2 = new Font("serif", Font.BOLD, 16);
		button_1 = new JButton("Submit");
		button_2 = new JButton("Login");
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkUsername();
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkIdPass();
			}
		});
		
		frame_1.setIconImage(icon_1_2);
		frame_1.setSize(600, 340);
		frame_1.setResizable(false);
		frame_1.setLayout(null);
		frame_1.setLocation(400, 200);
		frame_1.setVisible(true);
		frame_1.add(label_1);
		label_1.setBounds(270, 20, 150, 50);
		label_1.setFont(font_1);
		frame_1.add(text_1);
		text_1.setBounds(400, 34, 150, 25);
		text_1.setFont(font_2);
		frame_1.add(button_1);
		button_1.setBounds(370, 90, 100, 30);
		button_1.setBackground(Color.WHITE);
		frame_1.add(image_1);
		image_1.setBounds(0, 0, 600, 300);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame_2.setIconImage(icon_1_2);
		frame_2.setSize(600, 340);
		frame_2.setResizable(false);
		frame_2.setLayout(null);
		frame_2.setLocation(400, 200);
		frame_2.add(label_2);
		label_2.setBounds(360, 0, 150, 50);
		label_2.setFont(font_1);
		frame_2.add(label_3);
		label_3.setBounds(275, 36, 150, 50);
		label_3.setFont(font_1);
		frame_2.add(text_2);
		text_2.setBounds(400, 14, 150, 25);
		text_2.setFont(font_2);
		frame_2.add(text_3);
		text_3.setBounds(400, 50, 150, 25);
		text_3.setFont(font_2);
		frame_2.add(button_2);
		button_2.setBounds(370, 95, 100, 30);
		button_2.setBackground(Color.WHITE);
		frame_2.add(image_2);
		image_2.setBounds(0, 0, 600, 300);
		frame_2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void checkUsername() {
		
		username = String.valueOf(text_1.getPassword());
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ems", "root", "DBMS");
			PreparedStatement pstm = con.prepareStatement("select username from hr where username=?");
			pstm.setString(1, username);
			ResultSet rs = pstm.executeQuery();
			
			try {
				if(rs.next()) {
					frame_1.dispose();
					frame_2.setVisible(true);
				}
				else {
					text_1.setText(null);
					JOptionPane.showMessageDialog(frame_1, "incorrect Username", "Access Denied", JOptionPane.WARNING_MESSAGE);
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
	public void checkIdPass() {
		
		username = String.valueOf(text_1.getPassword());
		id = text_2.getText();
		password = String.valueOf(text_3.getPassword());
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ems", "root", "DBMS");
			PreparedStatement pstm_1 = con.prepareStatement("select id from hr where username=? and password=?");
			pstm_1.setString(1, username);
			pstm_1.setString(2, password);
			ResultSet rs_1 = pstm_1.executeQuery();
			PreparedStatement pstm_2 = con.prepareStatement("select password from hr where username=? and id=?");
			pstm_2.setString(1, username);
			pstm_2.setString(2, id);
			ResultSet rs_2 = pstm_2.executeQuery();
			PreparedStatement pstm_3 = con.prepareStatement("select name from hr where id=?");
			pstm_3.setString(1, id);
			ResultSet rs_3 = pstm_3.executeQuery();
			
			try {
				if(rs_1.next() && rs_2.next()) {
					frame_2.dispose();
					new Menu();
					
					if(rs_3.next()) {
						name = rs_3.getString(1);
						JOptionPane.showMessageDialog(frame_2, "Welcome " + name, "Authorized Login", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else {
					text_2.setText(null);
					text_3.setText(null);
					JOptionPane.showMessageDialog(frame_2, "incorrect Id or Password", "Access Denied", JOptionPane.WARNING_MESSAGE);
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
