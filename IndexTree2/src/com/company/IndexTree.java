package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Your class. Notice how it has no generics.
// This is because we use generics when we have no idea what kind of data we are getting
// Here we know we are getting two pieces of data:  a string and a line number
public class IndexTree {

	// This is your root 
	// again, your root does not use generics because you know your nodes
	// hold strings, an int, and a list of integers
	private IndexNode root;
	
	// Make your constructor
	// It doesn't need to do anything
	public IndexTree() {
		this.root = null;
	}

	public IndexNode node() {
		return this.root;
	}
	// ### ----- complete the methods below ### -----

	// this is your wrapper method
	// it takes in two pieces of data rather than one
	// call your recursive add method
	public void add(String word, int lineNumber){
		this.root = add(this.root, word,lineNumber);
	}

	// your recursive method for add
	// Think about how this is slightly different the the regular add method
	// When you add the word to the index, if it already exists, 
	// you want to  add it to the IndexNode that already exists
	// otherwise make a new indexNode
	private IndexNode add(IndexNode root, String word, int lineNumber){
		if(root == null){ //Check
			return new IndexNode(word, lineNumber);
		}

		int compare = word.compareTo(root.word);

		if (compare == 0){ //found our word.
			root.list.add(lineNumber);
			root.occurences += 1;
			return root;

		} else if (compare < 0) { //less than, so go left.
			root.left = add(root.left, word, lineNumber);
			return root;

		} else { //must be greater than, so go right.
			root.right = add(root.right, word, lineNumber);
			return root;
		}
		//return null;
	}

	// returns true if the word is in the index
	public boolean contains(String word){
		return contains(this.root, word);
		//return false;
	}

	private boolean contains(IndexNode root, String word) {
		if (root == null) { //Check
			return false;
		}

		int compare = word.compareTo(root.word);

		if (compare == 0) { //found our word, so true.
			return true;
		} else if (compare < 0) { // go left
			return contains(root.left, word); //recursive
		} else { // go right
			return contains(root.right, word); //recursive
		}
	}
	
	// call your recursive method
	// use book as guide
	public void delete(String word){
		this.root = delete(this.root, word);
	}

	// your recursive case
	// remove the word and all the entries for the word
	// This should be no different than the regular technique.
	private IndexNode delete(IndexNode root, String word) {
		if (root == null) { //Check
			return null;
		}

		int compare = word.compareTo(root.word);

		if (compare == 0) { // Same word.
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left != null && root.right == null) { // its the left one
				return root.left;
			} else if (root.left == null && root.right != null) { // its the right one
				return root.right;
			} else {
				// We will need to keep some order to our subtree prior to deleting
				IndexNode rootOfLeftSubtree = root.left;

				if (rootOfLeftSubtree.right == null) { // nothing there.
					root.word = rootOfLeftSubtree.word;
					root.left = rootOfLeftSubtree.left; //go left
					return root;
				} else { //something is there.
					return root;
				}
			}
		} else if (compare < 0) { // smaller so go to its left
			root.left = delete(root.left, word);
			return root;
		} else { //bigger
			root.right = delete(root.right, word);
			return root;
		}
	}

	// prints all the words in the index in inorder order
	// To successfully print it out
	// this should print out each word followed by the number of occurrences and the list of all occurrences
	// each word and its data gets its own line

	public void printIndex(){
		System.out.println("Printing Index");
		//InOrderTraverse(this.root, root.toString());
	}

	private void InOrderTraversal(IndexNode root, StringBuilder sb) {
		//System.out.println("In INORDER");
		if (root == null) {
			sb.append("\n");
		} else {
			InOrderTraversal(root.left,  sb);
			sb.append(root.toString()); //IndexNode root, does the printing
			InOrderTraversal(root.right, sb);
		}
	}

	public String toString() {
		//System.out.println("Bldg string");
		StringBuilder sb = new StringBuilder();
		InOrderTraversal(root, sb);
		return sb.toString();
	}

	public static void main(String[] args){
		// add all the words to the tree
		// print out the index
		// test removing a word from the index
		IndexTree index = new IndexTree();
		int lineCount = 0;

		System.out.println("Starting to Index the input file");
		System.out.println("Processing..");

		try {
			Scanner scanner = new Scanner(new File("pg100.txt"));
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				lineCount += 1;

				//System.out.println(line);
				//System.out.println("Processing.");
				//String[] words = line.split("[\\s+]|[-]");
				String[] words = line.split("\\s+");
				for(String word : words) {
					word = word.replaceAll(":", "");
					word = word.replaceAll("'", "");
					word = word.replaceAll(",", "");
					word = word.replaceAll("\\.", "");
					word = word.replaceAll(" ", "");
					word = word.replaceAll("}", "");
					word = word.replaceAll("-", "");
					word = word.replaceAll(";", "");
					word = word.replaceAll("\\?", "");
					word = word.replaceAll("!", "");
					word = word.replaceAll("\"", "");
					word = word.replaceAll(" ", "");
					if(word.equals("")){
						continue;
					}
					index.add(word, lineCount); //add to the Tree
				}

			}
			scanner.close(); //Close file
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		System.out.println(index); //Print out our tree.

		//index.toString();
		//printInorder(root);
		//printIndex();
	}
}


/*
	END OF FILE
 */