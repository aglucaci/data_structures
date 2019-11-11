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

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // row has the unique (row-clash)
        for (int d = 0; d < board.length; d++) {
            // if the number we are trying to
            // place is already present in
            // that row, return false;
            if (board[row][d] == num) {
                return false;
            }
        }

        // column has the unique numbers (column-clash)
        for (int r = 0; r < board.length; r++) {
            // if the number we are trying to
            // place is already present in
            // that column, return false;

            if (board[r][col] == num) {
                return false;
            }
        }

        // corresponding square has
        // unique number (box-clash)
        int sqrt = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }

        // if there is no clash, it's safe
        return true;
    }

    public static boolean solveSudoku() {
        // Initialize.
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        int n = 9;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;

                    // we still have some remaining
                    // missing values in Sudoku
                    isEmpty = false;
                    break;
                }
            }
        }

        // no empty space left
        if (isEmpty) {
            return true;
        }

        // Backtracking
        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku()) {
                    //PrintBoard(board);
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
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
        if (solveSudoku()) {
            PrintBoard(); // print solution }
        }

    }
}

