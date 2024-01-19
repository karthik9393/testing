package com.codewithkarthik;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Coding problem 
//Given a list of song titles, find the first three songs ordered by the second word.
//One-word songs should be considered last, 
//and ties should be broken by natural alphabetical order.


public class Problem2KylesInterview {

	public static void main(String[] args) {
		
		List<String> listOfSongs = Arrays.asList("Echo", "Rain", "Blue skies", "ocean waves", "Dancing flames", "Golden sunset");
		
		Comparator<String> c1 = new Comparator<String>() {
			
			@Override
			public int compare(String song1, String song2) {
				String[] words1 = song1.split(" ");
				String[] words2 = song2.split(" ");
				
				if(words1.length < 2 && words2.length < 2) {
					return song1.compareTo(song2);
				}else if (words1.length <2 ) {
					return 1;
				}else if (words2.length < 2) {
					return -1;
				}else {
					return words1[1].compareTo(words2[1]);
				}
				
			}
		};
		
		Collections.sort(listOfSongs, c1);
		for(String word: listOfSongs) {
			System.out.println(word);
		}

	}

}
