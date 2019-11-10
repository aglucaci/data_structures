package com.company;


//https://introcs.cs.princeton.edu/java/23recursion/Queens.java.html


public class Main {

    public static void main(String[] args) {
	// write your code here
        //int n = Integer.parseInt(args[0]);
        //enumerate(n);

        enumerate(8);
    }
    /***************************************************************************
     *  Try all permutations using backtracking
     ***************************************************************************/
    public static void enumerate(int n) {
        int[] a = new int[n];
        enumerate(a, 0);
    }

    public static void enumerate(int[] q, int k) {
        int n = q.length;
        if (k == n) printQueens(q);
        else {
            for (int i = 0; i < n; i++) {
                q[k] = i;
                if (isConsistent(q, k)) enumerate(q, k+1);
            }
        }
    }

    /***************************************************************************
     * Return true if queen placement q[n] does not conflict with
     * other queens q[0] through q[n-1]
     ***************************************************************************/
    public static boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n])             return false;   // same column
            if ((q[i] - q[n]) == (n - i)) return false;   // same major diagonal
            if ((q[n] - q[i]) == (n - i)) return false;   // same minor diagonal
        }
        return true;
    }

    /***************************************************************************
     * Prints n-by-n placement of queens from permutation q in ASCII.
     ***************************************************************************/
    public static void printQueens(int[] q) {
        int n = q.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j) {

                   System.out.print("Q ");
                }
                else {
                    System.out.print("* ");
                }
            }
            //System.out.println("1");
            System.out.println();
        }
        System.out.println("CHESS BOARD");
        System.out.println();
    }
}
