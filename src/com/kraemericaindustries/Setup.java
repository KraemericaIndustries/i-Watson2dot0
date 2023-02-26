package com.kraemericaindustries;

import com.kraemericaindustries.engine.Matrix;
import com.kraemericaindustries.io.InputFile;
import com.kraemericaindustries.jdbc.Create;
public class Setup {

    private static String serverUrl = "jdbc:sqlserver://127.0.0.1";
    private static String dbUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=watson";

    public static void database() throws Exception {

        System.out.println("*****************************************************************  THE SETUP  *****************************************************************************************");
        Create.DB(serverUrl);
        InputFile.readFile(dbUrl);
        Matrix.create();
        System.out.println("***********************************************************************************************************************************************************************");
        System.out.println();
    }
}
