package com.kraemericaindustries.ui;

import com.kraemericaindustries.engine.Matrix;
import com.kraemericaindustries.jdbc.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Messages {

    public static void welcomeMessage() {

        System.out.println("*****************************************************************  WELCOME  *******************************************************************************************");
        System.out.println("Welcome to the Word Guessing Game Helper!\n" +  //  Introduce the game, and how it is played
                "\n" +
                "Your opponent will  choose a familiar 5 letter word, with each letter appearing ONLY ONCE. (Valid: 'GLYPH'.  Invalid: 'DROOP')\n" +
                "See if you can guess the word!  Each time you make a guess, your opponent will respond with a number.\n" +
                "The number represents the number of letters in your guess that appear in the word chosen by your opponent.\n" +
                "Example:  If the opponent chooses 'LOSER' and you guess 'POSER' the response would be 4 ('O' makes 1, 'S' makes 2, 'E' makes 3, and 'R' makes 4.)\n" +
                "Will you be able to identify your opponent's word?\n" +
                "I'm going to help - by suggesting your most strategic plays possible!\n" +
                "First - let me get myself set up...");
        System.out.println("***********************************************************************************************************************************************************************");
        System.out.println();
    }
    public static void play() {
        System.out.println("*****************************************************************  THE GAME  ******************************************************************************************");
        System.out.println("Let's play!!!");
        System.out.println("***********************************************************************************************************************************************************************");
        System.out.println();
    }
    public static String report() throws SQLException {

        int count = 0;

        ResultSet resultSet = Database.select("select count (*) from Words_tbl");  //  Execute the statement object
        //  Process the result
        while(resultSet.next()) {
            count =  ((Number) resultSet.getObject(1)).intValue();
        }

        System.out.println("*****************************************************************  REPORT  ********************************************************************************************");
        String mostToLeastFrequentLetters = Matrix.print();  //  PRINT the Matrix.  Return a String of mostToLeastFrequentLetters to main for use in AnalysisEngine.reportAnalysis
        System.out.println("Data from previous turns: " + Matrix.turns);
        System.out.println("There are " + count + " words remaining in the database.");
        System.out.println("***********************************************************************************************************************************************************************");
        System.out.println();
        return mostToLeastFrequentLetters;
    }
    public static void printGeneralStrategies() {
        System.out.println("*****************************************************************  GENERAL STRATEGIES  ********************************************************************************");
        System.out.println("Eliminate as many MOST COMMON, UNKNOWN letters as possible (narrowing the field of possible words the most quickly)");
        System.out.println("Try to eliminate each MOST COMMON letters FIRST.");
        System.out.println("Successive guesses should only vary by ONE UNKNOWN letter at a time (doing so allows us to learn the most from responses.)");
        System.out.println("***********************************************************************************************************************************************************************");
        System.out.println();
    }
    public static void endGame(String guess) {

        System.out.println("The response was 5!!!");
        System.out.println("In the event the opponent advises that the previous guess (" + guess + ") is NOT their word, all that remains to be done is process of elimination.");
        System.out.println("Deleting the previous guess (" + guess + ") from the database... > This many rows were DELETED from the database: " +
                Database.statement("delete from Words_tbl where word = '" + guess + "'"));
        System.out.println("Here are all the OTHER words in the database that can be made from these 5 letters:");

        try {
            //  SELECT a word from Words_tbl that contains EACH of the following letters
            String query = "select * from Words_tbl where word like '%" +
                    guess.charAt(0) +
                    "%' and word like '%" +
                    guess.charAt(1) +
                    "%' and word like '%" +
                    guess.charAt(2) +
                    "%' and word like '%" +
                    guess.charAt(3) +
                    "%' and word like '%" +
                    guess.charAt(4) +
                    "%'";
            ResultSet resultSet = Database.select(query);  //  Execute the statement object
            //  Process the result
            while(resultSet.next()) {  //  ITERATE over all results returned from the SELECT statement
                String word = resultSet.getString("word");  //  SET the value of the local String variable named word to the last value returned by the SQL select statement
                System.out.print(word + "\t");
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Guess each of the above (in turn) to arrive at the answer.  ");
    }
}