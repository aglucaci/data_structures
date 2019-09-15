//Alexander G. Lucaci

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    //Class Declares
    //2d array for game board
    //Rows x Columns (3x3)

    private char[][] board = new char[3][3];
    int numMoves;
    private boolean isXTurn;
    private Scanner posInput;

    //Constructor
    public TicTacToe () {
        main();
    }

    //Main
    public void main() {
        System.out.println("\n");
        System.out.println("\nWelcome to Tic - Tac  - Toe.");
        System.out.println("(c) 2019");

        this.isXTurn = true;

        RestartTheGame();

        System.out.println("- Positions -");
        System.out.println("[ 1,  2,  13 ]");
        System.out.println("[ 4,  5,  6 ]");
        System.out.println("[ 7,  8,  9 ]");

        //Starts game
        DisplayTheBoard();

        //Take input
        TellWhoseTurnItIs();

        //This will loop, make a bool?
        //add a while loop?
    }

    // Methods
    public void AddAMove (int position) {
        //Board is set up as positions 1-9

        //row 1 : 1, 2, 3
        //row 2 : 4, 5, 6
        //row 3 : 7, 8, 9

        char mark = ' ';
        if (this.isXTurn == true) {
            mark = 'X';
            this.isXTurn = false;
        } else {
            mark = 'O';
            this.isXTurn = true;
        }

        if (numMoves == 10) {
            System.out.println("Game is tied, lets try again");
            RestartTheGame();

        }

        //Position to 2d array
        //make sure space is empty
        if (position == 1) { board[0][0] = mark; }
        if (position == 2) { board[0][1] = mark; }
        if (position == 3) { board[0][2] = mark; }

        if (position == 4) { board[1][0] = mark; }
        if (position == 5) { board[1][1] = mark; }
        if (position == 6) { board[1][2] = mark; }

        if (position == 7) { board[2][0] = mark; }
        if (position == 8) { board[2][1] = mark; }
        if (position == 9) { board[2][2] = mark; }

        //Count moves
        numMoves += 1;

        //Display board
        DisplayTheBoard();

        //Check if there is a winner
        DetectIfThereIsAWinner('X');
        DetectIfThereIsAWinner('O');

        //Loop
        TellWhoseTurnItIs();
    }

    public void DisplayTheBoard() {
        //returns the board
        //System.out.println(Arrays.deepToString(board));
        System.out.println("\nThe current board\n");
        System.out.println(Arrays.toString(board[0]));
        System.out.println(Arrays.toString(board[1]));
        System.out.println(Arrays.toString(board[2]));
    }

    public void TellWhoseTurnItIs () {
        posInput = new Scanner(System.in);

        //returns which players turn X's or O's
        if ( this.isXTurn == true) {
            // X turn
            //Take X input
            System.out.println("Enter a position for X (1-9): ");
            int position = posInput.nextInt();
            System.out.println("Entered: " + position);

            //Make sure it is a valid position, otherwise try again
            if (CheckIfValidMove(position) == true) {
                //Add a move
                AddAMove(position);
            } else {
                System.out.println("Invalid Move - X");
                TellWhoseTurnItIs ();
            }


        } else {
            //O turn
            //Take O turn
            System.out.println("Enter a position for O (1-9): ");
            int position = posInput.nextInt();
            System.out.println("Entered: " + position);

            //Make sure it is a valid position, otherwise try again
            if (CheckIfValidMove(position) == true) {
                //Add a move
                AddAMove(position);
            } else {
                System.out.println("Invalid Move - O");
                TellWhoseTurnItIs ();
            }



        }


    }

    private boolean CheckIfValidMove(int position) {
        boolean valid = false;
        char mark = ' ';

        if (position == 1 && board[0][0] == mark) { valid = true; }
        if (position == 2 && board[0][1] == mark) { valid = true; }
        if (position == 3 && board[0][2] == mark) { valid = true; }

        if (position == 4 && board[1][0] == mark) { valid = true; }
        if (position == 5 && board[1][1] == mark) { valid = true; }
        if (position == 6 && board[1][2] == mark) { valid = true; }

        if (position == 7 && board[2][0] == mark) { valid = true; }

        if (position == 8 && board[2][1] == mark) { valid = true; }
        if (position == 9 && board[2][2] == mark) { valid = true; }

        return valid;
    }

    public void DetectIfThereIsAWinner (char mark) {
        // should be called after each move.
        //Board is set up as positions 1-9

        //row 1 : 1, 2, 3
        //row 2 : 4, 5, 6
        //row 3 : 7, 8, 9
        boolean winner;
        //char mark = ;
        winner = false;

        //Horizontal
        if (board[0][0] == mark && board[0][1] == mark && board[0][2] == mark) {
            //'mark' won
            winner = true;
        }
        if (board[1][0] == mark && board[1][1] == mark && board[1][2] == mark) {
            //'mark' won
            winner = true;
        }
        if (board[2][0] == mark && board[2][1] == mark && board[2][2] == mark) {
            //'mark' won
            winner = true;
        }

        //Vertical
        if (board[0][0] == mark && board[1][0] == mark && board[2][0] == mark) {
            //'mark' won
            winner = true;
        }
        if (board[0][1] == mark && board[1][1] == mark && board[2][1] == mark) {
            //'mark' won
            winner = true;
        }
        if (board[0][2] == mark && board[1][2] == mark && board[2][2] == mark) {
            //'mark' won
            winner = true;
        }

        //Crosses
        if (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) {
            winner = true;
        }

        if (board[2][0] == mark && board[1][1] == mark && board[0][2] == mark) {
            winner = true;
        }

        if (winner == true) {
            System.out.println(mark + " is the winner.");
            TellTheUserWhoTheWinnerIs();
        }


    }

    public void TellTheUserWhoTheWinnerIs () {
        //

        if (this.isXTurn == false) {
            System.out.println("X WON");

            //Restart the game
            RestartTheGame ();
            DisplayTheBoard();
        } else {
            System.out.println("O WON");

            //Restart the game
            RestartTheGame ();
            DisplayTheBoard();
        }
    }


    public void RestartTheGame () {
        //Init the empty board
        for (int i = 0; i < 3; i++) {
            board[0][i] = ' ';
            board[1][i] = ' ';
            board[2][i] = ' ';
        }
        this.isXTurn = true;
        numMoves = 0;

    }


}
