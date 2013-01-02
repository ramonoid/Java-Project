package model;

import java.sql.Timestamp;

public class MMS extends Message {

	private String[] files;
	private String body;

	// Konstruktur f�r ein bereits existierendes MMS
	public MMS(String sender, String[] receiver, String userID, Timestamp timeStamp,
			String body, String[] files) {
		super(sender, receiver, userID, timeStamp);
		this.body = body;
		this.files = files;
	}

	// Konstruktur f�r ein neues MMS
	public MMS(String sender, String[] receiver, String userID, String body,
			String[] files) {
		super(sender, receiver, userID);
		this.body = body;
		this.files = files;
	}

	public String[] getFiles() {
		return files;
	}

	public String getBody() {
		return body;
	}

}
