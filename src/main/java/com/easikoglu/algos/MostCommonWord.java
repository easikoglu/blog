package com.easikoglu.algos;

import java.util.*;

public class MostCommonWord {
  public String mostCommonWord(String paragraph, String[] banned) {
    //String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

    String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
    String[] splittedWords = normalizedStr.split("\\s+");

    Set<String> bannedWords = new HashSet();
    for (String word : banned) bannedWords.add(word);

    Map<String, Integer> paragraphMap = new HashMap<>();

    for (int i = 0; i < splittedWords.length; i++) {
      String word = splittedWords[i];

      if (!bannedWords.contains(word)) {
        paragraphMap.put(word, paragraphMap.getOrDefault(word, 0) + 1);
      }
    }

    return Collections.max(paragraphMap.entrySet(), Comparator.comparing(Map.Entry::getValue))
        .getKey();
  }
}
