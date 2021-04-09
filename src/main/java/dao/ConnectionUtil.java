package main.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author jinalshah
 * ConnectionUtil : Its an abstract class created to hold Oracle database connection details.
 */
abstract class ConnectionUtil {

	protected Connection connection;
	private String connectionURL = "jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu";
	private String username = "jshah21";
	private String password = "abeckoab";
	public ConnectionUtil() {
		try {
			connection = DriverManager.getConnection(
					connectionURL, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
