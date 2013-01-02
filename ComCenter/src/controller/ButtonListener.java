package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonListener implements ActionListener {
//	private GUI smsGUI;
//	private GUI_LogIn loginGUI;
//
//	public ButtonListener(GUI smsGUI) {
//		this.smsGUI = smsGUI;
//	}
//	
//	public ButtonListener(GUI_LogIn loginGUI) {
//		this.loginGUI = loginGUI;
//	}
	
	private Controller controller;
	public ButtonListener(Controller controller){
		this.controller = controller;
		
	}
	
	//Usecases werden hier abgebildet
	public void actionPerformed(ActionEvent actionEvent) {
//		if (actionEvent.getActionCommand().equals("SendSMS")) {
//			SMS newSMS = smsGUI.getSMS();
//			/* User noch aus DB Laden */
//
//			Validator validateSMS = new Validator(newSMS);
//			if (validateSMS.isValidated()) {
//				new SaveToDB(newSMS);
//				smsGUI.setVisible(false);
//			}
//		}
//
//		if (actionEvent.getActionCommand().equals("CheckCredentials")) {
//			//String userid = loginGUI.getTxtUser();
//			//String password = loginGUI.getTxtPassword();
//			USER testUser = loginGUI.getTestUser();
//			System.out.println(testUser.getUser_id());
//			ValidateUser validatedUser =  new ValidateUser(testUser);
//			//ValidateUser validatedUser =  new ValidateUser(userid, password);
//			USER currentUser = validatedUser.getCurrentUser();
//			
//			//Hauptmenü starten sobald der User authentifiziert wurde
//			if(currentUser != null){
//				Controller.startMainMenu(currentUser);
//			}
//		}
		if (actionEvent.getActionCommand().equals("Login")) {		
			controller.navStartMain();
		}
		
		if (actionEvent.getActionCommand().equals("SendSMS")) {		
			controller.navSendSms();
		}
		
		if (actionEvent.getActionCommand().equals("SendMMS")) {		
			controller.navSendMms();
		}		
		
		if (actionEvent.getActionCommand().equals("SendPrint")) {		
			controller.navSendPrint();
		}			

		if (actionEvent.getActionCommand().equals("SendEmail")) {		
			controller.navSendEmail();
		}					
		
		
		if (actionEvent.getActionCommand().equals("ShowSMS")) {		
			controller.navShowSms();
		}
		
		if (actionEvent.getActionCommand().equals("ShowMMS")) {		
			controller.navShowMms();
		}		
		
		if (actionEvent.getActionCommand().equals("ShowPrint")) {		
			controller.navShowPrint();
		}			

		if (actionEvent.getActionCommand().equals("ShowEmail")) {		
			controller.navShowEmail();
		}		
		
		
		if (actionEvent.getActionCommand().equals("NewSMS")) {		
			controller.navNewSms();
		}
		
		if (actionEvent.getActionCommand().equals("NewMMS")) {		
			controller.navNewMms();
		}		
		
		if (actionEvent.getActionCommand().equals("NewPrint")) {		
			controller.navNewPrint();
		}			

		if (actionEvent.getActionCommand().equals("NewEmail")) {		
			controller.navNewEmail();
		}		
		
		if (actionEvent.getActionCommand().equals("CancelEmail")){
			controller.navListEmail();
		}
		if (actionEvent.getActionCommand().equals("CancelMMS")){
			controller.navListMms();
		 }
		    
		if(actionEvent.getActionCommand().equals("CancelSMS")){
		    controller.navListSms();
		}
	   if(actionEvent.getActionCommand().equals("CancelPrint")) {		
		    controller.navListPrint();	
		}
		
		if (actionEvent.getActionCommand().equals("Exit")){
			controller.navMainMenu();
		}
		
		
		if (actionEvent.getActionCommand().equals("SMS")) {		
			controller.navListSms();
		}		
		
		if (actionEvent.getActionCommand().equals("MMS")) {		
			controller.navListMms();
		}
		
		if (actionEvent.getActionCommand().equals("Email")) {		
			controller.navListEmail();
		}		
		if (actionEvent.getActionCommand().equals("Print")) {		
			controller.navListPrint();
		}		
		
		if (actionEvent.getActionCommand().equals("Admin")) {		
			//TODO: Navigate Admin
			controller.navListUser();
		}
		if (actionEvent.getActionCommand().equals("ModifyUser")) {		
			controller.navModUser();
		}		
		if (actionEvent.getActionCommand().equals("NewUser")) {		
			controller.navNewUser();
		}		
		if (actionEvent.getActionCommand().equals("DelUser")) {		
			controller.navDelUser();
		}				
	   if(actionEvent.getActionCommand().equals("CancelUser")) {		
		    controller.navListUser();	
		}
	   if(actionEvent.getActionCommand().equals("SaveNewUser")) {		
		    controller.navSaveNewUser();	
		}
	   if(actionEvent.getActionCommand().equals("SaveModUser")) {		
		    controller.navSaveModUser();	
		}
	}
}