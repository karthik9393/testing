package com.codewithkarthik;

import java.util.HashMap;
import java.util.Map;

//Given a sentence and a dictionary, translate a list of sentences. Assume
//each word in the sentence has a single, mapping in the dictionary, and words/phrases
//do not need to be reordered to be grammatically correct.


public class Problem1ChengsInterview {

	public static void main(String[] args) {
		
		String sentence = "I love programming";
		Map<String, String> dictionary = new HashMap<>();
		dictionary.put("I", "nenu");
		dictionary.put("love", "premistunaa");
		dictionary.put("programming", "teluguprogramming");
		
		String translatedSentence = translatedSentence(sentence, dictionary);
		System.out.println("Original sentence: "+ sentence);
		System.out.println("Translated sentence:  "+ translatedSentence);
	}

	private static String translatedSentence(String sentence, Map<String, String> dictionary) {
		StringBuilder translatedSentence = new StringBuilder();
		String[] words = sentence.split(" ");
		
		for(String word: words) {
			if(dictionary.containsKey(word)) {
				translatedSentence.append(dictionary.get(word)).append(" ");
			}else {
				translatedSentence.append(word).append(" ");
				
			}
		}
		return translatedSentence.toString().trim();
		
		
	}

}
