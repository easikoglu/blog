package com.easikoglu.algos;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

  public static final Map<Integer, String> symbols;
  private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

  static {
    Map<Integer, String> myMap = new HashMap<>();
    myMap.put(1000, "M");
    myMap.put(900, "CM");
    myMap.put(500, "D");
    myMap.put(400, "CD");
    myMap.put(100, "C");
    myMap.put(90, "XC");
    myMap.put(50, "L");
    myMap.put(10, "X");
    myMap.put(4, "IV");
    myMap.put(5, "V");
    myMap.put(1, "I");

    symbols = Collections.unmodifiableMap(myMap);
  }

  public static String intToRoman(int num) {

    StringBuilder sb = new StringBuilder();

    if (symbols.containsKey(num)) {
      return symbols.get(num);
    } else {
      for (int i = 0; i < values.length && num > 0; i++) {

        int value = values[i];

        while (value <= num) {

          num -= value;
          sb.append(symbols.get(value));
        }
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(intToRoman(4));
    System.out.println(intToRoman(5));
    System.out.println(intToRoman(6));
    System.out.println(intToRoman(7));
    //
  }
}
