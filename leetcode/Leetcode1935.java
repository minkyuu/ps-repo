// 문제 링크 : https://leetcode.com/problems/maximum-number-of-words-you-can-type/


import java.util.*;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> broken = new HashSet<>();

        for (int i = 0; i < brokenLetters.length(); i++) {
            char word = brokenLetters.charAt(i);
            broken.add(word);
        }

        String[] check = text.split(" ");
        int answer = 0;
        for (int i = 0; i < check.length; i++) {
            boolean word = true;

            for (int j = 0; j < check[i].length(); j++) {
                if (broken.contains(check[i].charAt(j))){
                    word = false;
                    break;
                }
            }

            if (word)
                answer++;
        }

        return answer;
    }
}
