package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.ButtonListener;
import controller.Helper;

import model.MMS;
import model.User;



public class GUI_MMS extends GUI_Header {

//	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	private JLabel lblCount;
	private JTextArea txtReceiver;
	private JTextArea txtSender;
	private JTextArea txtCount;
    private JFileChooser fc;
    private File file;
    private JTextArea txtFiles;
    private JButton btnSend;
	private JButton btnCancel;
	private JButton btnChoiseFile;
	private final JTextArea txtMessage;

	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_MMS frame = new GUI_MMS(new User("",""));
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
	public GUI_MMS(User user) {
		super(user);
		setTitle("Write a MMS message");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 329);
		contentPane = new JPanel();
//		contentPane.setBackground(new Color(230, 230, 250));
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setDefaults();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sender:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(31, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Receiver:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(31, 40, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Message:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(31, 107, 79, 14);
		contentPane.add(lblNewLabel_2);
		
		lblCount = new JLabel("Count:");
		lblCount.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCount.setBounds(31, 248, 46, 14);
		contentPane.add(lblCount);

		txtCount = new JTextArea();
		txtCount.setBackground(new Color(230, 230, 250));
		txtCount.setEditable(false);
		txtCount.setRows(1);
		txtCount.setBounds(118, 243, 51, 23);
		txtCount.setText("0/140");
		contentPane.add(txtCount);
		
		txtMessage = new JTextArea();
		txtMessage.setLineWrap(true);
		txtMessage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				txtCount.setText(String.valueOf(txtMessage.getText().length())+"/140");
			}
		});
	
		txtMessage.setBounds(120, 103, 350, 112);
		contentPane.add(txtMessage);
		
		txtReceiver = new JTextArea();
		txtReceiver.setRows(1);
		txtReceiver.setBounds(120, 36, 273, 23);
		contentPane.add(txtReceiver);
		
		txtSender = new JTextArea();
		txtSender.setEditable(false);
		txtSender.setRows(1);
		txtSender.setBounds(118, 7, 154, 23);
		contentPane.add(txtSender);
		
		btnSend = new JButton("Send");
		btnSend.setBounds(381, 245, 89, 23);
		contentPane.add(btnSend);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(280, 245, 91, 23);
		contentPane.add(btnCancel);
		
		txtFiles = new JTextArea();
		txtFiles.setRows(1);
		txtFiles.setBounds(118, 69, 273, 23);
		contentPane.add(txtFiles);
		
		JLabel lblAttachement = new JLabel("Attachement:");
		lblAttachement.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAttachement.setBounds(31, 73, 79, 14);
		contentPane.add(lblAttachement);
		
		btnChoiseFile = new JButton("Choose File");
		fc = new JFileChooser();
		btnChoiseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            int returnVal = fc.showOpenDialog(GUI_MMS.this);

	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                file = fc.getSelectedFile();
	                if( txtFiles.getText().equals("") )
	                {
	                	txtFiles.setText( file.getAbsolutePath());
	                }
	                else
	                {	                	
	                	txtFiles.setText( txtFiles.getText() + ";" + file.getAbsolutePath() );
	                }
	            }
			}
		});
		btnChoiseFile.setBounds(400, 69, 70, 22);
		contentPane.add(btnChoiseFile);
	}
	
	public void setActionListener(ButtonListener lbl) {
		this.btnCancel.setActionCommand("CancelMMS");
		this.btnCancel.addActionListener(lbl);
		this.btnSend.setActionCommand("SendMMS");
		this.btnSend.addActionListener(lbl);
	}	
	
	public MMS getMMS(){
		String[] receiver = this.txtReceiver.getText().split(";");    
		String[] files = this.txtFiles.getText().split(";");
		return new MMS(user.getPhoneNumber(), receiver, user.getUserID(), this.txtMessage.getText(), files );
	}
	
	public void setMMS(MMS mms){
//		String[] receiver = this.txtReceiver.getText().split(";");    
//		String[] files = this.txtFiles.getText().split(";");
		//(user.getPhoneNumber(), receiver, user.getUserID(), this.txtMessage.getText(), files );
		
//		StringBuffer strBuffer = new StringBuffer();
//		for(int i = 0; i < mms.getReceiver().length; i++ ){
//			if(i == 0)
//			{ 
//				strBuffer.append(mms.getReceiver()[i]);
//			}
//			else
//			{
//				strBuffer.append(";" + mms.getReceiver()[i]);
//			}
//		}
		this.txtReceiver.setText( Helper.arrayToString(mms.getReceiver()));
		
		
//		strBuffer = new StringBuffer();
//		for(int i = 0; i < mms.getFiles().length; i++ ){
//			if(i == 0)
//			{ 
//				strBuffer.append(mms.getFiles()[i]);
//			}
//			else
//			{
//				strBuffer.append(";" + mms.getFiles()[i]);
//			}
//		}
		this.txtFiles.setText( Helper.arrayToString( mms.getFiles() ));		
		this.txtSender.setText(mms.getSender());
		this.txtMessage.setText(mms.getBody());
		
	}	

	public void setReadOnly(boolean editable){
		this.txtReceiver.setEditable(editable);
		this.txtMessage.setEditable(editable);
		this.txtFiles.setEditable(editable);
		this.btnChoiseFile.setEnabled(editable);
		this.btnSend.setEnabled(editable);
	}
	
}


