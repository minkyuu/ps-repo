// 문제 링크 : https://www.acmicpc.net/problem/1764

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static Map<String, Integer> none = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 듣도 못한 사람
        checkPeople(N);

        // 보도 못한 사람
        checkPeople(M);
    }

    private static void checkPeople(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            String name = br.readLine();

            if (!none.containsKey(name)){
                none.put(name, 0);
            }
            none.put(name, none.get(name) + 1);
        }
    }

    private static void solve() throws IOException {
        List<String> result = new ArrayList<>();
        for (String name : none.keySet()) {
            if (none.get(name) >= 2)
                result.add(name);
        }

        System.out.println(result.size());
        result.stream().sorted().forEach(System.out::println);
    }
}
