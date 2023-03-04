package com.kraemericaindustries.jdbc;

import com.kraemericaindustries.engine.Matrix;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Database {
    static String url;
    static String user;
    static String password;
    static Connection conn = null;
    static Statement statement = null;
    static char[] animationChars = new char[] {'|', '/', '-', '\\'};  //  class fields
    static int[] letterCounts = new int[26];
    static int counter;
    static String line;

    public static void setDatabaseProperties() {

        Properties props = new Properties();
        try {
            props.load(new FileInputStream("watson.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        url = props.getProperty("url");
        user = props.getProperty("user");
        password = props.getProperty("password");
    }

    public static void create() throws Exception {

        System.out.println("Preparing to create the watson database...");
        System.out.println("Restarting the MSSQLSERVER Service...");
        System.out.println();
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "net stop mssqlserver && ping 127.0.0.1 -n 2 > nul && net start mssqlserver");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }

        try {
            conn = DriverManager.getConnection(url, user, password);  //  Establish Connection Object
            statement = conn.createStatement();                        //  Create a SQL statement object to send to the database
            //  WORKS!
            statement.addBatch("drop database watson;"
                    + "create database watson;"
                    + "use watson;"
                    + "create table Words_tbl (word varchar(5) primary key(word));");
            statement.executeBatch();

        } catch (SQLException e) {
//					  e.printStackTrace();
        }
        System.out.print("Drop the 'watson' database...");
        System.out.println(" > Database 'watson' successfully dropped.");
        System.out.print("Create the 'watson' database...");
        System.out.println(" > Database 'watson' successfully created.");
        System.out.println("Create the 'watson' database table...");
        System.out.print("Words.tbl...");
        System.out.println(" > Done!");
        System.out.println();

        url = url + ":1433;DatabaseName=watson";
    }

    public static int statement(String sqlStatement) {

        int r = 0;

        try {
            conn = DriverManager.getConnection(url, user, password);
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
            conn = DriverManager.getConnection(url, user, password);
            statement = conn.createStatement();
            resultSet = statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static void readFile() {

        try {
            File file = new File("FiveLetterWords.txt");
            Scanner input = new Scanner(file);
            System.out.println("Seeding known 5 letter words into the 'watson' database...");
            while (input.hasNextLine()) {
                line = (input.nextLine().toUpperCase());
                letterEnumerator(line.toUpperCase());
                //  READ FiveLetterWords.txt into the 'watson' database Words.tbl...
                try {
                    Connection conn = DriverManager.getConnection(url, user, password);  //  Establish Connection Object
                    Statement statement = conn.createStatement();  						 //  Create a SQL statement object to send to the database
                    counter = counter + statement.executeUpdate("insert into Words_tbl values('" + line + "')");					 //  Execute the statement object
                } catch (SQLException e) {
//					  e.printStackTrace();
                }
                System.out.print("Words added: " + counter + " " + animationChars[counter % 4] + '\r');  //  println
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
//			e.printStackTrace();
        }
        System.out.println("Number of words successfully added to the Database: " + counter);
        System.out.println();
//  DEBUG:  Show letter counts:
//		for(int j = 0; j <= letterCounts.length - 1; j++) {
//			System.out.println("Letter count @ index " + j + ":" + letterCounts[j]);
//		}
        Matrix.seedFrequency(letterCounts);
    }

    private static void letterEnumerator(String word) {

        for(int i = 0; i <= word.length() - 1; i++) {

            switch (word.charAt(i)) {
                case 'A' -> letterCounts[0]++;
                case 'B' -> letterCounts[1]++;
                case 'C' -> letterCounts[2]++;
                case 'D' -> letterCounts[3]++;
                case 'E' -> letterCounts[4]++;
                case 'F' -> letterCounts[5]++;
                case 'G' -> letterCounts[6]++;
                case 'H' -> letterCounts[7]++;
                case 'I' -> letterCounts[8]++;
                case 'J' -> letterCounts[9]++;
                case 'K' -> letterCounts[10]++;
                case 'L' -> letterCounts[11]++;
                case 'M' -> letterCounts[12]++;
                case 'N' -> letterCounts[13]++;
                case 'O' -> letterCounts[14]++;
                case 'P' -> letterCounts[15]++;
                case 'Q' -> letterCounts[16]++;
                case 'R' -> letterCounts[17]++;
                case 'S' -> letterCounts[18]++;
                case 'T' -> letterCounts[19]++;
                case 'U' -> letterCounts[20]++;
                case 'V' -> letterCounts[21]++;
                case 'W' -> letterCounts[22]++;
                case 'X' -> letterCounts[23]++;
                case 'Y' -> letterCounts[24]++;
                case 'Z' -> letterCounts[25]++;
                default -> System.out.println("Unknown letter, or some other flaw");
            }
        }
    }  //  End-of-letterEnumerator()
}