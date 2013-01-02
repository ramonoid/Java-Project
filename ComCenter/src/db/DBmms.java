package db;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.Helper;

import model.MMS;
import model.User;

public class DBmms extends DB {
	// Alle MMS eines Benutzers auslesen
	public static ArrayList<MMS> getMMS(User currentUser) throws SQLException,
			ClassNotFoundException {
		// Verbindung zur Datenbank herstellen
		connect();
		ps = con.prepareStatement("SELECT * FROM public.mms WHERE userid = ? or (LOCATE(?, receiver)>0);");
		ps.setString(1, currentUser.getUserID());
		ps.setString(2, currentUser.getPhoneNumber());
		rs = ps.executeQuery();
		ArrayList<MMS> mmslist = new ArrayList<MMS>();
		while (rs.next()) {
			mmslist.add(new MMS(rs.getString("sender"), rs
					.getString("receiver").split(";"), rs.getString("userid"),
					rs.getTimestamp("timestamp"), rs.getString("body"), rs
							.getString("files").split(";")));
		}
		// Verbindung zur Datenbank schliessen
		disconnect();
		return mmslist;
	}

	// Ein spezifisches MMS auslesen
	public static MMS getMMS(MMS mms) throws SQLException,
			ClassNotFoundException {
		connect();
		ps = con.prepareStatement("SELECT * FROM public.mms WHERE userid = ? and timestamp = ? LIMIT 1;");
		ps.setString(1, mms.getUserID());
		ps.setTimestamp(2, mms.getTimeStamp());
		rs = ps.executeQuery();
		try {
			rs.next();
			MMS dbMMS = new MMS(rs.getString("sender"), rs
					.getString("receiver").split(";"), rs.getString("userID"),
					rs.getTimestamp("timestamp"), rs.getString("body"), rs
							.getString("files").split(";"));
			return dbMMS;
		} catch (java.sql.SQLException e) {
			return null;
		} finally {
			disconnect();
		}
	}

	// Neues MMS in die Datenbank speicherm
	public static void saveMMS(MMS newMMS) throws ClassNotFoundException,
			SQLException {
		connect();
		ps = con.prepareStatement("INSERT INTO public.mms ( sender, receiver, userid, body, timestamp, files) VALUES ( ?, ?, ?, ?, sysdate, ?);");
		ps.setString(1, newMMS.getSender());
		ps.setString(2, Helper.arrayToString(newMMS.getReceiver()));
		ps.setString(3, newMMS.getUserID());
		ps.setString(4, newMMS.getBody());
		ps.setString(5, Helper.arrayToString(newMMS.getFiles()));
		ps.executeUpdate();
		disconnect();
	}
}
