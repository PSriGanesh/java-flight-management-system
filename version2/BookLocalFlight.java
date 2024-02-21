
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BookLocalFlight extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		BookLocalFlight frame = new BookLocalFlight("test");
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public BookLocalFlight(String user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 419);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(134, 115, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Local Flight Schedule");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(28, 0, 679, 28);
		contentPane.add(lblNewLabel);
		
		String[] columns = {"Flight ID", "Time", "Date", "From",
                "To" , "Economy Seats" , "Business Seats" , "Time Duration"};

		DefaultTableModel obj=new DefaultTableModel(columns,0);
        
		sqlconnect connection = new sqlconnect();
		Connection con = connection.connect();
		Statement st=null;
		String query="select * from localflights";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
			        Object[] update= {rs.getString(1) , rs.getString(2) , rs.getString(3)
			        			, rs.getString(4), rs.getString(5) , 
			        			rs.getString(6) , rs.getString(7) , rs.getString(8)};
			        
			    	obj.addRow(update);
			}
		}catch(Exception i) {
			System.out.println(i);
		}
	    
	     table = new JTable(obj);
	    JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 39, 764, 200);
		contentPane.add(scrollPane);
		JButton btnNewButton_1 = new JButton("Book Flight");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRowCount()==1)
				{
					String selectClass = JOptionPane.showInputDialog(null, "Enter '1' for Economy and '2' for Business class.",null);
					int slctClass = Integer.valueOf(selectClass);
					
					switch (slctClass)
					{
					case 1:
					{
						String query  = "insert into bookings values('"+user+"','Economy','"+table.getValueAt(table.getSelectedRow(),0).toString()+"')";
						sqlconnect connection = new sqlconnect();
						Connection con = connection.connect();
						Statement st=null;
						try {
							st = con.createStatement();
							st.executeQuery(query);
							JOptionPane.showMessageDialog(null, "Your flight has been booked!");
						}catch(Exception i) {
							
						}finally {
							JOptionPane.showMessageDialog(null, "Your flight has been booked!");
						}
						break;
					}
					case 2:
					{
						String query  = "insert into bookings values('"+user+"','Business','"+table.getValueAt(table.getSelectedRow(),0).toString()+"')";
						sqlconnect connection = new sqlconnect();
						Connection con = connection.connect();
						Statement st=null;
						try {
							st = con.createStatement();
							st.executeQuery(query);
							
						}catch(Exception i) {
							
						}
						finally {
							JOptionPane.showMessageDialog(null, "Your flight has been booked!");
						}
						break;
					}
						default:
						{
							JOptionPane.showMessageDialog(null, "You entered an invalid input. Try again");
							break;
						}
					}
				}
				else if(table.getSelectedRowCount()==0)
				{
					JOptionPane.showMessageDialog(null, "Please select a flight to book.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select one flight at a time.");
				}
			}
		});
		btnNewButton_1.setBounds(211, 249, 111, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Ticket Price");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount()==0)
				{
					JOptionPane.showMessageDialog(null, "Please select a flight to view price.");
					return;
				}
				double hour=Integer.valueOf((String) table.getModel().getValueAt(table.getSelectedRow(), 7));
				
				double cost=(hour*10000)+((hour*10000)*5/100);
				JOptionPane.showMessageDialog(null, "The cost for this flight is: "+cost);
			}
		});
		btnNewButton_2.setBounds(332, 249, 136, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassengerMenu obj=new PassengerMenu(user);
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(478, 249, 112, 23);
		contentPane.add(btnNewButton_3);
	

}
}
