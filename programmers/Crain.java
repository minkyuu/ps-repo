// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/64061

import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int col : moves) {
            col -= 1;

            int row = searchDoll(col, board);

            if (row != board.length) {
                int doll = board[row][col];

                if (!stack.isEmpty() && stack.peek() == doll) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(doll);
                }

                board[row][col] = 0;
            }
        }

        return answer;
    }

    private static int searchDoll(int col, int[][] board) {
        int row = board.length;

        for (int i = 0; i < board.length; i++){
            if (board[i][col] != 0)
                return i;
        }

        return row;
    }
}
