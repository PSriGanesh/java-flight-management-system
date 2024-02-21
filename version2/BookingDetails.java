import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Component;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class BookingDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingDetails frame = new BookingDetails("test");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookingDetails(String user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 390);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] columns = {"Flight ID", "Time", "Date", "From",
                "To" , "Seat Type" , "Duration"};

		DefaultTableModel obj=new DefaultTableModel(columns,0);
		sqlconnect connection = new sqlconnect();
		Connection con = connection.connect();
		Statement st=null;
		String query="SELECT localflights.flightid,localflights.departtime,localflights.fdate,localflights.startloc,localflights.endloc,bookings.seat_type,localflights.duration FROM bookings,localflights WHERE bookings.username='"+user+"' AND (bookings.flightid=localflights.flightid) UNION SELECT intflights.flightid,intflights.departtime,intflights.fdate,intflights.startloc,intflights.endloc,bookings.seat_type,intflights.duration FROM bookings,intflights WHERE bookings.username='"+user+"' AND (bookings.flightid=intflights.flightid)";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
			        Object[] update= {rs.getString(1) , rs.getString(2) , rs.getString(3)
			        			, rs.getString(4), rs.getString(5) , 
			        			rs.getString(6) , rs.getString(7)};
			    	obj.addRow(update);
			}
		}catch(Exception i) {
			System.out.println(i);
		}
		table = new JTable(obj);
	    JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 66, 679, 200);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Bookings");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Product Sans", Font.PLAIN, 23));
		lblNewLabel.setBounds(218, 10, 264, 41);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassengerMenu obj = new PassengerMenu(user);
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(308, 322, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel Flight");
		btnNewButton_1.setBounds(280, 276, 145, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount()==1) {
					sqlconnect connection = new sqlconnect();
					Connection con = connection.connect();
					Statement st=null;
					String query="select * from bookings where username='"+user+"' and flightid='"+table.getValueAt(table.getSelectedRow(),0).toString()+"'";
					try {
						st = con.createStatement();
						ResultSet rs = st.executeQuery(query);
						if(rs.next()!=false) {
							query ="insert into refunds values('"+user+"','"+table.getValueAt(table.getSelectedRow(),0).toString()+"','"+table.getValueAt(table.getSelectedRow(),5).toString()+"')";
							//obj.removeRow(table.getSelectedRow());
							System.out.println(query);
							System.out.println(st.executeQuery(query));
						}
						else
							JOptionPane.showMessageDialog(null, "No Booking found to cancel");
					}catch(Exception i) {
						JOptionPane.showMessageDialog(null, "Refund Request was submitted. Your booking will be deleted from history after the refund is processed");
					}
				}
				else if(table.getSelectedRowCount()==0)
				{
					JOptionPane.showMessageDialog(null, "Please select a flight to cancel.");
				}
				
				
			}
		});
		contentPane.add(btnNewButton_1);
	}
}
