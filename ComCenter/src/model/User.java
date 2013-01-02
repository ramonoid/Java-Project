package model;

public class User {

	private String userID;
	private String username;
	private String password;
	private String email;
	private String phoneNumber;

	public User(String userID, String username, String password, String email,
			String phoneNumber) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public User(String userID, String username, String email, String phoneNumber) {
		this.userID = userID;
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public User(String userID, String password) {
		this.userID = userID;
		this.password = password;
	}

	public String getUserID() {
		return userID;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

}
