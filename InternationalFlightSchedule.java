import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class InternationalFlightSchedule extends JFrame {

	private JPanel contentPane;
	static JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JButton btnNewButton_3;
	static ArrayList<Flight> flightList2=new ArrayList<Flight>();

	public static void main(String[] args) {
		InternationalFlightSchedule frame = new InternationalFlightSchedule();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public InternationalFlightSchedule() {
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 443);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(134, 115, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		String[] columns = {"Flight ID", "Time", "Date", "From",
                "To" , "Economy Seats" , "Business Seats" , "Time Duration"};

		DefaultTableModel obj=new DefaultTableModel(columns,0);

        
		sqlconnect connection = new sqlconnect();
		Connection con = connection.connect();
		Statement st=null;
		String query="select * from intflights";
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
	//	scrollPane.setColumnHeaderView(table);
		
		btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddInternationalFlight obj=new AddInternationalFlight();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(161, 250, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRowCount()==1)
				{
					String query  = "Delete from intflights where flightid='"+table.getValueAt(table.getSelectedRow(),0).toString()+"'";
					obj.removeRow(table.getSelectedRow());
					JOptionPane.showMessageDialog(null, "Selected flight has been deleted.");
					sqlconnect connection = new sqlconnect();
					Connection con = connection.connect();
					Statement st=null;
					try {
						st = con.createStatement();
						st.executeQuery(query);
						return;
					}catch(Exception i) {
						
					}
					
				}
				else if(table.getSelectedRowCount()==0)
				{
					JOptionPane.showMessageDialog(null, "Please select a row first.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select one row at a time.");
				}
			}
		});
		btnNewButton_1.setBounds(260, 250, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Edit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRowCount()==1)
				{
					EditFlight2 obj=new EditFlight2(table.getValueAt(table.getSelectedRow(),0).toString(),table.getValueAt(table.getSelectedRow(),1).toString(),table.getValueAt(table.getSelectedRow(),2).toString(),table.getValueAt(table.getSelectedRow(),3).toString(),table.getValueAt(table.getSelectedRow(),4).toString(),table.getValueAt(table.getSelectedRow(),5).toString(),table.getValueAt(table.getSelectedRow(),6).toString(),table.getValueAt(table.getSelectedRow(),7).toString());
					obj.setVisible(true);
					dispose();
				}
				else if(table.getSelectedRowCount()==0)
				{
					JOptionPane.showMessageDialog(null, "Please select a row first");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select one row at a time");
				}
			}
		});
		btnNewButton_2.setBounds(359, 250, 89, 23);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("International Flight Schedule");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 680, 28);
		contentPane.add(lblNewLabel);
		
		btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu obj=new Menu();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(458, 250, 89, 23);
		contentPane.add(btnNewButton_3);
		
	}

}
