package view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.ButtonListener;
import controller.Helper;

import model.Email;
import model.User;


public class GUI_List_Email extends GUI_Header_List {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_List_Email frame = new GUI_List_Email(new User("",""));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public GUI_List_Email(User user) throws SQLException{
		super(user, new String[] {"Sender", "User ID", "Receiver", "CC", "BBC", "Message", "Files", "TimeStamp"} ) ;
		setTitle("Email list");
//		this.setTable();
	}
	
//	public void setTable(){
//		model.addRow(new String[] { "Test", "Test123", "Mobile1", "Mail2", "Password3", "Mobile1", "Mail2", "123" } );
//		model.addRow(new String[] { "Test123", "Test123", "Mobile1", "Mail2", "Password3" , "Mobile1", "Mail2", "123"} );
//		model.addRow(new String[] { "Test456", "Test123", "Mobile1", "Mail2", "Password3" , "Mobile1", "Mail2", "123"} );
//	}
	public void setTable(ArrayList<Email> emailList){
		for (int i = model.getRowCount() - 1; i > -1; i--) {
	        model.removeRow(i);
	    }	
		for(Email email : emailList ){
			model.addRow(new String[] { email.getSender(), email.getUserID(), 
										Helper.arrayToString(email.getReceiver()), 
										Helper.arrayToString(email.getCc()), 
										Helper.arrayToString( email.getBcc()), 
										email.getBody(),
										Helper.arrayToString(email.getFiles()),
										String.valueOf(email.getTimeStamp())
										} );
		}
	}
	
	public void setActionListener(ButtonListener lbl) {
		this.btnNewMessage.setActionCommand("NewEmail");
		this.btnNewMessage.addActionListener(lbl);
		this.btnShowMessage.setActionCommand("ShowEmail");
		this.btnShowMessage.addActionListener(lbl);
		this.btnExit.addActionListener(lbl);
	}
	
	public Email getEmail()
	{	
		
		try
		{
			String[] receiver = table.getModel().getValueAt(table.getSelectedRow(), 1).toString().split(";");  
			String[] files = table.getModel().getValueAt(table.getSelectedRow(), 6).toString().split(";");
			String[] cc = table.getModel().getValueAt(table.getSelectedRow(), 3).toString().split(";");
			String[] bbc = table.getModel().getValueAt(table.getSelectedRow(), 4).toString().split(";");
			
			return new Email(		table.getModel().getValueAt(table.getSelectedRow(), 0).toString(), 
									receiver, 
									table.getModel().getValueAt(table.getSelectedRow(), 2).toString(),
									Timestamp.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 7).toString()),
									table.getModel().getValueAt(table.getSelectedRow(), 5).toString(), 
								    files,
								    cc,
								    bbc ) ;
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e)
		{
			return null;
		}
	}
}
