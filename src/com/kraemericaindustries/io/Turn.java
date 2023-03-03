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
}