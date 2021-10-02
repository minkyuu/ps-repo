// 문제 링크 : https://www.acmicpc.net/problem/2075


import java.util.*;

public class Main {

    static ArrayList<Integer> arr;
    static Scanner sc = new Scanner(System.in);
    static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = Integer.parseInt(sc.nextLine());
        arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] temp =  sc.nextLine().split(" ");
            for (String num : temp) {
                arr.add(Integer.parseInt(num));
            }
        }

    }

    private static void solve() {
        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(arr.get(N-1));
    }

}
