package P3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class oracleBaseDAO {
	
	protected static Connection connection;
	
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String DB_USER = "P2";
	private static final String DB_PASS = "4321";
	
	
	protected Connection getConnection() throws SQLException{
	
		if (connection == null) {
				connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PASS);
		}
		return connection;
	}
	
	public void closeConnection() throws SQLException {
		if(connection != null) {
			connection.close();
		}
	}
}
