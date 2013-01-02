package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.ButtonListener;
import controller.Helper;

import model.SMS;
import model.User;



public class GUI_SMS extends GUI_Header {

//	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	private JLabel lblCount;
	private JTextArea txtReceiver;
	private JTextArea txtSender;
	private JTextArea txtCount;
	private JButton btnSend;
	private JButton btnCancel;
	private final JTextArea txtMessage;

	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_SMS frame = new GUI_SMS(new User("",""));
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
	public GUI_SMS(User user) {
		super(user);
		setTitle("Write a SMS message");
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
		lblNewLabel_2.setBounds(31, 69, 79, 14);
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
	
		txtMessage.setBounds(120, 64, 350, 157);
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
		btnSend.setBounds(381, 245, 89, 23);
		contentPane.add(btnSend);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(280, 245, 91, 23);
		contentPane.add(btnCancel);
	}

	public void setActionListener(ButtonListener lbl) {
		this.btnCancel.setActionCommand("CancelSMS");
		this.btnCancel.addActionListener(lbl);
			this.btnSend.setActionCommand("SendSMS");
		this.btnSend.addActionListener(lbl);
	}	
	public SMS getSMS(){
		String[] receiver = this.txtReceiver.getText().split(";"); 
//		String[] files = this.txtFiles.getText().split(";");
		return new SMS(user.getPhoneNumber(), receiver, user.getUserID(), this.txtMessage.getText() );
	}
	public void setSMS(SMS sms)
	{
//		StringBuffer strBuffer = new StringBuffer();
//		for(int i = 0; i < sms.getReceiver().length; i++ ){
//			if(i == 0)
//			{ 
//				strBuffer.append(sms.getReceiver()[i]);
//			}
//			else
//			{
//				strBuffer.append(";" + sms.getReceiver()[i]);
//			}
//		}
//		this.txtReceiver.setText( strBuffer.toString());
		this.txtReceiver.setText(Helper.arrayToString(sms.getReceiver()));
		
		this.txtSender.setText(sms.getSender());
		this.txtMessage.setText(sms.getBody());
		
	}

	public void setReadOnly(boolean editable){
		this.txtReceiver.setEditable(editable);
		this.txtMessage.setEditable(editable);
		this.btnSend.setEnabled(editable);
	}
	
}


