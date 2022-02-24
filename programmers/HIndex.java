// 문제 링크: https://programmers.co.kr/learn/courses/30/lessons/42747

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        for (int h = citations.length; h > 0; h--) {
            int check = 0;
            for (int i = 0; i < citations.length; i++) {
                if(citations[i] >= h)
                    check++;
            }
            if (check >= h)
                return h;
        }
        return answer;
    }
}
