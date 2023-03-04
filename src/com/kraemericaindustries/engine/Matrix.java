package com.kraemericaindustries.engine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
public class Matrix {
    static ArrayList<ArrayList> truthTable = new ArrayList<>();
    static ArrayList<String> columns = new ArrayList<>();
    static ArrayList<Integer> index = new ArrayList<>();
    static ArrayList<String> knownIn = new ArrayList<>();
    static ArrayList<String> knownOut = new ArrayList<>();
    static ArrayList<String> unknown = new ArrayList<>();
    static TreeMap<String, Integer> frequency = new TreeMap<>();
    public static TreeMap<String, Integer> turns = new TreeMap<>();

    public static void create() {

        truthTable.add(columns);
        truthTable.add(index);
        truthTable.add(knownIn);
        truthTable.add(knownOut);
        truthTable.add(unknown);

        columns.add("A");
        columns.add("B");
        columns.add("C");
        columns.add("D");
        columns.add("E");
        columns.add("F");
        columns.add("G");
        columns.add("H");
        columns.add("I");
        columns.add("J");
        columns.add("K");
        columns.add("L");
        columns.add("M");
        columns.add("N");
        columns.add("O");
        columns.add("P");
        columns.add("Q");
        columns.add("R");
        columns.add("S");
        columns.add("T");
        columns.add("U");
        columns.add("V");
        columns.add("W");
        columns.add("X");
        columns.add("Y");
        columns.add("Z");

        unknown.add("A");
        unknown.add("B");
        unknown.add("C");
        unknown.add("D");
        unknown.add("E");
        unknown.add("F");
        unknown.add("G");
        unknown.add("H");
        unknown.add("I");
        unknown.add("J");
        unknown.add("K");
        unknown.add("L");
        unknown.add("M");
        unknown.add("N");
        unknown.add("O");
        unknown.add("P");
        unknown.add("Q");
        unknown.add("R");
        unknown.add("S");
        unknown.add("T");
        unknown.add("U");
        unknown.add("V");
        unknown.add("W");
        unknown.add("X");
        unknown.add("Y");
        unknown.add("Z");

        index.add(0);
        index.add(1);
        index.add(2);
        index.add(3);
        index.add(4);
        index.add(5);
        index.add(6);
        index.add(7);
        index.add(8);
        index.add(9);
        index.add(0);
        index.add(1);
        index.add(2);
        index.add(3);
        index.add(4);
        index.add(5);
        index.add(6);
        index.add(7);
        index.add(8);
        index.add(9);
        index.add(0);
        index.add(1);
        index.add(2);
        index.add(3);
        index.add(4);
        index.add(5);
        index.add(6);
    }

    public static void seedFrequency(int[] distribution) {

        for(int i = 0; i < distribution.length; i++) {
            frequency.put(switchIndexToLetter(i), distribution[i]);
        }
    }
    public static String print() {

        StringBuilder mostToLeastCommonLettersString = new StringBuilder();

        System.out.print("Known IN: ");
        for(String letter : knownIn) {
            System.out.print(letter + "|");
        }
        System.out.println();

        System.out.print("Known OUT: ");
        for(String letter : knownOut) {
            System.out.print(letter + "|");
        }
        System.out.println();

        System.out.print("Unknown:     ");
        for(String letter : unknown ) {
            System.out.print(letter + "|");
        }
        System.out.println();

        System.out.println("The MOST COMMON letters in the database (from MOST to LEAST) are: ");
        LinkedHashMap<String, Integer> sortedMap = frequency.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println(sortedMap);
        Set<String> keys = sortedMap.keySet();
//			System.out.println(keys);
        for(String letter : keys) {
            mostToLeastCommonLettersString.append(letter);
        }
        return mostToLeastCommonLettersString.toString();
    }

    public static String switchIndexToLetter(int index) {

        String letter = "";

        switch (index) {
            case 0 -> letter = "A";
            case 1 -> letter = "B";
            case 2 -> letter = "C";
            case 3 -> letter = "D";
            case 4 -> letter = "E";
            case 5 -> letter = "F";
            case 6 -> letter = "G";
            case 7 -> letter = "H";
            case 8 -> letter = "I";
            case 9 -> letter = "J";
            case 10 -> letter = "K";
            case 11 -> letter = "L";
            case 12 -> letter = "M";
            case 13 -> letter = "N";
            case 14 -> letter = "O";
            case 15 -> letter = "P";
            case 16 -> letter = "Q";
            case 17 -> letter = "R";
            case 18 -> letter = "S";
            case 19 -> letter = "T";
            case 20 -> letter = "U";
            case 21 -> letter = "V";
            case 22 -> letter = "W";
            case 23 -> letter = "X";
            case 24 -> letter = "Y";
            case 25 -> letter = "Z";
            default -> System.out.println("Oops...");
        }
        return letter;
    }
    public static void insertTurn(String guess, int response) {
        turns.put(guess, response);
    }
    public static void identifyChangedLetters() {

//        String turn1 = turns.ke
    }
}