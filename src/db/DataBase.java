package db;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBase {
    
    public static void connectToDataBase() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("config/db.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String dbUrl = props.getProperty("DB_URL");
        String user = props.getProperty("USER");
        String password = props.getProperty("PASSWORD");

         try{
            Connection connection = DriverManager.getConnection(dbUrl,user,password);
         }catch (SQLException e){
            e.printStackTrace();
         }
    }  
}
