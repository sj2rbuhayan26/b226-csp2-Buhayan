package com.joysistvi.recordingapp.config;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// reverse domain names
// using a reverse domain . it helps name conflicts between packages from different organization
// java doesnt enforce this. but its widely followed convention
// commercial (com) organization (org) networking (net) edu gov
public class DbConnection {

    private final static String URL ="jdbc:mysql://localhost:3306/recording_app_db";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";

    public Connection connect () throws SQLException {

        return DriverManager.getConnection(URL,USERNAME,PASSWORD);

    }

}
