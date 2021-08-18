package com.easikoglu.algos;

import java.util.HashSet;
import java.util.Set;

class SolutionlongestConsecutive {
  public static void main(String[] args) {
    String match = "hello";
    String text = "hello0123456789hello0123456789hello1234567890hello3423243423232";



    int firstIndex = text.indexOf(match);
    while (firstIndex >= 0) {
      System.out.println(firstIndex);
      firstIndex = text.indexOf(match, firstIndex + match.length());
    }
  }

  public int longestConsecutive(int[] nums) {
    Set<Integer> sets = new HashSet<Integer>();
    for (int num : nums) {
      sets.add(num);
    }

    int maxStreak = 0;
    for (int num : sets) {
      if (!sets.contains(num - 1)) { // try to reach root of starting point.
        int current = num;
        int streak = 1;

        while (sets.contains(current + 1)) {
          current += 1;
          streak += 1;
        }

        maxStreak = Math.max(streak, maxStreak);
      }
    }
    return maxStreak;
  }
}
