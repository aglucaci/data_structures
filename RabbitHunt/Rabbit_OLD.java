public class Rabbit extends Animal {

    private boolean haveSeenFox = false;
    private boolean canSeeFoxNow = false;
    private int distanceToFox;
    private int directionToFox;
    private int directionToBush;
    private int distanceToBush;
    private int turnCount = 0;
    private int directionToEdge;
    private int distanceToEdge;

    private int SawFox = 0;

    public Rabbit(Model model, int row, int column) {
        super(model, row, column);
    }

    int MoveLogic() {
        //System.out.println("In move logic");

        //Where is the fox?
        //System.out.println("Direction to Fox: " + directionToFox);
        //System.out.println("Direction to Fox: " + distanceToFox);

        int size = 90; // effectively removes these If statements
        //Based on direction, move away.
        if (directionToFox == Model.N && distanceToFox > size) {
            return Model.SE;
        }

        if (directionToFox == Model.N) {
            return Model.SW;
            //return Model.SE;
        }

        if (directionToFox == Model.S && distanceToFox > size) {
            return Model.NW;
        }

        if (directionToFox == Model.S) {
            return Model.NE;
        }

        if (directionToFox == Model.W && distanceToFox > size) {
            return Model.NE;
        }

        if (directionToFox == Model.W) {
            return Model.SE;
            //return Model.NE;
        }

        if (directionToFox == Model.E) {
            return Model.NW;
        }

        //Diagonals
        if (directionToFox == Model.NW && distanceToFox > size ) {
            return Model.E;
        }

        if (directionToFox == Model.NW) {
            //return Model.E;
            return Model.S;
        }

        if (directionToFox == Model.NE && distanceToFox > size) {
            return Model.S;
        }

        if (directionToFox == Model.NE) {
            //return Model.S;
            return Model.W;
        }

        if (directionToFox == Model.SE && distanceToFox > size) {
            return Model.W;
        }

        if (directionToFox == Model.SE) {
            //return Model.W;
            return Model.N;
        }

        if (directionToFox == Model.SW) {
            //return Model.N;
            return Model.E;
        }

        //return Model.NW;

        return random(Model.MIN_DIRECTION, Model.MAX_DIRECTION);


    }

    int decideMove() {

        //this.look(Model.N);
        //System.out.println("test");
        //System.out.println("Checking.");
        canSeeFoxNow = false;
        turnCount += 1;

        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            //System.out.println("In for");

            //I always know the distance to FOX? NO
            //System.out.println("Direction to Fox: " + distanceToFox);

            if (look(i) == Model.FOX) {
                //SawFox += 1; //negates the code below, at return Model.STAY
                canSeeFoxNow = haveSeenFox = true;
                directionToFox = i;
                distanceToFox = distance(i);

                //System.out.println("Direction to Fox: " + directionToFox);
                //System.out.println("Distance to Fox: " + distanceToFox);
                if (canMove(MoveLogic())) {
                    return MoveLogic();
                } else {
                    //System.out.println("Moving randomly");
                    return random(Model.MIN_DIRECTION, Model.MAX_DIRECTION);

                }
                //return MoveLogic();

                // return the result of move logic
            }

            if (look(i) == Model.BUSH) {
                //Direction to bush = i
                //return MoveLogic();
                // Move towards bush?
                directionToBush = i;
                distanceToBush = distance(i);
                //System.out.println("Direction to Bush: " + directionToBush);
                //System.out.println("Distance to Bush: " + distanceToBush);
            }

            if (look(i) == Model.EDGE) {
                directionToEdge = i;
                distanceToEdge = distance(i);
            }
        }

        //return random(Model.MIN_DIRECTION, Model.MAX_DIRECTION);
        //Otherwise, stay put.

        /*
        if (turnCount % 2 == 0) {
            //return random(Model.MIN_DIRECTION, Model.MAX_DIRECTION);
            return Model.STAY;

        }
        */

        //If the fox did see me, keep moving away.
        if (SawFox > 0) {
            SawFox--;
            if (canMove(MoveLogic())) {
                return MoveLogic();
            } else {
                //System.out.println("Fox saw me, Moving randomly");
                return random(Model.MIN_DIRECTION, Model.MAX_DIRECTION);

            }
        }

        return Model.STAY; // I was never seen.
        //return random(Model.MIN_DIRECTION, Model.MAX_DIRECTION);

    }
}
