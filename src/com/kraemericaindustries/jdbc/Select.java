package com.kraemericaindustries.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Select {
    public static int countWords() throws IOException {
        int count = 0;

        Properties props = new Properties();
        props.load(new FileInputStream("watson.properties"));

        String url = props.getProperty("dbUrl");
        String user = props.getProperty("user");
        String password = props.getProperty("password");

        try {
            Connection conn = DriverManager.getConnection(url, user, password);  	  //  Establish Connection Object
            Statement statement = conn.createStatement();                                         //  Create a SQL statement object to send to the database
            ResultSet resultSet = statement.executeQuery("select count (*) from Words_tbl");  //  Execute the statement object
            //  Process the result
            while(resultSet.next()) {
                count =  ((Number) resultSet.getObject(1)).intValue();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}