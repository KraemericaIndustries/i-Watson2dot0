package com.kraemericaindustries.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.kraemericaindustries.engine.Matrix;
public class InputFile {
    static char[] animationChars = new char[] {'|', '/', '-', '\\'};  //  class fields
    static int[] letterCounts = new int[26];
    static int counter;
    static String line;
    public static void readFile(String url) {

        try {
            File file = new File("FiveLetterWords.txt");
            Scanner input = new Scanner(file);
            System.out.println("Seeding known 5 letter words into the 'watson' database...");
            while (input.hasNextLine()) {
                line = (input.nextLine().toUpperCase());
                letterEnumerator(line.toUpperCase());
                //  READ FiveLEtterWords.txt into the 'watson' database Words.tbl...
                try {
                    Connection conn = DriverManager.getConnection(url, "sa", "topcon");  //  Establish Connection Object
                    Statement statement = conn.createStatement();  						 //  Create a SQL statement object to send to the database
                    counter = counter + statement.executeUpdate("insert into Words_tbl values('" + line + "')");					 //  Execute the statement object
                } catch (SQLException e) {
//					  e.printStackTrace();
                }
                System.out.print("Words added: " + counter + " " + animationChars[counter % 4] + '\r');  //  println
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
//			e.printStackTrace();
        }
        System.out.println("Number of words successfully added to the Database: " + counter);
        System.out.println();
//  DEBUG:  Show letter counts:
//		for(int j = 0; j <= letterCounts.length - 1; j++) {
//			System.out.println("Letter count @ index " + j + ":" + letterCounts[j]);
//		}
        Matrix.seedFrequency(letterCounts);
    }

    private static void letterEnumerator(String word) {

        for(int i = 0; i <= word.length() - 1; i++) {

            switch(word.charAt(i)) {
                case 'A': letterCounts[0]++;
                    break;
                case 'B': letterCounts[1]++;
                    break;
                case 'C': letterCounts[2]++;
                    break;
                case 'D': letterCounts[3]++;
                    break;
                case 'E': letterCounts[4]++;
                    break;
                case 'F': letterCounts[5]++;
                    break;
                case 'G': letterCounts[6]++;
                    break;
                case 'H': letterCounts[7]++;
                    break;
                case 'I': letterCounts[8]++;
                    break;
                case 'J': letterCounts[9]++;
                    break;
                case 'K': letterCounts[10]++;
                    break;
                case 'L': letterCounts[11]++;
                    break;
                case 'M': letterCounts[12]++;
                    break;
                case 'N': letterCounts[13]++;
                    break;
                case 'O': letterCounts[14]++;
                    break;
                case 'P': letterCounts[15]++;
                    break;
                case 'Q': letterCounts[16]++;
                    break;
                case 'R': letterCounts[17]++;
                    break;
                case 'S': letterCounts[18]++;
                    break;
                case 'T': letterCounts[19]++;
                    break;
                case 'U': letterCounts[20]++;
                    break;
                case 'V': letterCounts[21]++;
                    break;
                case 'W': letterCounts[22]++;
                    break;
                case 'X': letterCounts[23]++;
                    break;
                case 'Y': letterCounts[24]++;
                    break;
                case 'Z': letterCounts[25]++;
                    break;
                default: System.out.println("Unknown letter, or some other flaw");
                    break;
            }
        }
    }  //  End-of-letterEnumerator()
}