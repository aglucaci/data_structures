package com.company;

public class Main {

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

    public static void main(String args[]) {
        System.out.println("Solving Sudoku!");

        System.out.println("\n# --- Initial Board");
        PrintBoard();


        //while (solveSudoku() == true) {
        //    System.out.println("Working..");
        //}
        //solveSudoku();
        //PrintBoard();


        if (solveSudoku()) {
            System.out.println("\n# --- Solved Board");
            PrintBoard(); // display the final board
        }

    }
}

