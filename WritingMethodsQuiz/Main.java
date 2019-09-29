package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    int[] arr = {1, 2, 3, 4, 5, 70};

    List<Integer> list = new ArrayList<>(arr.length);
    for (int i: arr){
        list.add(Integer.valueOf(i));
    }

    System.out.println(getMax(list));
    System.out.println(reverse("apple"));
    System.out.println(reverse("Hello"));


    String[] words = {"enny", "meeny", "miney", "moe"};

    List<String> Words = new ArrayList<>(words.length);
    for (String i: words){
        Words.add(String.valueOf(i));
    }


    System.out.println(reverseWords(Words));


    }


    //public static <Integer> int getMax(List<Integer> list) {
    public static int getMax(List<Integer> list) {
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
            max = list.get(i);
            }
        }
        return max;
    }


    public static String reverse(String word){
        String reversed = "";

        for (int i=0; i < word.length(); i++) {
            reversed +=  word.charAt( word.length() - i - 1);
            //System.out.println(i + word.toString(word.charAt(i)));
            //System.out.println(i + " " + word.charAt( word.length() - i - 1));

        }
        return reversed;

    }

    public static List<String> reverseWords(List<String> words) {
        List<String> output = new ArrayList<String>();
        //List<String> output = new List<>();

        for (int i = 0; i < words.size(); i++) {
        //for (int i = 0; i < words.length(); i++) {
            String word = words.get(i);
            word = reverse(word);
            output.add(word);
        }
        return output;

    }





}
