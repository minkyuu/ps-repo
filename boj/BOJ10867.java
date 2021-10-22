// 문제 링크 : https://www.acmicpc.net/problem/10867

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!arr.contains(num)){
                arr.add(num);
            }
        }
    }

    private static void solve() {
        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        arr.stream().forEach(x -> System.out.print(x+" "));
    }
}
