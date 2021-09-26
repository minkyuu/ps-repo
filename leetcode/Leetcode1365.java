// 문제 링크 : https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

import java.util.*;

class Solution {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] nums2 = nums.clone();

        Arrays.sort(nums);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            } else {
                continue;
            }
            map.get(nums[i]).add(i);
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = map.get(nums2[i]).get(0);
        }

        return result;
    }
}