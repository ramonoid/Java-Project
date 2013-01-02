package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ButtonListener;

import model.User;


public class UserForm extends GUI_Header {
	private JTextField txtUserID;
	private JTextField txtUserName;
	private JTextField txtMobile;
	private JTextField txtMail;
	private JTextField txtPassword;
	private JLabel lblCreateOrModify;
	private JButton btnSave;
	private JButton btnExit;
//	private JButton btnModify;
//	private ComCenter.UserList frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserForm frame = new UserForm( new User(null, null));
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
	public UserForm(User user) {
		this.user = user;
		setBounds(100, 100, 304, 262);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		lblCreateOrModify = new JLabel("Create User");
		lblCreateOrModify.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCreateOrModify.setBounds(10, 11, 186, 19);
		getContentPane().add(lblCreateOrModify);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(20, 41, 65, 14);
		getContentPane().add(lblUserId);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(95, 38, 175, 20);
		getContentPane().add(txtUserID);
		txtUserID.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(20, 68, 65, 14);
		getContentPane().add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(95, 65, 175, 20);
		getContentPane().add(txtUserName);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(20, 97, 65, 14);
		getContentPane().add(lblMobile);
		
		txtMobile = new JTextField();
		txtMobile.setColumns(10);
		txtMobile.setBounds(95, 94, 175, 20);
		getContentPane().add(txtMobile);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(20, 125, 65, 14);
		getContentPane().add(lblMail);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(95, 122, 175, 20);
		getContentPane().add(txtMail);
		
		JLabel lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(20, 153, 65, 14);
		getContentPane().add(lblPasswort);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(95, 150, 175, 20);
		getContentPane().add(txtPassword);
		
		btnExit = new JButton("Exit");
//		btnExit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				closeFrame();
//			}
//		});
		btnExit.setBounds(20, 190, 89, 23);
		getContentPane().add(btnExit);
		
		btnSave = new JButton("Save");
//		btnSave.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				ResultSet user = DBconnect.getUser(txtUserID.getText());
//				try {
//					if (user.next()){
//						Component frame = null;
//						JOptionPane.showMessageDialog(frame,
//							    "User ID already exists! Choose another one!",
//							    "Inane error",
//							    JOptionPane.ERROR_MESSAGE);
//					} else {
//						DBconnect.addUser(txtUserID.getText(), txtUserName.getText(), txtMobile.getText(), txtMail.getText(), txtPassword.getText());
//						closeFrame();
//						try {
//							reloadUserList();
//						} catch (SQLException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					}
//				} catch (HeadlessException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
		btnSave.setBounds(181, 190, 89, 23);
		getContentPane().add(btnSave);
	}
	public void mofifyUser(String userid) throws SQLException{
//		lblCreateOrModify.setText("Modify User");
//		ResultSet user = DBconnect.getUser(userid);
//		if(user.next()){
//			txtUserID.setText(user.getString("USER_ID"));
//			txtUserID.disable();
//			txtUserName.setText(user.getString("USER_NAME"));
//			txtMobile.setText(user.getString("MOBILE"));
//			txtMail.setText(user.getString("MAIL"));
//			txtPassword.setText(user.getString("PASSWORD"));
//		}
//		getContentPane().remove(btnSave);
//		btnModify = new JButton("Modify");
//		btnModify.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//					DBconnect.updateUser(txtUserID.getText(), txtUserName.getText(), txtMobile.getText(), txtMail.getText(), txtPassword.getText());
//					closeFrame();
//					try {
//						reloadUserList();
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//		});
//		btnModify.setBounds(181, 190, 89, 23);
//		getContentPane().add(btnModify);
	}
	public void closeFrame(){
		this.setVisible(false);
	}
//	public void reloadUserList() throws SQLException{
//		frame = new UserList();
//		frame.setVisible(true);
//	}
	public void setActionListener(ButtonListener lbl) {
		this.btnSave.setActionCommand("SaveNewUser");
		this.btnSave.addActionListener(lbl);
		this.btnExit.setActionCommand("CancelUser");
		this.btnExit.addActionListener(lbl);

	}
	public void setActionListenerSave(String str) {
		this.btnSave.setActionCommand(str);
	}

	public void setUser(User user) {
		txtUserID.setText(user.getUserID());
		txtUserName.setText(user.getUsername());
		txtMobile.setText(user.getPhoneNumber());
		txtMail.setText(user.getEmail());
		txtPassword.setText(user.getPassword());
	}
	public User getUser() {
		return new User(txtUserID.getText(), txtUserName.getText(), txtPassword.getText(), txtMail.getText(), txtMobile.getText());

	}	
}
