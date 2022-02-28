// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/68644

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};

        Arrays.sort(numbers);
        Set<Integer> temp = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++){
                temp.add(numbers[i] + numbers[j]);
            }
        }

        answer = new int[temp.size()];
        int idx = 0;
        for (Iterator<Integer> it = temp.iterator(); it.hasNext(); ) {
            int n = it.next();
            answer[idx++] = n;
        }
        Arrays.sort(answer);
        return answer;
    }
}
