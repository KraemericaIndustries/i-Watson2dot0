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
            if (guess.length() != 5) {
                StringBuilder sb = new StringBuilder("HEY!  DUMMY!  Your guess is ")
                        .append(guess.length())
                        .append(" letters long!  Try again, moron.");
                System.out.println(sb);
            }
        } while (guess.length() != 5);  //  Discard guesses that are NOT 5 letters.
        return guess;
    }

    public static int response() {
        do {
            System.out.println("Now, enter the response from your opponent:");
            response = Turn.enterResponse();
            System.out.println("The response was: " + response);
            if (response > 5 || response < 0) {
                StringBuilder sb = new StringBuilder("HEY!  DUMMY!  Your response is ")
                        .append(response)
                        .append(", but it MUST be 0, 1, 2, 3, 4, or 5!  Try again, moron.");
                System.out.println(sb);
            }
        } while (response > 5 || response < 0);  //  Discard responses that are NOT 0 through 5.
        return response;
    }
}