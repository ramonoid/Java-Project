package db;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Email;
import model.User;
import controller.Helper;

public class DBemail extends DB {
	// Alle Emails eines Benutzers auslesen
	public static ArrayList<Email> getEmail(User currentUser)
			throws SQLException, ClassNotFoundException {
		// Verbindung zur Datenbank herstellen
		connect();
		ps = con.prepareStatement("SELECT * FROM public.email WHERE userid = ? or (LOCATE(?, receiver)>0);");
		ps.setString(1, currentUser.getUserID());
		ps.setString(2, currentUser.getEmail());
		rs = ps.executeQuery();
		ArrayList<Email> emaillist = new ArrayList<Email>();
		while (rs.next()) {
			emaillist.add(new Email(rs.getString("sender"), rs.getString(
					"receiver").split(";"), rs.getString("userid"), rs
					.getTimestamp("timestamp"), rs.getString("body"), rs
					.getString("files").split(";"), rs.getString("cc").split(
					";"), rs.getString("bcc").split(";")));
		}
		// Verbindung zur Datenbank schliessen
		disconnect();
		return emaillist;
	}

	// Ein spezifisches Email auslesen
	public static Email getEmail(Email email) throws SQLException,
			ClassNotFoundException {
		connect();
		ps = con.prepareStatement("SELECT * FROM public.email WHERE userid = ? and timestamp = ? LIMIT 1;");
		ps.setString(1, email.getUserID());
		ps.setTimestamp(2, email.getTimeStamp());
		rs = ps.executeQuery();
		try {
			rs.next();
			Email dbEmail = new Email(rs.getString("sender"), rs.getString(
					"receiver").split(";"), rs.getString("userid"), rs
					.getTimestamp("timestamp"), rs.getString("body"), rs
					.getString("files").split(";"), rs.getString("cc").split(
					";"), rs.getString("bcc").split(";"));
			return dbEmail;
		} catch (java.sql.SQLException e) {
			return null;
		} finally {
			disconnect();
		}
	}

	// Neues Email in die Datenbank speicherm
	public static void saveEmail(Email newEmail) throws ClassNotFoundException,
			SQLException {
		connect();
		ps = con.prepareStatement("INSERT INTO public.mms ( sender, receiver, userid, body, timestamp, files, cc, bcc) VALUES ( ?, ?, ?, ?, sysdate, ?, ?, ?);");
		ps.setString(1, newEmail.getSender());
		ps.setString(2, Helper.arrayToString(newEmail.getReceiver()));
		ps.setString(3, newEmail.getUserID());
		ps.setString(4, newEmail.getBody());
		ps.setString(5, Helper.arrayToString(newEmail.getFiles()));
		ps.setString(6, Helper.arrayToString(newEmail.getCc()));
		ps.setString(7, Helper.arrayToString(newEmail.getBcc()));
		ps.executeUpdate();
		disconnect();
	}
}
