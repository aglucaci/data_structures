/*
Data Structures - Rabbit Hunt, 2019.

Lets see how we can make the rabbit successfully escape the rabbit.

This work has been a collaboration between Alexander G. Lucaci
Alyssa Pivirotto and Jordan Zehr.
 */

public class Rabbit extends Animal {

    private boolean haveSeenFox = false; // Ever
    private boolean SawFox = false; // This turn

    private int distanceToFox;
    private int directionToFox;

    private int directionToBush;
    private int distanceToBush;

    private int directionToEdge;
    private int distanceToEdge;

    private int lastMoveDirection;

    private int turnsSinceFoxSighting = 0; // When was the last turn I saw the fox?

    public Rabbit(Model model, int row, int column) {
        super(model, row, column);
    }

    public int MoveLogic(int directionToObject) { //Decide on how to move.
        //This function is really optimized to move away from an Object.
        //In practice, this object is the Fox.
        if (canMove(Model.turn(directionToObject, 5))) {          //Diagonals away from here
            return Model.turn(directionToObject, 5);
        } else if (canMove(Model.turn(directionToObject, 3))){
            return Model.turn(directionToObject, 3);
        } else if (canMove(Model.turn(directionToObject, 7))) {
            return Model.turn(directionToObject, 7);
        } else if (canMove(Model.turn(directionToObject, 1))) {
            return Model.turn(directionToObject, 1);
        } else if (canMove(Model.turn(directionToObject, 4))) {   // Horizontals away.
            return Model.turn(directionToObject, 4);
        } else if (canMove(Model.turn(directionToObject, 6))) {
            return Model.turn(directionToObject, 6);
        } else if (canMove(Model.turn(directionToObject, 2))) {
            return Model.turn(directionToObject, 2);
        }
        else {
            return random(Model.MIN_DIRECTION, Model.MAX_DIRECTION); // Otherwise, move randomly. canMove?
        }
    }

    public int decideMove() {

        // Search for fox, similar to logic in fox class.
        // Look in the cardinal directions defined in the Model class.

        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            // Can see the fox and make a move.
            if (look(i) == Model.FOX) {
                // We saw the fox.
                // Update global variables referencing the fox.

                SawFox = true; //This turn
                haveSeenFox = true; // Ever
                turnsSinceFoxSighting = 0;
                directionToFox = i; // the cardinal direction.
                distanceToFox = distance(i); //distance calculated on the map.
                //Could store this and search how far the fox moves next turn.

                // if you see the fox, try to move away out of his sight either diagonal away, decreasing optimums, then random
                lastMoveDirection = MoveLogic(directionToFox);
                return MoveLogic(directionToFox);

            } else {
                //if we do not see the fox..
                SawFox = false;
                turnsSinceFoxSighting += 1; // increment the turn counter, true number of turns will be this number / 8

            }
        }

        // Perform a second search
        // This assumes we have not seen the fox
        // So therefore, search for the other objects, Bushes and the Edges of the Map.
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            if (look(i) == Model.BUSH) {
                //Direction to bush = i
                directionToBush = i;
                distanceToBush = distance(i);
                // Move towards bush?
                //if (canMove(directionToBush)){
                //    return directionToBush;
                //}
                //return MoveLogic(directionToBush);
            }

            if (look(i) == Model.EDGE) { //Move towards the center of the map, I don't know how useful this may be.
                directionToEdge = i;
                distanceToEdge = distance(i);
                //return MoveLogic(directionToBush);
            }
        }

        //Logic: If the fox did see me last turn, keep moving away.
        //This doesn't really get called.
        if (turnsSinceFoxSighting <= 2 && lastMoveDirection > 0) { //We saw the fox
            if (canMove(MoveLogic(directionToFox))){
                return MoveLogic(directionToFox);
            }
            //return lastMoveDirection;
        }

        //If I was never seen, it is perfectly okay to stay still.
        return Model.STAY; // I was never seen.
    }


}
