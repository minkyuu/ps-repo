// 문제 링크 : https://leetcode.com/problems/baseball-game/

import java.util.Stack;
import java.util.regex.Pattern;

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        String pattern = "^-?[0-9]*$";

        for (String record : ops){
            if (Pattern.matches(pattern, record)) {
                stack.push(Integer.parseInt(record));
            }

            else if (record.equals("+")) {
                int idx = stack.size();
                int operNum = stack.get(idx-2) + stack.get(idx-1);
                stack.push(operNum);
            }

            else if (record.equals("D")){
                stack.push(stack.peek() * 2);
            }

            else if (record.equals("C")){
                stack.pop();
            }
        }

        int result = stack.stream().mapToInt(x -> x).sum();

        return result;
    }
}
