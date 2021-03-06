// 문제 링크 : https://www.acmicpc.net/problem/10798

import java.util.Scanner;

public class BOJ10798 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] input = new char[5][15];
        int maxLength = Integer.MIN_VALUE;

        for(int i = 0; i < 5; i++) {
            String s = sc.nextLine().trim();
            maxLength = Math.max(maxLength, s.length());
            for(int j = 0; j < s.length(); j++) {
                input[i][j] = s.charAt(j);
            }
        }
 
	for(int i = 0; i < maxLength; i++) {
            for(int j = 0; j < 5; j++) {
                if(input[j][i] == '\0')
                    continue;
                System.out.print(input[j][i]);
            }
        }
    }

}
