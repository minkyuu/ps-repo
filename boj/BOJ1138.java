// 문제 링크: https://www.acmicpc.net/problem/1138

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] memories;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        memories = new int[N+1];

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        int idx = 1;
        while (st.hasMoreTokens()){
            memories[idx++] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        int[] result = new int[N+1];

        for (int i = 1; i <= N; i++) {
            int left = memories[i];

            for (int j = 1; j <= N; j++) {
                if (left == 0 && result[j] == 0){
                    result[j] = i;
                    break;
                } else if (result[j] == 0) {
                    left--;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
