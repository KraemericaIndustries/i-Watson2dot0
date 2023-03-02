package com.kraemericaindustries;

import com.kraemericaindustries.engine.Matrix;
import com.kraemericaindustries.io.InputFile;
import com.kraemericaindustries.jdbc.Create;

public class Setup {
    public static String database(String url, String user, String password) throws Exception {

        System.out.println("*****************************************************************  THE SETUP  *****************************************************************************************");
        String dbUrl = Create.DB(url, user, password);
        InputFile.readFile();
        Matrix.create();
        System.out.println("***********************************************************************************************************************************************************************");
        System.out.println();

        return dbUrl;
    }
}
