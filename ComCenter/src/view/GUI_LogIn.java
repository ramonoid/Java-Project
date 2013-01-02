package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ButtonListener;

import model.User;


public class GUI_LogIn extends GUI_Header  {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JButton btnLogin;

	public GUI_LogIn() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 282, 183);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblWelcomeToThe = new JLabel("Welcome to ComCenter");
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcomeToThe.setBounds(10, 11, 217, 27);
		contentPane.add(lblWelcomeToThe);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(20, 52, 75, 14);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(20, 77, 75, 14);
		contentPane.add(lblPassword);

		txtUser = new JTextField();
		txtUser.setBounds(90, 49, 155, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(90, 74, 155, 20);
		contentPane.add(txtPassword);

		btnLogin = new JButton("Login");
		btnLogin.setActionCommand("CheckCredentials");
		btnLogin.setBounds(156, 105, 89, 23);
		contentPane.add(btnLogin);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(20, 105, 89, 23);
		contentPane.add(btnExit);
	}

	public void setActionListener(ButtonListener lbl) {
		this.btnLogin.setActionCommand("Login");
		this.btnLogin.addActionListener(lbl);
	}

	public String getTxtUser() {
		return txtUser.getText();
	}

	@SuppressWarnings("deprecation")
	public String getTxtPassword() {
		return txtPassword.getText();
	}

	public User getUser() {
		return new User(txtUser.getText(), txtPassword.getText());
	}
	
}
