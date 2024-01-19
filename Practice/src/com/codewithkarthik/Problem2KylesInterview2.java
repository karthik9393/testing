package com.codewithkarthik;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2KylesInterview2 {

	public static void main(String[] args) {
		
		List<String> asList = Arrays.asList("Echo", "Dancing fires", "sunset", "Blue skies", "Rain");

		orderSongsBySecondWord(asList);
	}

	private static void orderSongsBySecondWord(List<String> asList) {
		asList.stream().sorted(Comparator.comparing(Problem2KylesInterview2::getSecondWord,Comparator.nullsLast(Comparator.naturalOrder()))).collect(Collectors.toList()).forEach(System.out::println);
		
		
	}
	public static String getSecondWord(String str) {
        String[] word = str.split(" ");
        return word.length > 1 ? word[1] : null;
    }

}
