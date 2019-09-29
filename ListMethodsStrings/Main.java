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
        ArrayList<String> C = new ArrayList<String>() {{
            add("boolean");
            add("boolin");
            add("applesauce");
            add("marathon");
            //add("boolin");
        } };

        System.out.print("2.1\n");
        System.out.print("\t" + unique(C));
        C.add("boolin");
        System.out.print("\n\t" + unique(C));
        System.out.print("\n");

        ArrayList<Integer> A = new ArrayList<Integer>() {{
            add(1);
            add(25);
            add(30);
            add(57);
        } };

        System.out.print("2.2\n");
        System.out.print("\t Input: " + A);
        System.out.print("\n");
        System.out.print("\t Output: " + allMultiples(A, 5));

        System.out.print("\n2.3\n");
        ArrayList<String> B = new ArrayList<String>() {{
            add("hotdog");
            add("pie");
            add("cake");
            add("pizza");
            add("soup");
        } };

        System.out.print("\t" + allStringsOfSize(B, 4));

        System.out.print("\n2.4\n");
        System.out.print("\t" + stringToListOfWords("Hello, World!"));

        System.out.print("\n2.5\n");
        ArrayList<Integer> D = new ArrayList<Integer>() {{
            add(7);
            add(2);
            add(2);
            add(1);
            add(8);
        } };

        System.out.print("\t Input: " + D + "\n");
        removeAllInstances(D, 2);
        System.out.print("\t Output: " + D);

    }

    //Generic method
    public static <E> boolean in (List<E> list, E item ){
        return false;
    }

    //2.1
    public static <E> boolean unique(ArrayList<E> list) {
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
    public static List<Integer> allMultiples(ArrayList<Integer> list, int number) {
        //List is [1, 25, 2, 5, 30, 19, 57, 2, 25] and 5 was provided
        // the new list should
        //contain [25, 5, 30, 25].
        ArrayList<Integer> OUTPUT = new ArrayList<Integer>();

        for (int item : list) {
            if (String.valueOf(item).contains(Integer.toString(number))) {
                OUTPUT.add(item);
            }
        }
        return OUTPUT;
    }

    //2.3
    public static List<String> allStringsOfSize(ArrayList<String> list, int length) {
        //inputs are ["I", "like", "to", "eat", "eat", "eat", "apples", "and", "bananas"] and 3,
        // the new list is ["eat", "eat", "eat", "and"].

        //Similar in style to above but for Strings
        ArrayList<String> OUTPUT = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            if(list.get(i).length() == length) { //Does this words length match our input length?
                OUTPUT.add(list.get(i));
            }
        }
        return OUTPUT;
    }

    //2.4
    public static List<String> stringToListOfWords (String word) {
        ArrayList<String> OUTPUT = new ArrayList<>();

        String[] newList = word.split(" ", 0 );  //split via space character

        for (int i = 0; i < newList.length; i++) {
            String holder = newList[i].replaceAll("[^a-zA-Z]",""); //take all the extra stuff out.
            //System.out.print(holder);
            OUTPUT.add(holder);
        }

        return OUTPUT;
    }

    //2.5
    public static <E> void removeAllInstances(ArrayList<E> list, E item) {
        //For example, if the method is passed the List<Integer> [1, 4, 5, 6, 5, 5, 2] and the Integer 5
        //the method removes all 5’s from the List
        //The List then becomes [1, 4, 6, 2]

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(item)) {
                list.remove(i); //This will change the list size.
                removeAllInstances(list, item); //Loop until we have no more items that match.
            }
        }
    }

    //Extra credit
    //Described in the stringToListOfWords() section
    /*
    For extra credit, sanitize the String, cleaning it up so that we remove the punctuation and other extraneous characters such that the output in
    the above example would become ["Hello", "world"]
     */

    // SEE 2.4 for Extra credit work.


}
