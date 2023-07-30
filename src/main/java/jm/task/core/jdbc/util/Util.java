package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.*;
import java.util.Properties;
import java.sql.DriverManager;

import static org.hibernate.cfg.AvailableSettings.DRIVER;


public class Util {
    // реализуйте настройку соеденения с БД

    private static final String URL = "jdbc:mysql://localhost:3306/pp_1_1_3-4_jdbc_hibernate";
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

    ///////////
    public static SessionFactory sessionFactory;//настройка и работа с сессиями

    public static SessionFactory getSessionFactory() {//Session
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties properties = new Properties();
                properties.put(DRIVER, "com.mysql.cj.jdbc.Driver");//"com.mysql.cj.jdbc.Driver"
                properties.put(Environment.URL, URL);//"jdbc:mysql://localhost:3306/PP_1_1_3-4_JDBC_Hibernate = false"
                properties.put(Environment.USER, USERNAME);//USER
                properties.put(Environment.PASS, PASSWORD);//PASSWORD
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                properties.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(properties);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (HibernateException e) {
                e.printStackTrace();
                System.out.println("Problem creating session factory");  //?
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}








