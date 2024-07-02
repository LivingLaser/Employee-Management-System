package main;
import ops.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateSalary implements Update {
	
	private JFrame frame_1, frame_2;
	private ImageIcon icon_1_1, image_1_1, image_1_4, image_1_5;
	private Image icon_1_2, image_1_2, image_1_3;
	private JLabel image_1, image_2, heading;
	private JLabel label_1, label_2, label_3, label_4, label_5, label_6, label_7, label_8, label_9, label_10, label_11;
	private JLabel label_text_1, label_text_2, label_text_3, label_text_4;
	private JTextField text_1, text_2, text_3, text_4, text_5, text_6, text_7;
	private Font font_1, font_2;
	private JButton button_1, button_2, button_3, button_4;
	private String e_id_1, e_id_2, e_id_3, basic, da, hra, ma, cca, pf, gross, net;
	private double num_1, num_2, num_3, num_4, num_5, num_6, res_1, res_2, res_3;
	
	UpdateSalary() {
		
		frame_1 = new JFrame("EMS - Update Salary");
		frame_2 = new JFrame("EMS - Update Salary");
		icon_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/EMS Logo.png"));
		icon_1_2 = icon_1_1.getImage();
		image_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/Salary.png"));
		image_1_2 = image_1_1.getImage().getScaledInstance(600, 340, Image.SCALE_DEFAULT);
		image_1_3 = image_1_1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
		image_1_4 = new ImageIcon(image_1_2);
		image_1_5 = new ImageIcon(image_1_3);
		image_1 = new JLabel(image_1_4);
		image_2 = new JLabel(image_1_5);
		heading = new JLabel("Update Salary Details");
		font_1 = new Font("arial black", Font.PLAIN, 16);
		font_2 = new Font("serif", Font.BOLD, 18);
		label_1 = new JLabel("Employee Id");
		label_2 = new JLabel("Employee Id:");
		label_3 = new JLabel("Name:");
		label_4 = new JLabel("Email Id:");
		label_5 = new JLabel("Phone:");
		label_6 = new JLabel("Basic Salary");
		label_7 = new JLabel("DA");
		label_8 = new JLabel("HRA");
		label_9 = new JLabel("MA");
		label_10 = new JLabel("CCA");
		label_11 = new JLabel("PF");
		label_text_1 = new JLabel();
		label_text_2 = new JLabel();
		label_text_3 = new JLabel();
		label_text_4 = new JLabel();
		text_1 = new JTextField();
		text_2 = new JTextField();
		text_3 = new JTextField();
		text_4 = new JTextField();
		text_5 = new JTextField();
		text_6 = new JTextField();
		text_7 = new JTextField();
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
		heading.setBounds(360, 10, 330, 50);
		heading.setFont(new Font("serif", Font.BOLD, 30));
		frame_2.add(label_2);
		label_2.setBounds(60, 50, 150, 100);
		label_2.setFont(font_1);
		frame_2.add(label_text_1);
		label_text_1.setBounds(200, 90, 500, 25);
		label_text_1.setFont(font_1);
		frame_2.add(label_3);
		label_3.setBounds(570, 50, 200, 100);
		label_3.setFont(font_1);
		frame_2.add(label_text_2);
		label_text_2.setBounds(650, 90, 500, 25);
		label_text_2.setFont(font_1);
		frame_2.add(label_4);
		label_4.setBounds(60, 100, 100, 100);
		label_4.setFont(font_1);
		frame_2.add(label_text_3);
		label_text_3.setBounds(200, 139, 500, 25);
		label_text_3.setFont(font_1);
		frame_2.add(label_5);
		label_5.setBounds(570, 100, 200, 100);
		label_5.setFont(font_1);
		frame_2.add(label_text_4);
		label_text_4.setBounds(650, 139, 500, 25);
		label_text_4.setFont(font_1);
		frame_2.add(label_6);
		label_6.setBounds(60, 170, 150, 100);
		label_6.setFont(font_1);
		frame_2.add(text_2);
		text_2.setBounds(200, 210, 250, 25);
		text_2.setFont(font_2);
		frame_2.add(label_7);
		label_7.setBounds(570, 170, 100, 100);
		label_7.setFont(font_1);
		frame_2.add(text_3);
		text_3.setBounds(650, 209, 250, 25);
		text_3.setFont(font_2);
		frame_2.add(label_8);
		label_8.setBounds(60, 220, 200, 100);
		label_8.setFont(font_1);
		frame_2.add(text_4);
		text_4.setBounds(200, 260, 250, 25);
		text_4.setFont(font_2);
		frame_2.add(label_9);
		label_9.setBounds(570, 220, 100, 100);
		label_9.setFont(font_1);
		frame_2.add(text_5);
		text_5.setBounds(650, 259, 250, 25);
		text_5.setFont(font_2);
		frame_2.add(label_10);
		label_10.setBounds(60, 270, 200, 100);
		label_10.setFont(font_1);
		frame_2.add(text_6);
		text_6.setBounds(200, 310, 250, 25);
		text_6.setFont(font_2);
		frame_2.add(label_11);
		label_11.setBounds(570, 270, 200, 100);
		label_11.setFont(font_1);
		frame_2.add(text_7);
		text_7.setBounds(650, 309, 250, 25);
		text_7.setFont(font_2);
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
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "DBMS");
			PreparedStatement pstm_1 = con.prepareStatement("select e_id from salary where e_id=?");
			pstm_1.setString(1, e_id_1);
			ResultSet rs_1 = pstm_1.executeQuery();
			PreparedStatement pstm_2 = con.prepareStatement("select e_id, basic_salary, da, hra, ma, cca, pf from salary where e_id=?");
			pstm_2.setString(1, e_id_2);
			PreparedStatement pstm_3 = con.prepareStatement("select name, email_id, phone from employee where e_id=?");
			pstm_3.setString(1, e_id_2);
			ResultSet rs_2, rs_3;
			
			try {
				if(rs_1.next()) {
					frame_1.dispose();
					rs_2 = pstm_2.executeQuery();
					rs_3 = pstm_3.executeQuery();
					
					if(rs_2.next()) {
						label_text_1.setText(rs_2.getString(1));
						text_2.setText(rs_2.getString(2));
						text_3.setText(rs_2.getString(3));
						text_4.setText(rs_2.getString(4));
						text_5.setText(rs_2.getString(5));
						text_6.setText(rs_2.getString(6));
						text_7.setText(rs_2.getString(7));
					}
					
					if(rs_3.next()) {
						label_text_2.setText(rs_3.getString(1));
						label_text_3.setText(rs_3.getString(2));
						label_text_4.setText(rs_3.getString(3));
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
		basic = text_2.getText();
		da = text_3.getText();
		hra = text_4.getText();
		ma = text_5.getText();
		cca = text_6.getText();
		pf = text_7.getText();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "DBMS");
			PreparedStatement pstm = con.prepareStatement("update salary set basic_salary=?, da=?, hra=?, ma=?, cca=?, pf=?, gross_salary=?, net_salary=? where e_id=?");
			
			try {
				if(basic.isBlank() || da.isBlank() || hra.isBlank() || ma.isBlank() || cca.isBlank() || pf.isBlank()) {
					JOptionPane.showMessageDialog(frame_2, "One or more fields are empty", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else {
					num_1 = Double.parseDouble(basic);
					num_2 = Double.parseDouble(da);
					num_3 = Double.parseDouble(hra);
					num_4 = Double.parseDouble(ma);
					num_5 = Double.parseDouble(cca);
					num_6 = Double.parseDouble(pf);
					res_1 = num_1 + num_2 + num_3 + num_4 + num_5;
					res_2 = ((res_1 * 2.7) / 100) + num_6;
					res_3 = res_1 - res_2;
					gross = String.valueOf(res_1);
					net = String.valueOf(res_3);
					
					pstm.setString(1, basic);
					pstm.setString(2, da);
					pstm.setString(3, hra);
					pstm.setString(4, ma);
					pstm.setString(5, cca);
					pstm.setString(6, pf);
					pstm.setString(7, gross);
					pstm.setString(8, net);
					pstm.setString(9, e_id_3);
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
