// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42840

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};

        int result1 = 0;
        int result2 = 0;
        int result3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if(first[i % first.length] == answers[i]) result1++;
            if(second[i % second.length] == answers[i]) result2++;
            if(third[i % third.length] == answers[i]) result3++;
        }

        int max = Math.max(Math.max(result1, result2), result3);
        List<Integer> temp = new ArrayList<>();
        if (max == result1) temp.add(1);
        if (max == result2) temp.add(2);
        if (max == result3) temp.add(3);

        answer = new int[temp.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }
}
