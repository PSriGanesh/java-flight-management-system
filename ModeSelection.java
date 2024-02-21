
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ModeSelection extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		ModeSelection frame = new ModeSelection();
		frame.setVisible(true);
	}
	public ModeSelection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 579, 368);
		setSize(1288,707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to  Airline Flight Management System ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(420, 12, 414, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminLogin obj=new AdminLogin();
				obj.setVisible(true);
			}
		});
		btnNewButton.setBounds(464, 172, 106, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Passenger");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login obj=new Login();
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(700, 172, 106, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Select your login type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(535, 56, 180, 29);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen obj = new MainScreen();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(27, 637, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setIcon(new ImageIcon("E:\\swiing\\account-lock-black.png"));
		lblNewLabel_2.setBounds(489, 95, 36, 67);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\swiing\\account.png"));
		lblNewLabel_3.setBounds(724, 95, 50, 67);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("E:\\swiing\\typeback.jpeg"));
		lblNewLabel_4.setBounds(0, 0, 1280, 677);
		contentPane.add(lblNewLabel_4);
		
	}
}
