package com.codewithkarthik;

import java.util.HashMap;
import java.util.Map;

//Given a sentence and a dictionary, translate a list of sentences. Assume
//each word in the sentence has a single, mapping in the dictionary, and words/phrases
//do not need to be reordered to be grammatically correct.

public class Problem1ChengsInterview2 {

	public static void main(String[] args) {
		
		//using only string
		
		String sentence = "I love you";
		Map<String, String> dictionary = new HashMap<>();
		dictionary.put("I", "nenu");
		dictionary.put("love", "premistunanu");
		dictionary.put("you", "ninu");
		
		String translatedSentence = translatedSentence(sentence, dictionary);
		System.out.println(translatedSentence);
	}

	private static String translatedSentence(String sentence, Map<String, String> dictionary) {
		String translatedSentence = "";
		String[] words = sentence.split(" ");
		
		for(String word: words) {
			if(dictionary.containsKey(word)) {
				translatedSentence += dictionary.get(word) + " ";
			}else {
				translatedSentence += word + " ";
			}
		}
		
		return translatedSentence;
		
		
	}

}
