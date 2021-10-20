// 문제 링크 : https://www.acmicpc.net/problem/17219

import java.io.*;
import java.util.HashMap;

public class Main {
    static int N;
    static int M;
    static HashMap<String, String> members = new HashMap<>();
    static String[] links;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        N = Integer.parseInt(nums[0]);
        M = Integer.parseInt(nums[1]);
        links = new String[M];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            members.put(temp[0], temp[1]);
        }

        for (int i = 0; i < M; i++) {
            links[i] = br.readLine();
        }
    }

    private static void solve() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < M; i++) {
            bw.write(members.get(links[i])+"\n");
        }

        bw.flush();
        bw.close();
    }
}
