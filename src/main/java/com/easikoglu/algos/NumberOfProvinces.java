package com.easikoglu.algos;

public class NumberOfProvinces {
  private int rowNumber;
  private int columnNumber;

  public int findCircleNum(int[][] isConnected) {

    rowNumber = isConnected.length;
    if (rowNumber <= 0) {
      throw new IllegalArgumentException("given argument is empty");
    }

    columnNumber = isConnected[0].length;

    int[] visited = new int[isConnected.length];

    int count = 0;
    for (int i = 0; i < rowNumber; i++) {
      if (visited[i] == 0) {
        dfs(isConnected, visited, i);
        count++;
      }
    }
    return count;
  }

  private void dfs(int[][] isConnected, int[] visited, int i) {
    for (int j = 0; j < isConnected.length; j++) {
      if (isConnected[i][j] == 1 && visited[j] == 0) {
        visited[j] = 1;
        dfs(isConnected, visited, j);
      }
    }
  }
}
