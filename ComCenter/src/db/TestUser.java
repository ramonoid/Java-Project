package db;

import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

public class TestUser {
//	public static void main(String[] args) throws ClassNotFoundException,
//			SQLException {
//		
//		//Neuer User erfassen
//		User newUser = new User("marco", "Marco Kramer", "test1234","marco@mail.com", "0788883322");
//		if(DB.getUser(newUser)==null){
//			DB.saveUser(newUser);
//			System.out.println("User sucessfully created!");
//		} else {
//			System.out.println("There is already an user with this ID!");
//		}
//		
//		//Auslesen der Informationen eines Benutzers 
//		System.out.print("\nNew User is called: ");
//		System.out.println(DB.getUser(new User("marco", null)).getUsername());
//		
//		//Benutzer anpassen (Achtung alle Werte werden vom Objekt an die DB gegeben)
//		User updateThisUser = new User("marco", "Marco Grümmer", "test1234","marco@mail.com", "0788883322");
//		if(DB.getUser(updateThisUser)!=null){
//			DB.updateUser(updateThisUser);
//			System.out.println("\nUser was successfully updated");
//			System.out.print("User is now called: ");
//			System.out.println(DB.getUser(updateThisUser).getUsername());
//		} else {
//			System.out.println("The User that you wish to update does not exist!");
//		}
//		
//		
//		//Alle User anzeigen
//		System.out.println("\nHere is a list of all Users:");
//		ArrayList<User> userlist = DB.getUser();
//		for (User user : userlist) {
//			System.out.println(user.getEmail());
//		}
//		
//		//Login eines Benutzers
//		User loginUser = new User("marco", "test1234");
//		if(DB.getUser(loginUser)==null){
//			System.out.println("User does not exist!");
//		} else {
//			if(DB.getUser(loginUser).getPassword().equals(loginUser.getPassword())){
//				System.out.println("\nLogin Successfull");
//			} else {
//				System.out.println("Wrong Password!");
//			}
//		}
//		
//		//Löschen eines Benutzers
//		DB.delUser(new User("marco", null));
//		if(DB.getUser(new User("marco", null))==null) System.out.println("\nUser successfully deleted!");
//	}
}
