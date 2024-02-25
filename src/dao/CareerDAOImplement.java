package dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.mysql.cj.protocol.Resultset;

import model.Career;

public class CareerDAOImplement implements CareerDAO {

    private static final String PROPERTIES_FILE = "config/db.properties";

    private String dbUrl;
    private String user;
    private String password;

    public CareerDAOImplement() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
            props.load(fis);
            this.dbUrl = props.getProperty("DB_URL");
            this.user = props.getProperty("USER");
            this.password = props.getProperty("PASSWORD");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String createCareer(Career career) {
        String response = "";
        if (!careerExist(career.getName())) {
            try {
                Connection connection = DriverManager.getConnection(dbUrl, user, password);
                String sql = "INSERT INTO carreras (nombre) VALUES (?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, career.getName());
                if (statement.executeUpdate() > 0) {
                    response = "Career added successfully.";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response = "Error adding career.";
            }
        } else {
            response = "That career already exists.";
        }
        return response;
    }

    private boolean careerExist(String name) {
        boolean check = false;
        try {
            Connection connection = DriverManager.getConnection(dbUrl, user, password);
            String sql = "SELECT COUNT(*) FROM carreras WHERE nombre LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultset = statement.executeQuery();
            if (resultset.next()) {
                check = resultset.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean updateCareer(Career career) {
        boolean check = false;
        try {
            Connection connection = DriverManager.getConnection(dbUrl, user, password);
            String sql = "UPDATE carreras SET nombre = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, career.getName());
            statement.setInt(2, career.getId());
            check=statement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean deleteCareer(int id) {
        /*
         * Tambien se podria hacer seleccionando por el nombre
         * o recibiendo el objeto Career...
         */
        boolean check = false;
        try {
            Connection connection = DriverManager.getConnection(dbUrl, user, password);
            String sql = "DELETE FROM carreras WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            check=statement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public Career getCareer(int id) {
        /* Tambien se podria buscar por nombre... etc */
        Career career = null;
        try {
            Connection connection = DriverManager.getConnection(dbUrl, user, password);
            String sql = "SELECT * FROM carreras WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                career = new Career(resultSet.getInt("id"), resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return career;
    }

    @Override
    public List<Career> getAllCareers() {
        List<Career> careers = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(dbUrl, user, password);
            String sql = "SELECT * FROM carreras";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                careers.add(new Career(resultSet.getInt("id"), resultSet.getString("nombre")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return careers;
    }

}