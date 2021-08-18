package com.easikoglu.algos;

public class NumberOfIsland {

  private int rowNumber;
  private int columnNumber;

  public int numIslands(char[][] grid) {
    int count = 0;
    rowNumber = grid.length;
    if (rowNumber == 0) return 0;
    columnNumber = grid[0].length;

    for (int i = 0; i < rowNumber; i++) {
      for (int j = 0; j < columnNumber; j++)
        if (grid[i][j] == '1') {
          ++count;
          MakeDFSMarking(grid, i, j);
        }
    }
    return count;
  }

  private void MakeDFSMarking(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= rowNumber || j >= columnNumber || grid[i][j] != '1') return;
    grid[i][j] = '0';
    MakeDFSMarking(grid, i - 1, j);
    MakeDFSMarking(grid, i + 1, j);
    MakeDFSMarking(grid, i, j - 1);
    MakeDFSMarking(grid, i, j + 1);
  }
}
