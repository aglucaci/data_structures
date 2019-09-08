package com.company;

//Assignment 1

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //test data
        //String filename = "/Users/user/Documents/ENROLLMENT_cp.data";

        // had to modify this to remove intro text
        //String filename = "/Users/user/Documents/livejournal.txt";

        // had to modify this to remove intro text
        //String filename = "/Users/user/Documents/librarybooks.txt";

        String filename = "/Users/user/Documents/fantasypoints.txt";



        System.out.println("Reading: " + filename);

        //ArrayList<Integer> elements = new ArrayList<Integer>();



        int[] elements = {};

        elements = readMysteriousNumbers(filename);

        System.out.println("Returned: " + Arrays.toString(elements));
        System.out.println("Elements: " + elements.length);

        int n = 0;

        System.out.println("Analyzing position: "  + n);

        //System.out.println(Arrays.toString(nthDigitTally(0, elements)));
        int [] freqs;
        freqs = nthDigitTally(0, elements);

        //System.out.println(Arrays.toString(nthDigitTally(0, elements)));


        for (int i = 0; i < freqs.length; i++ ) {
            System.out.println(i + "s: " + freqs[i]);
        }


    }


    public static void main_OLD(String[] args) throws IOException {
        // write your code here

        // Q1 part 1, count number of digits, assume positive integer
        System.out.println("\nQ1 Part 1");
        System.out.println("Expecting 1, got: " + countDigits(0));
        System.out.println("Expecting 1, got: " + countDigits(9));
        System.out.println("Expecting 2, got: " + countDigits(12));
        System.out.println("Expecting 3, got: " + countDigits(120));
        System.out.println("Expecting 3, got: " + countDigits(900));
        System.out.println("Expecting 4, got: " + countDigits(1000));
        System.out.println("Expecting 5, got: " + countDigits(10000));
        System.out.println("Expecting 6, got: " + countDigits(100000));
        System.out.println("Expecting 6, got: " + countDigits(700640));

        //Q1 part 2, returns digit from the right
        System.out.println("\nQ1 Part 2");
        System.out.println("Expecting 3, got: " + nthDigitBack(0, 123));
        System.out.println("Expecting 2, got: " + nthDigitBack(1, 123));
        System.out.println("Expecting 1, got: " + nthDigitBack(2, 123));
        System.out.println("Expecting 0, got: " + nthDigitBack(3, 123));
        System.out.println("Expecting 0, got: " + nthDigitBack(0, 0));
        System.out.println("Expecting 8, got: " + nthDigitBack(3, 18023));

        //Q1 part 3, returns digit from the left
        System.out.println("\nQ1 Part 3");
        System.out.println("Expecting 1, got: " + nthDigit( 0 , 123));
        System.out.println("Expecting 2, got: " + nthDigit( 1 , 123));
        System.out.println("Expecting 3, got: " + nthDigit( 2 , 123));
        System.out.println("Expecting 0, got: " + nthDigit( 3 , 123));
        System.out.println("Expecting 0, got: " + nthDigit( 0 , 0));
        System.out.println("Expecting 2, got: " + nthDigit( 3 , 18023));

        //Q2 part 1
        //This has a typo in the HW description
        System.out.println("\nQ2 Part 1");
        int tally[] = {0, 0, 1, 2, 0, 0, 3, 0 ,9, 0};
        System.out.println("Initial tally: " + Arrays.toString(tally));
        updateTally(2, 1072, tally);
        //n = 2 of 1072 is 7 not 1.
        System.out.println("Updated! " + Arrays.toString(tally));
        //this is also wrong, digit is correct (2) but the position in tally is wrong.
        updateTally(0, 2541, tally);
        System.out.println("Updated! " + Arrays.toString(tally));

        //Q2 part 2
        System.out.println("\nQ2 Part 2");
        int enrollments[] = {12176, 5476, 543, 3490, 24892, 28619, 2595, 603, 2527, 1465, 1858};
        System.out.println(Arrays.toString(nthDigitTally(0, enrollments)));

        //Q3 part 1
        System.out.println("\nQ3 Part 1");
        System.out.println("Doing some file reading");
        String filename = "/Users/user/Documents/ENROLLMENT.data";
        System.out.println("Reading: " + filename);
        //System.out.println("Returned: " + Arrays.toString(readMysteriousNumbers(filename)));
        System.out.println("Returned: " + readMysteriousNumbers(filename));

        //Q3 part 2
        //Formatting main
        //Would be easier to do with ArrayList
        //Q4 part 1
    }

    public static int countDigits(int num) {
        /* May need to use absolute value of num */
        int x;
        int divider = 10;
        int count = 1;
        //if (num < divider){
        //    return 1;
        //}
        //x = num / divider;
        x = num; // abs of num
        while (x >= divider) {
            x = x / divider;
            count += 1;
            //System.out.println(x);
        }
        return count;

    }

    public static int nthDigitBack(int n, int num) {
        // check if this is a bogus call
        if (n >= countDigits(num)) {
            return 0;
        }
        int x;
        x = num;
        /*
        while (n > 0) {
            x = x % 10;
            n -= 1;
        }
        */
        // return (x % 10) / n;
        for (int i = 0; i <= n - 1; i++) {
            x /= 10;
            //x = x / 10;
            //System.out.println(x);
        }
        x = x % 10;
        // retrieve nth digit from the right side of num
        return x;
    }

    public static int nthDigit(int n, int num) {
        if (n >= countDigits(num)) {
            return 0;
        }
        //int x = 0;
        //return x;
        /*
        System.out.println("\n");
        System.out.println("n: " + n);
        System.out.println("num: " + num);
        System.out.println("Count digits: " + countDigits(num));

        System.out.println("nthDigitBack: " + nthDigitBack(n, num));
        System.out.println("nthDigitBack - 1: " + nthDigitBack(n - 1, num));
        System.out.println("nthDigitBack, n: " + nthDigitBack(n, num));
        System.out.println("nthDigitBack, count: " + nthDigitBack(countDigits(num), num));
        System.out.println("nthDigitBack, count - 1: " + nthDigitBack(countDigits(num) - 1, num));
        System.out.println("nthDigitBack, count - n: " + nthDigitBack(countDigits(num) - n, num));
        System.out.println("nthDigitBack, n - count: " + nthDigitBack(n - countDigits(num), num));
        System.out.println("nthDigitBack, n - count + 1: " + nthDigitBack(n - countDigits(num) + 1, num));
        System.out.println("nthDigitBack, count - n - 1: " + nthDigitBack(countDigits(num) - n - 1, num));
        //System.out.println("here: " + nthDigitBack(n + 2, num));
        */
        // in the case of 123. pos 1 frm the left = pos 3 (count digits) from the right
        // 0 pos left, 2 position right
        //int answer = 0;
        /*
        if (n == 0) {
            //System.out.println("nthDigitBack, count - 1: " + nthDigitBack(countDigits(num) - 1, num));
            return nthDigitBack(countDigits(num) - 1, num);
        }
        */
        return nthDigitBack(countDigits(num) - n - 1, num);
        //return 0;
    }


    public static int[] nthDigitTally (int n, int[] nums) {
        int[] freqs = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        //int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        //System.out.println("n: " + n);
        // in  the nth position, what is the frequnecy of 0-9
        //loop over nums
        for (int i = 0; i < nums.length; i++) {
            //get nth position
            //System.out.println("number: " + nums[i]);
            //System.out.println("nthDigit: " + nthDigit(n, nums[i]));

            //updateTally(n, nums[i], answer);

            freqs[nthDigit(n, nums[i])] += 1;

            //updateTally(i, nums[i], freqs);

            //Can't seem to get this to work with updateTally.
        }
        return freqs;

    }

    public static void updateTally(int n, int num, int[] tally) {
        //assumes tally is an int[] of 10 integers

        tally[n] = nthDigit(n, num);
        //return nthDigit(n, num);
    }

    public static int[] nthDigitTally_OLD(int n, int[] nums) {
        int[] freqs = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        //int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        //System.out.println("n: " + n);
        // in  the nth position, what is the frequnecy of 0-9
        //loop over nums
        for (int i = 0; i < nums.length; i++) {
            //get nth position
            //System.out.println("number: " + nums[i]);
            //System.out.println("nthDigit: " + nthDigit(n, nums[i]));

            //updateTally(n, nums[i], answer);

            freqs[nthDigit(n, nums[i])] += 1;

            //updateTally(i, nums[i], freqs);

            //Can't seem to get this to work with updateTally.
        }
        return freqs;

    }


    public static int[] readMysteriousNumbers(String filename) throws IOException {
        //Review the file reading video from module 2
        /*
        File file = new File(filename);

        BufferedReader br = new BufferedReader(new FileReader(file));
        */
        //FileReader fr = new FileReader(filename);

        /*
        try {
            //  Block of code to try
            while ((st = br.readLine()) != null) {
                System.out.println("Adding: " + st);
                elements[elements.length + 1] = Integer.parseInt(st);
            }
        }
        catch(Exception e) {
        //  Block of code to handle errors
            System.out.println("im guessing the file ended");
            return elements;
        }
        */
        /*
        while ((st = br.readLine()) != null) {
            System.out.println("Adding: " + st);
            elements[elements.length + 1] = Integer.parseInt(st);
        }
        */
        /*
        int i;

        while ((i=fr.read()) != -1) {
            //System.out.print((char) i);

            elements[elements.length + 1] = (int) i;
        }
        */

        File file = new File(filename);

        //int[] elements = {};
        //int[] elements = new int[0];

        //ArrayList<Integer> elements = new ArrayList<Integer>();

        Scanner sc = new Scanner(file);

        int nextInt;
        int i = 0;

        int[] elements = new int[10000];
        //int[] elements;

        while (sc.hasNextInt()) {
            //int[] elements = new int[i];
            //System.out.println(sc.nextLine());
            //elements[elements.length + 1] = Integer.parseInt(sc.nextLine());
            nextInt = sc.nextInt();

            //System.out.println("Read: " + nextInt);
            //System.out.println(nextI);
            //elements[elements.length + 1] = nextI;

            //how do I add this to an array?

            //System.out.println(Arrays.toString(elements));


           //elements[i] = Integer.parseInt(nextInt);
            elements[i] = nextInt;
            //System.out.println(Arrays.toString(elements));
            i += 1;

            //int[] elements = new int[i];


            //elements.add(nextInt);

            //elements = new int[i++];
            //elements[i] = nextI;

            //elements[i++] = (int) nextI;
            //elements[elements.length + 1] = Integer.parseInt(sc.nextLine());

        }

        //remove 0s
        //shamefully stolen from: https://stackoverflow.com/questions/8777217/remove-all-zeros-from-array
        int targetIndex = 0;

        for( int sourceIndex = 0;  sourceIndex < elements.length;  sourceIndex++ ) {
            if ( elements[sourceIndex] != 0 ) {
                elements[targetIndex++] = elements[sourceIndex];
            }
        }

        int[] newArray = new int[targetIndex];
        System.arraycopy( elements, 0, newArray, 0, targetIndex );


        return newArray;


        //return elements;
    }


}
