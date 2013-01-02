package db;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.Helper;

import model.SMS;
import model.User;

public class DBsms extends DB {
	// Alle SMS eines Benutzers auslesen
		public static ArrayList<SMS> getSMS(User currentUser) throws SQLException,
				ClassNotFoundException {
			// Verbindung zur Datenbank herstellen
			connect();
			ps = con.prepareStatement("SELECT * FROM public.sms WHERE userid = ? or (LOCATE(?, receiver)>0);");
			ps.setString(1, currentUser.getUserID());
			ps.setString(2, currentUser.getPhoneNumber());
			rs = ps.executeQuery();
			ArrayList<SMS> smslist = new ArrayList<SMS>();
			while (rs.next()) {
				smslist.add(new SMS(rs.getString("sender"), rs
						.getString("receiver").split(";"), rs.getString("userid"),
						rs.getTimestamp("timestamp"), rs.getString("body")));
			}
			// Verbindung zur Datenbank schliessen
			disconnect();
			return smslist;
		}

		// Ein spezifisches SMS auslesen
		public static SMS getSMS(SMS sms) throws SQLException,
				ClassNotFoundException {
			connect();
			ps = con.prepareStatement("SELECT * FROM public.sms WHERE userid = ? and timestamp = ? LIMIT 1;");
			ps.setString(1, sms.getUserID());
			ps.setTimestamp(2, sms.getTimeStamp());
			rs = ps.executeQuery();
			try {
				rs.next();
				SMS dbSMS = new SMS(rs.getString("sender"), rs
						.getString("receiver").split(";"), rs.getString("userID"),
						rs.getTimestamp("timestamp"), rs.getString("body"));
				return dbSMS;
			} catch (java.sql.SQLException e) {
				return null;
			} finally {
				disconnect();
			}
		}

		// Neues SMS in die Datenbank speicher
		// Ist die Nachricht länger als 160 Zeichen, werden mehrere SMS mit
		// Teilnachrichten abgelegt
		public static void saveSMS(SMS newSMS) throws ClassNotFoundException,
				SQLException {
			connect();
			ps = con.prepareStatement("INSERT INTO public.sms ( sender, receiver, userid, body, timestamp) VALUES ( ?, ?, ?, ?, sysdate);");
			ps.setString(1, newSMS.getSender());
			ps.setString(2, Helper.arrayToString(newSMS.getReceiver()));
			ps.setString(3, newSMS.getUserID());
			String[] bodies = Helper.splitByLength(newSMS.getBody(), 160);
			for (String body : bodies) {
				ps.setString(4, body);
				ps.executeUpdate();
			}
			disconnect();
		}
}
