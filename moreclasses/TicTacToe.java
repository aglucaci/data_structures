//Alexander G. Lucaci

public class TicTacToe {

    //Class Declares
    //2d array for game board
    //Rows x Columns (3x3)

    char[][] board = new char[3][3];



    //Constructor
    public void TicTacToe (int numPlayers) {

        System.out.print("Number of players: " + numPlayers + "\n");


        for (int a = 0; a <= 3; a++){
           for (int b = 0; b <= 3; b++) {
               System.out.print(b);
               System.out.print(a);

               //board[b][a] = 0;

           }
        }

        //this.DisplayTheBoard();
    }

    //Main
    public static void main(String[] args) {

    }

    // Methods
    public void AddAMove () {

    }

    public void DisplayTheBoard() {
        //returns the board
        //System.out.print(board);

        System.out.println(board[0][0]);

        /*
        System.out.println("/---|---|---\\");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("/---|---|---\\");
        */

    }

    public void TellWhoseTurnItIs () {
        //returns which players turn X's or O's

    }

    public void DetectIfThereIsAWinner () {
        // should be called after each move.

    }

    public void TellTheUserWhoTheWinnerIs () {
        //
    }


    public void RestartTheGame () {

    }


}
