package com.company;

//Assignment 1

public class Main {

    public static void main(String[] args) {
        // write your code here

        // Q1 part 1, count number of digits, assume positive integer
        System.out.println("\nQ1");
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
        System.out.println("\nQ2");
        System.out.println("Expecting 3, got: " + nthDigitBack(0, 123));
        System.out.println("Expecting 2, got: " + nthDigitBack(1, 123));
        System.out.println("Expecting 1, got: " + nthDigitBack(2, 123));
        System.out.println("Expecting 0, got: " + nthDigitBack(3, 123));
        System.out.println("Expecting 0, got: " + nthDigitBack(0, 0));
        System.out.println("Expecting 8, got: " + nthDigitBack(3, 18023));

        //Q1 part 3, returns digit from the left
        System.out.println("\nQ3");
        System.out.println("Expecting 1, got: " + nthDigit( 0 , 123));
        System.out.println("Expecting 2, got: " + nthDigit( 1 , 123));
        System.out.println("Expecting 3, got: " + nthDigit( 2 , 123));
        System.out.println("Expecting 0, got: " + nthDigit( 3 , 123));
        System.out.println("Expecting 0, got: " + nthDigit( 0 , 0));
        System.out.println("Expecting 2, got: " + nthDigit( 3 , 18023));

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
}