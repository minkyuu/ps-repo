// 문제 링크 : https://leetcode.com/problems/find-the-difference/submissions/

import java.util.*;

class Solution {
    public char findTheDifference(String s, String t) {
        char answer = 'a';
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (!map1.containsKey(key))
                map1.put(key, 0);
            map1.put(key, map1.get(key) + 1);
        }
        
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            if (map1.containsKey(key) && map1.get(key) > 0) {
                map1.put(key, map1.get(key) -1);
                continue;
            } 
            return key;
            
        }
        return answer;
    }
}
