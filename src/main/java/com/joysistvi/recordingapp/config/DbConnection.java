package com.joysistvi.recordingapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/recording_app_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public Connection connect() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed: " + e.getMessage(), e);
        }
    }

    public void testConnection() {
        try (Connection conn = connect()) {
            if (conn != null) {
                System.out.println("Connected to recording_app_db successfully!");
            }
        } catch (Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}