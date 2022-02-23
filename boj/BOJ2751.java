// 문제 링크 : https://www.acmicpc.net/problem/2751

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] nums;
    public static void main(String[] args) throws Exception{
        input();
        solve();
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void solve() {
        Arrays.sort(nums);
        for (int num : nums){
            System.out.println(num);
        }
    }
}
