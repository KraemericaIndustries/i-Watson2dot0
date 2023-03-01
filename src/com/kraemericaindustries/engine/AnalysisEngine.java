package com.kraemericaindustries.engine;
public class AnalysisEngine {
    private static String[] words;
    public static String[] reportAnalysis(String mostToLeastFrequentLetters) {

        System.out.println("Analyzing the REPORT to determine specific strategy...");
        System.out.println();
        if (Matrix.turns.size() == 0) {
            System.out.println("*****************************************************************  SPECIFIC STRATEGIES  *******************************************************************************");
            System.out.println("There are no prior turns stored in the database.  I suggest making a guess with the 5 MOST COMMON letters, followed by a guess with the 'next most common' (2nd through 6th...)");
            System.out.println("This will attempt to eliminate the MOST COMMON letter, which will narrow the field of possible words the most");
            System.out.println("Successive guesses should only vary by ONE UNKNOWN letter at a time (doing so allows us to learn the most from responses.)");
            words = GuessEngine.findWords(mostToLeastFrequentLetters, 2);
            StringBuilder sb = new StringBuilder("I suggest playing the word ")
                    .append(words[0])
                    .append(" followed by playing the word ")
                    .append(words[1])
                    .append(".  (As determined by GuessEngine.findWords)");
            System.out.println(sb);
            System.out.println("***********************************************************************************************************************************************************************");
        } else if (Matrix.turns.size() == 1) {
            System.out.println("*****************************************************************  SPECIFIC STRATEGIES  *******************************************************************************");
            System.out.println("There is only 1 prior turn stored in the database.  I suggest trying to make a guess with the NEXT 5 MOST COMMON letters (2nd through 6th...)");
            System.out.println("This will attempt to eliminate the MOST COMMON letter, which will narrow the field of possible words the most");
            System.out.println("Successive guesses should only vary by ONE UNKNOWN letter at a time (doing so allows us to learn the most from responses.)");
            StringBuilder sb = new StringBuilder("I suggest playing the word ")
                    .append(words[1])
                    .append(".");
            System.out.println(sb);
            System.out.println("***********************************************************************************************************************************************************************");
        }
        return words;
    }
}