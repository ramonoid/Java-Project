package db;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.Helper;

import model.Print;
import model.User;

public class DBprint extends DB {
	// Alle Prints eines Benutzers auslesen
	public static ArrayList<Print> getPrint(User currentUser)
			throws SQLException, ClassNotFoundException {
		// Verbindung zur Datenbank herstellen
		connect();
		ps = con.prepareStatement("SELECT * FROM public.print WHERE userid = ?);");
		ps.setString(1, currentUser.getUserID());
		rs = ps.executeQuery();
		ArrayList<Print> printlist = new ArrayList<Print>();
		while (rs.next()) {
			printlist.add(new Print(rs.getString("sender"), rs.getString(
					"receiver").split(";"), rs.getString("userid"), rs
					.getTimestamp("timestamp"), rs.getString("files")
					.split(";")));
		}
		// Verbindung zur Datenbank schliessen
		disconnect();
		return printlist;
	}

	// Einen spezifischen Print auslesen
	public static Print getPrint(Print print) throws SQLException,
			ClassNotFoundException {
		connect();
		ps = con.prepareStatement("SELECT * FROM public.mms WHERE userid = ? and timestamp = ? LIMIT 1;");
		ps.setString(1, print.getUserID());
		ps.setTimestamp(2, print.getTimeStamp());
		rs = ps.executeQuery();
		try {
			rs.next();
			Print dbPrint = new Print(rs.getString("sender"),
					rs.getString("receiver").split(";"),
					rs.getString("userid"), rs.getTimestamp("timestamp"), rs
							.getString("files").split(";"));
			return dbPrint;
		} catch (java.sql.SQLException e) {
			return null;
		} finally {
			disconnect();
		}
	}

	// Neuen Print in die Datenbank speichern
	public static void savePrint(Print newPrint) throws ClassNotFoundException,
			SQLException {
		connect();
		ps = con.prepareStatement("INSERT INTO public.print ( sender, receiver, userid, timestamp, files) VALUES ( ?, ?, ?, sysdate, ?);");
		ps.setString(1, newPrint.getSender());
		ps.setString(2, Helper.arrayToString(newPrint.getReceiver()));
		ps.setString(3, newPrint.getUserID());
		ps.setString(4, Helper.arrayToString(newPrint.getFiles()));
		ps.executeUpdate();
		disconnect();
	}
}
