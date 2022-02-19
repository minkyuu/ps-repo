// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/12977

import java.util.*;

class Solution {
    static boolean[] isPrime;
    
    public int solution(int[] nums) {
        int answer = 0;

        getPrime();

        for(int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++){
                for (int k = j+1; k < nums.length; k++){
                    int digit = nums[i] + nums[j] + nums[k];
                    if (isPrime[digit]) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    private static void getPrime(){
        int n = 3000;
        isPrime = new boolean[n+1];

        Arrays.fill(isPrime , true);

        isPrime [0] = isPrime [1] = false;
        for(int i=2; i*i<=n; i++){
            if(isPrime[i]){
                for(int j=i*i; j<=n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
