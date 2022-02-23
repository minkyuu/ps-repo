// 문제 링크 : https://www.acmicpc.net/problem/2751

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<Integer> nums = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        input();
        solve();
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            nums.add(Integer.parseInt(br.readLine()));
        }
    }

    private static void solve() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Collections.sort(nums);
        for (int num : nums){
            bw.write(num + "\n");
        }

        bw.flush();
        bw.close();
    }
}
