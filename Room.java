public class Room {

    public int numberInRoom = 0;

    private static int totalNumber = 0;

    //private int totalNumber;

    public void Room(int numPeople) {
        this.numberInRoom = numPeople;
        this.totalNumber += numPeople;

    }

    public void addOneToRoom () {
        this.numberInRoom += 1;
        this.totalNumber += 1;

    }

    public void removeOneFromRoom () {
        if (this.numberInRoom > 0) {
            this.numberInRoom -= 1;
            this.totalNumber -= 1;

        }
    }

    public int getNumber() {
        return this.numberInRoom;
    }


    public int getTotal() {
        return this.totalNumber;
    }

}
