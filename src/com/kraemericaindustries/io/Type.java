package com.kraemericaindustries.io;

public class Type {

    private static String guess;
    private static int response;

    public static String guess() {

        //  INPUT a guess...
        do {
            System.out.println("Guess a 5 letter word:");
            guess = (Turn.enterGuess()).toUpperCase();
            System.out.println("You guessed: " + guess);
            if (guess.length() != 5) System.out.println("HEY!  DUMMY!  Your guess is " + guess.length() + " letters long!  Try again, moron.");
        } while (guess.length() != 5);  //  Discard guesses that are NOT 5 letters.
        return guess;
    }


    public static int response() {
        do {
            System.out.println("Now, enter the response from your opponent:");
            response = Turn.enterResponse();
            System.out.println("The response was: " + response);
            if (response > 5 || response < 0) System.out.println("HEY!  DUMMY!  Your response is " + response + ", but it MUST be 0, 1, 2, 3, 4, or 5!  Try again, moron.");
        } while (response > 5 || response < 0);  //  Discard responses that are NOT 0 through 5.
        return response;
    }
}
