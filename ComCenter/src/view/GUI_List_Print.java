package view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.ButtonListener;
import controller.Helper;

import model.Print;
import model.User;


public class GUI_List_Print extends GUI_Header_List {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_List_Print frame = new GUI_List_Print(new User("",""));
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
	public GUI_List_Print(User user) throws SQLException{
		super(user, new String[] {"Sender", "UserID", "Receiver", "TimeStamp", "Files"} ) ;
		setTitle("Print list");
	}
	
//	public void setTable(){
//		model.addRow(new String[] { "Test", "Test123", "Mobile1", "1234", "Password3" } );
//	}
	public void setTable(ArrayList<Print> printList){
		for (int i = model.getRowCount() - 1; i > -1; i--) {
	        model.removeRow(i);
	    }		
		for(Print print : printList){
			model.addRow(new String[] { print.getSender(), print.getUserID(), 
					Helper.arrayToString(print.getReceiver()), String.valueOf(print.getTimeStamp()), 
					Helper.arrayToString(print.getFiles()) } );
			}
	}
	
	public void setActionListener(ButtonListener lbl) {
		this.btnNewMessage.setActionCommand("NewPrint");
		this.btnNewMessage.addActionListener(lbl);
		this.btnShowMessage.setActionCommand("ShowPrint");
		this.btnShowMessage.addActionListener(lbl);
		this.btnExit.addActionListener(lbl);
	}
	public Print getPrint(){
	try{
	String[] receiver = table.getModel().getValueAt(table.getSelectedRow(), 2).toString().split(";");  
	String[] files = table.getModel().getValueAt(table.getSelectedRow(), 4).toString().split(";");
	
	return new Print(		table.getModel().getValueAt(table.getSelectedRow(), 0).toString(), 
							receiver, 
							table.getModel().getValueAt(table.getSelectedRow(), 1).toString(),
							Timestamp.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 3).toString()),
						    files) ;	
	}
	catch(java.lang.ArrayIndexOutOfBoundsException e)
	{
		return null;
	}
	}
}
