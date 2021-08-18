package com.easikoglu.algos;

import java.util.*;

public class FindValidParantheses {

  public static Map<Character, Character> bracketsMap;

  static {
    HashMap<Character, Character> myHashMap = new HashMap<>();

    myHashMap.put("{".charAt(0), "}".charAt(0));
    myHashMap.put("(".charAt(0), ")".charAt(0));
    myHashMap.put("[".charAt(0), "]".charAt(0));
    bracketsMap = Collections.unmodifiableMap(myHashMap);
  }

  public boolean isValid(String s) {

    HashSet<String> leftBrackets = new HashSet<>(Arrays.asList("(", "{", "["));

    Stack<Character> charStack = new Stack<>();

    char[] inputChars = s.toCharArray();
    for (int i = 0; i < inputChars.length; i++) {
      char inputChar = inputChars[i];
      if (bracketsMap.containsKey(inputChar)) {
        charStack.push(bracketsMap.get(inputChar));
      } else if (charStack.isEmpty() || charStack.pop() != inputChar) {
        return false;
      }

    }
    return charStack.isEmpty();
  }
}
