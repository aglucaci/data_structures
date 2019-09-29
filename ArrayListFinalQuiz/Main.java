package com.company;

/*
The following questions concern the following problem:

Write a method called isPermutaion() which takes in two \List objects which contain the same types.

It returns true if the Lists are permutations of each other and false if not.

Two lists are permutations if they contain the same elements, including the same number of duplicates, but they don't have to contain the elements in the same order.
For example, [1,2,4] and [2,1,4] are permutations of each other.
 */

/*
References: https://www.geeksforgeeks.org/initializing-a-list-in-java/
 */
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // For example, [1,2,4] and [2,1,4] are permutations of each other.
        List<Integer> A = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(4);
        } };

        List<Integer> B = new ArrayList<Integer>() {{
            add(2);
            add(1);
            add(4);
        } };

        System.out.println("ArrayList : " + A.toString());

        System.out.println("ArrayList : " + B.toString());

        System.out.println(isPermutation(A, B));

        String prefix = "boo";

        List<String> C = new ArrayList<String>() {{
            add("boolean");
            add("boolin");
            add("applesauce");
            add("marathon");
        } };

        System.out.println(C);

        removePrefixStrings(C, prefix);

        System.out.println(C);
    }



    public static boolean isPermutation(List<Integer> A, List<Integer> B) {
        if (A.size() != B.size()) {
            return false;
        }

        for (int item: A) {
            int countA = 0, countB = 0;

            for (int i = 0; i < A.size(); i++) {
                if (item == A.get(i)) {
                    countA++;
                }
            }

            for (int i = 0; i < B.size(); i++) {
                if (item == B.get(i)) {
                    countB++;
                }
            }


            if (countA != countB) {
                return false;
            }







        }

        return true;
    }

    public static void removePrefixStrings(List<String> list, String prefix) {

        //for (int i = 0; i < list.size(); i++) {
        //for (int i = list.size() - 1; i >= 0; i++) {
        for (int i = 0; i < list.size(); i++) {
        //for (int i = list.size() - 1; i >=0 ; i++) {
            String word = list.get(i);

            if (word.startsWith(prefix)) {
                list.remove(i);
            }
        }

    }


}
