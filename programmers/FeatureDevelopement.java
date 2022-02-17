// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42586

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] period = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            period[i] = (int) ((100 - progresses[i]) / speeds[i]);
            if ((100 - progresses[i]) % speeds[i] != 0)
                period[i] += 1;
        }

        Stack<Integer> stack = new Stack<>();
        List<Integer> temp = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < period.length; i++) {
            if (stack.isEmpty()) {
                stack.add(period[i]);
                max = period[i];
            }
            else{
                if (max >= period[i]) {
                    stack.add(period[i]);
                } else {
                    temp.add(stack.size());
                    stack.clear();
                    stack.add(period[i]);
                }
                max = Math.max(max, period[i]);
            }
        }
        if (!stack.isEmpty())
            temp.add(stack.size());

        int[] answer = temp.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
