package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static PreparedStatement ps;
	static int count;

	public static void connect() throws ClassNotFoundException, SQLException {
		Class.forName("org.hsqldb.jdbcDriver");
		String config = "jdbc:hsqldb:file:db/ComCenterDB; shutdown=true";
		String user = "root";
		String password = "";
		con = DriverManager.getConnection(config, user, password);
		stmt = con.createStatement();
	}

	public static void disconnect() throws SQLException {
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
	}
}