package com.phonebook.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static ConnectionManager instance = null;
    private Connection connection = null;

    private ConnectionManager() {

    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }

        return instance;
    }

    private boolean openConnection() {

        String CONNECTION_STRING = "jdbc:mysql://localhost:3306/phonebook?useSSL=false&" +
                "useUnicode=true&" +
                "characterEncoding=utf8&" +
                "useJDBCCompliantTimezoneShift=true&" +
                "useLegacyDatetimeCode=false&" +
                "serverTimezone=UTC";

        String USERNAME = "root";
        String PASSWORD = "toor";

        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            return true;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public Connection getConnection() {
        if (connection == null) {
            if (openConnection()) {
                return connection;
            }
            else {
                return null;
            }
        }
        return connection;
    }

    public void close() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}