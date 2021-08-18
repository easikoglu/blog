package com.easikoglu.algos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToHireKWorker {

  public static void main(String[] args) {
    MinCostToHireKWorker costToHireKWorker = new MinCostToHireKWorker();

    costToHireKWorker.mincostToHireWorkers(new int[] {10, 20, 5}, new int[] {70, 50, 30}, 2);
  }

  public double mincostToHireWorkers(int[] quality, int[] wage, int K) {

    int N = quality.length;
    Employer[] employers = new Employer[N];
    for (int i = 0; i < quality.length; i++) {
      employers[i] = new Employer( wage[i],quality[i]);
    }

    Arrays.sort(employers);


    double ans = 1e9;
    int sumq = 0;
    PriorityQueue<Integer> pool = new PriorityQueue<>(Comparator.reverseOrder());
    int ratio = 0;
    for (Employer worker : employers) {
      pool.offer(worker.quality);
      sumq += worker.quality;
      if (pool.size() > K) sumq -= pool.poll();
      if (pool.size() == K) ans = Math.min(ans, sumq * worker.ratio());
    }

    return ans;
  }
}

class Employer implements Comparable<Employer> {

  int wage;
  int quality;

  public Employer(int wage, int quantity) {
    this.wage = wage;
    this.quality = quantity;
  }

  public double ratio() {
    return (double) wage / quality;
  }

  @Override
  public int compareTo(Employer o) {
    return Double.compare(ratio(), o.ratio());
  }
}
