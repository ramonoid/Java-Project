package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ButtonListener;

import model.User;



public class MainMenu extends GUI_Header {

	private JPanel contentPane;
	private JButton btnSMS;
	private JButton btnMMS;
	private JButton btnMail;
	private JButton btnPrint;
	private JButton btnAdmin;

	/**
	* Launch the application.
	*/
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainMenu frame = new MainMenu(new User("",""));
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	* Create the frame.
	*/
	public MainMenu(User user) {
		super(user);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 540, 329);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		btnSMS = new JButton("SMS");
		btnSMS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSMS.setBounds(10, 11, 89, 23);
		contentPane.add(btnSMS);
		
		btnMMS = new JButton("MMS");
		btnMMS.setBounds(8, 50, 91, 23);
		contentPane.add(btnMMS);
		
		btnMail = new JButton("Mail");
		btnMail.setBounds(10, 84, 89, 23);
		contentPane.add(btnMail);
		
		btnPrint = new JButton("Print");
		btnPrint.setBounds(10, 118, 89, 23);
		contentPane.add(btnPrint);
		
		btnAdmin = new JButton("Admin");
		btnAdmin.setBounds(10, 152, 91, 23);
		contentPane.add(btnAdmin);
	}
	
	public void setActionListener(ButtonListener lbl) {
		this.btnSMS.setActionCommand("SMS");
		this.btnSMS.addActionListener(lbl);
		this.btnMMS.setActionCommand("MMS");
		this.btnMMS.addActionListener(lbl);
		this.btnPrint.setActionCommand("Print");
		this.btnPrint.addActionListener(lbl);
		this.btnMail.setActionCommand("Email");
		this.btnMail.addActionListener(lbl);
		this.btnAdmin.setActionCommand("Admin");
		this.btnAdmin.addActionListener(lbl);
	}
}


