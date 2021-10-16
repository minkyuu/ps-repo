// 문제 링크 : https://www.acmicpc.net/problem/10989

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
    }

    private static void solve() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            bw.write(arr[i]+"\n");
        }

        bw.flush();
        bw.close();
    }
}
