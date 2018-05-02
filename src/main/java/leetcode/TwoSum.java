package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11};
        int[] res = new TwoSum().twoSum(nums, 18);
        System.out.println(res[0] + "," + res[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no match");
    }

    public int[] twoSum_hashtable(int[] nums, int target) {
        //valueToIndexMap as lookup table
        Map<Integer, Integer> valueToIndexMap = new HashMap<Integer, Integer>(nums.length); //int map with knows size helps
        for (int i = 0; i < nums.length; i++) {
            valueToIndexMap.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            int complement = target - nums[j];
            if(valueToIndexMap.containsKey(complement) && valueToIndexMap.get(complement) != j){  //same value can not use twice
                return new int[]{j, valueToIndexMap.get(complement)};
            }
        }
        throw new IllegalArgumentException("no match");

        //bad idea to do 2 loop upon map directly(slow and need to handle order for result), loop original array instead
    }


}