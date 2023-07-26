package jm.task.core.jdbc.util;


import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД

    private static final String URL = "jdbc:mysql://localhost:3306/PP_1_1_3-4_JDBC_Hibernate";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                return connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }
}








