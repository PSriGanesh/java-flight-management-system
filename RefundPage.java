import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class RefundPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		RefundPage frame = new RefundPage();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public RefundPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 387);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Refunds");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Product Sans", Font.PLAIN, 20));
		lblNewLabel.setBounds(238, 10, 186, 22);
		contentPane.add(lblNewLabel);
		String[] columns = {"Username", "FlightID", "FlightDate", "From",
                "To" , "SeatType"};

		DefaultTableModel obj=new DefaultTableModel(columns,0);
		
		sqlconnect connection = new sqlconnect();
		Connection con = connection.connect();
		Statement st=null;
		String query="SELECT refunds.username,localflights.flightid,localflights.fdate,localflights.startloc,localflights.endloc,refunds.seat_type FROM refunds,localflights WHERE (refunds.flight_id=localflights.flightid) UNION SELECT refunds.username,intflights.flightid,intflights.fdate,intflights.startloc,intflights.endloc,refunds.seat_type from refunds,intflights WHERE (refunds.flight_id=intflights.flightid)";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
			        Object[] update= {rs.getString(1) , rs.getString(2) , rs.getString(3)
			        			, rs.getString(4), rs.getString(5) , 
			        			rs.getString(6)};
			    	obj.addRow(update);
			}
		}catch(Exception i) {
			System.out.println(i);
		}
		
		table = new JTable(obj);		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 39, 650, 200);
		contentPane.add(scrollPane);
		
		btnNewButton = new JButton("Generate Refund");
		btnNewButton.setFont(new Font("Product Sans", Font.PLAIN, 13));
		btnNewButton.setBounds(273, 249, 151, 35);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount()==1) {
					String user = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
					String fid = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
					String query  = "delete from bookings where username='"+user+"' and flightid='"+fid+"';"+"delete from refunds where username='"+user+"' and flight_id='"+fid+"'";
					sqlconnect connection = new sqlconnect();
					Connection con = connection.connect();
					Statement st=null;
					try {
						st = con.createStatement();
						obj.removeRow(table.getSelectedRow());
						st.executeQuery(query);
					}catch(Exception i) {
						System.out.println(i);
					}
					finally {
						JOptionPane.showMessageDialog(null, "Refund Successful");
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Please Select A Refund Request.");
			}
		});
		
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(308, 319, 85, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu obj = new Menu();
				obj.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
	}
}
