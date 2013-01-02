package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;


public class GUI_Header extends JFrame {

	protected JPanel contentPane;
	protected User user;

	/**
	 * Create the frame.
	 */
	public GUI_Header(User user) {
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 424);
		contentPane = new JPanel();
		setDefaults();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		setDefaults();
	}
	public GUI_Header() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 424);
		contentPane = new JPanel();
		setDefaults();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	protected void setDefaults()
	{
		setResizable(false);
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

}
