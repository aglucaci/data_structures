package com.company;

public class Queens {

    public static boolean isSolved = false;

    public static void main(String[] args) {
        int[] boardSize = new int[8];
        System.out.println("#8 Queens Solver\n");
        //System.out.println("");

        solveBoard(boardSize, 0); //Start here
    }

    public static void solveBoard(int[] board, int row) {
        //System.out.println(q + " " + k);
        if (row == 8) {
            printQueens(board); // We have finished!
        } else { //not solved, so lets solve.
            for (int i = 0; i < 8; i++) { // loop over board size
                board[row] = i; // loop, assigning position
                if (isValid(board, row)) {
                    solveBoard(board, row + 1); // recursion
                }
            }
        }
    }

    public static boolean isValid(int[] board, int n) {
        for (int i = 0; i < n; i++) {
            if (board[i] == board[n])    {
                return false;
            }

            if ((board[i] - board[n]) == (n - i)) {
                return false;   // same major diagonal
            }

            if ((board[n] - board[i]) == (n - i)) {
                return false;   // same minor diagonal
            }
        }
        return true;
    }

    public static void printQueens(int[] board) {
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println("\n#Solved Chess board");
        System.out.println();
        System.exit(0); // End the program

    }
}
