package model;

import java.sql.Timestamp;

public class Print extends Message {

	private String[] files;

	// Konstruktur für ein bereits existierender Print
	public Print(String sender, String[] receiver, String userID, Timestamp timeStamp, String[] files) {
		super(sender, receiver, userID, timeStamp);
		this.files = files;
	}

	// Konstruktur für einen neuen Print
	public Print(String sender, String[] receiver, String userID, String[] files) {
		super(sender, receiver, userID);
		this.files = files;
	}

	public String[] getFiles() {
		return files;
	}

}
