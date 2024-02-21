import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import swtest.Frametest;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public Login() {
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 401);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Airline Flight Management System ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(100, 10, 414, 24);
		contentPane.add(lblNewLabel);
		
		JLabel label1 = new JLabel("Username");
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label1.setBounds(207, 81, 83, 17);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("password");
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label2.setBounds(207, 134, 83, 17);
		contentPane.add(label2);
		
		username = new JTextField();
		username.setBounds(207, 104, 121, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JButton signupbtn = new JButton("Sign Up");
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SignUP obj=new SignUP();
				obj.setVisible(true);
			}
		});
		signupbtn.setBounds(242, 331, 89, 23);
		contentPane.add(signupbtn);
		
		JLabel label3 = new JLabel("New User?");
		label3.setForeground(Color.WHITE);
		label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label3.setBounds(137, 331, 83, 19);
		contentPane.add(label3);
		
		password = new JPasswordField();
		password.setBounds(207, 161, 121, 20);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(538, 331, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (username.getText().equals("") || password.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please fill all the fileds");
				}
				String query  = "SELECT * from users WHERE username='"+username.getText()+"' AND pwd='"+password.getText()+"'";
				sqlconnect connection = new sqlconnect();
				Connection con = connection.connect();
				Statement st=null;
				try {
					st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					if(rs.next()!=false) {
						PassengerMenu obj = new PassengerMenu();
						obj.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "You are not a registered user.");
					}
				}catch(Exception i) {
					System.out.println(i);
				}
				/*for (Passengers x: SignUP.PassengerList)
				{
					if (username.getText().equals(x.getUsername()) && password.getText().equals(x.getPassword()))
					{
						PassengerMenu obj = new PassengerMenu();
						obj.setVisible(true);
						dispose();
					}
					else if(username.getText().equals(x.getUsername()))
					{
						JOptionPane.showMessageDialog(null, "Incorrect password. Enter Again.");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You are not a registered user.");

					}
				}*/
			}
		});
		loginbtn.setBounds(223, 206, 85, 21);
		contentPane.add(loginbtn);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\swiing\\Black-3D-Blocks-iphone.jpg"));
		lblNewLabel_1.setBounds(187, 61, 184, 208);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
