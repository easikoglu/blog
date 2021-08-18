package com.easikoglu.algos;

import java.util.HashMap;
import java.util.Map;

public class MinWindowsSubstring {


  public static int lengthOfLongestSubstring(String s) {

    if(s.length() == 0){
      return 0;
    }

    int left =0, right=0;

    int sizeOfStr = s.length();

    Map<Character,Integer> characterIntegerMap = new HashMap<>();
    int maxSize = 0;
    while(right < sizeOfStr){

      char current = s.charAt(right);
      Integer count = characterIntegerMap.getOrDefault(current, 0);
      characterIntegerMap.put(current,count+1);


      while(characterIntegerMap.get(current) > 1){
        char atLeft = s.charAt(left);
        characterIntegerMap.put(atLeft, characterIntegerMap.get(atLeft)-1);
        left++;
      }

      maxSize = Math.max(maxSize,right-left+1);
      right++;

    }
    return maxSize;

  }



  public static void main(String[] args) {

    String s = "pwwkew";
    String t = "ABC";
    System.out.println(lengthOfLongestSubstring(s));
  }

  public static String minWindow(String s, String t) {

    if (s.length() == 0 || t.length() == 0) {
      return "";
    }

    Map<Character, Integer> dictionaryT = new HashMap<>();

    for (int i = 0; i < t.length(); i++) {
      char charAt = t.charAt(i);
      Integer count = dictionaryT.getOrDefault(charAt, 0);
      dictionaryT.put(charAt, count + 1);
    }
    int left = 0, right = 0;
    int uniqueNumberOfChars = dictionaryT.size();

    int formed = 0;
    Map<Character, Integer> slidingWindowCounts = new HashMap<Character, Integer>();

    int windowsLength = Integer.MIN_VALUE;
    int[] response = {windowsLength, 0, 0};
    for (; right < s.length(); right++) {

      char currentChar = s.charAt(right);

      int count = slidingWindowCounts.getOrDefault(currentChar, 0);
      slidingWindowCounts.put(currentChar, count + 1);

      if (dictionaryT.containsKey(currentChar) && slidingWindowCounts.get(currentChar).equals(dictionaryT.get(currentChar))) {
        formed++;
      }
      while (left <= right && formed == uniqueNumberOfChars) {
        char windowEndChar = s.charAt(left);

        if (response[0] == windowsLength || right - left + 1 < response[0]) {
          response[0] = right - left + 1;
          response[1] = left;
          response[2] = right;
        }

        slidingWindowCounts.put(windowEndChar, slidingWindowCounts.get(windowEndChar) - 1);
        if (dictionaryT.containsKey(windowEndChar)
            && slidingWindowCounts.get(windowEndChar).intValue() < dictionaryT.get(windowEndChar).intValue()) {
          formed--;
        }
        left++;
      }
    }

    return response[0] == windowsLength ? "" : s.substring(response[1], response[2]+1);
  }
}
