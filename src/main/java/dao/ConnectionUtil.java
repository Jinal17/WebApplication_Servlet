/**
 * 
 */
package main.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author jinalshah
 *
 */
public class ConnectionUtil {

	Connection connection;
	String connectionURL = "jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu";
	String username = "jshah21";
	String password = "abeckoab";
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
