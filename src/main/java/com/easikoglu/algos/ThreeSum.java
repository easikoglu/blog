package com.easikoglu.algos;

import java.util.*;

public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        makeTwoSum(nums, i, result);
      }
    }
    return result;
  }

  private void makeTwoSum(int[] nums, int i, List<List<Integer>> result) {
    Set<Integer> numsSet = new HashSet<>();

    for (int j = i + 1; j < nums.length; j++) {
      int complement = -(nums[i] + nums[j]);
      if (numsSet.contains(complement)) {
        result.add(Arrays.asList(nums[i], nums[j], complement));
        while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
          j++;
        }
        numsSet.add(nums[j]);
      }
    }
  }
}
