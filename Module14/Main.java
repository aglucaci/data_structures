// Uses JUNG jar files.

import edu.uci.ics.jung.graph.DirectedSparseGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    //Initialize class

    static DirectedSparseGraph<Integer, String> passcode = new DirectedSparseGraph<Integer, String>();
    static String fileName = "p079_keylog.txt";
    static int lineNum = 0;
    static List <Integer> output = new ArrayList<>();
    static Queue <Integer> inDegreeZero = new LinkedList<>();



    public static void main(String[] args) {
        // Initialize method
        Scanner scanner = null;

        // Read our key file..
        try {
            scanner = new Scanner(new File(fileName));
            System.out.println("We have detected our keylog..");
        } catch (FileNotFoundException e1) {
            //TODO Auto-generated catch block
            e1.printStackTrace();
        }

        System.out.println("Processing ..");

        while (scanner.hasNextLine()) { // loop

            String keylog = scanner.nextLine();
            lineNum++; // count line numbers

            for (int i = 0; i < keylog.length(); i++){
                char num = keylog.charAt(i); // grab the char.
                int number = Character.getNumericValue(num);  // convert to number.

                if(i == 0){ // first time
                    if (passcode.addVertex(number) == false) { //our graph.
                        continue;
                    } else {
                        passcode.addVertex(number); // place the vertex
                    }

                } else { // all other cases, build links

                    char prev = keylog.charAt(i - 1); // grab the previous character.

                    int previous = Character.getNumericValue(prev); // get its int value

                    StringBuilder edge = new StringBuilder(); // edge builder.

                    edge.append(prev); // build connection
                    edge.append(num); //

                    if (passcode.addEdge(edge.toString(), previous, number)){ // add edges
                            passcode.addEdge(edge.toString(), previous, number);

                    } else { // if it already exists.
                        continue;
                    }

                }

            }

        }
        scanner.close();

        System.out.println("Done..");

        PrintCode();
    }


    public static void PrintCode() {
        //passcode is a global variable. our directed graph

        while (passcode.getVertexCount() > 0) { // while we have verticies.

            for(Integer num : passcode.getVertices()){ //get verticies
                if(passcode.inDegree(num) == 0) { inDegreeZero.offer(num); } // linked list.
            }

            while (inDegreeZero.isEmpty() == false) { // loop, linked list
                passcode.removeVertex(inDegreeZero.peek()); // linked list

                output.add(inDegreeZero.remove()); // add to output
            }
        }


        System.out.println("The passcode: ");

        // setup output.
        String listString = "";

        for (Integer s : output) {
            listString += s;
        }

        System.out.println(listString);

    }

}