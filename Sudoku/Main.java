package com.company;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //public static int[][] LoadedBoard = new int[][];

    public static int[][] board = new int[][]{
            {0, 0, 2, 9, 8, 0, 5, 0, 0},
            {4, 0, 0, 0, 7, 0, 0, 1, 3},
            {0, 3, 9, 6, 0, 4, 0, 7, 0},
            {2, 0, 0, 0, 5, 6, 4, 0, 0},
            {8, 4, 0, 3, 0, 0, 2, 0, 1},
            {9, 0, 7, 0, 0, 1, 0, 8, 6},
            {6, 0, 0, 7, 0, 5, 1, 3, 0},
            {0, 9, 1, 4, 0, 0, 0, 0, 5},
            {0, 2, 0, 0, 3, 0, 6, 0, 8}
    };

    public static int numAttempts = 0;

    public static int runningSum = 0;

    public static boolean isSolved = false;

    public static boolean isValid(int row, int col, int num) {
        // Check row for clash.
        for (int d = 0; d < board.length; d++) { if (board[row][d] == num) { return false; } }

        //Check columns for clash
        for (int r = 0; r < board.length; r++) { if (board[r][col] == num) { return false; } }

        // corresponding square has
        // unique number (box-clash)
        //int sqrt = (int) Math.sqrt(board.length);
        int sqrt = 3;
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) { return false; }
            }
        }

        // if there is no clash, it's safe
        return true;
    }

    public static boolean solveSudoku() {
        //System.out.println("Working.");
        // Initialize.
        numAttempts += 1;
        //System.out.println(numAttempts + " Solution not found yet.");
        //PrintBoard();
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        int n = 9;

        for (int i = 0; i < n; i++) {


            for (int j = 0; j < n; j++) {


                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
        }

        // no empty space left
        if (isEmpty) { return true; }

        // Backtracking
        for (int num = 1; num <= n; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;

                if (solveSudoku()) { //Recursive
                    //PrintBoard(board);
                    return true;

                } else {
                    board[row][col] = 0;
                }
            }
        }

        //System.out.println(numAttempts + " Solution not found yet.");
        return false;
    }

    public static void PrintBoard() {
        // Print our board
        int count = 0;
        int countRows = 0;
        int numHorizontalLines = 0;

        System.out.print("\n  ----------------------------------\n");
        for (int i = 0; i < 9; i++) {
            System.out.print("| ");
            for (int j = 0; j < 9; j++) {

                System.out.print(board[i][j]);
                count += 1;

                if (isSolved == true && j < 3 && i < 1) {
                    runningSum += board[i][j];
                    //System.out.println("Adding: " + board[i][j]);
                }

                if (count == 3) {
                    System.out.print(" | ");
                    count = 0;
                } else {
                    System.out.print(" - ");
                }
            }

            countRows += 1;
            if (countRows == 3) {
                numHorizontalLines += 1;
                if (numHorizontalLines == 3) {
                    System.out.print("\n  ----------------------------------\n");
                } else {
                    System.out.print("\n  ----------+-----------+------------\n");
                }
                countRows = 0;
            } else {
                System.out.print("\n");
            }
        }
    }

    public static void main(String args[]) throws Exception {
        System.out.println("Loading Data for Sudoku!");
        String input;
        URL url = new URL("https://projecteuler.net/project/resources/p096_sudoku.txt");

        BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));

        List<String> sudoku = new ArrayList<>();

        while ((input = read.readLine()) != null)
            //System.out.println(input +  " line");
            //System.out.println(input);
            if (input.charAt(0) != 'G') {
                //System.out.println(input);
                sudoku.add(input);
            }
        read.close();

        //Data has been read.
        //System.out.println(sudoku);
        int n = sudoku.size() / 9; // 50
        System.out.println("Number of Sudoku Boards: " + n);
        int count = 9;
        int i = 0;

        int numRuns = 1;

        //Debugging
        /*
        for (int z = 9; z < 18; z++) {

            System.out.println(sudoku.get(z));
        }
        */


        for (int m = 0; m < n; m++) {
            System.out.println("Processing board: " + numRuns);
            i = 9 * m;
            count = numRuns * 9;

            //Loop n times
            String line;
            int data;
            char ch = '*';

            //0-9,, .. etc

            //if (numRuns > 1) { count -= 1;}
            //System.out.println(i + " " + count);

            while (i < count) { // Scans over the Arraylist.
                line = sudoku.get(i);
                //System.out.println(sudoku.get(i));
                //System.out.println(line);
                //System.out.println(line);

                for (int j = i; j < line.length(); j++) {
                    //System.out.println(≈);
                    //data = Integer.parseInt(line.valueOf(j));
                    //data = Integer.parseInt(line.charAt(j));
                    ch = line.charAt(j);
                    data = Character.getNumericValue(ch);

                    //System.out.println(Integer.parseInt(line.valueOf(j)));
                    //System.out.println("Digit: " + data + " At Position: " + i + " | " + j);
                    //System.out.println("Current value: " + board[j][i] + "\n");
                    board[i][j] = data;

                }
                i++;
            }

            //System.out.println("Solving Board");
            runSudoku();
            numRuns += 1;
        }
    }

    public static void runSudoku() {
        System.out.println("Solving Sudoku!");

        System.out.println("\n# --- Initial Board");
        isSolved = false;
        PrintBoard();

        if (solveSudoku()) {
            System.out.println("\n# --- Solved Board");
            isSolved = true;
            PrintBoard(); // display the final board
            System.out.println("Running sum: " + runningSum);


        }

    }


}
