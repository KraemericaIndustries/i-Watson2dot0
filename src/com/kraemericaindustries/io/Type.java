package com.kraemericaindustries.io;
public class Type {
    public static String guess(int counter) {
        //  INPUT a guess...
        String guess;
        do {
            System.out.print("Turn # " + counter + ".  Guess a 5 letter word: ");
            guess = (Turn.enterGuess()).toUpperCase();
            System.out.println("Guess #" + counter + ": " + guess);
            if (guess.length() != 5) {
                String doOver = "HEY!  DUMMY!  Your guess is " +
                        guess.length() +
                        " letters long!  Try again, moron.";
                System.out.println(doOver);
            }
        } while (guess.length() != 5);  //  Discard guesses that are NOT 5 letters.
        return guess;
    }
    public static int response(int counter) {
        int response;
        do {
            System.out.print("Turn # " + counter + ".  Now, enter the response from your opponent: ");
            response = Turn.enterResponse();
            System.out.println("Response # " + counter + ": " + response);
            if (response > 5 || response < 0) {
                String doOver = "HEY!  DUMMY!  Your response is " +
                        response +
                        ", but it MUST be 0, 1, 2, 3, 4, or 5!  Try again, moron.";
                System.out.println(doOver);
            }
        } while (response > 5 || response < 0);  //  Discard responses that are NOT 0 through 5.
        return response;
    }
}