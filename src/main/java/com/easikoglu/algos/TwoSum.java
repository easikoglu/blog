package com.easikoglu.algos;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numMap = new HashMap<>();
        for(int i =0; i < nums.length; i++){

            int secondIndex = target - nums[i];
            if(numMap.containsKey(secondIndex)) {
                return new int [] {numMap.get(secondIndex),i};
            }
            numMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("no two sum ");
    }
}
