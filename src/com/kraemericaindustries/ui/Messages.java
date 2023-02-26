package com.kraemericaindustries.ui;

import com.kraemericaindustries.Setup;
import com.kraemericaindustries.engine.Matrix;
import com.kraemericaindustries.jdbc.Select;

public class Messages {

    public static void welcomeMessage() {

        System.out.println("*****************************************************************  WELCOME  *******************************************************************************************");
        System.out.println("Welcome to the Word Guessing Game Helper!\n" +  //  Introduce the game, and how it is played
                "\n" +
                "Your opponent will  choose a familiar 5 letter word, with each letter appearing ONLY ONCE. (Valid: 'GLYPH'.  Invalid: 'DROOP')\n" +
                "See if you can guess the word!  Each time you make a guess, your opponent will respond with a number.\n" +
                "The number represents the number of letters in your guess that appear in the word chosen by your opponent.\n" +
                "Example:  If the opponent chooses 'LOSER' and you guess 'POSER' the response would be 4 ('O' makes 1, 'S' makes 2, 'E' makes 3, and 'R' makes 4.)\n" +
                "Will you be able to identify your opponenet's word?\n" +
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


    public static String report(String url) {


        System.out.println("*****************************************************************  REPORT  ********************************************************************************************");
        String mostToLeastFrequentLetters = Matrix.print();  //  PRINT the Matrix.  Return a String of mostToLeastFrequentLetters to main for use in AnalysisEngine.reportAnalysis
        System.out.println("Data from previous turns: " + Matrix.turns);
        System.out.println("There are " + Select.countWords(url) + " words remaining in the database.");
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
}
