package model;

import java.sql.Timestamp;

public class SMS extends Message {

	private String body;

	public String getBody() {
		return body;
	}

	// Konstruktur f�r ein bereits existierendes SMS
	public SMS(String sender, String[] receiver, String userID, Timestamp timeStamp, String body) {
		super(sender, receiver, userID, timeStamp);
		this.body = body;
	}

	// Konstruktur f�r ein neues SMS
	public SMS(String sender, String[] receiver, String userID, String body) {
		super(sender, receiver, userID);
		this.body = body;
	}
	
}