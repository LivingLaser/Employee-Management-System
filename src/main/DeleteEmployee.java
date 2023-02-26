package main;
import ops.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteEmployee implements Delete {
	
	private JFrame frame;
	private ImageIcon icon_1_1, image_1_1, image_1_3;
	private Image icon_1_2, image_1_2;
	private JLabel image, label;
	private JTextField text;
	private JButton button;
	private String e_id_1, e_id_2;
	private int choice;
	
	DeleteEmployee() {
		
		frame = new JFrame("EMS - Delete Employee");
		icon_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/EMS Logo.png"));
		icon_1_2 = icon_1_1.getImage();
		image_1_1 = new ImageIcon(ClassLoader.getSystemResource("images/Delete.png"));
		image_1_2 = image_1_1.getImage().getScaledInstance(600, 340, Image.SCALE_DEFAULT);
		image_1_3 = new ImageIcon(image_1_2);
		image = new JLabel(image_1_3);
		label = new JLabel("Employee Id");
		text = new JTextField();
		button = new JButton("Delete");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDelete();
			}
		});
		
		frame.setIconImage(icon_1_2);
		frame.setSize(600, 340);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocation(400, 200);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true);
		frame.add(label);
		label.setBounds(90, 40, 200, 100);
		label.setFont(new Font("arial black", Font.BOLD, 25));
		frame.add(text);
		text.setBounds(280, 75, 200, 35);
		text.setFont(new Font("serif", Font.BOLD, 20));
		frame.add(button);
		button.setBounds(250, 180, 100, 40);
		button.setBackground(Color.RED);
		button.setForeground(Color.WHITE);
		frame.add(image);
		image.setBounds(0, 0, 600, 340);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void getDelete() {
		
		e_id_1 = text.getText();
		e_id_2 = text.getText();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ems", "root", "DBMS");
			PreparedStatement pstm_1 = con.prepareStatement("select e_id from employee where e_id=?");
			pstm_1.setString(1, e_id_1);
			ResultSet rs_1 = pstm_1.executeQuery();
			PreparedStatement pstm_2 = con.prepareStatement("delete from employee where e_id=?");
			pstm_2.setString(1, e_id_2);
			PreparedStatement pstm_3 = con.prepareStatement("delete from salary where e_id=?");
			pstm_3.setString(1, e_id_2);
			
			try {
				if(rs_1.next()) {
					choice = JOptionPane.showConfirmDialog(frame, "Delete employee and all related data", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(choice==JOptionPane.YES_OPTION) {
						pstm_2.executeUpdate();
						pstm_3.executeUpdate();
						JOptionPane.showMessageDialog(frame, "Record deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "No record found", "Warning", JOptionPane.WARNING_MESSAGE);
					text.setText(null);
				}
			}
			finally {
				con.close();
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(frame, "Failed to connect", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
