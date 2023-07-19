package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/PP_1_1_3-4_JDBC_Hibernate";
    private static final String DB_Driver = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;

    public static Connection getConnection() {

        // try {
        //   connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        // } catch (SQLException e) {
        //     System.out.println("Соединение с БД!");
        // }
        // return connection;
        // }
        try {
            Class.forName(DB_Driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}





