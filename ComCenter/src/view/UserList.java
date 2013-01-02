package view;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import javax.swing.ListSelectionModel;

import controller.ButtonListener;

import model.Print;
import model.User;

public class UserList extends GUI_Header {

	private JPanel contentPane;
	private JTable table;
	final DefaultTableModel model;
//	private final JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserList frame = new UserList(new User(null, null));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	private JButton btnDeleteUser;
	private JButton btnNewUser;
	private JButton btnModifyUser;
	private JButton btnExit;
	
	public UserList(User user) throws SQLException {
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 478, 205);
		contentPane.add(scrollPane);

		String col[] = { "User ID", "Name", "Mobile", "Mail", "Password" };
		model = new DefaultTableModel(
				new String[][] {}, col);
		table = new JTable(model){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
//		ResultSet userList = DBconnect.getUser();
//		while (userList.next()) {
//			model.addRow(new String[] { userList.getString("USER_ID"),
//					userList.getString("USER_NAME"), userList.getString("MOBILE"),
//					userList.getString("MAIL"), userList.getString("PASSWORD") });
//		}

		JTableHeader header = table.getTableHeader();
		scrollPane.setViewportView(table);

		btnNewUser = new JButton("New User");
//		btnNewUser.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				UserForm frame = new UserForm();
//				frame.setVisible(true);
//				closeFrame();
//			}
//		});
		btnNewUser.setBounds(143, 227, 89, 23);
		contentPane.add(btnNewUser);
		
		
		btnDeleteUser = new JButton("Delete User");
//		btnDeleteUser.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Component frame = null;
//				String userID = table.getModel()
//						.getValueAt(table.getSelectedRow(), 0).toString();
//				int n = JOptionPane.showConfirmDialog(frame,
//						"Wollen Sie den Benutzer '" + userID
//								+ "' wirklich löschen?", "An Inane Question",
//						JOptionPane.YES_NO_OPTION);
//				if (n == JOptionPane.YES_OPTION) {
//					model.removeRow(table.getSelectedRow());
//					DBconnect.delUser(userID);
//				}
//			}
//		});
		btnDeleteUser.setBounds(270, 227, 89, 23);
		contentPane.add(btnDeleteUser);
//
		btnModifyUser = new JButton("Modify User");
//		btnModifyUser.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				int iSelectedRow = table.getSelectedRow();
//				String userid = table.getModel().getValueAt(iSelectedRow, 0)
//						.toString();
//				System.out.println(userid);
//				UserForm frame = new UserForm();
//				try {
//					frame.mofifyUser(userid);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				frame.setVisible(true);
//				closeFrame();
//			}
//		});
		btnModifyUser.setBounds(399, 227, 89, 23);
		contentPane.add(btnModifyUser);
//		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFrame();
			}
		});
		btnExit.setBounds(10, 227, 89, 23);
		contentPane.add(btnExit);
//		setTable();
//		setTable();
//		setTable();
		
	}
	public User getUser()
	{
		try{
			return new User(  table.getModel().getValueAt(table.getSelectedRow(), 0).toString(),
							  table.getModel().getValueAt(table.getSelectedRow(), 1).toString(),
							  table.getModel().getValueAt(table.getSelectedRow(), 4).toString(),
						      table.getModel().getValueAt(table.getSelectedRow(), 3).toString(),
							  table.getModel().getValueAt(table.getSelectedRow(), 2).toString()) ;	
			}
			catch(java.lang.ArrayIndexOutOfBoundsException e)
			{
				return null;
			}

	}
	
//	public void setTable(){
//		model.addRow(new String[] { "Test", "Test123", "Mobile1", "1234", "Password3" } );
//	}
	public void setTable(ArrayList<User> userList){
		for (int i = model.getRowCount() - 1; i > -1; i--) {
	        model.removeRow(i);
	    }
		for(User user : userList){
			model.addRow(new String[] { user.getUserID(), user.getUsername(), 
					user.getPhoneNumber(), user.getEmail(), 
					user.getPassword() } );
			}
	}
	
	public void setActionListener(ButtonListener lbl) {
		this.btnModifyUser.setActionCommand("ModifyUser");
		this.btnModifyUser.addActionListener(lbl);
		this.btnNewUser.setActionCommand("NewUser");
		this.btnNewUser.addActionListener(lbl);
		this.btnDeleteUser.setActionCommand("DelUser");
		this.btnDeleteUser.addActionListener(lbl);
		this.btnExit.setActionCommand("Exit");
		this.btnExit.addActionListener(lbl);		
	}
	
	public void closeFrame(){
		this.setVisible(false);
	}
}
