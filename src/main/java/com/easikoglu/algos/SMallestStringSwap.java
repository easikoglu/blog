package com.easikoglu.algos;

import java.util.*;

public class SMallestStringSwap {

  int[] parent;

  public static void main(String[] args) {

    SMallestStringSwap swap = new SMallestStringSwap();
    List<List<Integer>> alist = new ArrayList<>();
    List<Integer> innerList = new ArrayList<>();
    innerList.add(0);
    innerList.add(3);

    alist.add(innerList);
    List<Integer> innerList2 = new ArrayList<>();
    innerList2.add(1);
    innerList2.add(2);
    alist.add(innerList2);
    String abcd = swap.smallestStringWithSwaps("dcab", alist);

    System.out.println(abcd);
  }

  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

    if (s == null || s.length() == 0) {
      throw new IllegalArgumentException("s can not be null");
    }

    parent = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {
      parent[i] = i;
    }

    for (List<Integer> pair : pairs) {
      union(pair.get(0), pair.get(1));
    }

    char[] chars = s.toCharArray();
    Map<Integer, PriorityQueue<Character>> mapForRootAndChars = new HashMap<>();
    for (int i = 0; i < chars.length; i++) {

      int root = find(i);

      mapForRootAndChars.putIfAbsent(root, new PriorityQueue<>());
      mapForRootAndChars.get(root).offer(chars[i]);
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < parent.length; i++) {
      sb.append(mapForRootAndChars.get(parent[i]).poll());
    }

    return sb.toString();
  }

  private void union(int index1, int index2) {

    int parent1 = find(index1);
    int parent2 = find(index2);

    if (parent1 == parent2) {
      return;
    }
    if (parent1 > parent2) {
      parent[parent1] = parent2;
    } else {
      parent[parent2] = parent1;
    }
  }

  private int find(int index) {

    while (parent[index] != index) {
      parent[index] = parent[parent[index]];
      index = parent[index];
    }
    return index;
  }
}
