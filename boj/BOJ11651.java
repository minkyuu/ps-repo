// 문제 링크 : https://www.acmicpc.net/problem/11651

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Map<Integer, ArrayList<Integer>> coordinates = new HashMap<>();

    public static void main(String[] args) throws IOException{
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);

            if (!coordinates.containsKey(y))
                coordinates.put(y, new ArrayList<>());
            coordinates.get(y).add(x);
            coordinates.get(y).sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
        }
    }

    private static void solve() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] keySet = new int[coordinates.size()];

        int idx = 0;
        for (int key : coordinates.keySet()) {
            keySet[idx++] = key;
        }

        Arrays.sort(keySet);
        for (int key : keySet){
            for (int i = 0; i < coordinates.get(key).size(); i++) {
                bw.write(coordinates.get(key).get(i) + " " + key + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

}
