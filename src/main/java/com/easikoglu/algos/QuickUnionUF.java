package com.easikoglu.algos;

public class QuickUnionUF {

  private int[] ids;

  public QuickUnionUF(int N) {

    ids = new int[N];

    for (int i = 0; i < N; i++) {
      ids[i] = i;
    }
  }

  private int root(int i) {
    while (i != ids[i]) {
      i = ids[i];
    }
    return i;
  }

  public boolean connected(int a, int b){
    return root(a) == root(b);
  }

  public void union(int a, int b){
    int a1 = root(a);
    int b1 = root(b);
    ids[a1] = b1;
  }
}


