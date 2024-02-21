
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Menu extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		Menu frame = new Menu();
		frame.setVisible(true);
	}
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 384);
		ImagePanel panel = new ImagePanel(
		new ImageIcon("./background.png").getImage());
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Airline Flight Management System");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Product Sans", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 11, 477, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Refund Requests");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefundPage obj=new RefundPage();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(184, 158, 161, 28);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Local Flight Schedule");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalFlightSchedule obj=new LocalFlightSchedule();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(184, 59, 161, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("International Flights");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InternationalFlightSchedule obj=new InternationalFlightSchedule();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(184, 109, 161, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModeSelection obj=new ModeSelection();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(184, 205, 161, 29);
		contentPane.add(btnNewButton_2);
		contentPane.add(panel);
		contentPane.setLocation(10000, 10000);
		
		
	}
}
