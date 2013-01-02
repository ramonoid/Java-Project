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

import model.Email;
import model.User;



public class GUI_Email extends GUI_Header {

//	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	private JLabel lblCount;
	private JTextArea txtReceiver;
	private JTextArea txtSender;
	private JTextArea txtCount;
	private JTextArea txtCc;
	private JTextArea txtBbc;
	private JLabel lblCc;
	private JLabel lblBbc;
	private JTextArea txtFiles;
	private JButton btnChoiseFile;
	private JLabel lblFile;
	private final JTextArea txtMessage;
	private JFileChooser fc;
    private File file;
    private JButton btnSend;
	private JButton btnCancel;

	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Email frame = new GUI_Email(new User("", "" ));
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
	public GUI_Email(User user) {
		super(user);
		setTitle("Write a SMS message");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 424);
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
		lblNewLabel_2.setBounds(31, 174, 79, 14);
		contentPane.add(lblNewLabel_2);
		
		lblCount = new JLabel("Count:");
		lblCount.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCount.setBounds(31, 367, 46, 14);
		contentPane.add(lblCount);

		txtCount = new JTextArea();
		txtCount.setBackground(new Color(230, 230, 250));
		txtCount.setEditable(false);
		txtCount.setRows(1);
		txtCount.setBounds(124, 363, 51, 23);
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
	
		txtMessage.setBounds(120, 174, 350, 178);
		contentPane.add(txtMessage);
		
		txtReceiver = new JTextArea();
		txtReceiver.setRows(1);
		txtReceiver.setBounds(120, 35, 273, 23);
		contentPane.add(txtReceiver);
		
		txtSender = new JTextArea();
		txtSender.setRows(1);
		txtSender.setBounds(120, 6, 154, 23);
		contentPane.add(txtSender);
		
		
		btnSend = new JButton("Send");
		btnSend.setBounds(381, 363, 89, 23);
		contentPane.add(btnSend);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(280, 363, 91, 23);
		contentPane.add(btnCancel);
		
		txtCc = new JTextArea();
		txtCc.setRows(1);
		txtCc.setBounds(120, 70, 273, 23);
		contentPane.add(txtCc);
		
		txtBbc = new JTextArea();
		txtBbc.setRows(1);
		txtBbc.setBounds(120, 106, 273, 23);
		contentPane.add(txtBbc);
		
		lblCc = new JLabel("CC:");
		lblCc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCc.setBounds(31, 74, 79, 14);
		contentPane.add(lblCc);
		
		lblBbc = new JLabel("BBC:");
		lblBbc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBbc.setBounds(31, 110, 79, 14);
		contentPane.add(lblBbc);
		
		txtFiles = new JTextArea();
		txtFiles.setRows(1);
		txtFiles.setBounds(120, 140, 273, 23);
		contentPane.add(txtFiles);
		
		fc = new JFileChooser();
		btnChoiseFile = new JButton("Choise File");
		btnChoiseFile.setActionCommand("Choose File");
		btnChoiseFile.setBounds(400, 141, 70, 22);
		contentPane.add(btnChoiseFile);
		btnChoiseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            int returnVal = fc.showOpenDialog(GUI_Email.this);

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
		
		
		lblFile = new JLabel("File:");
		lblFile.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFile.setBounds(31, 149, 79, 14);
		contentPane.add(lblFile);
	}
	
	public Email getEmail(){
		
		String[] receiver = this.txtReceiver.getText().split(";");  
		String[] files = this.txtFiles.getText().split(";");
		String[] cc = this.txtCc.getText().split(";");
		String[] bbc = this.txtBbc.getText().split(";");
		return new Email(this.txtSender.getText(), 
								receiver, 
								user.getUserID(), 
							    this.txtMessage.getText(), 
							    files,
							    cc,
							    bbc);
		
		
	}
	
	public void setEmail(Email email){
//		StringBuffer strBuffer = new StringBuffer();
//		for(int i = 0; i < email.getReceiver().length; i++ ){
//			if(i == 0)
//			{ 
//				strBuffer.append(email.getReceiver()[i]);
//			}
//			else
//			{
//				strBuffer.append(";" + email.getReceiver()[i]);
//			}
//		}
		this.txtReceiver.setText( Helper.arrayToString( email.getReceiver()));
		
//		strBuffer = new StringBuffer();
//		for(int i = 0; i < email.getCc().length; i++ ){
//			if(i == 0)
//			{ 
//				strBuffer.append(email.getCc()[i]);
//			}
//			else
//			{
//				strBuffer.append(";" + email.getCc()[i]);
//			}
//		}
		this.txtCc.setText( Helper.arrayToString( email.getCc()));
		
//		strBuffer = new StringBuffer();
//		for(int i = 0; i < email.getBcc().length; i++ ){
//			if(i == 0)
//			{ 
//				strBuffer.append(email.getBcc()[i]);
//			}
//			else
//			{
//				strBuffer.append(";" + email.getBcc()[i]);
//			}
//		}
		this.txtBbc.setText( Helper.arrayToString(email.getBcc()));		
		
//		strBuffer = new StringBuffer();
//		for(int i = 0; i < email.getFiles().length; i++ ){
//			if(i == 0)
//			{ 
//				strBuffer.append(email.getFiles()[i]);
//			}
//			else
//			{
//				strBuffer.append(";" + email.getFiles()[i]);
//			}
//		}
		this.txtFiles.setText( Helper.arrayToString(email.getFiles()));		
		this.txtSender.setText(email.getSender());
		this.txtMessage.setText(email.getBody());
	}
	
	
	public void setReadOnly(boolean editable){
		this.txtReceiver.setEditable(editable);
		this.txtMessage.setEditable(editable);
		this.txtFiles.setEditable(editable);
		this.txtCc.setEditable(editable);
		this.txtBbc.setEditable(editable);
		this.btnChoiseFile.setEnabled(editable);
		this.btnSend.setEnabled(editable);
	}
	
	
	
	public void setActionListener(ButtonListener lbl) {
		this.btnCancel.setActionCommand("CancelEmail");
		this.btnCancel.addActionListener(lbl);
		this.btnSend.setActionCommand("SendEmail");
		this.btnSend.addActionListener(lbl);
	}
}


