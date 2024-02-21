

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

public class PassengerMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		PassengerMenu frame = new PassengerMenu("Tester");
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public PassengerMenu(String user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 406);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome, "+user+"!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(83, 11, 414, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Local Flights");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookLocalFlight obj=new BookLocalFlight();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(202, 110, 150, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("International Flights");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookInternationalFlight obj=new BookInternationalFlight();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(202, 159, 150, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModeSelection obj=new ModeSelection();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(202, 255, 150, 23);
		contentPane.add(btnNewButton_2); 
		
		JButton btnNewButton_3 = new JButton("Booking History");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(202, 210, 150, 21);
		contentPane.add(btnNewButton_3);
	}
}
