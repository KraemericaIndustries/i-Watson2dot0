package com.kraemericaindustries.io;

import java.util.Scanner;
public class Turn {
    public static String enterGuess() {
        //  System.out.println("Entering 'IO.Turn.enterInfo()' method...");  //  DEBUG
        Scanner input= new Scanner(System.in);
        String capture = input.nextLine();
        //  input.close();
        //  System.out.println("keyboard:capture = " + capture);            //  DEBUG
        //  System.out.println("Exiting 'MakeGuess:keyboard' method...");   //  DEBUG
        System.out.println();
        capture = capture.toUpperCase();  //  Regardless of the case in the InputStream typed at the keyboard, convert the String contents of the 'guessString' variable to UPPERCASE
        return capture;
    }  //  keyboardInput()

    public static int enterResponse() {
        //  System.out.println("Entering 'IO.Turn.enterInfo()' method...");  //  DEBUG
        Scanner input= new Scanner(System.in);
        int capture = input.nextInt();
        //  input.close();
        //  System.out.println("keyboard:capture = " + capture);            //  DEBUG
        //  System.out.println("Exiting 'MakeGuess:keyboard' method...");   //  DEBUG
        System.out.println();
        return capture;
    }  //  keyboardInput()

    public static boolean isGuessOpponentsWord(String guess) {
        //  INPUT a guess...
        boolean guessIsOpponentsWord = false;
        String capture;

        do {
            System.out.println("Is the most recent guess (" + guess + ") your opponents word?  (yes/no)");

            Scanner input = new Scanner(System.in);
            capture = input.nextLine();

            System.out.println("You typed: " + capture);
            if (!(capture.equals("yes")) && !(capture.equals("no"))) {
                System.out.println("HEY!  DUMMY!  You were supposed to type 'yes' or 'no' - but you typed: '" + capture + "'.  Try again, moron.");
            } else if (capture.equals("yes")) {
                guessIsOpponentsWord = true;
            }
        } while (!(capture.equals("yes")) && !(capture.equals("no")));  //  Discard guesses that are NOT 5 letters.
        return guessIsOpponentsWord;
    }
}