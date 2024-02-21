
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	static ArrayList<Admin> AdminList=new ArrayList<Admin>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		AdminLogin frame = new AdminLogin();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		ImagePanel panel = new ImagePanel(
				new ImageIcon("./back2.jpeg").getImage());
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 389);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Airline Flight Management System ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 457, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Product Sans", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(10, 189, 91, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Product Sans", Font.PLAIN, 19));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 253, 91, 17);
		contentPane.add(lblNewLabel_2);
		
		username = new JTextField();
		username.setBounds(10, 216, 86, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(10, 280, 86, 20);
		contentPane.add(password);
		
		Admin obj=new Admin("admin","admin");
		AdminList.add(obj);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Admin x: AdminList)
				{
					if (username.getText().equals("admin") && password.getText().equals("password"))
					{
						Menu obj=new Menu();
						obj.setVisible(true);
						dispose();
					}
					else if (username.getText().equals(x.getUsername()))
					{
						JOptionPane.showMessageDialog(null, "Incorrect password. Enter Again.");
					}
					else if (password.getText().equals(x.getPassword()))
					{
						JOptionPane.showMessageDialog(null, "Incorrect username. Enter Again.");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You are not a registered admin.");
					}
				}
			}
		});
		btnNewButton.setBounds(10, 310, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModeSelection obj = new ModeSelection();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(445, 319, 89, 23);
		contentPane.add(btnNewButton_1);
		contentPane.add(panel);
	}
}
