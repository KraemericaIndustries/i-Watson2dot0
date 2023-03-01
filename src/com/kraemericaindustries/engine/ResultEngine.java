package com.kraemericaindustries.engine;
public class ResultEngine {
    static String changedLetters;
    public static void printResults(String[] words) {

        System.out.println("*****************************************************************  RESULT  ********************************************************************************************");
        System.out.println("Let's have a look at all previous turns (guess=answer): ");
        System.out.println(Matrix.turns);

        if(Matrix.turns.size() == 1) System.out.println("With only 1 prior turn taken, very little can be learned.  Take another turn.  I suggest playing the word: " + words[1]);

        if(Matrix.turns.size() == 2) Matrix.identifyChangedLetters();

//		if(Matrix.turns.size() == 2) Engine.findChangedLetters();

//		turns = SELECT.returnTurns(url, numTurns);  //  Information on prior turns is needed here, to drive logic
//
//		if(numTurns >= 2 && (turns[0][26] - turns[1][26] == 1)) {
//			changedLetters = (Comparator.arrayToString(turns));
//			BATCH.firstInSecondOut(url, changedLetters);
//		}
//
//		if(numTurns >= 2 && (turns[0][26] - turns[1][26] == -1)) {
//			changedLetters = (Comparator.arrayToString(turns));
//			BATCH.secondInFirstOut(url, changedLetters);
//		}
//		if(numTurns > 1) {
//			Reduce.turns();
//		}

        System.out.println("Now let's remove ALL letters from EVERY turn that are KNOWN to be IN or OUT, and REDUCE the responses each time we remove a KNOWN letter.  This leaves (<guess>, <answer>): ");
        System.out.println(Matrix.turns);
        System.out.println("***********************************************************************************************************************************************************************");
    }

    private static String findChangedLetters() {

        int[][] turns = new int[1][25];

        return changedLetters;
    }
}