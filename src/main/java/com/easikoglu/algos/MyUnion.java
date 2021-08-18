package com.easikoglu.algos;

class MyUnion {

    int [] roots;
    int count;
    private int[] size;
    public MyUnion(int n) {
        roots = new int[n];
        size = new  int[n];
        for(int i =0; i<n;i++) {
            roots[i] = i;
            size[i] = 1;
        }
        count = n; // assuming every element is component.
    }

    public MyUnion(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        count = m*n;
        roots = new int[m*n];
        size = new int[m*n];

        for(int k = 0; k<m; ++k){
            for(int j = 0;j<n; j++){
                if(grid[k][j] == '1'){
                    roots[k*n + j] = k*n+j;
                }
                size[k*n +j] = 0;
            }
        }
    }

    private int findRoot(int p) {
        validate(p); // check bounds
        while(p != roots[p]){ // try to find root of element
                roots[p] = roots[roots[p]]; // path compression
            p = roots[p];
        }

        return p;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = roots.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    public void union (int p , int q) {

        int rootP = findRoot(p);
        int rootQ = findRoot(q);

        if(rootP==rootQ) {
            return;
        }
        if (size[rootP] < size[rootQ]) {
            roots[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            roots[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    public int getCount (){
        return this.count;
    }
}
