package com.kraemericaindustries.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute {

    static Connection conn = null;
    static Statement statement = null;
    static ResultSet resultSet = null;

    static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=watson;encrypt=true;trustServerCertificate=true";
    static String user = "sa";
    static String pass = "topcon";

    //  RUN jdbc executeUpdate SQL statement...
    public static int statement(String sqlStatement) {

        int r = 0;

        try {
            conn = DriverManager.getConnection(url, user, pass);
            statement = conn.createStatement();
            r = statement.executeUpdate(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    //  RUN jdbc executeQuery SQL statement...
    public static ResultSet select(String selectQuery) {

        ResultSet resultSet = null;

        try {
            conn = DriverManager.getConnection(url, user, pass);
            statement = conn.createStatement();
            resultSet = statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}  //  end-of-class