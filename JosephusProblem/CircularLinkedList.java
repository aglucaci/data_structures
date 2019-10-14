package circularlinkedlist;
import java.util.Iterator;


public class CircularLinkedList<E> implements Iterable<E> {
    // Your variables
    Node<E> head;
    Node<E> tail;
    public int size;  // BE SURE TO KEEP TRACK OF THE SIZE

    // implement this constructor
    public CircularLinkedList() {
        this.size = 0;
        head = null;
    }

    // I highly recommend using this helper method
    // Return Node<E> found at the specified index
    // be sure to handle out of bounds cases
    private Node<E> getNode(int index ) { //this code is borrowed heavily from the LinkedList - getNode video
        Node<E> current = head;
        for (int i = 0; i < index; i++) { current = current.next; }
        return current;
    }

    // attach a node to the end of the list
    public boolean add(E item) {
        this.add(size,item);
        return true;
    }

    // Cases to handle
    // out of bounds
    // adding to empty list
    // adding to front
    // adding to "end"
    // adding anywhere else
    // REMEMBER TO INCREMENT THE SIZE
    public void add(int index, E item){
        if(index < 0 || index > size){ // check to make sure we take into account the out of bounds case
            throw new IndexOutOfBoundsException("Error: Index out of bounds. (void add)");
        }

        Node<E> adding = new Node(item);

        if(size == 0){ //since the list is empty, we will be adding to empty list
            this.head = adding;
            this.tail = adding;
        } else if(index == 0){ // since index is at 0 we will be adding to the add to front of the list
            adding.next = head;
            head = adding;
            tail.next = head;
        } else if(index == size){  //since index is equal to the length of the list, we will be adding to end of the list.
            tail.next = adding;
            tail = adding;
            tail.next = head;
        } else{
            Node<E> before = getNode(index-1);
            adding.next = before.next;
            before.next = adding;
        }
        size += 1;

        /*

        if(size == 0){ //since the list is empty, we will be adding to empty list
            this.head = adding;
            this.tail = adding;
        }

        //boolean testBool = index == size;
        //int caseSize = testBool ? true;

        switch(index) {
            case 0:
                adding.next = head;
                head = adding;
                tail.next = head;
            case size: //needs to be constant
                tail.next = adding;
                tail = adding;
                tail.next = head;
            default:
                Node<E> before = getNode(index-1);
                adding.next = before.next;
                before.next = adding;

        }


        size += 1;
        */

    }
    // remove must handle the following cases
    // out of bounds
    // removing the only thing in the list
    // removing the first thing in the list (need to adjust the last thing in the list to point to the beginning)
    // removing the last thing
    // removing any other node
    // REMEMBER TO DECREMENT THE SIZE
    public E remove(int index) {
        if (index < 0 || index >= size) { // check to make sure index is within our size.
            throw new IndexOutOfBoundsException("Error: Index out of bounds (E remove)");
        }

        E toReturn = null;

        if (size == 1){ // this is the end of the line.  Last person alive.
            toReturn = head.item;
            this.head = null;
            this.tail = null;
        } else if(index == 0){ // remove person at the beginning of the list.
            toReturn = head.item;
            head = head.next;
            tail.next = head;
            //System.out.println(tail);
        } else if(index == size - 1) { //removes the person at the end.
            Node<E> before = getNode(index -1);
            toReturn = tail.item;
            before.next = head;
            tail = before;
        } else{ // removes persons located internally on our ring.
            Node<E> before = getNode(index -1);
            toReturn = before.next.item;
            before.next = before.next.next;
        }
        size -= 1; //decrements the size of the ring.

        return toReturn;
    }

    // Turns your list into a string
    // Useful for debugging
    public String toString(){
        Node<E> current =  head;
        StringBuilder result = new StringBuilder();
        if(size == 0){
            return "";
        }
        if(size == 1) {
            return head.item.toString();

        }
        else{
            do{
                result.append(current.item);
                result.append(" ==> ");
                current = current.next;
            } while(current != head);
        }
        return result.toString();
    }


    public Iterator<E> iterator() {
        return new ListIterator<E>();
    }

    // provided code for different assignment
    // you should not have to change this
    // change at your own risk!
    // this class is not static because it needs the class it's inside of to survive!
    private class ListIterator<E> implements Iterator<E>{

        Node<E> nextItem;
        Node<E> prev;
        int index;

        @SuppressWarnings("unchecked")
        //Creates a new iterator that starts at the head of the list
        public ListIterator(){
            nextItem = (Node<E>) head;
            index = 0;
        }

        // returns true if there is a next node
        // this is always should return true if the list has something in it
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return size != 0;
        }

        // advances the iterator to the next item
        // handles wrapping around back to the head automatically for you
        public E next() {
            // TODO Auto-generated method stub
            prev =  nextItem;
            nextItem = nextItem.next;
            index =  (index + 1) % size;
            return prev.item;

        }

        // removed the last node was visted by the .next() call
        // for example if we had just created a iterator
        // the following calls would remove the item at index 1 (the second person in the ring)
        // next() next() remove()
        public void remove() {
            int target;
            if(nextItem == head) {
                target = size - 1;
            } else{
                target = index - 1;
                index -= 1;
            }
            CircularLinkedList.this.remove(target); //calls the above class
        }

    }

    // It's easiest if you keep it a singly linked list
    // SO DON'T CHANGE IT UNLESS YOU WANT TO MAKE IT HARDER
    private static class Node<E>{
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }

    }

    /*
    public int GetSize(); {
        int size1 = this.size;
        return size1;
    }
    */

    public static void main(String[] args){
        int numPeople = 13; // Size of ring, i.e. The number of people
        int StepSize = 2; // Step size, how many people to skip while moving around the ring.
        int round = 1;

        // set up the new ring of people.
        CircularLinkedList l = new CircularLinkedList();

        //Populate our ring.
        for (int i = 1; i <= numPeople; i++) { l.add(i); }

        //print the circle to the console.
        System.out.println("We have created the ring of people.");
        System.out.println(l);
        System.out.println("Let the purging begin:");
        //System.out.println("Round: " + round);

        Iterator inter = l.iterator(); //set up iterator

        while (inter.hasNext()){ //while there's still a next
            for (int i = 0; i < StepSize; i++) { //for k times, go next
                inter.next();
            }

            inter.remove(); //remove at that position
            System.out.println("Round: " + round + " ");
            System.out.println(l); //print out the linked list

            round += 1;

        }
    }
}
