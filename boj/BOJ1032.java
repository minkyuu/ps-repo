// 문제 링크 : https://www.acmicpc.net/problem/1032

import java.util.Scanner;

public class Main {
    static int N;
    static String[] arr;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
        }
    }

    private static void solve() {
        String result = "";
        for (int idx = 0; idx < arr[0].length(); idx++) {
            boolean check = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i].charAt(idx) != arr[0].charAt(idx)){
                    check = false;
                    break;
                }
            }

            if (check)
                result += arr[0].charAt(idx);
            else
                result += "?";
        }

        System.out.println(result);
    }
}
