package com.kraemericaindustries;

import com.kraemericaindustries.engine.ResultEngine;
import com.kraemericaindustries.io.Type;
import com.kraemericaindustries.ui.Messages;

import static com.kraemericaindustries.engine.AnalysisEngine.reportAnalysis;
import static com.kraemericaindustries.engine.Matrix.insertTurn;
import static com.kraemericaindustries.ui.Messages.welcomeMessage;

public class Main {

    private static String dbUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=watson";
    static String[] words;
    private static int response;

    public static void main(String[] args) throws Exception {

        welcomeMessage();
        Setup.database();  //  CREATE Watson DB, CREATE Words_tbl, READ FiveLetterWords.txt into DB, CREATE The Matrix and POPULATE with initial values
        Messages.play();

        do {
            String mostToLeastFrequentLetters = Messages.report(dbUrl);			//  PRINT The Matrix.  Return the letter counts from the database sorted from most to least frequent in a SET.
            Messages.printGeneralStrategies();
            words = reportAnalysis(mostToLeastFrequentLetters);  //  ASSESS the Report, suggest strategies, take action (Matrix.size == 0. Matrix.size == 1 and so on).
            insertTurn(Type.guess(), Type.response());					//  Take a turn, and INSERT it into the Matrix.
            ResultEngine.printResults(words);									//  REWORK NEEDED!! PRINT AND ASSESS AGAINST MATRIX, NOT to the DB.
        } while (response < 5);
        System.out.println("You guessed it!!!");
    }
}