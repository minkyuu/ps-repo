package leetcode_problem.sort;

// 문제 링크 : https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;

class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new LinkedHashMap<>();
        for (int num : nums){
            if (!countMap.containsKey(num))
                countMap.put(num, 0);
            countMap.put(num, countMap.get(num) + 1);
        }

        int[] result = new int[k];
        int idx = 0;
        while (k > 0) {
            int max = 0;
            int maxNum = 0;
            for (int key : countMap.keySet()) {
                if (countMap.get(key) > max) {
                    max = countMap.get(key);
                    maxNum = key;
                }
            }
            result[idx++] = maxNum;
            countMap.remove(maxNum);
            k--;
        }

        return result;
    }
}