package com.easikoglu.algos;

public class ContainerWithMostWater {

  public static void main(String[] args) {
    //

    ContainerWithMostWater c = new ContainerWithMostWater();
    int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(c.maxArea(a));
  }

  public int maxArea(int[] height) {

    int volume = 0;

    int left_point = 0;
    int right_point = height.length - 1;
    while(left_point < right_point){
      volume = Math.max(volume,Math.min(height[left_point],height[right_point])*(right_point-left_point));
      if(height[left_point] <height[right_point]){
        left_point++;
      }else {
        right_point--;
      }
    }

    return volume;
  }
}
