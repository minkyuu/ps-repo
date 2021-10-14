// 문제 링크 : https://www.acmicpc.net/problem/1920

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] A;
    static int M;
    static int[] check;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        String[] temp = sc.nextLine().split(" ");

        A = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            A[i] = Integer.parseInt(temp[i]);
        }

        M = Integer.parseInt(sc.nextLine());

        temp = sc.nextLine().split(" ");
        check = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            check[i] = Integer.parseInt(temp[i]);
        }
    }

    private static void solve() {
        Arrays.sort(A);

        for (int i = 0; i < check.length; i++) {
            System.out.println(binarySearch(check[i]));
        }
    }

    private static int binarySearch(int target) {
        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (A[mid] > target) {
                right = mid -1;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else if (A[mid] == target) {
                return 1;
            }
        }

        return 0;
    }
}
