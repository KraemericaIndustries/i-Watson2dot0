package com.kraemericaindustries;

import com.kraemericaindustries.engine.Matrix;
import com.kraemericaindustries.io.InputFile;
import com.kraemericaindustries.jdbc.Create;

import java.io.FileInputStream;
import java.util.Properties;

public class Setup {
//    private static String serverUrl = "jdbc:sqlserver://127.0.0.1";
//    private static String dbUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=watson";



    public static void database() throws Exception {

        Properties props = new Properties();
        props.load(new FileInputStream("watson.properties"));

        String dbUrl = props.getProperty("dbUrl");

        System.out.println("*****************************************************************  THE SETUP  *****************************************************************************************");
        Create.DB();
        InputFile.readFile();
        Matrix.create();
        System.out.println("***********************************************************************************************************************************************************************");
        System.out.println();
    }
}
