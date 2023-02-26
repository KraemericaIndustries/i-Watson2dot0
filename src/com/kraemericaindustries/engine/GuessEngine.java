package com.kraemericaindustries.engine;

import com.kraemericaindustries.jdbc.Execute;

import java.sql.ResultSet;
import java.sql.SQLException;

//  Create an instance of this class for variable persistence

public class GuessEngine {

    static String url;
    static String lettersMostToLeast;
    static int M = 0;
    static int L = 5;
    static int w;
    static String letters;
    static int counter;

    public static String[] findWords(String mostToLeastFrequentLetters, int numWords) {

        String[] words = new String[numWords];

//		for(Map.Entry<String, Integer> entry : Matrix.frequency.entrySet()) {
//			letters = letters + entry.getKey();
//		}
//		System.out.println("mostToLeastFrequentLetters: " + mostToLeastFrequentLetters);
        System.out.println();

        String word = "";

        do {  //  DO this (at least once)
            try {
                word = "";															 //  INITIALIZE the local String variable to the value returned by the SQL select when no match is found in the DB.
                String query = "select * from Words_tbl where word like '%" +		 //  SELECT a word from Words_tbl that contains EACH of the following letters
                        mostToLeastFrequentLetters.charAt(M) + "%' and word like '%" +
                        mostToLeastFrequentLetters.charAt(M + 1) + "%' and word like '%" +
                        mostToLeastFrequentLetters.charAt(M + 2) + "%' and word like '%" +
                        mostToLeastFrequentLetters.charAt(M + 3) + "%' and word like '%" +
                        mostToLeastFrequentLetters.charAt(L - 1) + "%'";
                ResultSet resultSet = Execute.select(query);				 //  Execute the statement object
                //  Process the result
                while(resultSet.next()) {				 //  ITERATE over all results returned from the SELECT statement
                    word = resultSet.getString("word");  //  SET the value of the local String variable named word to the last value returned by the SQL select statement
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //  ADD word to array...
            if(word != "") {	  //  IF the SELECT statement returns a result
                words[w] = word;  //  SET the current index of the words array to the word returned by the SELECT statement
                M++;			  //  INCREMENT the substring index to the NEXT MOST COMMON letters (in an attempt to ELIMINATE the most common letter).
                w++;			  //  INCREMENT the index to the words array
            }

            //  When NO WORD is returned, increment the letter indexes...
            if(w > 2 && word != "" || L == mostToLeastFrequentLetters.length() - 1) {  //  IF seeking 2 words, and a word IS returned, an the end index IS NOT at the end of the letters
                M++;																   //  INCREMENT the index pointing to the START of the String of letters (to try and make a determination on the most common letter)
                L = M + 5;															   //  RESET the index pointing to the LAST letter in the String, to the 6th most common letter in the String
            } else {																   //  ELSE word != ""
                L++;																   //  INCREMENT the END index of the letters String
            }

        } while(w < words.length);  //  WHILE the INDEX to the words array is LESS THAN the LENGTH of the words array

        for(int i = 0; i <= words.length - 1; i++) {  //  ITERATE over the words array
            System.out.println(words[i]);			  //  PRINT the word found at each index
        }
        return words;  //  return the word selected from the database by the SQL select statement
    }




}