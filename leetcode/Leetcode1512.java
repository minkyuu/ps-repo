// 문제 링크 : https://leetcode.com/problems/number-of-good-pairs/ 

import java.util.*;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> digits = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if(!digits.containsKey(nums[i]))
                    digits.put(nums[i], 0);
            digits.put(nums[i], digits.get(nums[i])+1);
        }
        
        int answer = 0;
        for(int key : digits.keySet()){
            int num = digits.get(key);
            if(num > 1) {
                answer += (num * (num - 1)) / 2;
            }
        }
        
        return answer;
    }
}

