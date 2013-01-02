package model;

import java.sql.Timestamp;

public class Email extends Message {

	private String[] cc;
	private String[] bcc;
	private String body;
	private String[] files;

	// Konstruktur für ein bereits existierendes Email
	public Email(String sender, String[] receiver, String userID,
			Timestamp timeStamp, String body, String[] files, String[] cc,
			String[] bcc) {

		super(sender, receiver, userID, timeStamp);
		this.body = body;
		this.files = files;
		this.cc = cc;
		this.bcc = bcc;
	}

	// Konstruktur für ein neues Email
	public Email(String sender, String[] receiver, String userID, String body,
			String[] files, String[] cc, String[] bcc) {
		super(sender, receiver, userID);
		this.body = body;
		this.files = files;
		this.cc = cc;
		this.bcc = bcc;
	}

	public String[] getCc() {
		return cc;
	}

	public String[] getBcc() {
		return bcc;
	}

	public String getBody() {
		return body;
	}

	public String[] getFiles() {
		return files;
	}

}
