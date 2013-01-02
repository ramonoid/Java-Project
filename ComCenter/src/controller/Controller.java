package controller;

import java.sql.SQLException;

import model.User;
import view.GUI_Email;
import view.GUI_List_Email;
import view.GUI_List_MMS;
import view.GUI_List_Print;
import view.GUI_List_SMS;
import view.GUI_LogIn;
import view.GUI_MMS;
import view.GUI_Print;
import view.GUI_SMS;
import view.MainMenu;
import view.UserForm;
import view.UserList;
import db.DBemail;
import db.DBmms;
import db.DBprint;
import db.DBsms;
import db.DBuser;

public class Controller {

	private GUI_LogIn logIn;

	private GUI_Email email;
	private GUI_MMS mms;
	private GUI_SMS sms;
	private GUI_Print print;

	private GUI_List_Email emailList;
	private GUI_List_MMS mmsList;
	private GUI_List_Print printList;
	private GUI_List_SMS smsList;
	private UserList adminList;
	private UserForm admin;

	private MainMenu mainMenu;
	private ButtonListener listener;
	private User user;

	public Controller() {

		// user = new User(null, null);
		listener = new ButtonListener(this);

		logIn = new GUI_LogIn();
		logIn.setVisible(true);
		logIn.setActionListener(listener);
	}

	public void navListEmail() {
		mainMenu.setVisible(false);
		try {
			emailList = new GUI_List_Email(user);
			emailList.setActionListener(listener);
    		emailList.setTable(DBemail.getEmail(user));
		}
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}			
		 catch (SQLException e) {
			e.printStackTrace();
		}
		if (email != null) {
			email.setVisible(false);
		}
		emailList.setVisible(true);
		// TODO: setTable
		// emailList.setTable();
	}

	public void navListPrint() {
		mainMenu.setVisible(false);
		try {
			printList = new GUI_List_Print(user);
			printList.setActionListener(listener);
    		printList.setTable(DBprint.getPrint(user));
		}
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (print != null) {
			print.setVisible(false);
		}

		printList.setVisible(true);
		// TODO: setTable
		// printList.setTable();
	}

	public void navListSms() {
		mainMenu.setVisible(false);
		try {
			smsList = new GUI_List_SMS(user);
			smsList.setActionListener(listener);
			try {
				smsList.setTable(DBsms.getSMS(user));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (sms != null) {
			sms.setVisible(false);
		}

		smsList.setVisible(true);
		// TODO: setTable
		// sms.setTable();
	}

	public void navListMms() {
		mainMenu.setVisible(false);
		try {
			mmsList = new GUI_List_MMS(user);
			mmsList.setActionListener(listener);
    		mmsList.setTable(DBmms.getMMS(user));
		}
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (mms != null) {
			mms.setVisible(false);
		}

		mmsList.setVisible(true);
		// TODO: setTable
		// mmsList.setTable();
	}

	public void navShowEmail() {

		if (emailList.getEmail() != null) {
			email = new GUI_Email(user);
			email.setEmail(emailList.getEmail());
			emailList.setVisible(false);
			email.setActionListener(listener);
			email.setReadOnly(false);
			email.setVisible(true);
		}
	}

	public void navShowPrint() {
		if (printList.getPrint() != null) {
			print = new GUI_Print(user);
			printList.setVisible(false);
			print.setPrint(printList.getPrint());
			print.setActionListener(listener);
			print.setReadOnly(false);
			print.setVisible(true);
		}
	}

	public void navShowSms() {
		if (smsList.getSms() != null) {
			smsList.setVisible(false);
			sms = new GUI_SMS(user);
			sms.setActionListener(listener);
			sms.setSMS(smsList.getSms());
			sms.setReadOnly(false);
			sms.setVisible(true);
		}

	}

	public void navShowMms() {
		if (mmsList.getMms() != null) {
			mmsList.setVisible(false);
			mms = new GUI_MMS(user);
			mms.setActionListener(listener);
			mms.setMMS(mmsList.getMms());
			mms.setReadOnly(false);
			mms.setVisible(true);
		}
	}

	public void navNewEmail() {
		emailList.setVisible(false);
		email = new GUI_Email(user);
		email.setActionListener(listener);
		// email.setEmail(emailList.getEmail());
		email.setReadOnly(true);
		email.setVisible(true);
	}

	public void navNewPrint() {
		printList.setVisible(false);
		print = new GUI_Print(user);
		print.setActionListener(listener);
		// print.setPrint(printList.getPrint());
		print.setReadOnly(true);
		print.setVisible(true);
	}

	public void navNewSms() {
		smsList.setVisible(false);
		sms = new GUI_SMS(user);
		sms.setActionListener(listener);
		// sms.setSMS(smsList.getSms());
		sms.setReadOnly(true);
		sms.setVisible(true);

	}

	public void navNewMms() {
		mmsList.setVisible(false);
		mms = new GUI_MMS(user);
		mms.setActionListener(listener);
		// mms.setMMS(mmsList.getMms());
		mms.setReadOnly(true);
		mms.setVisible(true);
	}

	public void navMainMenu() {
		mainMenu.setVisible(true);
		// TODO: besser ausprogrammieren
		if (mmsList != null) {
			mmsList.setVisible(false);
		}

		if (smsList != null) {
			smsList.setVisible(false);
		}

		if (printList != null) {
			printList.setVisible(false);
		}

		if (emailList != null) {
			emailList.setVisible(false);
		}
		if (adminList != null) {
			adminList.setVisible(false);
		}

	}

	public void navStartMain() {

		try {
			if (DBuser.getUser(logIn.getUser()) != null
					&& DBuser.getUser(logIn.getUser()).getPassword()
							.equals(logIn.getUser().getPassword())) {
				user = DBuser.getUser(logIn.getUser());
				mainMenu = new MainMenu(user);
				mainMenu.setVisible(true);
				mainMenu.setActionListener(listener);
				logIn.setVisible(false);

			} else {
				// TODO: Fehlermeldung Falscher User oder PW
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void navListUser() {

		try {
			adminList = new UserList(user);
			adminList.setActionListener(listener);
			adminList.setTable(DBuser.getUser());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (admin != null) {
				admin.setVisible(false);
			}
			mainMenu.setVisible(false);
			adminList.setVisible(true);
		}

	}

	public void navModUser() {
		if (adminList.getUser() != null) {
			adminList.setVisible(false);
			admin = new UserForm(user);
			admin.setActionListener(listener);
			admin.setActionListenerSave("SaveModUser");
			admin.setUser(adminList.getUser());
			// admin.setReadOnly(true);
			admin.setVisible(true);
		}
	}

	public void navNewUser() {
		adminList.setVisible(false);
		admin = new UserForm(user);
		admin.setActionListener(listener);
		admin.setActionListenerSave("SaveNewUser");
		// email.setEmail(emailList.getEmail());
		// admin.setReadOnly(true);
		admin.setVisible(true);
	}

	public void navDelUser() {

		if (adminList.getUser() != null) {
			try {
				DBuser.delUser(adminList.getUser());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			adminList.setTable(DBuser.getUser());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// if(DB.getUser(new User("marco", null))==null)
		// System.out.println("\nUser successfully deleted!");

	}

	public void navSaveNewUser() {

		try {
			if (DBuser.getUser(admin.getUser()) == null) {
				DBuser.saveUser(admin.getUser());
				System.out.println("User sucessfully created!");
			} else {
				System.out.println("There is already an user with this ID!");
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			admin.setVisible(false);
			adminList.setVisible(true);
			try {
				adminList.setTable(DBuser.getUser());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void navSaveModUser() {

		try {
			if (DBuser.getUser(admin.getUser()) != null) {
				DBuser.updateUser(admin.getUser());
				System.out.println("\nUser was successfully updated");
				System.out.print("User is now called: ");
				System.out.println(DBuser.getUser(admin.getUser())
						.getUsername());
			} else {
				System.out
						.println("The User that you wish to update does not exist!");
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			admin.setVisible(false);
			adminList.setVisible(true);
			try {
				adminList.setTable(DBuser.getUser());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// public void navSaveUser() {
	//
	//
	// try {
	// if(DB.getUser(admin.getUser()) == null){
	// DB.saveUser(admin.getUser());
	// System.out.println("User sucessfully created!");
	// } else {
	// System.out.println("There is already an user with this ID!");
	// }
	// } catch (ClassNotFoundException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// } catch (SQLException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	//
	//
	//
	// try {
	// adminList.setTable(DB.getUser());
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	public void navSendSms() {

		try {
			DBsms.saveSMS(sms.getSMS());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sms.setVisible(false);
			smsList.setVisible(true);
			try {
				smsList.setTable(DBsms.getSMS(user));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void navSendMms() {

		try {
			DBmms.saveMMS(mms.getMMS());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mms.setVisible(false);
			mmsList.setVisible(true);
			try {
				mmsList.setTable(DBmms.getMMS(user));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void navSendPrint() {
		try {
			DBprint.savePrint(print.getPrint());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			print.setVisible(false);
			printList.setVisible(true);
			try {
				printList.setTable(DBprint.getPrint(user));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void navSendEmail() {
		try {
			DBemail.saveEmail(email.getEmail());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			email.setVisible(false);
			emailList.setVisible(true);
			try {
				emailList.setTable(DBemail.getEmail(user));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
	}

	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// private GUI_LogIn loginGUI;
	// public void run() {
	// try {
	// loginGUI = new GUI_LogIn();
	// loginGUI.setVisible(true);
	// loginGUI.setActionListener(new ButtonListener(loginGUI));
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	// public void run() {
	// try {

	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }
}
