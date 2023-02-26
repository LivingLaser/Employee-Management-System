package main;
import ops.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SalarySlip implements View {
	
	private JFrame frame_1, frame_2;
	private JPanel panel;
	private ImageIcon icon_1_1, image_1_1, image_1_3;
	private Image icon_1_2, image_1_2;
	private JLabel image, heading;
	private JLabel label_1, label_2, label_3, label_4, label_5, label_6, label_7, label_8, label_9, label_10, label_11, label_12, label_13;
	private JLabel label_text_1, label_text_2, label_text_3, label_text_4, label_text_5, label_text_6, label_text_7, label_text_8, label_text_9, label_text_10, label_text_11, label_text_12;
	private JTextField text, design_1, design_2, design_3, design_4, design_5, design_6;
	private Font font;
	private JButton button_1, button_2, button_3, button_4;
	private String e_id_1, e_id_2;
	
	SalarySlip() {
		
		frame_1 = new JFrame("EMS - Salary Invoice");
		frame_2 = new JFrame("EMS - Salary Invoice");
		panel = new JPanel();
		icon_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/EMS Logo.png"));
		icon_1_2 = icon_1_1.getImage();
		image_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/Salary.png"));
		image_1_2 = image_1_1.getImage().getScaledInstance(600, 340, Image.SCALE_DEFAULT);
		image_1_3 = new ImageIcon(image_1_2);
		image = new JLabel(image_1_3);
		heading = new JLabel("EMS");
		font = new Font("arial black", Font.PLAIN, 16);
		label_1 = new JLabel("Employee Id");
		label_2 = new JLabel("Employee Id:");
		label_3 = new JLabel("Name:");
		label_4 = new JLabel("Email Id:");
		label_5 = new JLabel("Phone:");
		label_6 = new JLabel("Basic Salary:");
		label_7 = new JLabel("DA:");
		label_8 = new JLabel("HRA:");
		label_9 = new JLabel("MA:");
		label_10 = new JLabel("CCA:");
		label_11 = new JLabel("PF:");
		label_12 = new JLabel("Gross Salary (Rs.):");
		label_13 = new JLabel("Net Salary [after all deductions] (Rs.):");
		label_text_1 = new JLabel();
		label_text_2 = new JLabel();
		label_text_3 = new JLabel();
		label_text_4 = new JLabel();
		label_text_5 = new JLabel();
		label_text_6 = new JLabel();
		label_text_7 = new JLabel();
		label_text_8 = new JLabel();
		label_text_9 = new JLabel();
		label_text_10 = new JLabel();
		label_text_11 = new JLabel();
		label_text_12 = new JLabel();
		text = new JTextField();
		design_1 = new JTextField();
		design_2 = new JTextField();
		design_3 = new JTextField();
		design_4 = new JTextField();
		design_5 = new JTextField();
		design_6 = new JTextField();
		button_1 = new JButton("Submit");
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
		panel.setBounds(0, 0, 1000, 400);
		panel.setBackground(Color.YELLOW);
		panel.add(design_1);
		design_1.setBounds(0, 20, 1000, 10);
		design_1.setEditable(false);
		design_1.setBackground(Color.BLACK);
		panel.add(design_2);
		design_2.setBounds(0, 70, 1000, 10);
		design_2.setEditable(false);
		design_2.setBackground(Color.BLACK);
		panel.add(design_3);
		design_3.setBounds(0, 180, 1000, 10);
		design_3.setEditable(false);
		design_3.setBackground(Color.BLACK);
		panel.add(design_4);
		design_4.setBounds(0, 290, 1000, 10);
		design_4.setEditable(false);
		design_4.setBackground(Color.BLACK);
		panel.add(design_5);
		design_5.setBounds(0, 330, 1000, 10);
		design_5.setEditable(false);
		design_5.setBackground(Color.BLACK);
		panel.add(design_6);
		design_6.setBounds(0, 370, 1000, 10);
		design_6.setEditable(false);
		design_6.setBackground(Color.BLACK);
		panel.add(heading);
		heading.setBounds(450, 23, 100, 50);
		heading.setFont(new Font("serif", Font.BOLD, 40));
		panel.add(label_2);
		label_2.setBounds(50, 50, 200, 100);
		label_2.setFont(font);
		panel.add(label_text_1);
		label_text_1.setBounds(180, 50, 500, 100);
		label_text_1.setFont(font);
		panel.add(label_3);
		label_3.setBounds(50, 70, 100, 100);
		label_3.setFont(font);
		panel.add(label_text_2);
		label_text_2.setBounds(180, 70, 500, 100);
		label_text_2.setFont(font);
		panel.add(label_4);
		label_4.setBounds(50, 90, 100, 100);
		label_4.setFont(font);
		panel.add(label_text_3);
		label_text_3.setBounds(180, 90, 500, 100);
		label_text_3.setFont(font);
		panel.add(label_5);
		label_5.setBounds(50, 110, 100, 100);
		label_5.setFont(font);
		panel.add(label_text_4);
		label_text_4.setBounds(180, 110, 500, 100);
		label_text_4.setFont(font);
		panel.add(label_6);
		label_6.setBounds(220, 160, 200, 100);
		label_6.setFont(font);
		panel.add(label_text_5);
		label_text_5.setBounds(350, 160, 500, 100);
		label_text_5.setFont(font);
		panel.add(label_7);
		label_7.setBounds(600, 160, 100, 100);
		label_7.setFont(font);
		panel.add(label_text_6);
		label_text_6.setBounds(645, 160, 500, 100);
		label_text_6.setFont(font);
		panel.add(label_8);
		label_8.setBounds(220, 190, 100, 100);
		label_8.setFont(font);
		panel.add(label_text_7);
		label_text_7.setBounds(350, 190, 500, 100);
		label_text_7.setFont(font);
		panel.add(label_9);
		label_9.setBounds(600, 190, 100, 100);
		label_9.setFont(font);
		panel.add(label_text_8);
		label_text_8.setBounds(645, 190, 500, 100);
		label_text_8.setFont(font);
		panel.add(label_10);
		label_10.setBounds(220, 220, 100, 100);
		label_10.setFont(font);
		panel.add(label_text_9);
		label_text_9.setBounds(350, 220, 500, 100);
		label_text_9.setFont(font);
		panel.add(label_11);
		label_11.setBounds(600, 220, 100, 100);
		label_11.setFont(font);
		panel.add(label_text_10);
		label_text_10.setBounds(645, 220, 500, 100);
		label_text_10.setFont(font);
		panel.add(label_12);
		label_12.setBounds(50, 265, 200, 100);
		label_12.setFont(font);
		panel.add(label_text_11);
		label_text_11.setBounds(225, 265, 500, 100);
		label_text_11.setFont(font);
		panel.add(label_13);
		label_13.setBounds(50, 305, 350, 100);
		label_13.setFont(font);
		panel.add(label_text_12);
		label_text_12.setBounds(395, 305, 500, 100);
		label_text_12.setFont(font);
		frame_2.add(button_3);
		button_3.setBounds(270, 450, 140, 50);
		button_3.setBackground(Color.BLACK);
		button_3.setForeground(Color.WHITE);
		frame_2.add(button_4);
		button_4.setBounds(600, 450, 140, 50);
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
			PreparedStatement pstm_1 = con.prepareStatement("select e_id from salary where e_id=?");
			pstm_1.setString(1, e_id_1);
			ResultSet rs_1 = pstm_1.executeQuery();
			PreparedStatement pstm_2 = con.prepareStatement("select * from salary where e_id=?");
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
						label_text_5.setText(rs_2.getString(2));
						label_text_6.setText(rs_2.getString(3));
						label_text_7.setText(rs_2.getString(4));
						label_text_8.setText(rs_2.getString(5));
						label_text_9.setText(rs_2.getString(6));
						label_text_10.setText(rs_2.getString(7));
						label_text_11.setText(rs_2.getString(8));
						label_text_12.setText(rs_2.getString(9));
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
