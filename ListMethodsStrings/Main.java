package com.company;

/*
Alexander G. Lucaci

List Methods and Strings
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//All things ArrayList

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String> C = new ArrayList<String>() {{
            add("boolean");
            add("boolin");
            add("applesauce");
            add("marathon");
            //add("boolin");
        } };

        System.out.print("2.1\n");
        System.out.print("\t" + unique(C));
        System.out.print("\n");

        List<Integer> A = new ArrayList<Integer>() {{
            add(1);
            add(25);
            add(30);
            add(57);
        } };

        System.out.print("2.2\n");
        System.out.print("\t Input: " + A);
        System.out.print("\n");
        System.out.print("\t Output: " + allMultiples(A, 5));

    }

    //Generic method
    public static <E> boolean in (List<E> list, E item ){
        return false;
    }

    //2.1
    public static <E> boolean unique(List<E> list) {
        //Takes in an ArrayList
        //Rather than looping over items and counting their occurence
        //Create a unique set of items
        Set<E> uniqueItems = new HashSet<E>(list);

        //If the length of the unique set is different that length of the incoming ArrayList, a duplicate exists.
        if(uniqueItems.size() < list.size()){
            return false;
        }
        //Otherwise, they are all unique
        return true;
    }

    //2.2
    public static List<Integer> allMultiples(List<Integer> list, int number) {
        //List is [1, 25, 2, 5, 30, 19, 57, 2, 25] and 5 was provided
        // the new list should
        //contain [25, 5, 30, 25].
        List<Integer> OUTPUT = new ArrayList<Integer>();

        for (int item : list) {
            if (String.valueOf(item).contains(Integer.toString(number))) {
                OUTPUT.add(item);
            }
        }

        return OUTPUT;
    }

    //2.3
    public static void allStringsOfSize() {

    }

    //2.4
    public static void stringToListOfWords () {

    }

    //2.5
    public static void removeAllInstances() {

    }

    //Extra credit
    //Described in the stringToListOfWords() section


}
