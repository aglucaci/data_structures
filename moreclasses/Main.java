public class Main {

    /* https://www.tutorialspoint.com/java/java_object_classes.htm
    *
    * */


    public static void main(String[] args) {
	// write your code here
        //..Room[] room = new Room[10];
        System.out.println("Initializing rooms");
        //room = new Room(10);
        //System.out.println(room.length);
        Room smallRoom = new Room();
        smallRoom.Room(10);
        System.out.println(smallRoom.getNumber());
        Room bigRoom = new Room();
        bigRoom.Room(90);
        System.out.println(bigRoom.getNumber());
        System.out.println(bigRoom.getTotal());
        System.out.println(smallRoom.getTotal());


        //Complex Number
        ComplexNumber complexnumber = new ComplexNumber(2.3, 4.5);
        complexnumber.PrintNumber(complexnumber);
        complexnumber.add(complexnumber);
        complexnumber.subtract(complexnumber);
        complexnumber.multiply(complexnumber);
        complexnumber.divide(complexnumber);



        //Tic Tac Toe




        System.out.print("\nStarting Tic Tac Toe");

        TicTacToe game_tictactoe = new TicTacToe();

        //game_tictactoe.TicTacToe(2);
        //game_tictactoe.DisplayTheBoard();





    }
}

