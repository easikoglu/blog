package com.easikoglu.algos.hackerrank;

import java.io.IOException;
import java.util.*;

class Result {

  /*
   * Complete the 'isValid' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String isValid(String s) {
    // Write your code here

    final String YES = "YES";
    final String NO = "NO";

    if (s.isEmpty()) return NO;
    if (s.length() <= 3) return YES;

    char[] chars = s.toCharArray();
    Map<Character, Integer> characterIntegerMap = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < chars.length; i++) {

      Integer count = characterIntegerMap.getOrDefault(chars[i], 0);
      characterIntegerMap.put(chars[i], count + 1);
    }

    int max = 0;
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (Map.Entry<Character, Integer> entry : characterIntegerMap.entrySet()) {

      Integer freq = freqMap.getOrDefault(entry.getValue(), 0);
      freqMap.put(entry.getValue(), freq + 1);
    }

    Integer maxKeyFreq =
        Collections.max(freqMap.entrySet(), Comparator.comparing(Map.Entry::getKey)).getKey();
    Integer minKeyFreq =
        Collections.min(freqMap.entrySet(), Comparator.comparing(Map.Entry::getKey)).getKey();

    if (maxKeyFreq - 1 > minKeyFreq  && minKeyFreq !=1) {
      return "NO";
    }
    if (freqMap.get(minKeyFreq) < freqMap.get(maxKeyFreq)) {
      if(freqMap.get(minKeyFreq) > 1){
          return "NO";
      }
    }else {
        if(freqMap.get(maxKeyFreq) > 1){
            return "NO";
        }
    }

    return "YES";
  }
}

public class Sherlock {

  String data;


  public Sherlock(String data) {
    this.data = data;
  }

  public static void main(String[] args) throws IOException {


    Sherlock s = new Sherlock("test");
    System.out.println(s.interpret("test"));



  }

  public boolean interpret(String str) {
    StringTokenizer st = new StringTokenizer(str);
    while (st.hasMoreTokens()) {
      String test = st.nextToken();
      if (test.equals(data)) {
        return true;
      }
    }
    return false;
  }
}
