package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static int lineCount = 1;

    public static void main(String[] args) {
	// write your code here
        System.out.println("## Starting (Indexing with Trees)");

        //String fileName = "/Users/user/Documents/Data Structs/Module11/Module 11 files/pg100.txt";
        String fileName = "pg100.txt";

        try {
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);

                String[] words = line.split("\\s+");
                for(String word : words){
                	word = word.replaceAll(":", "");
                	word = word.replaceAll(",", "");
                    word = word.replaceAll("\\.", "");
                    word = word.replaceAll("'", "");
                    word = word.replaceAll("\n", "");
                    if (word != "") {
                        System.out.println(lineCount + " ['" + word + "']");
                        lineCount++;
                    }

                }
            }
            scanner.close();

        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}


// This will be much like the index you find at the end of a textbook, where each topic is listed in alphabetical order with the pages it is found on


// The IndexTree is made up of special IndexNodes.

// Rather than using generics,
//      each IndexNode stores a word,
//      the count of occurrences of that word,
//      and a list of all lines that word appeared on (this means that each IndexNode will hold their own list)


// Nodes in the tree will be sorted by the String.


// Use an IndexTree object to store an index of all the words that are in the provided text file, then display the index by performing an inorder traversal of the tree.