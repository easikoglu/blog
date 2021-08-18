package com.easikoglu.algos;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length ==1 && k ==1){
            return nums;
        }

        int maxValue = Integer.MIN_VALUE;
        int currentRunningMax = Integer.MIN_VALUE;
        int size = nums.length;
        int numOfWindow = size - k + 1;

        int [] resultList = new int[numOfWindow];
        int counter = 0;
        int l=0,r=0;
        for(; r<size;r++){

            if(nums[r] > currentRunningMax){
                currentRunningMax = nums[r];
            }

            if(r-l == k-1){
                resultList[counter] = currentRunningMax;
                counter++;
                currentRunningMax = Integer.MIN_VALUE;
                l++;
                r = r-(k-1);

            }
        }


        return resultList;


    }



  public static void main(String[] args) {
    //

      int [] nums = {1,-1};
      int k = 1;

      maxSlidingWindow(nums,k);
  }
}
