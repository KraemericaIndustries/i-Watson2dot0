package com.kraemericaindustries;

import com.kraemericaindustries.engine.Matrix;
import com.kraemericaindustries.engine.ResultEngine;
import com.kraemericaindustries.io.Type;
import com.kraemericaindustries.jdbc.Database;
import com.kraemericaindustries.ui.Messages;

import static com.kraemericaindustries.engine.AnalysisEngine.reportAnalysis;
import static com.kraemericaindustries.engine.Matrix.insertTurn;
import static com.kraemericaindustries.ui.Messages.welcomeMessage;
public class Main {
    static String[] words;

    public static void main(String[] args) throws Exception {

        String guess;
        int response;
        int counter = 1;

        welcomeMessage();                  //  PRINT the welcome message
        Database.setDatabaseProperties();  //  READ in database settings from the properties file
        Database.create();                 //  CREATE Watson DB, CREATE Words_tbl, READ FiveLetterWords.txt into DB, CREATE The Matrix and POPULATE with initial values
        Database.readFile();               //  Seed known 5-letter words into the 'watson' database
        Matrix.create();                   //  CREATE the Matrix/truthTable
        Messages.play();                   //  PRINT the play game message

        do {
            String mostToLeastFrequentLetters = Messages.report(counter);  //  PRINT The Matrix.  Return the letter counts from the database sorted from most to least frequent in a SET.
            Messages.printGeneralStrategies();
            words = reportAnalysis(mostToLeastFrequentLetters);     //  ASSESS the Report, suggest strategies, take action (Matrix.size == 0. Matrix.size == 1 and so on).
            guess = Type.guess(counter);                            //  TYPE a guess
            response = Type.response(counter);                             //  TYPE the response
            insertTurn(guess, response);                            //  Take a turn, and INSERT it into the Matrix.
            ResultEngine.printResults(words, counter);                       //  REWORK NEEDED!! PRINT AND ASSESS AGAINST MATRIX, NOT to the DB.
            counter++;
        } while (response < 5);
        //  Response to previous guess is 5...
        Messages.endGame(guess, counter);
    }
}