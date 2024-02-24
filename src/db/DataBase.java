package db;

import java.io.*;
import java.sql.*;
import java.util.*;
import model.Career;

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
            this.connection = DriverManager.getConnection(dbUrl, user, password);
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

    public boolean insertCareer(Career career){
        boolean check=false;
        String sql="INSERT INTO carreras (nombre) VALUES (?)";
        try{
            PreparedStatement statement=this.connection.prepareStatement(sql);
            statement.setString(1, career.getName());
            int rowsInserted=statement.executeUpdate();
            check=rowsInserted>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public List<Career> getAllCareers(){
        List<Career> careers = new ArrayList<>();
        String sql="SELECT * FROM carreras";
        try {
            PreparedStatement statement=this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("nombre");
                Career career=new Career(id,name);
                careers.add(career);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return careers;
    }

}
