package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;



public class GUI_List_User extends GUI_Header {

	private JPanel contentPane;

	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_List_User frame = new GUI_List_User(new User("",""));
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
	public GUI_List_User(User user) {
		super(user);
		setTitle("Message List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 329);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSend = new JButton("Open");
		btnSend.setBounds(381, 245, 89, 23);
		contentPane.add(btnSend);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(280, 245, 91, 23);
		contentPane.add(btnCancel);
		
		List list = new List();
		list.setBounds(10, 10, 460, 227);
		contentPane.add(list);
	}
}


