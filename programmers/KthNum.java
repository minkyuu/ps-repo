// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42748

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            answer[i] = kthNum(commands[i], array);
        }

        return answer;
    }

    private int kthNum(int[] command, int[] array) {
        int start = command[0] - 1;
        int end = command[1] - 1;
        int k = command[2] - 1;

        int[] temp = new int[end - start + 1];
        int idx = 0;
        for (int j = start; j <= end; j++) {
            temp[idx++] = array[j];
        }

        Arrays.sort(temp);

        return temp[k];
    }
}
