package view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.ButtonListener;
import controller.Helper;

import model.SMS;
import model.User;


public class GUI_List_SMS extends GUI_Header_List {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_List_SMS frame = new GUI_List_SMS(new User("",""));
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
	public GUI_List_SMS(User user) throws SQLException{
		super(user, new String[] {"Sender", "User ID", "Receiver", "Timestamp", "Message"} ) ;
		setTitle("SMS list");
//		this.setTable();
	}
	
//	public void setTable(){
//		model.addRow(new String[] { "Test", "Test123", "3333", "1234", "Password3" } );
//	}
	public void setTable(ArrayList<SMS> smsList){
		for (int i = model.getRowCount() - 1; i > -1; i--) {
	        model.removeRow(i);
	    }	
		for(SMS sms : smsList){
			model.addRow(new String[] { sms.getSender(), sms.getUserID(), 
					Helper.arrayToString(sms.getReceiver()), String.valueOf(sms.getTimeStamp()), sms.getBody() } );
		}
	}	
	public void setActionListener(ButtonListener lbl) {
		this.btnNewMessage.setActionCommand("NewSMS");
		this.btnNewMessage.addActionListener(lbl);
		this.btnShowMessage.setActionCommand("ShowSMS");
		this.btnShowMessage.addActionListener(lbl);
		this.btnExit.addActionListener(lbl);
	}
	
	
	public SMS getSms(){
	try{
		String[] receiver = table.getModel().getValueAt(table.getSelectedRow(), 2).toString().split(";");  
		return new SMS(		table.getModel().getValueAt(table.getSelectedRow(), 0).toString(), 
								receiver, 
								table.getModel().getValueAt(table.getSelectedRow(), 1).toString(),
								Timestamp.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 3).toString()),
								table.getModel().getValueAt(table.getSelectedRow(), 4).toString())  ;		
	}
	catch(java.lang.ArrayIndexOutOfBoundsException e)
	{
		return null;
	}
	}
	
}
