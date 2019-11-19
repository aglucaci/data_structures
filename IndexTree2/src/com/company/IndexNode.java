package com.company;

import java.util.ArrayList;
import java.util.List;

public class IndexNode  {

	// The word for this entry
	String word;
	// The number of occurrences for this word
	int occurences;
	// A list of line numbers for this word.
	List<Integer> list; 
	
	
	
	IndexNode left;
	IndexNode right;

	public IndexNode() {
		this.left = null;
		this.right=null;
		occurences=0;
	}


	public IndexNode(String word, int lineNumber) {
		this.word = word;
		list = new ArrayList<>();
		this.list.add(lineNumber);
		this.occurences++;
	}


	// Constructors
	// Constructor should take in a word and a line number
	// it should initialize the list and set occurrences to 1
	
	
	
	
	// Complete This
	// return the word, the number of occurrences, and the lines it appears on.
	// string must be one line
	
	public String toString(){
		String listWord = this.word;
		listWord += "  " + this.occurences + "  " + list.toString();
		return listWord;
		//return "";
	}
	
	
	
}
