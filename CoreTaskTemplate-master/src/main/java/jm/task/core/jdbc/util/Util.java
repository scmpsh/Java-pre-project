package jm.task.core.jdbc.util;

import javax.security.auth.login.Configuration;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    public static Connection getConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("org.postgresql.Driver").newInstance());
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/jshantay",
                    "jshantay", "");
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static Configuration getConfiguration() {
//
//
//        return ;
//    }
}
