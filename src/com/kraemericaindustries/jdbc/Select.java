package com.kraemericaindustries.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

//	public static int fromLetterCountsLoaded(String url) {
//
//		int val = 0;
//
//		try {
//			Connection conn = DriverManager.getConnection(url, "sa", "topcon");  		   //  Establish Connection Object
//			Statement statement = conn.createStatement();  								   //  Create a SQL statement object to send to the database
//			ResultSet resultSet = statement.executeQuery("select count (*) from LetterCountsLoaded_tbl");  //  Execute the statement object
//			//  Process the result
//			  while(resultSet.next()) {
//				  val =  ((Number) resultSet.getObject(1)).intValue();
//			  }
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return val;
//	}

//	public static String mostCommonLetters(String url) {
//
//		String mostCommonLetters = "";
//		int num = fromLetterCountsLoaded(url);
//
//		try {
//			Connection conn = DriverManager.getConnection(url, "sa", "topcon");  		   //  Establish Connection Object
//			Statement statement = conn.createStatement();  								   //  Create a SQL statement object to send to the database
//			ResultSet resultSet = statement.executeQuery("select distinct top(" + num + ") letter, occurences From LetterCountsLoaded_tbl order by occurences DESC");  //  Execute the statement object
//			//  Process the result
//			  while(resultSet.next()) {
//			  	mostCommonLetters += (resultSet.getString("letter"));
//			  }
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return mostCommonLetters;
//	}

    public static String wordWithMostCommonLetters(String url, String allLettersMostToLeastCommon, int order) {
        String word = "";
        String mostCommonLetters = "";

        if(order == 1) {
            mostCommonLetters = allLettersMostToLeastCommon.substring(0, 5);
        } else if(order == 2) {
            mostCommonLetters = allLettersMostToLeastCommon.substring(1, 6);
        }
        try {
            Connection conn = DriverManager.getConnection(url, "sa", "topcon");  		   //  Establish Connection Object
            Statement statement = conn.createStatement();  								   //  Create a SQL statement object to send to the database
            ResultSet resultSet = statement.executeQuery("select * from Words_tbl where word like '%" + mostCommonLetters.charAt(0) + "%' and word like '%" + mostCommonLetters.charAt(1) + "%' and word like '%" + mostCommonLetters.charAt(2) + "%' and word like '%" + mostCommonLetters.charAt(3) + "%' and word like '%" + mostCommonLetters.charAt(4) + "%'");  //  Execute the statement object
            //  Process the result
            while(resultSet.next()) {
                word = resultSet.getString("word");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return word;
    }

    public static int countTurns(String url) {
        int count = 0;
        try {
            Connection conn = DriverManager.getConnection(url, "sa", "topcon");  		   //  Establish Connection Object
            Statement statement = conn.createStatement();  								   //  Create a SQL statement object to send to the database
            ResultSet resultSet = statement.executeQuery("select count (*) from Turns_tbl");  //  Execute the statement object
            //  Process the result
            while(resultSet.next()) {
                count = ((Number) resultSet.getObject(1)).intValue();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int countWords(String url) {
        int count = 0;
        try {
            Connection conn = DriverManager.getConnection(url, "sa", "topcon");  		   //  Establish Connection Object
            Statement statement = conn.createStatement();  								   //  Create a SQL statement object to send to the database
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

    public static int numMostCommonLetter(String url) {
        int count = 0;
        try {
            Connection conn = DriverManager.getConnection(url, "sa", "topcon");  		   //  Establish Connection Object
            Statement statement = conn.createStatement();  								   //  Create a SQL statement object to send to the database
            ResultSet resultSet = statement.executeQuery("select max(occurences) from LetterCountsLoaded_tbl");  //  Execute the statement object
            //  Process the result
            while(resultSet.next()) {
                count =  ((Number) resultSet.getObject(1)).intValue();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int numWordsWithMostCommonLetter(String url, char letter) {

        int count = 0;
        try {
            Connection conn = DriverManager.getConnection(url, "sa", "topcon");  		   //  Establish Connection Object
            Statement statement = conn.createStatement();  								   //  Create a SQL statement object to send to the database
            ResultSet resultSet = statement.executeQuery("select count (*) from Words_tbl where word like '%" + letter + "%'");  //  Execute the statement object
            //  Process the result
            while(resultSet.next()) {
                count =  ((Number) resultSet.getObject(1)).intValue();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void allTurns(String url) {

        try {
            Connection conn = DriverManager.getConnection(url, "sa", "topcon");		//  Establish Connection Object
            Statement statement = conn.createStatement();								//  Create a SQL statement object to send to the database
            ResultSet resultSet = statement.executeQuery("select * from Turns_tbl");  //  Execute the statement object
            //  Process the result
            while(resultSet.next()) {
                System.out.print(resultSet.getString("guess") + ", ");
                System.out.println(resultSet.getString("answer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//		System.out.println(" > Done!");
    }

    public static int[][] returnTurns(String url, int numTurns) {

        int turns[][] = new int[numTurns][27];
        int index = 0;

        try {
            Connection conn = DriverManager.getConnection(url, "sa", "topcon");		//  Establish Connection Object
            Statement statement = conn.createStatement();								//  Create a SQL statement object to send to the database
            ResultSet resultSet = statement.executeQuery("select * from Turns_tbl");  //  Execute the statement object
            //  Process the result
            while(resultSet.next()) {

                String guess = resultSet.getString("guess");

                for(int i = 0; i < guess.length(); i++) {

                    switch(guess.charAt(i)) {
                        case 'A': turns[index][0] = 1;
                            break;
                        case 'B': turns[index][1] = 1;
                            break;
                        case 'C': turns[index][2] = 1;
                            break;
                        case 'D': turns[index][3] = 1;
                            break;
                        case 'E': turns[index][4] = 1;
                            break;
                        case 'F': turns[index][5] = 1;
                            break;
                        case 'G': turns[index][6] = 1;
                            break;
                        case 'H': turns[index][7] = 1;
                            break;
                        case 'I': turns[index][8] = 1;
                            break;
                        case 'J': turns[index][9] = 1;
                            break;
                        case 'K': turns[index][10] = 1;
                            break;
                        case 'L': turns[index][11] = 1;
                            break;
                        case 'M': turns[index][12] = 1;
                            break;
                        case 'N': turns[index][13] = 1;
                            break;
                        case 'O': turns[index][14] = 1;
                            break;
                        case 'P': turns[index][15] = 1;
                            break;
                        case 'Q': turns[index][16] = 1;
                            break;
                        case 'R': turns[index][17] = 1;
                            break;
                        case 'S': turns[index][18] = 1;
                            break;
                        case 'T': turns[index][19] = 1;
                            break;
                        case 'U': turns[index][20] = 1;
                            break;
                        case 'V': turns[index][21] = 1;
                            break;
                        case 'W': turns[index][22] = 1;
                            break;
                        case 'X': turns[index][23] = 1;
                            break;
                        case 'Y': turns[index][24] = 1;
                            break;
                        case 'Z': turns[index][25] = 1;
                            break;
                        default: System.out.println("Oops...");
                            break;
                    }
                    turns[index][26] = Integer.parseInt(resultSet.getString("answer"));
                }
                index++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
        return turns;
    }
}
