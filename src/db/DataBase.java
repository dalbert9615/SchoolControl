package db;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBase {

    private Connection connection;

    public DataBase() {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("config/db.properties");
            props.load(fis);
            String dbUrl = props.getProperty("DB_URL");
            String user = props.getProperty("USER");
            String password = props.getProperty("PASSWORD");
            Connection connection = DriverManager.getConnection(dbUrl, user, password);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
