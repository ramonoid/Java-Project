package view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.ButtonListener;
import controller.Helper;

import model.MMS;
import model.User;


public class GUI_List_MMS extends GUI_Header_List {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_List_MMS frame = new GUI_List_MMS(new User("",""));
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
	public GUI_List_MMS(User user) throws SQLException{
		super(user, new String[] {"Sender", "UserID", "Receiver", "TimeStamp", "Message", "Files"} ) ;
		setTitle("SMS list");
//		this.setTable();
	}
	
//	public void setTable(){
//		model.addRow(new String[] { "Test", "Test123", "Mobile1", "1234", "Password3", "test" } );
//	}
	
	
	public void setTable(ArrayList<MMS> mmslist){
		
		for (int i = model.getRowCount() - 1; i > -1; i--) {
	        model.removeRow(i);
	    }	
		for(MMS mms : mmslist){
			model.addRow(new String[] { mms.getSender(), 
										mms.getUserID(), 
										Helper.arrayToString(mms.getReceiver()),
										String.valueOf(mms.getTimeStamp()), 
										Helper.arrayToString(mms.getFiles()) } );
		}

	}
	public void setActionListener(ButtonListener lbl) {
		this.btnNewMessage.setActionCommand("NewMMS");
		this.btnNewMessage.addActionListener(lbl);
		this.btnShowMessage.setActionCommand("ShowMMS");
		this.btnShowMessage.addActionListener(lbl);
		this.btnExit.addActionListener(lbl);
	}

	public MMS getMms(){

    try{
		String[] receiver = table.getModel().getValueAt(table.getSelectedRow(), 2).toString().split(";");  
		String[] files = table.getModel().getValueAt(table.getSelectedRow(), 5).toString().split(";");
		return new MMS( table.getModel().getValueAt(table.getSelectedRow(), 0).toString(),
						receiver,
						table.getModel().getValueAt(table.getSelectedRow(), 1).toString(),
						Timestamp.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 3).toString()),
						table.getModel().getValueAt(table.getSelectedRow(), 4).toString(),
						files);
	}
	catch(java.lang.ArrayIndexOutOfBoundsException e)
	{
		return null;
	}
	}	

}


