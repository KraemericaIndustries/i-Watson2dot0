package com.kraemericaindustries.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Select {
    public static int countWords(String url, String user, String password) throws IOException {
        int count = 0;

        try {
            Connection conn = DriverManager.getConnection(url, user, password);                   //  Establish Connection Object
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