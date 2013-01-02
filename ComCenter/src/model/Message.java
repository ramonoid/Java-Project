package model;

import java.sql.Timestamp;

public abstract class Message {

	private String sender;
	private String[] receiver;
	private String userID;
	private Timestamp timeStamp;

	// Konstruktur für eine bereits existierende Message
	public Message(String sender, String[] receiver, String userID,
			Timestamp timeStamp) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.userID = userID;
		this.timeStamp = timeStamp;
	}

	// Konstruktur für eine neue Message
	// (Timestamp wird bei der Insanzierung gesetzt)
	public Message(String sender, String[] receiver, String userID) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.userID = userID;
	}

	public String getSender() {
		return sender;
	}

	public String[] getReceiver() {
		return receiver;
	}

	public String getUserID() {
		return userID;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

}
