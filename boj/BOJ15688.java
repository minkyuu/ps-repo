// 문제 링크 : https://www.acmicpc.net/problem/15688

import java.io.*;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void solve() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Arrays.sort(A);
        for (int num : A) {
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
    }
}
