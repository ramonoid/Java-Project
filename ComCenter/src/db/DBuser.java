package db;

import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

public class DBuser extends DB {
	// Alle Benutzer aus der Datenbank auslesen
		public static ArrayList<User> getUser() throws SQLException,
				ClassNotFoundException {
			// Verbindung zur Datenbank herstellen
			connect();
			ps = con.prepareStatement("SELECT * FROM public.user;");
			rs = ps.executeQuery();
			ArrayList<User> userlist = new ArrayList<User>();
			while (rs.next()) {
				userlist.add(new User(rs.getString("USERID"), rs
						.getString("USERNAME"), rs.getString("PASSWORD"), rs
						.getString("EMAIL"), rs.getString("PHONENUMBER")));
			}
			// Verbindung zur Datenbank schliessen
			disconnect();
			return userlist;
		}

		// Einzelner Benutzer aus DB auslesen.
		// Liefert Null zurück wenn der User nicht existiert!
		public static User getUser(User user) throws SQLException,
				ClassNotFoundException {
			connect();
			ps = con.prepareStatement("SELECT * FROM public.user WHERE userid = ? LIMIT 1;");
			ps.setString(1, user.getUserID());
			rs = ps.executeQuery();
			try {
				rs.next();
				User dbUser = new User(rs.getString("userID"),
						rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("phoneNumber"));
				return dbUser;
			} catch (java.sql.SQLException e) {
				return null;
			} finally {
				disconnect();
			}
		}

		// Neuer Benutzer in der Datenbank erfassen
		public static void saveUser(User newUser) throws ClassNotFoundException,
				SQLException {
			connect();
			ps = con.prepareStatement("INSERT INTO public.user ( userid, username, password, email, phonenumber ) VALUES ( ?, ?, ?, ?, ?);");
			ps.setString(1, newUser.getUserID());
			ps.setString(2, newUser.getUsername());
			ps.setString(3, newUser.getPassword());
			ps.setString(4, newUser.getEmail());
			ps.setString(5, newUser.getPhoneNumber());
			ps.executeUpdate();
			disconnect();
		}

		// Bestehender Benutzer updaten
		public static void updateUser(User newUser) throws ClassNotFoundException,
				SQLException {
			connect();
			ps = con.prepareStatement("UPDATE public.user SET userid = ?, username = ?, password = ?, email = ?, phonenumber = ? WHERE userid = ?;");
			ps.setString(1, newUser.getUserID());
			ps.setString(2, newUser.getUsername());
			ps.setString(3, newUser.getPassword());
			ps.setString(4, newUser.getEmail());
			ps.setString(5, newUser.getPhoneNumber());
			ps.setString(6, newUser.getUserID());
			ps.executeUpdate();
			disconnect();
		}

		// Benutzer löschen
		public static void delUser(User newUser) throws ClassNotFoundException,
				SQLException {
			connect();
			ps = con.prepareStatement("DELETE FROM public.user WHERE userid = ?;");
			ps.setString(1, newUser.getUserID());
			ps.executeUpdate();
			disconnect();
		}

}
