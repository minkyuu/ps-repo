// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/68935

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuffer sb = new StringBuffer();
        while(n > 0) {
            sb.append(n%3);
            n = n/3;
        }

        for (int i = 0; i < sb.length(); i++){
            int p = sb.length() - i - 1;
            answer += (sb.charAt(i) - 48) * (Math.pow(3, p));
        }
        
        return answer;
    }
}
