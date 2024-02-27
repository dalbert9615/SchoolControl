package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class DBConnection {

	private static Connection con;
	private static String dbUrl;
	private static String user;
	private static String password;
	
	public static void closeConnection() {
		if (DBConnection.con != null) {
            try {
            	DBConnection.con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	public static Connection getInstance() {
		if(con==null) {
			setDbProperties();
			try {
				con = DriverManager.getConnection(dbUrl,user,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}

	private static void setDbProperties() {
		Properties props = new Properties();
		try {
			FileInputStream fis = new FileInputStream("config/db.properties");
			props.load(fis);
			DBConnection.dbUrl = props.getProperty("DB_URL");
			DBConnection.user = props.getProperty("USER");
			DBConnection.password = props.getProperty("PASSWORD");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
