// 문제 링크 : https://leetcode.com/problems/count-the-number-of-consistent-strings/


import java.util.*;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int answer = 0;
        Set<Character> check = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            check.add(allowed.charAt(i));
        }
        
        for (String word : words){
            boolean consistent = true;
            for (int i = 0; i < word.length(); i++) {
                if(!check.contains(word.charAt(i))) {
                    consistent = false;
                    break;
                }
            }
            if (consistent)
                answer++;
        }
        
        return answer;
    }
}
