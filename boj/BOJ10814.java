// 문제 링크 : https://www.acmicpc.net/problem/10814

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static int N;
    static HashMap<Integer, ArrayList<String>> members = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            int age = Integer.parseInt(temp[0]);
            String name = temp[1];

            if (!members.containsKey(age))
                members.put(age, new ArrayList<>());
            members.get(age).add(name);
        }
    }

    private static void solve() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int age : members.keySet()) {
            for (String name : members.get(age)){
                bw.write(age +" "+name+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
