package tuntiprojekti.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;

public class DataAccessObject {

	/**
	 * Antaa tietokantayhteyden
	 * 
	 * @return connTietokantayhteys
	 */
	protected static Connection getConnection() {
		Connection connection = null;

		// Alkum‰‰ritykset
		String username = "a1404309";
		String password = "xoBUcz24m";
		String url = "jdbc:mariadb://localhost:3306/1404309";         //"jdbc:mysql://proto284.haaga-helia.fi:3306/a1404309"
		
		
		try {
			// Ladataan ajuri
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
		
		// Avataan yhteys conn-nimiseen muuttujaan
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return connection;
	}
	

	/**
	 * Sulkee Statementin ja Connectionin
	 * 
	 * @param SQL-statement
	 * @param Tietokantayhteys
	 */
	protected static void close(Statement stmt, Connection connection) {
		close (null, stmt, connection);
	}

	/**
	 * Sulkee ResultSetin, Statementin ja Connectionin
	
	 */
	protected static void close(ResultSet rs, Statement stmt, Connection conn ) {
		
		try {
			if (rs != null) { // Suljetaan rs (palautetut taulut), mik‰li olemassa
				rs.close();
			}
			if (stmt != null) { // Suljetaan stmt (SQL-statement), mik‰li olemassa
				stmt.close();
			}
			if (conn != null) { // Suljetaan conn (yhteys), mik‰li olemassa
				conn.close();
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
