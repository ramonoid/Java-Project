package view;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import javax.swing.ListSelectionModel;

import model.User;

public class GUI_Header_List extends GUI_Header {

//	private JPanel contentPane;
	protected DefaultTableModel model;
	protected JTable table;
	protected JButton btnNewMessage;
	protected JButton btnShowMessage;
	protected JButton btnExit;
	
	/* TODO
	 *  Fehler abfangen bei "kein User ausgewählt!"
	 */

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_Header_List frame = new GUI_Header_List(new User("",""));
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public GUI_Header_List(User user, String[] col) throws SQLException {
		super(user);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setDefaults();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 478, 205);
		contentPane.add(scrollPane);

//		String col[] = { "User ID", "Name", "Mobile", "Mail", "Password" };
		model = new DefaultTableModel(
				new String[][] {}, col);
		table = new JTable(model){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

//		ResultSet GUI_Header_List = DBconnect.getUser();
//		while (GUI_Header_List.next()) {
//			model.addRow(new String[] { GUI_Header_List.getString("USER_ID"),
//					GUI_Header_List.getString("USER_NAME"), GUI_Header_List.getString("MOBILE"),
//					GUI_Header_List.getString("MAIL"), GUI_Header_List.getString("PASSWORD") });
//		}

		JTableHeader header = table.getTableHeader();
		scrollPane.setViewportView(table);

		btnNewMessage = new JButton("New Message");
//		btnNewMessage.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				UserForm frame = new UserForm();
//				frame.setVisible(true);
//				closeFrame();
//			}
//		});
		btnNewMessage.setBounds(191, 227, 130, 23);
		contentPane.add(btnNewMessage);
//
		btnShowMessage = new JButton("Show Message");
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
		btnShowMessage.setBounds(368, 227, 128, 23);
		contentPane.add(btnShowMessage);
		
//		
		btnExit = new JButton("Exit");
		btnExit.setActionCommand("Exit");
//		btnExit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				closeFrame();
//			}
//		});
		btnExit.setBounds(10, 227, 130, 23);
		contentPane.add(btnExit);
		
	}
	public void closeFrame(){
		this.setVisible(false);
	}
}
